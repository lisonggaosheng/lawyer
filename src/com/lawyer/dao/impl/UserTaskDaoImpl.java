package com.lawyer.dao.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lawyer.dao.UserTaskDao;
import com.lawyer.pojo.SysTask;

public class UserTaskDaoImpl extends HibernateDaoSupport implements UserTaskDao {

	@Override
	public Object insertUserTask(SysTask userTask) throws Exception {
		this.getHibernateTemplate().save(userTask);
		this.getHibernateTemplate().flush();
		return userTask;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SysTask> selectUserTasks(final int currentPage,final SysTask task)
			throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		final String nowdate = sdf.format(new Date());
		
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				String sql = "";
				if(task != null){
					if (task.getLawyername() != null
							&& !task.getLawyername().equals("")) {
						sql += " t.lawyername like '%" + task.getLawyername() + "%' and ";
					}
				}
				
				String hql = "from SysTask t where remindTime>='"+nowdate+"' and status=1 and " + sql;
				hql = hql.substring(0, hql.length() - 4) + "  order by remindTime asc";
				Query query = session.createQuery(hql);
				query.setFirstResult((currentPage - 1) * 10);
				query.setMaxResults(10);
				return query.list();
			}
		});
	}

	@Override
	public Object selectUserTaskPageSize(final SysTask task) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		final String nowdate = sdf.format(new Date());
		
		return this.getHibernateTemplate().execute(new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				String sql = "";
				if(task != null){
					if (task.getLawyername() != null
							&& !task.getLawyername().equals("")) {
						sql += " t.lawyername like '%" + task.getLawyername() + "%' and ";
					}
				}
				
				String hql = "select count(*) from SysTask t where remindTime>='"+nowdate+"' and status=1 and " + sql;
				hql = hql.substring(0, hql.length() - 4);
				Query query = session.createQuery(hql);
				return query.iterate().next();
			}
		});
	}

	@Override
	public SysTask getTask(int taskid) throws Exception {
		return (SysTask) getHibernateTemplate().get(SysTask.class,taskid);
	}

	

}

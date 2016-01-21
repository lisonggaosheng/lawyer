package com.lawyer.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lawyer.dao.CourtCountDao;
import com.lawyer.pojo.Applierinfo;
import com.lawyer.pojo.ApplierinfoNetwork;
import com.lawyer.pojo.ApplierinfoOnself;
import com.lawyer.pojo.ContactExpress;
import com.lawyer.pojo.ContactFax;
import com.lawyer.pojo.ContactMail;
import com.lawyer.pojo.ContactSee;
import com.lawyer.pojo.ContactTel;
import com.lawyer.pojo.ContractSign;
import com.lawyer.pojo.Court;
import com.lawyer.pojo.Executebusiness;
import com.lawyer.pojo.Tongji;
import com.lawyer.pojo.Users;

public class CourtCountDaoImpl extends HibernateDaoSupport implements CourtCountDao {

	@Override
	public int countCourtByTime(final String sdate, final String edate) throws Exception {
		final String hql = "select count(*) from Court where savetime between ? and ? ";
		Object obj = this.getHibernateTemplate().execute(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						query.setString(0, sdate);
						query.setString(1, edate);
						return query.iterate().next();
					}
				});
		return Integer.parseInt(obj + "");
	}

	

	@SuppressWarnings({ "unchecked"})
	@Override
	public List<Tongji> countCourtUserOne() throws Exception {
		List<Court> list = this.getHibernateTemplate().find("FROM Court  GROUP BY uid");
		List<Tongji> tlist = new ArrayList<Tongji>();		
		Object obj = null;
		for (Court Court : list) {
			Users user = null;
			Iterator<Users> ituser = this.getHibernateTemplate().find("FROM Users u WHERE u.UId = '"+Court.getUid()+"'").iterator();
			while (ituser.hasNext()) {
				user = ituser.next();	
				final String hql = "select count(*) from Court where uid='"+user.getUId()+"' ";
				obj = this.getHibernateTemplate().execute(
						new HibernateCallback() {
							@Override
							public Object doInHibernate(Session session)
									throws HibernateException, SQLException {
								Query query = session.createQuery(hql);
								return query.iterate().next();
							}
						});			
				Tongji tongji = new Tongji();
				tongji.setUser(user);
				tongji.setNum(Integer.parseInt(obj + ""));
				String bili = (Double.parseDouble((Integer.parseInt(obj + "") * 100 / countCourt() )+"")+"") + "%";
				tongji.setBili(bili);
				tongji.setInfo("被执行人执行信息");
				tlist.add(tongji);
			}		
		}
		return tlist;
	}
	
	@SuppressWarnings("unchecked")
	public List<Tongji> countCourtUserTow() throws Exception {
		List<Executebusiness> list = this.getHibernateTemplate().find("FROM Executebusiness GROUP BY users.UId");
		List<Tongji> tlist = new ArrayList<Tongji>();		
		Object obj = null;
		for (Executebusiness eb : list) {
			Users user = null;
			Iterator<Users> ituser = this.getHibernateTemplate().find("FROM Users u WHERE u.UId = '"+eb.getUsers().getUId()+"'").iterator();
			while (ituser.hasNext()) {
				user = ituser.next();	
				final String hql = "select count(*) from Executebusiness where users.UId='"+user.getUId()+"' ";
				obj = this.getHibernateTemplate().execute(
						new HibernateCallback() {
							@Override
							public Object doInHibernate(Session session)
									throws HibernateException, SQLException {
								Query query = session.createQuery(hql);
								return query.iterate().next();
							}
						});			
				Tongji tongji = new Tongji();
				tongji.setUser(user);
				tongji.setNum(Integer.parseInt(obj + ""));
				String bili = (Double.parseDouble((Integer.parseInt(obj + "") * 100 / countExeBussess() )+"")+"") + "%";
		//		String bili = "11%";
				tongji.setBili(bili);
				tongji.setInfo("被执行人企业信息");
				tlist.add(tongji);
			}		
		}
		return tlist;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Tongji> countCourtUserFour() throws Exception {	
		List<Tongji> tlist = new ArrayList<Tongji>();
		Object obj = null;
		//电子邮件
		List<ContactMail> list1 = this.getHibernateTemplate().find("FROM ContactMail  GROUP BY users.UId");					
		for (ContactMail cm : list1) {
			Users user = null;
			Iterator<Users> ituser = this.getHibernateTemplate().find("FROM Users u WHERE u.UId = '"+cm.getUsers().getUId()+"'").iterator();
			while (ituser.hasNext()) {
				user = ituser.next();	
				final String hql = "select count(*) from ContactMail where users.UId='"+user.getUId()+"' ";
				obj = this.getHibernateTemplate().execute(
						new HibernateCallback() {
							@Override
							public Object doInHibernate(Session session)
									throws HibernateException, SQLException {
								Query query = session.createQuery(hql);
								return query.iterate().next();
							}
						});			
				Tongji tongji1 = new Tongji();
				tongji1.setUser(user);
				tongji1.setNum(Integer.parseInt(obj + ""));
				String bili = (Double.parseDouble((Integer.parseInt(obj + "") * 100 / countMail() )+"")+"") + "%";
		//		String bili = "11%";
				tongji1.setBili(bili);
				tongji1.setInfo("电子邮件");
				tlist.add(tongji1);
			}		
		}
		//联系电话
		List<ContactTel> list2 = this.getHibernateTemplate().find("FROM ContactTel  GROUP BY users.UId");					
		for (ContactTel ct : list2) {
			Users user = null;
			Iterator<Users> ituser = this.getHibernateTemplate().find("FROM Users u WHERE u.UId = '"+ct.getUsers().getUId()+"'").iterator();
			while (ituser.hasNext()) {
				user = ituser.next();	
				final String hql = "select count(*) from ContactTel where users.UId='"+user.getUId()+"' ";
				obj = this.getHibernateTemplate().execute(
						new HibernateCallback() {
							@Override
							public Object doInHibernate(Session session)
									throws HibernateException, SQLException {
								Query query = session.createQuery(hql);
								return query.iterate().next();
							}
						});			
				Tongji tongji1 = new Tongji();
				tongji1.setUser(user);
				tongji1.setNum(Integer.parseInt(obj + ""));
				String bili = (Double.parseDouble((Integer.parseInt(obj + "") * 100 / countTel() )+"")+"") + "%";
		//		String bili = "11%";
				tongji1.setBili(bili);
				tongji1.setInfo("电话联系");
				tlist.add(tongji1);
			}		
		}
		//传真
		List<ContactFax> list3 = this.getHibernateTemplate().find("FROM ContactFax  GROUP BY users.UId");					
		for (ContactFax cf : list3) {
			Users user = null;
			Iterator<Users> ituser = this.getHibernateTemplate().find("FROM Users u WHERE u.UId = '"+cf.getUsers().getUId()+"'").iterator();
			while (ituser.hasNext()) {
				user = ituser.next();	
				final String hql = "select count(*) from ContactFax where users.UId='"+user.getUId()+"' ";
				obj = this.getHibernateTemplate().execute(
						new HibernateCallback() {
							@Override
							public Object doInHibernate(Session session)
									throws HibernateException, SQLException {
								Query query = session.createQuery(hql);
								return query.iterate().next();
							}
						});			
				Tongji tongji1 = new Tongji();
				tongji1.setUser(user);
				tongji1.setNum(Integer.parseInt(obj + ""));
				String bili = (Double.parseDouble((Integer.parseInt(obj + "") * 100 / countFax() )+"")+"") + "%";
		//		String bili = "11%";
				tongji1.setBili(bili);
				tongji1.setInfo("传真");
				tlist.add(tongji1);
			}		
		}
		//快递
		List<ContactExpress> list4 = this.getHibernateTemplate().find("FROM ContactExpress  GROUP BY users.UId");					
		for (ContactExpress ce : list4) {
			Users user = null;
			Iterator<Users> ituser = this.getHibernateTemplate().find("FROM Users u WHERE u.UId = '"+ce.getUsers().getUId()+"'").iterator();
			while (ituser.hasNext()) {
				user = ituser.next();	
				final String hql = "select count(*) from ContactExpress where users.UId='"+user.getUId()+"' ";
				obj = this.getHibernateTemplate().execute(
						new HibernateCallback() {
							@Override
							public Object doInHibernate(Session session)
									throws HibernateException, SQLException {
								Query query = session.createQuery(hql);
								return query.iterate().next();
							}
						});			
				Tongji tongji1 = new Tongji();
				tongji1.setUser(user);
				tongji1.setNum(Integer.parseInt(obj + ""));
				String bili = (Double.parseDouble((Integer.parseInt(obj + "") * 100 / countEx() )+"")+"") + "%";
		//		String bili = "11%";
				tongji1.setBili(bili);
				tongji1.setInfo("快递");
				tlist.add(tongji1);
			}		
		}
		//登门拜访
		List<ContactSee> list5 = this.getHibernateTemplate().find("FROM ContactSee  GROUP BY users.UId");					
		for (ContactSee cse : list5) {
			Users user = null;
			Iterator<Users> ituser = this.getHibernateTemplate().find("FROM Users u WHERE u.UId = '"+cse.getUsers().getUId()+"'").iterator();
			while (ituser.hasNext()) {
				user = ituser.next();	
				final String hql = "select count(*) from ContactSee where users.UId='"+user.getUId()+"' ";
				obj = this.getHibernateTemplate().execute(
						new HibernateCallback() {
							@Override
							public Object doInHibernate(Session session)
									throws HibernateException, SQLException {
								Query query = session.createQuery(hql);
								return query.iterate().next();
							}
						});			
				Tongji tongji1 = new Tongji();
				tongji1.setUser(user);
				tongji1.setNum(Integer.parseInt(obj + ""));
				String bili = (Double.parseDouble((Integer.parseInt(obj + "") * 100 / countSee() )+"")+"") + "%";
		//		String bili = "11%";
				tongji1.setBili(bili);
				tongji1.setInfo("登门拜访");
				tlist.add(tongji1);
			}		
		}
		//签约情况
		List<ContractSign> list6 = this.getHibernateTemplate().find("FROM ContractSign  GROUP BY users.UId");					
		for (ContractSign csi : list6) {
			Users user = null;
			Iterator<Users> ituser = this.getHibernateTemplate().find("FROM Users u WHERE u.UId = '"+csi.getUsers().getUId()+"'").iterator();
			while (ituser.hasNext()) {
				user = ituser.next();	
				final String hql = "select count(*) from ContractSign where users.UId='"+user.getUId()+"' ";
				obj = this.getHibernateTemplate().execute(
						new HibernateCallback() {
							@Override
							public Object doInHibernate(Session session)
									throws HibernateException, SQLException {
								Query query = session.createQuery(hql);
								return query.iterate().next();
							}
						});			
				Tongji tongji1 = new Tongji();
				tongji1.setUser(user);
				tongji1.setNum(Integer.parseInt(obj + ""));
				String bili = (Double.parseDouble((Integer.parseInt(obj + "") * 100 / countSign() )+"")+"") + "%";
		//		String bili = "11%";
				tongji1.setBili(bili);
				tongji1.setInfo("签约情况");
				tlist.add(tongji1);
			}		
		}
	
		return tlist;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tongji> countCourtUserThree() throws Exception {
		List<Tongji> tlist = new ArrayList<Tongji>();
		Object obj = null;
		//案源申请执行人企业信息
		List<Applierinfo> list1 = this.getHibernateTemplate().find("FROM Applierinfo  GROUP BY users.UId");				
		
		for (Applierinfo app : list1) {
			Users user = null;
			Iterator<Users> ituser = this.getHibernateTemplate().find("FROM Users u WHERE u.UId = '"+app.getUsers().getUId()+"'").iterator();
			while (ituser.hasNext()) {
				user = ituser.next();	
				final String hql = "select count(*) from Applierinfo where users.UId='"+user.getUId()+"' ";
				obj = this.getHibernateTemplate().execute(
						new HibernateCallback() {
							@Override
							public Object doInHibernate(Session session)
									throws HibernateException, SQLException {
								Query query = session.createQuery(hql);
								return query.iterate().next();
							}
						});			
				Tongji tongji1 = new Tongji();
				tongji1.setUser(user);
				tongji1.setNum(Integer.parseInt(obj + ""));
				String bili = (Double.parseDouble((Integer.parseInt(obj + "") * 100 / countApp() )+"")+"") + "%";
		//		String bili = "11%";
				tongji1.setBili(bili);
				tongji1.setInfo("申请执行人企业信息");
				tlist.add(tongji1);
			}		
		}
		//案源申请执行人企业网络信息
		List<ApplierinfoNetwork> list2 = this.getHibernateTemplate().find("FROM ApplierinfoNetwork GROUP BY users.UId");	
		for (ApplierinfoNetwork an : list2) {
			Users user = null;
			Iterator<Users> ituser = this.getHibernateTemplate().find("FROM Users u WHERE u.UId = '"+an.getUsers().getUId()+"'").iterator();
			while (ituser.hasNext()) {
				user = ituser.next();	
				final String hql = "select count(*) from ApplierinfoNetwork where users.UId='"+user.getUId()+"' ";
				obj = this.getHibernateTemplate().execute(
						new HibernateCallback() {
							@Override
							public Object doInHibernate(Session session)
									throws HibernateException, SQLException {
								Query query = session.createQuery(hql);
								return query.iterate().next();
							}
						});			
				Tongji tongji2 = new Tongji();
				tongji2.setUser(user);
				tongji2.setNum(Integer.parseInt(obj + ""));
				String bili = (Double.parseDouble((Integer.parseInt(obj + "") * 100 / countAppNet() )+"")+"") + "%";
		//		String bili = "11%";
				tongji2.setBili(bili);
				tongji2.setInfo("申请执行人企业信息(网络信息)");
				tlist.add(tongji2);
			}		
		}
		
		//案源申请执行人企业自有信息
		List<ApplierinfoOnself> list3 = this.getHibernateTemplate().find("FROM ApplierinfoOnself GROUP BY users.UId");	
		for (ApplierinfoOnself ao : list3) {
			Users user = null;
			Iterator<Users> ituser = this.getHibernateTemplate().find("FROM Users u WHERE u.UId = '"+ao.getUsers().getUId()+"'").iterator();
			while (ituser.hasNext()) {
				user = ituser.next();	
				final String hql = "select count(*) from ApplierinfoOnself where users.UId='"+user.getUId()+"' ";
				obj = this.getHibernateTemplate().execute(
						new HibernateCallback() {
							@Override
							public Object doInHibernate(Session session)
									throws HibernateException, SQLException {
								Query query = session.createQuery(hql);
								return query.iterate().next();
							}
						});			
				Tongji tongji3 = new Tongji();
				tongji3.setUser(user);
				tongji3.setNum(Integer.parseInt(obj + ""));
				String bili = (Double.parseDouble((Integer.parseInt(obj + "") * 100 / countAppOnselt() )+"")+"") + "%";
		//		String bili = "11%";
				tongji3.setBili(bili);
				tongji3.setInfo("申请执行人企业信息(自有信息)");
				tlist.add(tongji3);
			}		
		}
		return tlist;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tongji> countCourtUserFourByTime(String sdate, String edate)
			throws Exception {
		List<Tongji> tlist = new ArrayList<Tongji>();
		Object obj = null;
		//电子邮件
		List<ContactMail> list1 = this.getHibernateTemplate().find("FROM ContactMail  GROUP BY users.UId");					
		for (ContactMail cm : list1) {
			Users user = null;
			Iterator<Users> ituser = this.getHibernateTemplate().find("FROM Users u WHERE u.UId = '"+cm.getUsers().getUId()+"'").iterator();
			while (ituser.hasNext()) {
				user = ituser.next();	
				final String hql = "select count(*) from ContactMail where users.UId='"+user.getUId()+"' and cmSavetime BETWEEN'"+sdate+"' AND '"+edate+"' ";
				obj = this.getHibernateTemplate().execute(
						new HibernateCallback() {
							@Override
							public Object doInHibernate(Session session)
									throws HibernateException, SQLException {
								Query query = session.createQuery(hql);
								return query.iterate().next();
							}
						});			
				Tongji tongji1 = new Tongji();
				tongji1.setUser(user);
				tongji1.setNum(Integer.parseInt(obj + ""));
				String bili = (Double.parseDouble((Integer.parseInt(obj + "") * 100 / countMail() )+"")+"") + "%";
		//		String bili = "11%";
				tongji1.setBili(bili);
				tongji1.setInfo("电子邮件");
				tlist.add(tongji1);
			}		
		}
		//联系电话
		List<ContactTel> list2 = this.getHibernateTemplate().find("FROM ContactTel  GROUP BY users.UId");					
		for (ContactTel ct : list2) {
			Users user = null;
			Iterator<Users> ituser = this.getHibernateTemplate().find("FROM Users u WHERE u.UId = '"+ct.getUsers().getUId()+"'").iterator();
			while (ituser.hasNext()) {
				user = ituser.next();	
				final String hql = "select count(*) from ContactTel where users.UId='"+user.getUId()+"'and ctSavetime BETWEEN'"+sdate+"' AND '"+edate+"' ";
				obj = this.getHibernateTemplate().execute(
						new HibernateCallback() {
							@Override
							public Object doInHibernate(Session session)
									throws HibernateException, SQLException {
								Query query = session.createQuery(hql);
								return query.iterate().next();
							}
						});			
				Tongji tongji1 = new Tongji();
				tongji1.setUser(user);
				tongji1.setNum(Integer.parseInt(obj + ""));
				String bili = (Double.parseDouble((Integer.parseInt(obj + "") * 100 / countTel() )+"")+"") + "%";
		//		String bili = "11%";
				tongji1.setBili(bili);
				tongji1.setInfo("电话联系");
				tlist.add(tongji1);
			}		
		}
		//传真
		List<ContactFax> list3 = this.getHibernateTemplate().find("FROM ContactFax  GROUP BY users.UId");					
		for (ContactFax cf : list3) {
			Users user = null;
			Iterator<Users> ituser = this.getHibernateTemplate().find("FROM Users u WHERE u.UId = '"+cf.getUsers().getUId()+"'").iterator();
			while (ituser.hasNext()) {
				user = ituser.next();	
				final String hql = "select count(*) from ContactFax where users.UId='"+user.getUId()+"'and cfSavetime BETWEEN'"+sdate+"' AND '"+edate+"' ";
				obj = this.getHibernateTemplate().execute(
						new HibernateCallback() {
							@Override
							public Object doInHibernate(Session session)
									throws HibernateException, SQLException {
								Query query = session.createQuery(hql);
								return query.iterate().next();
							}
						});			
				Tongji tongji1 = new Tongji();
				tongji1.setUser(user);
				tongji1.setNum(Integer.parseInt(obj + ""));
				String bili = (Double.parseDouble((Integer.parseInt(obj + "") * 100 / countFax() )+"")+"") + "%";
		//		String bili = "11%";
				tongji1.setBili(bili);
				tongji1.setInfo("传真");
				tlist.add(tongji1);
			}		
		}
		//快递
		List<ContactExpress> list4 = this.getHibernateTemplate().find("FROM ContactExpress  GROUP BY users.UId");					
		for (ContactExpress ce : list4) {
			Users user = null;
			Iterator<Users> ituser = this.getHibernateTemplate().find("FROM Users u WHERE u.UId = '"+ce.getUsers().getUId()+"'").iterator();
			while (ituser.hasNext()) {
				user = ituser.next();	
				final String hql = "select count(*) from ContactExpress where users.UId='"+user.getUId()+"'and ceSavetime BETWEEN'"+sdate+"' AND '"+edate+"' ";
				obj = this.getHibernateTemplate().execute(
						new HibernateCallback() {
							@Override
							public Object doInHibernate(Session session)
									throws HibernateException, SQLException {
								Query query = session.createQuery(hql);
								return query.iterate().next();
							}
						});			
				Tongji tongji1 = new Tongji();
				tongji1.setUser(user);
				tongji1.setNum(Integer.parseInt(obj + ""));
				String bili = (Double.parseDouble((Integer.parseInt(obj + "") * 100 / countEx() )+"")+"") + "%";
		//		String bili = "11%";
				tongji1.setBili(bili);
				tongji1.setInfo("快递");
				tlist.add(tongji1);
			}		
		}
		//登门拜访
		List<ContactSee> list5 = this.getHibernateTemplate().find("FROM ContactSee  GROUP BY users.UId");					
		for (ContactSee cse : list5) {
			Users user = null;
			Iterator<Users> ituser = this.getHibernateTemplate().find("FROM Users u WHERE u.UId = '"+cse.getUsers().getUId()+"'").iterator();
			while (ituser.hasNext()) {
				user = ituser.next();	
				final String hql = "select count(*) from ContactSee where users.UId='"+user.getUId()+"'and csSavetime BETWEEN'"+sdate+"' AND '"+edate+"' ";
				obj = this.getHibernateTemplate().execute(
						new HibernateCallback() {
							@Override
							public Object doInHibernate(Session session)
									throws HibernateException, SQLException {
								Query query = session.createQuery(hql);
								return query.iterate().next();
							}
						});			
				Tongji tongji1 = new Tongji();
				tongji1.setUser(user);
				tongji1.setNum(Integer.parseInt(obj + ""));
				String bili = (Double.parseDouble((Integer.parseInt(obj + "") * 100 / countSee() )+"")+"") + "%";
		//		String bili = "11%";
				tongji1.setBili(bili);
				tongji1.setInfo("登门拜访");
				tlist.add(tongji1);
			}		
		}
		//签约情况
		List<ContractSign> list6 = this.getHibernateTemplate().find("FROM ContractSign  GROUP BY users.UId");					
		for (ContractSign csi : list6) {
			Users user = null;
			Iterator<Users> ituser = this.getHibernateTemplate().find("FROM Users u WHERE u.UId = '"+csi.getUsers().getUId()+"'").iterator();
			while (ituser.hasNext()) {
				user = ituser.next();	
				final String hql = "select count(*) from ContractSign where users.UId='"+user.getUId()+"'and csSavetime BETWEEN'"+sdate+"' AND '"+edate+"' ";
				obj = this.getHibernateTemplate().execute(
						new HibernateCallback() {
							@Override
							public Object doInHibernate(Session session)
									throws HibernateException, SQLException {
								Query query = session.createQuery(hql);
								return query.iterate().next();
							}
						});			
				Tongji tongji1 = new Tongji();
				tongji1.setUser(user);
				tongji1.setNum(Integer.parseInt(obj + ""));
				String bili = (Double.parseDouble((Integer.parseInt(obj + "") * 100 / countSign() )+"")+"") + "%";
		//		String bili = "11%";
				tongji1.setBili(bili);
				tongji1.setInfo("签约情况");
				tlist.add(tongji1);
			}		
		}
	
		return tlist;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tongji> countCourtUserOneByTime(String sdate, String edate)
			throws Exception {
		List<Court> list = this.getHibernateTemplate().find("FROM Court  GROUP BY uid");
		List<Tongji> tlist = new ArrayList<Tongji>();		
		Object obj = null;
		for (Court Court : list) {
			Users user = null;
			Iterator<Users> ituser = this.getHibernateTemplate().find("FROM Users u WHERE u.UId = '"+Court.getUid()+"'").iterator();
			while (ituser.hasNext()) {
				user = ituser.next();	
				final String hql = "select count(*) from Court where uid='"+user.getUId()+"' and  savetime BETWEEN '"+sdate+"' AND '"+edate+"' ";
				obj = this.getHibernateTemplate().execute(
						new HibernateCallback() {
							@Override
							public Object doInHibernate(Session session)
									throws HibernateException, SQLException {
								Query query = session.createQuery(hql);
								return query.iterate().next();
							}
						});			
				Tongji tongji = new Tongji();
				tongji.setUser(user);
				tongji.setNum(Integer.parseInt(obj + ""));
				String bili = (Double.parseDouble((Integer.parseInt(obj + "") * 100 / countCourt() )+"")+"") + "%";
				tongji.setBili(bili);
				tongji.setInfo("被执行人执行信息");
				tlist.add(tongji);
			}		
		}
		return tlist;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tongji> countCourtUserThreeByTime(String sdate, String edate)
			throws Exception {
		List<Tongji> tlist = new ArrayList<Tongji>();
		Object obj = null;
		//案源申请执行人企业信息
		List<Applierinfo> list1 = this.getHibernateTemplate().find("FROM Applierinfo  GROUP BY users.UId");				
		
		for (Applierinfo app : list1) {
			Users user = null;
			Iterator<Users> ituser = this.getHibernateTemplate().find("FROM Users u WHERE u.UId = '"+app.getUsers().getUId()+"'").iterator();
			while (ituser.hasNext()) {
				user = ituser.next();	
				final String hql = "select count(*) from Applierinfo where users.UId='"+user.getUId()+"' and appSavetime between '"+sdate+"' and '"+edate+"' ";
				obj = this.getHibernateTemplate().execute(
						new HibernateCallback() {
							@Override
							public Object doInHibernate(Session session)
									throws HibernateException, SQLException {
								Query query = session.createQuery(hql);
								return query.iterate().next();
							}
						});			
				Tongji tongji1 = new Tongji();
				tongji1.setUser(user);
				tongji1.setNum(Integer.parseInt(obj + ""));
				String bili = (Double.parseDouble((Integer.parseInt(obj + "") * 100 / countApp() )+"")+"") + "%";
		//		String bili = "11%";
				tongji1.setBili(bili);
				tongji1.setInfo("申请执行人企业信息");
				tlist.add(tongji1);
			}		
		}
		//案源申请执行人企业网络信息
		List<ApplierinfoNetwork> list2 = this.getHibernateTemplate().find("FROM ApplierinfoNetwork GROUP BY users.UId");	
		for (ApplierinfoNetwork an : list2) {
			Users user = null;
			Iterator<Users> ituser = this.getHibernateTemplate().find("FROM Users u WHERE u.UId = '"+an.getUsers().getUId()+"'").iterator();
			while (ituser.hasNext()) {
				user = ituser.next();	
				final String hql = "select count(*) from ApplierinfoNetwork where users.UId='"+user.getUId()+"' and anSavetime between '"+sdate+"' and '"+edate+"' ";
				obj = this.getHibernateTemplate().execute(
						new HibernateCallback() {
							@Override
							public Object doInHibernate(Session session)
									throws HibernateException, SQLException {
								Query query = session.createQuery(hql);
								return query.iterate().next();
							}
						});			
				Tongji tongji2 = new Tongji();
				tongji2.setUser(user);
				tongji2.setNum(Integer.parseInt(obj + ""));
				String bili = (Double.parseDouble((Integer.parseInt(obj + "") * 100 / countAppNet() )+"")+"") + "%";
		//		String bili = "11%";
				tongji2.setBili(bili);
				tongji2.setInfo("申请执行人企业信息(网络信息)");
				tlist.add(tongji2);
			}		
		}
		
		//案源申请执行人企业自有信息
		List<ApplierinfoOnself> list3 = this.getHibernateTemplate().find("FROM ApplierinfoOnself GROUP BY users.UId");	
		for (ApplierinfoOnself ao : list3) {
			Users user = null;
			Iterator<Users> ituser = this.getHibernateTemplate().find("FROM Users u WHERE u.UId = '"+ao.getUsers().getUId()+"'").iterator();
			while (ituser.hasNext()) {
				user = ituser.next();	
				final String hql = "select count(*) from ApplierinfoOnself where users.UId='"+user.getUId()+"' and aoSavetime between '"+sdate+"' and '"+edate+"' ";
				obj = this.getHibernateTemplate().execute(
						new HibernateCallback() {
							@Override
							public Object doInHibernate(Session session)
									throws HibernateException, SQLException {
								Query query = session.createQuery(hql);
								return query.iterate().next();
							}
						});			
				Tongji tongji3 = new Tongji();
				tongji3.setUser(user);
				tongji3.setNum(Integer.parseInt(obj + ""));
				String bili = (Double.parseDouble((Integer.parseInt(obj + "") * 100 / countAppOnselt() )+"")+"") + "%";
		//		String bili = "11%";
				tongji3.setBili(bili);
				tongji3.setInfo("申请执行人企业信息(自有信息)");
				tlist.add(tongji3);
			}		
		}
		return tlist;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tongji> countCourtUserTowByTime(String sdate, String edate)
			throws Exception {
		List<Executebusiness> list = this.getHibernateTemplate().find("FROM Executebusiness GROUP BY users.UId");
		List<Tongji> tlist = new ArrayList<Tongji>();		
		Object obj = null;
		for (Executebusiness eb : list) {
			Users user = null;
			Iterator<Users> ituser = this.getHibernateTemplate().find("FROM Users u WHERE u.UId = '"+eb.getUsers().getUId()+"'").iterator();
			while (ituser.hasNext()) {
				user = ituser.next();	
				final String hql = "select count(*) from Executebusiness where users.UId='"+user.getUId()+"' and ESavetime between '"+sdate+"' and '"+edate+"' ";
				obj = this.getHibernateTemplate().execute(
						new HibernateCallback() {
							@Override
							public Object doInHibernate(Session session)
									throws HibernateException, SQLException {
								Query query = session.createQuery(hql);
								return query.iterate().next();
							}
						});			
				Tongji tongji = new Tongji();
				tongji.setUser(user);
				tongji.setNum(Integer.parseInt(obj + ""));
				String bili = (Double.parseDouble((Integer.parseInt(obj + "") * 100 / countExeBussess() )+"")+"") + "%";
				tongji.setBili(bili);
				tongji.setInfo("被执行人企业信息");
				tlist.add(tongji);
			}		
		}
		return tlist;
	}

	/**
	 * 被执行人信息总数
	 */
	@Override
	public long countCourt() throws Exception {
		final String hql = "select count(*) from Court";
		Object obj = this.getHibernateTemplate().execute(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						return query.iterate().next();
					}
				});
		return Integer.parseInt(obj + "");
	}
	/**
	 * 被执行人企业信息总数
	 */
	@Override
	public long countExeBussess() throws Exception {
		final String hql = "select count(*) from Executebusiness";
		Object obj = this.getHibernateTemplate().execute(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						return query.iterate().next();
					}
				});
		return Integer.parseInt(obj + "");
	}
	@Override
	public long countApp() throws Exception {
		final String hql = "select count(*) from Applierinfo";
		Object obj = this.getHibernateTemplate().execute(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						return query.iterate().next();
					}
				});
		return Integer.parseInt(obj + "");
	}

	@Override
	public long countAppNet() throws Exception {
		final String hql = "select count(*) from ApplierinfoNetwork";
		Object obj = this.getHibernateTemplate().execute(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						return query.iterate().next();
					}
				});
		return Integer.parseInt(obj + "");
	}

	@Override
	public long countAppOnselt() throws Exception {
		final String hql = "select count(*) from ApplierinfoOnself";
		Object obj = this.getHibernateTemplate().execute(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						return query.iterate().next();
					}
				});
		return Integer.parseInt(obj + "");
	}

	@Override
	public long countEx() throws Exception {
		final String hql = "select count(*) from ContactExpress";
		Object obj = this.getHibernateTemplate().execute(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						return query.iterate().next();
					}
				});
		return Integer.parseInt(obj + "");
	}

	@Override
	public long countFax() throws Exception {
		final String hql = "select count(*) from ContactFax";
		Object obj = this.getHibernateTemplate().execute(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						return query.iterate().next();
					}
				});
		return Integer.parseInt(obj + "");
	}

	@Override
	public long countMail() throws Exception {
		final String hql = "select count(*) from ContactMail";
		Object obj = this.getHibernateTemplate().execute(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						return query.iterate().next();
					}
				});
		return Integer.parseInt(obj + "");
	}

	@Override
	public long countSee() throws Exception {
		final String hql = "select count(*) from ContactSee";
		Object obj = this.getHibernateTemplate().execute(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						return query.iterate().next();
					}
				});
		return Integer.parseInt(obj + "");
	}

	@Override
	public long countSign() throws Exception {
		final String hql = "select count(*) from ContractSign";
		Object obj = this.getHibernateTemplate().execute(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						return query.iterate().next();
					}
				});
		return Integer.parseInt(obj + "");
	}

	@Override
	public long countTel() throws Exception {
		final String hql = "select count(*) from ContactTel";
		Object obj = this.getHibernateTemplate().execute(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						return query.iterate().next();
					}
				});
		return Integer.parseInt(obj + "");
	}
}

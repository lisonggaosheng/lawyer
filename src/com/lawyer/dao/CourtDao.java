package com.lawyer.dao;

import java.util.List;

import com.lawyer.pojo.Applierinfo;
import com.lawyer.pojo.ApplierinfoNetwork;
import com.lawyer.pojo.ApplierinfoOnself;
import com.lawyer.pojo.Apply;
import com.lawyer.pojo.ContactExpress;
import com.lawyer.pojo.ContactFax;
import com.lawyer.pojo.ContactMail;
import com.lawyer.pojo.ContactSee;
import com.lawyer.pojo.ContactTel;
import com.lawyer.pojo.Court;
import com.lawyer.pojo.Executebusiness;
import com.lawyer.pojo.PageBean;
import com.lawyer.pojo.Users;

public interface CourtDao {
	/**
	 * excel导入被执行人信息
	 */
	public void excelInsertCourt(List<Court> dataList);
	public Object getCourtByCasecode(Court court) throws Exception;
	
	public List<Court> selectCourtsByName(String pname);
	public List<Court> selectCourtsByNameCasecode(String pname,String caseCode);
	
	/**
	 * 向数据库插入企业更新所需要的数据
	 */
	public void createUpdateData(Court court, String startDate, String endDate,String instartDate,String inendDate,String minMoney,String maxMoney);
	
	/**
	 * 法院编码更新
	 */
	public void courtcodeUpdate(Users users)throws Exception;
	/**
	 * 企业状态更新
	 */
	public void updateStutas(Users users)throws Exception;
	/**
	 * 债务人公告信息批处理导入
	 */
	public void insertNoteCourts(Users users)throws Exception;
	/**
	 * 债务人失信信息批处理导入
	 */
	public void insertDishonestyCourts(Users users)throws Exception;
	/**
	 * 数据暂时排除
	 */
	public int presentExclude(Court court);
	/**
	 * 数据永久排除
	 */
	public int perpetualExclude(Court court);
	/**
	 * 数据恢复
	 */
	public int dataRecover(Court court);
	/**
	 * 向数据库插入外部软件所需要的数据
	 */
	public void createDate(Court court, String startDate, String endDate,String instartDate,String inendDate,String minMoney,String maxMoney);
	/**
	 * 改变一个案源信息执行步骤
	 */
	public void changeOneStep(Court court,String courtStep);
	/**
	 * 改变案源数据执行步骤
	 */
	public void changeStep(Court court, String startDate, String endDate,String instartDate,String inendDate,String minMoney,String maxMoney,String courtStep);
	/**
	 *按条件分页查询court信息 
	 */
	public List<Court> selectCourts(Court court,Executebusiness exb,int currentPage,String startDate,String endDate,String instartDate,String inendDate,String minMoney,String maxMoney)throws Exception;
	/**
	 *按条件分页查询的总页数 
	 */
	public int  selectTatolPage(Court court,Executebusiness exb,String startDate,String endDate,String instartDate,String inendDate,String minMoney,String maxMoney)throws Exception;
	
	
	/**
	 *按条件分页查询court信息 
	 */
	public List<Court> selectNoteCourts(Court court,int currentPage,String startDate,String endDate,String instartDate,String inendDate,String minMoney,String maxMoney)throws Exception;
	/**
	 *按条件分页查询的总页数 
	 */
	public int  selectNoteTatolPage(Court court,String startDate,String endDate,String instartDate,String inendDate,String minMoney,String maxMoney)throws Exception;
	
	
	public void insertCourt(Court court) throws Exception;//新建案源信息——田紫贺
	public Apply selectApply(Users users)throws Exception;//申请权限，查询有无对象——田紫贺
	public Apply selectCourt3(Apply apply,Users users) throws Exception;//新建案源信息——何静
	@SuppressWarnings("rawtypes")
	public List selectCourtAll(Court court)throws Exception;//查询全部案源信息——何静
	public void updateCourt(Court court)throws Exception;//修改案源信息（被执行人执行信息） ——何静
	public int countCourtByCC(String courtcode,String caseCreateTime) throws Exception; //根据法院编号和时间获取案件数量——郭志鹏
	
	public String insertMoreCourts(Users user) throws Exception;//案源的批处理操作——郭志鹏
	
	
	/** 
     * 分页查询
     * @param hql 查询的条件
     * @param offset 开始记录
     * @param length 一次查询几条记录
     * @return
     */
	public List queryForPage(final String hql,final int offset,final int length);
    
    /**
     * 查询所有记录数
     * @param hql 查询的条件
     * @return 总记录数
     */
    public int getAllRowCount(String hql);
    
	/**
     * 分页查询
     * @param page 当前第几页
     * @param pageSize 每页大小
     * @return 封闭了分页信息(包括记录集list)的Bean
     */
    public PageBean queryForPage(int pageSize,int page);
    
    
    public Apply appSelectById(Apply apply,Users users)throws Exception;  //申请   案源管理   查看详细信息 权限   --田紫贺
    public Court selectCourtById(Court court)throws Exception;    //按id  查询  案源  详细信息   ---田紫贺
    
    
    
    public Court selCourtByCasecodeself(String casecodeself)throws Exception;
	public void toupdCourt1(Court court)throws Exception;
	public Executebusiness selExecutebusById(String id)throws Exception;
	public Executebusiness selExecutebusByCasecodeself(String ecCasecodeself)throws Exception;
	public void toupdExecutebus(Executebusiness eb)throws Exception;
	public Applierinfo selApplierinfoByCasecodeself(String appCCasecodeself)throws Exception;
	public void toupdApplierinfo(Applierinfo ap)throws Exception;
	public ApplierinfoNetwork selNetwork(String anCasecodeself)throws Exception;
	public void toupdNetwork(ApplierinfoNetwork an)throws Exception;
	public ApplierinfoOnself updApplierinfoOnself(String aoCasecodeself)throws Exception;
	public void toupdApplierinfoOnself(ApplierinfoOnself ao)throws Exception;
	
	public ContactMail updConMail(String cmCasecodeself)throws Exception;
	public void toupdConMail(ContactMail cm)throws Exception;
	
	public ContactTel updConTel(String ctCasecodeself)throws Exception;
	public void toupdConTel(ContactTel ct)throws Exception;
	
	public ContactExpress updConExpress(String ceCasecodeself)throws Exception;
	public void toupdConExpress(ContactExpress ce)throws Exception;
	
	public ContactFax updConFax(String cfCasecodeself)throws Exception;
	public void toupdConFax(ContactFax cf)throws Exception;
	
	public ContactSee updConSee(String csCasecodeself)throws Exception;
	public void toupdConSee(ContactSee csee)throws Exception;
}

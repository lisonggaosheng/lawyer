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
	
	public void excelInsertCourt(List<Court> dataList);
	public Object getCourtByCasecode(Court court) throws Exception;
	
	public List<Court> selectCourtsByName(String pname);
	public List<Court> selectCourtsByNameCasecode(String pname,String caseCode);
	
	public void createUpdateData(Court court, String startDate, String endDate,String instartDate,String inendDate,String minMoney,String maxMoney);
	
	public void courtcodeUpdate(Users users)throws Exception;
	
	public void updateStutas(Users users)throws Exception;
	
	public void insertNoteCourts(Users users)throws Exception;
	
	public String insertDishonestyCourts(Users users)throws Exception;
	
	public int presentExclude(Court court);
	
	public int perpetualExclude(Court court);
	
	public int dataRecover(Court court);
	
	public void createDate(Court court, String startDate, String endDate,String instartDate,String inendDate,String minMoney,String maxMoney);
	
	public void changeOneStep(Court court,String courtStep);
	
	public void changeStep(Court court, String startDate, String endDate,String instartDate,String inendDate,String minMoney,String maxMoney,String courtStep);
	
	public List<Court> selectCourts(Court court,Executebusiness exb,int currentPage,String startDate,String endDate,String instartDate,String inendDate,String minMoney,String maxMoney)throws Exception;
	
	public int  selectTatolPage(Court court,Executebusiness exb,String startDate,String endDate,String instartDate,String inendDate,String minMoney,String maxMoney)throws Exception;
	
	
	public List<Court> selectNoteCourts(Court court,int currentPage,String startDate,String endDate,String instartDate,String inendDate,String minMoney,String maxMoney)throws Exception;
	
	public int  selectNoteTatolPage(Court court,String startDate,String endDate,String instartDate,String inendDate,String minMoney,String maxMoney)throws Exception;
	
	public void insertCourt(Court court) throws Exception;
	public Apply selectApply(Users users)throws Exception;
	public Apply selectCourt3(Apply apply,Users users) throws Exception;
	public List selectCourtAll(Court court)throws Exception;
	public void updateCourt(Court court)throws Exception;
	public long countCourtByCC(String courtcode,String caseCreateTime) throws Exception; 
	
	public String insertMoreCourts(Users user) throws Exception;//��Դ���������������־��
	
	public List queryForPage(final String hql,final int offset,final int length);
    
    public int getAllRowCount(String hql);
    
    public PageBean queryForPage(int pageSize,int page);
    
    
    public Apply appSelectById(Apply apply,Users users)throws Exception;  
    public Court selectCourtById(Court court)throws Exception;  
    
    
    
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

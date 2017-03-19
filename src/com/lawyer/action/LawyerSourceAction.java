package com.lawyer.action;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.lawyer.pojo.Applierinfo;
import com.lawyer.pojo.ApplierinfoNetwork;
import com.lawyer.pojo.ApplierinfoOnself;
import com.lawyer.pojo.ContactExpress;
import com.lawyer.pojo.ContactMail;
import com.lawyer.pojo.ContactTel;
import com.lawyer.pojo.ContractSign;
import com.lawyer.pojo.Court;
import com.lawyer.pojo.Executebusiness;
import com.lawyer.service.LawyerSourceService;
import com.lawyer.tools.ExcelLoadAndPut;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LawyerSourceAction extends ActionSupport {

	private ExcelLoadAndPut excelLoadandput;
	private LawyerSourceService lawyerSourceServicer;
	private ApplierinfoNetwork applierinfoNetwork;
	private Applierinfo applierinfo;
	private ApplierinfoOnself applierinfoOnself;
	private Court court;
	private Executebusiness executebusiness;
	private ContactMail contactMail;
	private ContactTel contactTel;
	private ContractSign contractSign;
	private ContactExpress contactExpress;
	private String startqianyuetime;
	private String endqianyuetime;
	private String startliantime;
	private String endliantime;
	private String minmoney;
	private String maxmoney;
	private String startSentEmstime;
	private String endSentEmstime;
	private String startctTime;
	private String endctTime;
	
	private String startmarkTime;
	private String endmarkTime;
	
	private String[] adayin;
	private String[] bdayin;
	private String[] cdayin;
	private String[] ddayin;
	private String pattern;
	private String courtstr;
	private String Page;
	String PageSize;
	private String flog;
	private String filename="";
	private String showNote;
	private String showPe;
	private String excludeInfo;

	public String getShowNote() {
		return showNote;
	}

	public void setShowNote(String showNote) {
		this.showNote = showNote;
	}

	public String getShowPe() {
		return showPe;
	}

	public void setShowPe(String showPe) {
		this.showPe = showPe;
	}

	public String getExcludeInfo() {
		return excludeInfo;
	}

	public void setExcludeInfo(String excludeInfo) {
		this.excludeInfo = excludeInfo;
	}

	public String getFilename() {
		try {
			return new String(filename.getBytes(), "iso-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void setFilename(String filename) {
		try {
			filename = URLDecoder.decode(filename, "utf-8");
			this.filename = new String(filename.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public ExcelLoadAndPut getExcelLoadandput() {
		return excelLoadandput;
	}

	public void setExcelLoadandput(ExcelLoadAndPut excelLoadandput) {
		this.excelLoadandput = excelLoadandput;
	}

	public String getFlog() {
		return flog;
	}

	public void setFlog(String flog) {
		this.flog = flog;
	}

	public String getPageSize() {
		return PageSize;
	}

	public void setPageSize(String pageSize) {
		PageSize = pageSize;
	}

	public String getPage() {
		return Page;
	}

	public void setPage(String page) {
		Page = page;
	}



	public String getCourtstr() {
		return courtstr;
	}

	public void setCourtstr(String courtstr) {
		this.courtstr = courtstr;
	}

	public String[] getBdayin() {
		return bdayin;
	}

	public void setBdayin(String[] bdayin) {
		this.bdayin = bdayin;
	}

	public String[] getCdayin() {
		return cdayin;
	}

	public void setCdayin(String[] cdayin) {
		this.cdayin = cdayin;
	}

	public String[] getDdayin() {
		return ddayin;
	}

	public void setDdayin(String[] ddayin) {
		this.ddayin = ddayin;
	}

	public ContactExpress getContactExpress() {
		return contactExpress;
	}

	public String[] getAdayin() {
		return adayin;
	}

	public void setAdayin(String[] adayin) {
		this.adayin = adayin;
	}

	public String getStartqianyuetime() {
		return startqianyuetime;
	}

	public void setStartqianyuetime(String startqianyuetime) {
		this.startqianyuetime = startqianyuetime;
	}

	public String getEndqianyuetime() {
		return endqianyuetime;
	}

	public void setEndqianyuetime(String endqianyuetime) {
		this.endqianyuetime = endqianyuetime;
	}

	public String getStartliantime() {
		return startliantime;
	}

	public void setStartliantime(String startliantime) {
		this.startliantime = startliantime;
	}

	public String getEndliantime() {
		return endliantime;
	}

	public void setEndliantime(String endliantime) {
		this.endliantime = endliantime;
	}

	public String getMinmoney() {
		return minmoney;
	}

	public void setMinmoney(String minmoney) {
		this.minmoney = minmoney;
	}

	public String getMaxmoney() {
		return maxmoney;
	}

	public void setMaxmoney(String maxmoney) {
		this.maxmoney = maxmoney;
	}

	public String getStartSentEmstime() {
		return startSentEmstime;
	}

	public void setStartSentEmstime(String startSentEmstime) {
		this.startSentEmstime = startSentEmstime;
	}

	public String getEndSentEmstime() {
		return endSentEmstime;
	}

	public void setEndSentEmstime(String endSentEmstime) {
		this.endSentEmstime = endSentEmstime;
	}

	/*
	 * 张磊下载
	 */
	public InputStream getDownloadFile() {
		if(filename.equals("案件信息打印.xls")){
			InputStream  in = ServletActionContext.getServletContext()
				.getResourceAsStream("\\file\\dayin3.xls");
			return in;
		}
		else {
			InputStream in = ServletActionContext.getServletContext()
				.getResourceAsStream("\\file\\dayin2.xls");
			return in;
		}
	}

	public String down() {
		return "success";
	}

	/*
	 * 张磊打印
	 */

	public String daYin() throws Exception {

		List<Court> courtlist = new ArrayList<Court>();
		List<Object[]> listdayin = new ArrayList<Object[]>();
		listdayin.add(new Object[] { "打印的案源信息" });
		// 传到页面打印

		Map<String, Object> request = ActionContext.getContext()
				.getContextMap();

		String basePath = ServletActionContext.getServletContext().getRealPath(
				"/");
		InputStream in = new FileInputStream(basePath + "file\\dayin.xls");
		OutputStream out = new FileOutputStream(basePath + "file\\dayin2.xls");
		int temp;
		while ((temp = in.read()) != -1) {
			out.write(temp);
			out.flush();
		}
		in.close();
		out.close();
		String [] courts =courtstr.split(",");
		if (courts != null && courts.length > 0) {
			for (int i = 0; i < courts.length; i++) {
				Court cour = lawyerSourceServicer.DaYinCourt(
						courts [i].trim());
				Court cou = new Court();
				cou.setCasecodeself("案源编号:" + cour.getCasecodeself());
				listdayin
						.add(new Object[] { "案源编号:", cour.getCasecodeself() });
				int ob = 0;
				if (adayin != null && adayin.length > 0) {
					Object[] obja = new Object[14];
					for (int a = 0; a < adayin.length; a++) {
						listdayin.add(new Object[] { "被执行人执行信息" });
						if (adayin[a].equals("1")) {
							cou.setPname("被执行人姓名：" + cour.getPname());
							obja[ob] = "被执行人姓名：";
							ob++;
							obja[ob] = cour.getPname();
							if ("".equals(cour.getPname())) {
								obja[ob] = "未填写";
							}
							ob++;
						}
						if (adayin[a].equals("2")) {
							cou.setPartyCardNum("身份证号码："
									+ cour.getPartyCardNum());
							obja[ob] = "身份证号码：";
							ob++;
							obja[ob] = cour.getPartyCardNum();
							if ("".equals(cour.getPartyCardNum())) {
								obja[ob] = "未填写";
							}
							ob++;
						}
						if (adayin[a].equals("3")) {
							cou.setExecCourtName("执行法院："
									+ cour.getExecCourtName());
							obja[ob] = "执行法院：";
							ob++;
							obja[ob] = cour.getExecCourtName();
							if ("".equals(cour.getExecCourtName())) {
								obja[ob] = "未填写";
							}
							ob++;
						}

						if (adayin[a].equals("4")) {
							cou.setCaseCreateTime("立案时间："
									+ cour.getCaseCreateTime());
							obja[ob] = "立案时间：";
							ob++;
							obja[ob] = cour.getCaseCreateTime();
							if ("".equals(cour.getCaseCreateTime())) {
								obja[ob] = "未填写";
							}
							ob++;

						}
						if (adayin[a].equals("5")) {
							cou.setCaseCode("案件编号：" + cour.getCaseCode());
							obja[ob] = "案件编号：";
							ob++;
							obja[ob] = cour.getCaseCode();
							if ("".equals(cour.getCaseCode())) {
								obja[ob] = "未填写";
							}
							ob++;
						}
						if (adayin[a].equals("6")) {
							cou.setExecMoney("执行标的：" + cour.getExecMoney());
							obja[ob] = "执行标的：";
							ob++;
							obja[ob] = cour.getExecMoney();
							if ("".equals(cour.getExecMoney())) {
								obja[ob] = "未填写";
							}
							ob++;
						}
						if (adayin[a].equals("7")) {
							cou.setCaseState("案件状态：" + cour.getCaseState());
							obja[ob] = "案件状态：";
							ob++;
							obja[ob] = cour.getCaseState();
							if ("".equals(cour.getCaseState())) {
								obja[ob] = "未填写";
							}
							ob++;
						}

					}

					for (; ob < 14; ob++) {
						obja[ob] = "";
					}
					listdayin.add(obja);
					

				}
				ob = 0;
				Executebusiness excu = null;
				if (bdayin != null && bdayin.length > 0) {
					Object[] objb = new Object[16];
					excu = new Executebusiness();
					Executebusiness excut = cour.getEb();
					listdayin.add(new Object[] { "被执行人企业信息" });

					if (excut == null) {
						excut = new Executebusiness();
					}
					for (int a = 0; a < bdayin.length; a++) {
						if (bdayin[a].equals("1")) {
							objb[ob] = "被执行人注册号：";
							ob++;
							if (excut.getERenumber() != null) {
								excu.setERenumber("被执行人注册号："
										+ excut.getERenumber());
								objb[ob] = excut.getERenumber();
							} else {
								excu.setERenumber("被执行人注册号：未填写");
								objb[ob] = "未填写";
							}
							ob++;
						}
						if (bdayin[a].equals("2")) {
							objb[ob] = "企业类型：";
							ob++;
							if (excut.getEType() != null) {
								excu.setEType("企业类型：" + excut.getEType());
								objb[ob] = excut.getEType();
							} else {
								excu.setEType("企业类型：未填写");
								objb[ob] = "未填写";
							}
							ob++;
						}
						if (bdayin[a].equals("3")) {
							objb[ob] = "主体名称：";
							ob++;
							if (excut.getEName() != null) {
								excu.setEName("主体名称：" + excut.getEName());
								objb[ob] = excut.getEName();
							} else {
								excu.setEName("主体名称：未填写");
								objb[ob] = "未填写";
							}
							ob++;
						}

						if (bdayin[a].equals("4")) {
							objb[ob] = "法定代表人：";
							ob++;
							if (excut.getERepname() != null) {
								excu
										.setERepname("法定代表人："
												+ excut.getERepname());
								objb[ob] = excut.getERepname();
							} else {
								excu.setERepname("法定代表人：未填写");
								objb[ob] = "未填写";
							}
							ob++;
						}
						if (bdayin[a].equals("5")) {
							objb[ob] = "行政区划：";
							ob++;
							if (excut.getEDistrict() != null) {
								excu.setEDistrict("行政区划："
										+ excut.getEDistrict());
								objb[ob] = excut.getEDistrict();
							} else {
								excu.setEDistrict("行政区划：未填写");
								objb[ob] = "未填写";
							}
							ob++;
						}
						if (bdayin[a].equals("6")) {
							objb[ob] = "登记机关：";
							ob++;
							if (excut.getEOrgan() != null) {
								excu.setEOrgan("登记机关：" + excut.getEOrgan());
								objb[ob] = excut.getEOrgan();
							} else {
								excu.setEOrgan("登记机关：未填写");
								objb[ob] = "未填写";
							}
							ob++;
						}
						if (bdayin[a].equals("7")) {
							objb[ob] = "地址/住所：";
							ob++;
							if (excut.getEAddress() != null) {
								excu
										.setEAddress("地址/住所："
												+ excut.getEAddress());
								objb[ob] = excut.getEAddress();
							} else {
								excu.setEAddress("地址/住所：未填写");
								objb[ob] = "未填写";
							}
							ob++;
						}
						if (bdayin[a].equals("8")) {
							objb[ob] = "企业状态：";
							ob++;
							if (excut.getEStatus() != null) {
								excu.setEStatus("企业状态：" + excut.getEStatus());
								objb[ob] = excut.getEStatus();
							} else {
								excu.setEStatus("企业状态：未填写");
								objb[ob] = "未填写";
							}
							ob++;
						}

						cou.setEb(excu);

					}

					for (; ob < 16; ob++) {
						objb[ob] = "";
					}
					listdayin.add(objb);
					
				}
				ob = 0;
				ApplierinfoOnself apsel = null;
				Applierinfo ap = null;
				if (cdayin != null && cdayin.length > 0) {
					listdayin.add(new Object[] { "申请执行人企业信息" });
					Object[] objc = new Object[16];
					ApplierinfoOnself appsel = cour.getAo();
					Applierinfo app = cour.getAp();

					if (appsel == null) {
						appsel = new ApplierinfoOnself();
					}
					if (app == null) {
						app = new Applierinfo();
					}
					apsel = new ApplierinfoOnself();
					ap = new Applierinfo();

					for (int a = 0; a < cdayin.length; a++) {

						if (cdayin[a].equals("1")) {
							objc[ob] = "申请人名称：";
							ob++;
							if (apsel.getAoName() != null) {
								apsel.setAoName("申请人名称：" + appsel.getAoName());
								objc[ob] = appsel.getAoName();
							} else {
								apsel.setAoName("申请人名称：未填写");
								objc[ob] = "未填写";
							}
							ob++;
						}
						if (cdayin[a].equals("2")) {
							objc[ob] = "申请人地址：";
							ob++;
							if (appsel.getAoAddress() != null) {
								apsel.setAoAddress("申请人地址："
										+ appsel.getAoAddress());
								objc[ob] = appsel.getAoAddress();
							} else {
								apsel.setAoAddress("申请人地址：未填写");
								objc[ob] = "未填写";
							}
							ob++;
						}
						if (cdayin[a].equals("3")) {
							objc[ob] = "联系人姓名：";
							ob++;
							if (appsel.getAoName1() != null) {
								apsel
										.setAoName1("联系人姓名："
												+ appsel.getAoName1());
								objc[ob] = appsel.getAoName1();
							} else {
								apsel.setAoName1("联系人姓名：未填写");
								objc[ob] = "未填写";
							}
							ob++;
						}

						if (cdayin[a].equals("4")) {
							objc[ob] = "申请人名称：";
							ob++;
							if (appsel.getAoPhone1() != null) {
								apsel.setAoPhone1("联系人电话："
										+ appsel.getAoPhone1());
								objc[ob] = appsel.getAoPhone1();
							} else {
								apsel.setAoPhone1("联系人电话：未填写");
								objc[ob] = "未填写";
							}
							ob++;
						}
						if (cdayin[a].equals("5")) {
							objc[ob] = "法定代表人：";
							ob++;
							if (app.getAppRepname() != null) {
								ap
										.setAppRepname("法定代表人："
												+ app.getAppRepname());
								objc[ob] = app.getAppRepname();
							} else {
								ap.setAppRepname("法定代表人：未填写");
								objc[ob] = "未填写";
							}
							ob++;
						}
						if (cdayin[a].equals("6")) {
							objc[ob] = "行政区划：";
							ob++;
							if (app.getAppDistrict() != null) {
								ap.setAppDistrict("行政区划："
										+ app.getAppDistrict());
								objc[ob] = app.getAppDistrict();
							} else {
								ap.setAppDistrict("行政区划：未填写");
								objc[ob] = "未填写";
							}
							ob++;
						}
						if (cdayin[a].equals("7")) {
							objc[ob] = "登记机关：";
							ob++;
							if (app.getAppOrgan() != null) {
								ap.setAppOrgan("登记机关：" + app.getAppOrgan());
								objc[ob] = app.getAppOrgan();
							} else {
								ap.setAppOrgan("登记机关：未填写");
								objc[ob] = "未填写";
							}
							ob++;
						}
						if (cdayin[a].equals("8")) {
							objc[ob] = "地址/住所：";
							ob++;
							if (app.getAppAddress() != null) {
								ap
										.setAppAddress("地址/住所："
												+ app.getAppAddress());
								objc[ob] = app.getAppAddress();
							} else {
								ap.setAppAddress("地址/住所：未填写");
								objc[ob] = "未填写";
							}
							ob++;
						}

						cou.setAo(apsel);
						cou.setAp(ap);
					}
					for (; ob < 16; ob++) {
						objc[ob] = "";
					}
					listdayin.add(objc);
				}

				List<ContactMail> conmaillist = null;
				List<ContactExpress> conexplist = null;
				List<ContactTel> contellist = null;
				ContractSign consin = null;
				ob = 0;
				if (ddayin != null && ddayin.length > 0) {
					listdayin.add(new Object[] { "与申请执行人联系信息" });
					consin = new ContractSign();
					List<ContactMail> conmailist = cour.getListcm();
					List<ContactExpress> conexlist = cour.getListce();
					List<ContactTel> contelist = cour.getListct();
					ContractSign consi = cour.getCsign();

					if (conmailist == null) {
						conmailist = new ArrayList<ContactMail>();
					}
					if (conexlist == null) {
						conexlist = new ArrayList<ContactExpress>();
					}
					if (contelist == null) {
						contelist = new ArrayList<ContactTel>();
					}
					if (consi == null) {
						consi = new ContractSign();
					}
			
					for (int a = 0; a < ddayin.length; a++) {

						if (ddayin[a].equals("1")) {
							conmaillist = new ArrayList<ContactMail>();
							ContactMail conmail = null;
							Object[] objmail = null;
							listdayin.add(new Object[] { "邮件信息" });
							int mai = 0;
							if (conmailist.size() > 0) {
								for (ContactMail conmai : conmailist) {
									
									objmail = new Object[2];
									conmail = new ContactMail();
									objmail[mai] = "邮件地址：";
									mai++;
									if (conmai.getCmMail() != null) {
										conmail.setCmMail("邮件地址："
												+ conmai.getCmMail() + "<br/>");
										objmail[mai] = conmai.getCmMail();
									} else {
										conmail.setCmMail("邮件地址：未填写<br/>");
										objmail[mai] = "未填写";
									}
									conmaillist.add(conmail);
									listdayin.add(objmail);
									mai = 0;
								}
							} else {
								objmail = new Object[2];
								conmail = new ContactMail();
								conmail.setCmMail("邮件地址：未填写<br/>");
								conmaillist.add(conmail);
								objmail[mai] = "邮件地址：";
								mai++;
								objmail[mai] = "未填写";
								listdayin.add(objmail);
							}
						}
						
						if (ddayin[a].equals("7")) {
							conmaillist = new ArrayList<ContactMail>();
							ContactMail conmail = null;
							Object[] objmail = null;
							listdayin.add(new Object[] { "邮件信息" });
							int mai = 0;
							if (conmailist.size() > 0) {
								for (ContactMail conmai : conmailist) {
									
									objmail = new Object[2];
									conmail = new ContactMail();
									objmail[mai] = "邮件发件人：";
									mai++;
									if (conmai.getCmMsender() != null) {
										conmail.setCmMsender("邮件发件人："
												+ conmai.getCmMsender() + "<br/>");
										objmail[mai] = conmai.getCmMsender();
									} else {
										conmail.setCmMsender("邮件发件人：未填写<br/>");
										objmail[mai] = "未填写";
									}
									conmaillist.add(conmail);
									listdayin.add(objmail);
									mai = 0;
								}
							} else {
								objmail = new Object[2];
								conmail = new ContactMail();
								conmail.setCmMsender("邮件发件人：未填写<br/>");
								conmaillist.add(conmail);
								objmail[mai] = "邮件发件人：";
								mai++;
								objmail[mai] = "未填写";
								listdayin.add(objmail);
							}
						}
						
						if (ddayin[a].equals("8")) {
							conmaillist = new ArrayList<ContactMail>();
							ContactMail conmail = null;
							Object[] objmail = null;
							listdayin.add(new Object[] { "邮件信息" });
							int mai = 0;
							if (conmailist.size() > 0) {
								for (ContactMail conmai : conmailist) {
									
									objmail = new Object[2];
									conmail = new ContactMail();
									objmail[mai] = "发件时间：";
									mai++;
									if (conmai.getCmDate() != null) {
										conmail.setCmDate("发件时间："
												+ conmai.getCmDate() + "<br/>");
										objmail[mai] = conmai.getCmDate();
									} else {
										conmail.setCmDate("发件时间：未填写<br/>");
										objmail[mai] = "未填写";
									}
									conmaillist.add(conmail);
									listdayin.add(objmail);
									mai = 0;
								}
							} else {
								objmail = new Object[2];
								conmail = new ContactMail();
								conmail.setCmDate("发件时间：未填写<br/>");
								conmaillist.add(conmail);
								objmail[mai] = "发件时间：";
								mai++;
								objmail[mai] = "未填写";
								listdayin.add(objmail);
							}
						}
						
						if (ddayin[a].equals("2")) {
							listdayin.add(new Object[] { "快递信息" });
							conexplist = new ArrayList<ContactExpress>();
							ContactExpress conexp = null;
							Object[] objexp = null;
							int exp = 0;
							if (conexlist.size() > 0) {
								for (ContactExpress conex : conexlist) {
									objexp = new Object[2];
									conexp = new ContactExpress();
									objexp[exp] = "快递号：";
									exp++;
									if (conex.getCeNumber() != null) {
										conexp
												.setCeNumber("快递号："
														+ conex.getCeNumber()
														+ "<br/>");
										objexp[exp] = conex.getCeNumber();
									} else {
										conexp.setCeNumber("快递号：未填写<br/>");
										objexp[exp] = "未填写";
									}
									exp = 0;
									conexplist.add(conexp);
									listdayin.add(objexp);
								}
							} else {
								objexp = new Object[2];
								conexp = new ContactExpress();
								conexp.setCeNumber("快递号：未填写<br/>");
								conexplist.add(conexp);
								objexp[exp] = "快递号：";
								exp++;
								objexp[exp] = "未填写";
								listdayin.add(objexp);
							}
							exp = 0;
						}
						if (ddayin[a].equals("3")) {
							listdayin.add(new Object[] { "电话联系信息" });
							int tel = 0;
							Object[] objtel = null;
							contellist = new ArrayList<ContactTel>();
							ContactTel contel = null;

							if (contelist.size() > 0) {

								for (ContactTel conte : contelist) {
									objtel = new Object[2];
									objtel[tel] = "电话联系结果：";
									tel++;
									contel = new ContactTel();
									if (conte.getCtResult() != null) {
										contel
												.setCtResult("电话联系结果："
														+ conte.getCtResult()
														+ "<br/>");
										objtel[tel] = conte.getCtResult();
									} else {
										contel.setCtResult("电话联系结果：未填写<br/>");
										objtel[tel] = "未填写";
									}
									tel = 0;
									contellist.add(contel);
									listdayin.add(objtel);
								}
							} else {
								objtel = new Object[2];
								objtel[tel] = "电话联系结果：";
								tel++;
								objtel[tel] = "未填写";
								contel = new ContactTel();
								contel.setCtResult("电话联系结果：未填写<br/>");
								contellist.add(contel);
								listdayin.add(objtel);
							}

						}
						Object[] objsin = new Object[6];
						int sin = 0;
						if (ddayin[a].equals("4")) {
							objsin[sin] = "签约时间：";
							sin++;
							if (consi.getCsDate() != null) {
								objsin[sin] = consi.getCsDate();
								consin.setCsDate("签约时间：" + consi.getCsDate());
							} else {
								objsin[sin] = "未填写";
								consin.setCsDate("签约时间：未填写");
							}
							sin++;
						}
						if (ddayin[a].equals("5")) {
							objsin[sin] = "签约联系人：";
							sin++;
							if (consi.getCsName() != null) {
								objsin[sin]=consi.getCsName();
								consin.setCsName("签约联系人：" + consi.getCsName());
							} else {
								objsin[sin]="未填写";
								consin.setCsName("签约联系人：未填写");
							}
							sin++;
						}
						if (ddayin[a].equals("6")) {
							objsin[sin]="签约号：";
							sin++;
							if (consi.getCsNo() != null) {
								objsin[sin]=consi.getCsNo();
								consin.setCsNo("签约号：" + consi.getCsNo());
							} else {
								objsin[sin]="未填写";
								consin.setCsNo("签约号：未填写");
							}
							sin++;
						}
						
						for(;sin<6;sin++){
							objsin[sin]="";
						}
						listdayin.add(objsin);
						cou.setListcm(conmaillist);
						cou.setListce(conexplist);
						cou.setListct(contellist);
						cou.setCsign(consin);

					}
				}
				courtlist.add(cou);
			}
			request.put("ddayin", ddayin);
			request.put("courtlist", courtlist);
			request.put("adayin", adayin);
			request.put("bdayin", bdayin);
			request.put("cdayin", cdayin);
			adayin = null;
			bdayin = null;
			cdayin = null;
			ddayin = null;
		}
		excelLoadandput.PutExcel(basePath + "file\\dayin2.xls", "", listdayin);
		if(pattern.endsWith("pattern1")){
			return "pattern";
		}else{
			return "success";
		}
	}

	public void setContactExpress(ContactExpress contactExpress) {
		this.contactExpress = contactExpress;
	}

	@SuppressWarnings("unchecked")
	public String seniorSelectSource() throws Exception {
		String usedmark = "";
		String disposeResult = "";
		if(applierinfo.getUsedMark() == null){
			usedmark = "";
		}else{
			usedmark = String.valueOf(applierinfo.getUsedMark());
		}
		
		if(applierinfo.getDisposeResult() == null){
			disposeResult = "";
		}else{
			disposeResult = applierinfo.getDisposeResult();
		}
		
		String[] params = null;
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (flog.endsWith("0")) {
			Page = 1 + "";
			params = new String[] { 
					court.getPname(), 					//0
					court.getPartyCardNum(),
					court.getExecCourtName(),
					court.getCaseCode(),
					court.getCaseState(), 
					applierinfo.getAppRepname(),
					applierinfo.getAppDistrict(),
					applierinfo.getAppOrgan(),
					applierinfo.getAppAddress(),
					applierinfoOnself.getAoName(),
					applierinfoOnself.getAoAddress(),
					applierinfoOnself.getAoName1(),
					applierinfoOnself.getAoPhone1(), 
					contactTel.getCtName(),
					contractSign.getCsName(),
					contractSign.getCsNo(), 
					executebusiness.getERenumber(),
					executebusiness.getEType(),
					executebusiness.getEName(),
					executebusiness.getERepname(),
					executebusiness.getEDistrict(),
					executebusiness.getEOrgan(),
					executebusiness.getEAddress(),
					contactMail.getCmMail(), 
					contactExpress.getCeNumber(),
					executebusiness.getEStatus(),
					startqianyuetime,//26
					endqianyuetime,
					startliantime,
					endliantime,
					minmoney,
					maxmoney,
					court.getCasecodeself(),
					applierinfo.getAppName(),
					contactExpress.getCeName(),
					startSentEmstime,
					endSentEmstime,
					startctTime,
					endctTime,
					contactTel.getCtName1(),
					contactTel.getCtTel1(),//40
					usedmark,
					startmarkTime,
					endmarkTime, //43
					disposeResult
					
			};
			flog="1";
			session.put("params", params);
		} else {
			params = (String[]) session.get("params");
		}
		List exclude = new ArrayList();
		if(!showPe.equals("")){
			exclude.add(showPe);
		}
		if(!excludeInfo.equals("")){
			exclude.add(excludeInfo);
		}
		if (exclude != null && exclude.size() > 0) {	
				PageSize = lawyerSourceServicer.excludeSeniorSelectPageSize(100,exclude,showNote, params);
				if(Page.equals("")){
					Page=1+"";
				}
				if(Integer
						.parseInt(Page)>Integer
						.parseInt(PageSize)){
					Page=PageSize;
				}
				List<Court> rs = lawyerSourceServicer.excludeSeniorSelect(Integer
						.parseInt(Page),showNote, 100,exclude, params);
				Map<String, Object> request = ActionContext.getContext()
				.getContextMap();
				request.put("showNote", showNote);
				request.put("rs", rs);
		}else{
			PageSize = lawyerSourceServicer.seniorSelectPageSize(100,showNote, params);
			if(Page.equals("")){
				Page=1+"";
			}
			if(Integer.parseInt(Page)>Integer.parseInt(PageSize)){
				Page=PageSize;
			}
			List<Court> rs = lawyerSourceServicer.seniorSelect(Integer
					.parseInt(Page),showNote, 100, params);
			Map<String, Object> request = ActionContext.getContext()
			.getContextMap();
			request.put("showNote", showNote);
			request.put("rs", rs);
		}
		return Action.SUCCESS;
	}

	public ApplierinfoNetwork getApplierinfoNetwork() {
		return applierinfoNetwork;
	}

	public void setApplierinfoNetwork(ApplierinfoNetwork applierinfoNetwork) {
		this.applierinfoNetwork = applierinfoNetwork;
	}

	public ApplierinfoOnself getApplierinfoOnself() {
		return applierinfoOnself;
	}

	public void setApplierinfoOnself(ApplierinfoOnself applierinfoOnself) {
		this.applierinfoOnself = applierinfoOnself;
	}

	public Court getCourt() {
		return court;
	}

	public void setCourt(Court court) {
		this.court = court;
	}

	public Executebusiness getExecutebusiness() {
		return executebusiness;
	}

	public void setExecutebusiness(Executebusiness executebusiness) {
		this.executebusiness = executebusiness;
	}

	public ContactMail getContactMail() {
		return contactMail;
	}

	public void setContactMail(ContactMail contactMail) {
		this.contactMail = contactMail;
	}

	public ContactTel getContactTel() {
		return contactTel;
	}

	public void setContactTel(ContactTel contactTel) {
		this.contactTel = contactTel;
	}

	public ContractSign getContractSign() {
		return contractSign;
	}

	public void setContractSign(ContractSign contractSign) {
		this.contractSign = contractSign;
	}

	public LawyerSourceService getLawyerSourceServicer() {
		return lawyerSourceServicer;
	}

	public void setLawyerSourceServicer(LawyerSourceService lawyerSourceServicer) {
		this.lawyerSourceServicer = lawyerSourceServicer;
	}

	public Applierinfo getApplierinfo() {
		return applierinfo;
	}

	public void setApplierinfo(Applierinfo applierinfo) {
		this.applierinfo = applierinfo;
	}

	public String getStartctTime() {
		return startctTime;
	}

	public void setStartctTime(String startctTime) {
		this.startctTime = startctTime;
	}

	public String getEndctTime() {
		return endctTime;
	}

	public void setEndctTime(String endctTime) {
		this.endctTime = endctTime;
	}

	public String getStartmarkTime() {
		return startmarkTime;
	}

	public void setStartmarkTime(String startmarkTime) {
		this.startmarkTime = startmarkTime;
	}

	public String getEndmarkTime() {
		return endmarkTime;
	}

	public void setEndmarkTime(String endmarkTime) {
		this.endmarkTime = endmarkTime;
	}

}

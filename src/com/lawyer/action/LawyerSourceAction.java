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

import org.apache.commons.lang.StringUtils;
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
	 * ��������
	 */
	public InputStream getDownloadFile() {
		if(filename.equals("������Ϣ��ӡ.xls")){
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
	 * ���ڴ�ӡ
	 */

	public String daYin() throws Exception {

		List<Court> courtlist = new ArrayList<Court>();
		List<Object[]> listdayin = new ArrayList<Object[]>();
		listdayin.add(new Object[] { "��ӡ�İ�Դ��Ϣ" });
		// ����ҳ���ӡ

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
				cou.setCasecodeself("��Դ���:" + cour.getCasecodeself());
				listdayin
						.add(new Object[] { "��Դ���:", cour.getCasecodeself() });
				int ob = 0;
				if (adayin != null && adayin.length > 0) {
					Object[] obja = new Object[14];
					for (int a = 0; a < adayin.length; a++) {
						listdayin.add(new Object[] { "��ִ����ִ����Ϣ" });
						if (adayin[a].equals("1")) {
							cou.setPname("��ִ��������" + cour.getPname());
							obja[ob] = "��ִ��������";
							ob++;
							obja[ob] = cour.getPname();
							if ("".equals(cour.getPname())) {
								obja[ob] = "δ��д";
							}
							ob++;
						}
						if (adayin[a].equals("2")) {
							cou.setPartyCardNum("���֤���룺"
									+ cour.getPartyCardNum());
							obja[ob] = "���֤���룺";
							ob++;
							obja[ob] = cour.getPartyCardNum();
							if ("".equals(cour.getPartyCardNum())) {
								obja[ob] = "δ��д";
							}
							ob++;
						}
						if (adayin[a].equals("3")) {
							cou.setExecCourtName("ִ�з�Ժ��"
									+ cour.getExecCourtName());
							obja[ob] = "ִ�з�Ժ��";
							ob++;
							obja[ob] = cour.getExecCourtName();
							if ("".equals(cour.getExecCourtName())) {
								obja[ob] = "δ��д";
							}
							ob++;
						}

						if (adayin[a].equals("4")) {
							cou.setCaseCreateTime("����ʱ�䣺"
									+ cour.getCaseCreateTime());
							obja[ob] = "����ʱ�䣺";
							ob++;
							obja[ob] = cour.getCaseCreateTime();
							if ("".equals(cour.getCaseCreateTime())) {
								obja[ob] = "δ��д";
							}
							ob++;

						}
						if (adayin[a].equals("5")) {
							cou.setCaseCode("������ţ�" + cour.getCaseCode());
							obja[ob] = "������ţ�";
							ob++;
							obja[ob] = cour.getCaseCode();
							if ("".equals(cour.getCaseCode())) {
								obja[ob] = "δ��д";
							}
							ob++;
						}
						if (adayin[a].equals("6")) {
							cou.setExecMoney("ִ�б�ģ�" + cour.getExecMoney());
							obja[ob] = "ִ�б�ģ�";
							ob++;
							obja[ob] = cour.getExecMoney();
							if ("".equals(cour.getExecMoney())) {
								obja[ob] = "δ��д";
							}
							ob++;
						}
						if (adayin[a].equals("7")) {
							cou.setCaseState("����״̬��" + cour.getCaseState());
							obja[ob] = "����״̬��";
							ob++;
							obja[ob] = cour.getCaseState();
							if ("".equals(cour.getCaseState())) {
								obja[ob] = "δ��д";
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
					listdayin.add(new Object[] { "��ִ������ҵ��Ϣ" });

					if (excut == null) {
						excut = new Executebusiness();
					}
					for (int a = 0; a < bdayin.length; a++) {
						if (bdayin[a].equals("1")) {
							objb[ob] = "��ִ����ע��ţ�";
							ob++;
							if (excut.getERenumber() != null) {
								excu.setERenumber("��ִ����ע��ţ�"
										+ excut.getERenumber());
								objb[ob] = excut.getERenumber();
							} else {
								excu.setERenumber("��ִ����ע��ţ�δ��д");
								objb[ob] = "δ��д";
							}
							ob++;
						}
						if (bdayin[a].equals("2")) {
							objb[ob] = "��ҵ���ͣ�";
							ob++;
							if (excut.getEType() != null) {
								excu.setEType("��ҵ���ͣ�" + excut.getEType());
								objb[ob] = excut.getEType();
							} else {
								excu.setEType("��ҵ���ͣ�δ��д");
								objb[ob] = "δ��д";
							}
							ob++;
						}
						if (bdayin[a].equals("3")) {
							objb[ob] = "������ƣ�";
							ob++;
							if (excut.getEName() != null) {
								excu.setEName("������ƣ�" + excut.getEName());
								objb[ob] = excut.getEName();
							} else {
								excu.setEName("������ƣ�δ��д");
								objb[ob] = "δ��д";
							}
							ob++;
						}

						if (bdayin[a].equals("4")) {
							objb[ob] = "��������ˣ�";
							ob++;
							if (excut.getERepname() != null) {
								excu
										.setERepname("��������ˣ�"
												+ excut.getERepname());
								objb[ob] = excut.getERepname();
							} else {
								excu.setERepname("��������ˣ�δ��д");
								objb[ob] = "δ��д";
							}
							ob++;
						}
						if (bdayin[a].equals("5")) {
							objb[ob] = "������";
							ob++;
							if (excut.getEDistrict() != null) {
								excu.setEDistrict("������"
										+ excut.getEDistrict());
								objb[ob] = excut.getEDistrict();
							} else {
								excu.setEDistrict("������δ��д");
								objb[ob] = "δ��д";
							}
							ob++;
						}
						if (bdayin[a].equals("6")) {
							objb[ob] = "�Ǽǻ�أ�";
							ob++;
							if (excut.getEOrgan() != null) {
								excu.setEOrgan("�Ǽǻ�أ�" + excut.getEOrgan());
								objb[ob] = excut.getEOrgan();
							} else {
								excu.setEOrgan("�Ǽǻ�أ�δ��д");
								objb[ob] = "δ��д";
							}
							ob++;
						}
						if (bdayin[a].equals("7")) {
							objb[ob] = "��ַ/ס��";
							ob++;
							if (excut.getEAddress() != null) {
								excu
										.setEAddress("��ַ/ס��"
												+ excut.getEAddress());
								objb[ob] = excut.getEAddress();
							} else {
								excu.setEAddress("��ַ/ס��δ��д");
								objb[ob] = "δ��д";
							}
							ob++;
						}
						if (bdayin[a].equals("8")) {
							objb[ob] = "��ҵ״̬��";
							ob++;
							if (excut.getEStatus() != null) {
								excu.setEStatus("��ҵ״̬��" + excut.getEStatus());
								objb[ob] = excut.getEStatus();
							} else {
								excu.setEStatus("��ҵ״̬��δ��д");
								objb[ob] = "δ��д";
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
					listdayin.add(new Object[] { "����ִ������ҵ��Ϣ" });
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
							objc[ob] = "��������ƣ�";
							ob++;
							if (apsel.getAoName() != null) {
								apsel.setAoName("��������ƣ�" + appsel.getAoName());
								objc[ob] = appsel.getAoName();
							} else {
								apsel.setAoName("��������ƣ�δ��д");
								objc[ob] = "δ��д";
							}
							ob++;
						}
						if (cdayin[a].equals("2")) {
							objc[ob] = "�����˵�ַ��";
							ob++;
							if (appsel.getAoAddress() != null) {
								apsel.setAoAddress("�����˵�ַ��"
										+ appsel.getAoAddress());
								objc[ob] = appsel.getAoAddress();
							} else {
								apsel.setAoAddress("�����˵�ַ��δ��д");
								objc[ob] = "δ��д";
							}
							ob++;
						}
						if (cdayin[a].equals("3")) {
							objc[ob] = "��ϵ������";
							ob++;
							if (appsel.getAoName1() != null) {
								apsel
										.setAoName1("��ϵ������"
												+ appsel.getAoName1());
								objc[ob] = appsel.getAoName1();
							} else {
								apsel.setAoName1("��ϵ������δ��д");
								objc[ob] = "δ��д";
							}
							ob++;
						}

						if (cdayin[a].equals("4")) {
							objc[ob] = "��������ƣ�";
							ob++;
							if (appsel.getAoPhone1() != null) {
								apsel.setAoPhone1("��ϵ�˵绰��"
										+ appsel.getAoPhone1());
								objc[ob] = appsel.getAoPhone1();
							} else {
								apsel.setAoPhone1("��ϵ�˵绰��δ��д");
								objc[ob] = "δ��д";
							}
							ob++;
						}
						if (cdayin[a].equals("5")) {
							objc[ob] = "��������ˣ�";
							ob++;
							if (app.getAppRepname() != null) {
								ap
										.setAppRepname("��������ˣ�"
												+ app.getAppRepname());
								objc[ob] = app.getAppRepname();
							} else {
								ap.setAppRepname("��������ˣ�δ��д");
								objc[ob] = "δ��д";
							}
							ob++;
						}
						if (cdayin[a].equals("6")) {
							objc[ob] = "������";
							ob++;
							if (app.getAppDistrict() != null) {
								ap.setAppDistrict("������"
										+ app.getAppDistrict());
								objc[ob] = app.getAppDistrict();
							} else {
								ap.setAppDistrict("������δ��д");
								objc[ob] = "δ��д";
							}
							ob++;
						}
						if (cdayin[a].equals("7")) {
							objc[ob] = "�Ǽǻ�أ�";
							ob++;
							if (app.getAppOrgan() != null) {
								ap.setAppOrgan("�Ǽǻ�أ�" + app.getAppOrgan());
								objc[ob] = app.getAppOrgan();
							} else {
								ap.setAppOrgan("�Ǽǻ�أ�δ��д");
								objc[ob] = "δ��д";
							}
							ob++;
						}
						if (cdayin[a].equals("8")) {
							objc[ob] = "��ַ/ס��";
							ob++;
							if (app.getAppAddress() != null) {
								ap
										.setAppAddress("��ַ/ס��"
												+ app.getAppAddress());
								objc[ob] = app.getAppAddress();
							} else {
								ap.setAppAddress("��ַ/ס��δ��д");
								objc[ob] = "δ��д";
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
					listdayin.add(new Object[] { "������ִ������ϵ��Ϣ" });
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
							listdayin.add(new Object[] { "�ʼ���Ϣ" });
							int mai = 0;
							if (conmailist.size() > 0) {
								for (ContactMail conmai : conmailist) {
									
									objmail = new Object[2];
									conmail = new ContactMail();
									objmail[mai] = "�ʼ���ַ��";
									mai++;
									if (conmai.getCmMail() != null) {
										conmail.setCmMail("�ʼ���ַ��"
												+ conmai.getCmMail() + "<br/>");
										objmail[mai] = conmai.getCmMail();
									} else {
										conmail.setCmMail("�ʼ���ַ��δ��д<br/>");
										objmail[mai] = "δ��д";
									}
									conmaillist.add(conmail);
									listdayin.add(objmail);
									mai = 0;
								}
							} else {
								objmail = new Object[2];
								conmail = new ContactMail();
								conmail.setCmMail("�ʼ���ַ��δ��д<br/>");
								conmaillist.add(conmail);
								objmail[mai] = "�ʼ���ַ��";
								mai++;
								objmail[mai] = "δ��д";
								listdayin.add(objmail);
							}
						}
						
						if (ddayin[a].equals("7")) {
							conmaillist = new ArrayList<ContactMail>();
							ContactMail conmail = null;
							Object[] objmail = null;
							listdayin.add(new Object[] { "�ʼ���Ϣ" });
							int mai = 0;
							if (conmailist.size() > 0) {
								for (ContactMail conmai : conmailist) {
									
									objmail = new Object[2];
									conmail = new ContactMail();
									objmail[mai] = "�ʼ������ˣ�";
									mai++;
									if (conmai.getCmMsender() != null) {
										conmail.setCmMsender("�ʼ������ˣ�"
												+ conmai.getCmMsender() + "<br/>");
										objmail[mai] = conmai.getCmMsender();
									} else {
										conmail.setCmMsender("�ʼ������ˣ�δ��д<br/>");
										objmail[mai] = "δ��д";
									}
									conmaillist.add(conmail);
									listdayin.add(objmail);
									mai = 0;
								}
							} else {
								objmail = new Object[2];
								conmail = new ContactMail();
								conmail.setCmMsender("�ʼ������ˣ�δ��д<br/>");
								conmaillist.add(conmail);
								objmail[mai] = "�ʼ������ˣ�";
								mai++;
								objmail[mai] = "δ��д";
								listdayin.add(objmail);
							}
						}
						
						if (ddayin[a].equals("8")) {
							conmaillist = new ArrayList<ContactMail>();
							ContactMail conmail = null;
							Object[] objmail = null;
							listdayin.add(new Object[] { "�ʼ���Ϣ" });
							int mai = 0;
							if (conmailist.size() > 0) {
								for (ContactMail conmai : conmailist) {
									
									objmail = new Object[2];
									conmail = new ContactMail();
									objmail[mai] = "����ʱ�䣺";
									mai++;
									if (conmai.getCmDate() != null) {
										conmail.setCmDate("����ʱ�䣺"
												+ conmai.getCmDate() + "<br/>");
										objmail[mai] = conmai.getCmDate();
									} else {
										conmail.setCmDate("����ʱ�䣺δ��д<br/>");
										objmail[mai] = "δ��д";
									}
									conmaillist.add(conmail);
									listdayin.add(objmail);
									mai = 0;
								}
							} else {
								objmail = new Object[2];
								conmail = new ContactMail();
								conmail.setCmDate("����ʱ�䣺δ��д<br/>");
								conmaillist.add(conmail);
								objmail[mai] = "����ʱ�䣺";
								mai++;
								objmail[mai] = "δ��д";
								listdayin.add(objmail);
							}
						}
						
						if (ddayin[a].equals("2")) {
							listdayin.add(new Object[] { "�����Ϣ" });
							conexplist = new ArrayList<ContactExpress>();
							ContactExpress conexp = null;
							Object[] objexp = null;
							int exp = 0;
							if (conexlist.size() > 0) {
								for (ContactExpress conex : conexlist) {
									objexp = new Object[2];
									conexp = new ContactExpress();
									objexp[exp] = "��ݺţ�";
									exp++;
									if (conex.getCeNumber() != null) {
										conexp
												.setCeNumber("��ݺţ�"
														+ conex.getCeNumber()
														+ "<br/>");
										objexp[exp] = conex.getCeNumber();
									} else {
										conexp.setCeNumber("��ݺţ�δ��д<br/>");
										objexp[exp] = "δ��д";
									}
									exp = 0;
									conexplist.add(conexp);
									listdayin.add(objexp);
								}
							} else {
								objexp = new Object[2];
								conexp = new ContactExpress();
								conexp.setCeNumber("��ݺţ�δ��д<br/>");
								conexplist.add(conexp);
								objexp[exp] = "��ݺţ�";
								exp++;
								objexp[exp] = "δ��д";
								listdayin.add(objexp);
							}
							exp = 0;
						}
						if (ddayin[a].equals("3")) {
							listdayin.add(new Object[] { "�绰��ϵ��Ϣ" });
							int tel = 0;
							Object[] objtel = null;
							contellist = new ArrayList<ContactTel>();
							ContactTel contel = null;

							if (contelist.size() > 0) {

								for (ContactTel conte : contelist) {
									objtel = new Object[2];
									objtel[tel] = "�绰��ϵ���";
									tel++;
									contel = new ContactTel();
									if (conte.getCtResult() != null) {
										contel
												.setCtResult("�绰��ϵ���"
														+ conte.getCtResult()
														+ "<br/>");
										objtel[tel] = conte.getCtResult();
									} else {
										contel.setCtResult("�绰��ϵ���δ��д<br/>");
										objtel[tel] = "δ��д";
									}
									tel = 0;
									contellist.add(contel);
									listdayin.add(objtel);
								}
							} else {
								objtel = new Object[2];
								objtel[tel] = "�绰��ϵ���";
								tel++;
								objtel[tel] = "δ��д";
								contel = new ContactTel();
								contel.setCtResult("�绰��ϵ���δ��д<br/>");
								contellist.add(contel);
								listdayin.add(objtel);
							}

						}
						Object[] objsin = new Object[6];
						int sin = 0;
						if (ddayin[a].equals("4")) {
							objsin[sin] = "ǩԼʱ�䣺";
							sin++;
							if (consi.getCsDate() != null) {
								objsin[sin] = consi.getCsDate();
								consin.setCsDate("ǩԼʱ�䣺" + consi.getCsDate());
							} else {
								objsin[sin] = "δ��д";
								consin.setCsDate("ǩԼʱ�䣺δ��д");
							}
							sin++;
						}
						if (ddayin[a].equals("5")) {
							objsin[sin] = "ǩԼ��ϵ�ˣ�";
							sin++;
							if (consi.getCsName() != null) {
								objsin[sin]=consi.getCsName();
								consin.setCsName("ǩԼ��ϵ�ˣ�" + consi.getCsName());
							} else {
								objsin[sin]="δ��д";
								consin.setCsName("ǩԼ��ϵ�ˣ�δ��д");
							}
							sin++;
						}
						if (ddayin[a].equals("6")) {
							objsin[sin]="ǩԼ�ţ�";
							sin++;
							if (consi.getCsNo() != null) {
								objsin[sin]=consi.getCsNo();
								consin.setCsNo("ǩԼ�ţ�" + consi.getCsNo());
							} else {
								objsin[sin]="δ��д";
								consin.setCsNo("ǩԼ�ţ�δ��д");
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
		if(applierinfo.getUsedMark() != null){
			usedmark = String.valueOf(applierinfo.getUsedMark());
		}
		
		if(applierinfo.getDisposeResult() != null){
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
					Page="1";
				}
				if(Integer
						.parseInt(Page)>Integer
						.parseInt(PageSize)){
					Page=PageSize;
				}
				List<Court> rs = lawyerSourceServicer.excludeSeniorSelect(Integer
						.parseInt(Page),showNote, 100,exclude, params);
				Map<String, Object> request = ActionContext.getContext().getContextMap();
				request.put("showNote", showNote);
				request.put("rs", rs);
		}else{
			PageSize = lawyerSourceServicer.seniorSelectPageSize(100,showNote, params);
			if(Page.equals("")){
				Page="1";
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

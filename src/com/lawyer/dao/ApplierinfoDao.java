package com.lawyer.dao;

import java.util.List;

import com.lawyer.pojo.Applierinfo;
import com.lawyer.pojo.Court;
import com.lawyer.pojo.Users;

public interface ApplierinfoDao {
	public void insertApp(Applierinfo applierinfo) throws Exception;//�������ִ������ҵ��Ϣ��ע����Ϣ��������־��
//	public Applierinfo selectApp(Applierinfo applierinfo,Users users)throws Exception;//����Ȩ�ޣ���ѯ���޶��󡪡���־��
	public List selectApp(Applierinfo applierinfo)throws Exception;//��ѯ����ִ������ҵ��Ϣ��ע����Ϣ��������־��
	public void updateAppMark(Applierinfo applierinfo)throws Exception;//�����������г���� ������־��
	public void insertMoreApplierinfos(Users user) throws Exception;//��Դ����������ִ������ҵ��Ϣ�����������������־��
	public void insertAppSoft(Applierinfo applierinfo) throws Exception;
	public List<Applierinfo> selAp(Applierinfo applierinfo)throws Exception;
	
	/**
	 * ���������˵���ҵ״̬
	 * @param applierinfo
	 * @throws Exception
	 */
	public void updateAppStatus(Applierinfo applierinfo)throws Exception;
	
	public Applierinfo selectByCasecodeself(String casecodeself)throws Exception;
	
}

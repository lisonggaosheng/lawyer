package com.lawyer.service.impl;

import com.lawyer.dao.AddrecordDao;
import com.lawyer.pojo.Addrecord;
import com.lawyer.service.AddRecordService;

public class AddRecordServiceImpl implements AddRecordService {
	private AddrecordDao ard = null;
	
	public AddrecordDao getArd() {
		return ard;
	}

	public void setArd(AddrecordDao ard) {
		this.ard = ard;
	}

	@Override
	public void insertRecord(Addrecord addrecord) throws Exception {
		ard.insertRecord(addrecord);
	}

}

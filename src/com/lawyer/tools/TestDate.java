package com.lawyer.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestDate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
		try {
			System.out.println(sdf1.format(sdf2.parse("2012-01-01")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

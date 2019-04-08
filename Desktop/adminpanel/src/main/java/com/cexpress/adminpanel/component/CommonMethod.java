package com.cexpress.adminpanel.component;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;



public class CommonMethod {

	
	
	
	public static String  ConcatName(String firstName,String middleName,String lastName)
	{
		String fullName;
		if(middleName.isEmpty())
		{
			fullName=firstName+" "+lastName;
		}
		else
		{
			fullName=firstName+" "+middleName+" "+lastName;
		}
		return fullName;
	}
	
	public static Integer getCurrentMonthNo()
	{
		 Calendar c = Calendar.getInstance();
		
		 Integer month = c.get(Calendar.MONTH)+1;
		 System.out.println("monthno is"+month);
		return month;
		
	}
	public static Integer getCurrentyear() {
		 Calendar c = Calendar.getInstance();
		  Integer year = c.get(Calendar.YEAR);
		return year;
	}

	
	public static List<String>getMonthList()
	{
		List<String> monthList = new ArrayList<>();
		for (int i = 0; i < 12; i++) {
			monthList.add(getMonthForInt(i));
		}
		return monthList;
	}
	
	public static String getMonthForInt(int m) {
		String month = "invalid";
		DateFormatSymbols dfs = new DateFormatSymbols();
		String[] months = dfs.getMonths();
		if (m >= 0 && m <= 11) {
			month = months[m];
		}
		return month;
	}
	
}

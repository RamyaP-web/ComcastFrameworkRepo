package com.comcast.crm.generic.WebDriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getRandomNumber()
	{
		Random random=new Random();
		int randomint=random.nextInt(5000);
		return randomint;
		
	}
	public String getSystemDateYYYYDDMM()
	{
	Date date=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
String date1=	sdf.format(date);
            return date1;
	}
	public   String getDateAfterDays(String format ,int days)
	{
		SimpleDateFormat s = new SimpleDateFormat(format);
		String date = s.format(new Date());
		Calendar c =   s.getCalendar();
		c.add(Calendar.DAY_OF_MONTH, days);
		return s.format(c.getTime());
		
	}

}

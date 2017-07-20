package com.mivim.daoImpl;

import java.sql.Date;
import java.util.Calendar;
import java.util.UUID;

public class Utils {
	
	public static String getUUId()
	{
		return UUID.randomUUID().toString();
	}
	public static Date getDate()
	{
		return new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		
	}
	public static int getStatusCode()
	{
		return 1;
	}

}

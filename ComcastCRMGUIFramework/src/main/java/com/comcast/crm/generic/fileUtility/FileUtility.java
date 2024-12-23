package com.comcast.crm.generic.fileUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {
	
	public String getdatafrompropertyfile(String key) throws Exception
	
	{
		FileInputStream fobj=new FileInputStream("./ConfigarationAppdata/commondata.properties");
		Properties pobj=new Properties();
		pobj.load(fobj);
		String data=pobj.getProperty(key);
		
		return data;
		
	}

}

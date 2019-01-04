package com.wsm.db;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBHelper {
	private static String DRIVER;
	private static String URL;
	private static String NAME;
	private static String PASS;
	public static ComboPooledDataSource cpds=new ComboPooledDataSource();
	static{
		Properties p=new Properties();
		InputStream in=DBHelper.class.getClassLoader().getResourceAsStream("db.properties");
		try {
			p.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DRIVER=p.getProperty("DRIVER");
		URL=p.getProperty("URL");
		NAME=p.getProperty("NAME");
		PASS=p.getProperty("PASS");
		try {
			cpds.setDriverClass(DRIVER);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cpds.setJdbcUrl(URL);
		cpds.setUser(NAME);
		cpds.setPassword(PASS);
		cpds.setInitialPoolSize(10);
		cpds.setAcquireIncrement(10);
		cpds.setMaxPoolSize(100);
	}
}

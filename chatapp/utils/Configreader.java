package com.radhika.chatapp.utils;

import java.util.ResourceBundle;

public class Configreader {

	Configreader(){}
	private static ResourceBundle rb = ResourceBundle.getBundle("config");
	public static String getValue(String key)
	{
		return rb.getString(key);
	}
	
	
	
}

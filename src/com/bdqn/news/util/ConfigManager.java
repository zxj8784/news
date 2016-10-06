package com.bdqn.news.util;

import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;

/**
 * ��ȡ�����ļ��Ĺ�����---ʹ�õ���ģʽ
 * @�ɿ��������ݲ�Ĺ��߰�
 *
 */
public class ConfigManager {
	//��ȡ�����ļ� properties.load(inputstream)
	
	private static ConfigManager configManager;
	private static Properties properties;
	
	private ConfigManager(){
		String configFile = "database.properties";
		properties = new Properties();
		InputStream is = ConfigManager.class.getClassLoader().getResourceAsStream(configFile);
		try {
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ConfigManager getInstance(){
		if(configManager==null){
			configManager = new ConfigManager();
		}
		return configManager;
	}
	
	public String getString(String key){
		return properties.getProperty(key);
	}
	
}

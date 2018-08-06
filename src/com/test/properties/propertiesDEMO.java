package com.test.properties;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

public class propertiesDEMO {

	public static void main(String[] args) {

		//1.ClassLoder讀取配置文件，該方式只能讀取類路徑下的配置文件，有侷限但是如果配置文件在類路徑下比較方便
		try {
			Properties properties = new Properties();
			InputStream in = propertiesDEMO.class.getClassLoader().getResourceAsStream("com/test/config/config1.properties");
			properties.load(in);
			System.out.println(properties.getProperty("host"));
			System.out.println(properties.getProperty("username"));
			System.out.println(properties.getProperty("password"));
			System.out.println();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//2.使用 InputStream 讀取配置文件，該方式的優點在於可以讀取任意路徑下的配置文件
		try {
			Properties properties = new Properties();
			BufferedReader bufferedReader = new BufferedReader(new FileReader("h:/workspace/Properties/WebContent/properties/config2.properties"));
			properties.load(bufferedReader);
			System.out.println(properties.getProperty("host"));
			System.out.println(properties.getProperty("username"));
			System.out.println(properties.getProperty("password"));
			System.out.println();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		//3.使用 ResourceBundle.getBundle() 靜態方法來獲取（ResourceBundle是一個抽象類），這種方式來獲取properties屬性文件不需要加.properties字尾名，只需要文件名即可
		ResourceBundle resource =  ResourceBundle.getBundle("com/test/config/config1");
		System.out.println(resource.getString("host"));
		System.out.println(resource.getString("username"));
		System.out.println(resource.getString("password"));
		System.out.println();
	}

}

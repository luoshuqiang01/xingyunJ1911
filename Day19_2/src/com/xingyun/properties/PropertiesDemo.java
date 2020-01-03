package com.xingyun.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {
	
	public static void Proper() {
		//创建properties容器集合  
		Properties pt = new Properties();
		pt.setProperty("name", "李四");
		pt.setProperty("age", "20");
//		Set<Object> keySet = pt.keySet();
//		Collection<Object> values = pt.values();
		//输出   将你的内存中内容保存到本地的properties文件中
		try {
			FileWriter fw=new FileWriter("d:\\app\\file\\temp\\out.properties");
			pt.store(fw, "这是学生信息");
			fw.close();
		    System.out.println("1233");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(pt);
	}

	
	//读取外部文件  
	public static void getProper() {
		try {
			FileInputStream fis = new FileInputStream("db.properties");
			InputStreamReader isr= new InputStreamReader(fis,"utf-8");
			Properties pt = new Properties();
			pt.load(isr);
			//获取key值
			Set<Object> keySet = pt.keySet();
			System.out.println(keySet);
			//获取value
			Collection<Object> values = pt.values();
			System.out.println(values);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		getProper();
	}
	
	
	
}

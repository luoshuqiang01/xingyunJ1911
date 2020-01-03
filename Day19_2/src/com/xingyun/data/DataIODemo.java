package com.xingyun.data;

import java.io.DataInputStream;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
/**
 * 数据流
 * @author Administrator
 *
 */
public class DataIODemo {
	
	static Student[] stu =new Student[3];
	
	//创建学生对象 把学生信息保存到一个数组中
	public static Student[] creatStu() {
		Student stu1 = new Student("吉星亮",28,'男');
		Student stu2 = new Student("孙悟空",15,'男');
		Student stu3 = new Student("张修杜",18,'中');
		stu[0]=stu1;
		stu[1]=stu2;
		stu[2]=stu3;
		return stu;
	}
	
	//写出数据
	public static void dataOutput() {
		//创建数据输出流  指定写出去的位置
		try {
			DataOutputStream dos =new DataOutputStream(new FileOutputStream("d:\\app\\file\\temp\\date.txt"));
			//使用对应的writer方法写数据
			Student[] stus = creatStu();
			for(int i=0;i<stus.length;i++) {
				dos.writeUTF(stus[i].getName());
				dos.writeInt(stus[i].getAge());
				dos.writeChar(stus[i].getSex());
			}
			dos.flush();
			dos.close();
			System.out.println(Arrays.toString(stu));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	//获取的文件必须是data写出去的文件
	public static void dataInput() {
		try {
			DataInputStream dis = new DataInputStream(new FileInputStream("d:\\app\\file\\temp\\date.txt"));
			//读取的数据使用对应的变量进行保存
			//并且按照写入的顺序进行读取
			System.out.println(stu.length);
			System.out.println(DataIODemo.stu.length);
			ArrayList<Student> stulist= new ArrayList();
			for(int i=0;i<stu.length;i++) {
					Student stu = new Student();
					stu.setName(dis.readUTF());
					stu.setAge(dis.readInt());
					stu.setSex(dis.readChar());
					stulist.add(stu);
			}
			//使用iterator迭代器
			Iterator<Student> iterator = stulist.iterator();
			while(iterator.hasNext()) {
				System.out.println(iterator.next());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

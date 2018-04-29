package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Data {
	static String totalData = "";
	static{
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("C:\\0.BigData\\4.web\\ysproject\\songlist.json"));
			String data = in.readLine();
			while(data != null) {
				totalData = totalData + data;
				data = in.readLine();
				System.out.println(totalData);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static String jsonData(){
		return totalData;
	}
}









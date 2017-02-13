package com.prepare.java;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class EmployeeClient {
	public static void main(String args[])throws Exception {
		
		FileInputStream in=new FileInputStream("R:\\Studies\\Advance java\\jdbc\\Prepare\\src\\com\\prepare\\java\\jdbc.properties");
		Properties p=new Properties();
		p.load(in);
		
		String driver=p.getProperty("driver");
		String url=p.getProperty("url");
		String user=p.getProperty("user");
		String pass=p.getProperty("pass");
		
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url,user,pass);
		
		String sql="insert into employee values(?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		
		
		ps.setInt(1, 5);
		ps.setString(2,"ravi");
		ps.setDouble(3,6000.00);
		
		ps.setInt(1, 6);
		ps.setString(2,"fgh");
		ps.setDouble(3,6000.00);
		
		int r=ps.executeUpdate();
		System.out.println(r);
		in.close();
		ps.close();
		con.close();
	}
	
}

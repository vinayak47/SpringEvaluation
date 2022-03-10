package com.icreon.demo.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

@Service
public class Myconnection {

	

	public static Connection con ;
	public PreparedStatement pst;
		
		public static Connection getConnection() {

			String url = "jdbc:mysql://localhost:3306/capstone";
			String username = "root";
			String password = "root";
			
			try {
				if(con==null) {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, username, password);
				}
				} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			} return con ;
		
		}
}

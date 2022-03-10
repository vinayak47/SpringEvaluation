package com.icreon.demo.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.icreon.demo.model.User;



@Service
public class userDao {

//	@Autowired
//	User users;
	

	private static Connection con;

	public userDao(Connection con) {
		this.con = con;
	}
	
	public userDao() {
		
	}

	public static User getUserByUsernameAndPassword(String username, String password) {
		User user = null;

		try {

			String query = "select * from users where username =? and password=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, password);

			ResultSet set = pstmt.executeQuery();

			if (set.next()) {
				user = new User();

                user.setUsername(set.getString("username"));
				user.setPassword(set.getString("password"));
				

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;

	}
}

package com.radhika.chatapp.dao;
import java.sql.PreparedStatement;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.radhika.chatapp.dto.UserDTO;
import com.radhika.chatapp.utils.Encryption;

public class UserDAO {
// Throws , we don't handle , caller will handle , work at function level
	// throw - work at statement level
	
	public boolean isLogin(UserDTO userDTO ) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException,Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		final String SQL = "select userid from users where userid=? and password=?";
		try
		{
			con = CommonDAO.createConnection();
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, userDTO.getUserid());
			String encryptedPwd = Encryption.passwordEncrpt(new String(userDTO.getPassword()));
			pstmt.setString(2, encryptedPwd);
			rs = pstmt.executeQuery();
			return rs.next();
		}
		finally
		{
			if(rs!= null)
			{
				rs.close();
			}
			if(pstmt != null)
			{
				pstmt.close();
			}
			
			if(con!= null)
			{
				con.close();
			}
		}
	
	}
	public int add(UserDTO userDTO) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, Exception
	{
		System.out.println("Rec " + userDTO.getUserid() + "  " + userDTO.getPassword());
		Connection connection = null;
		Statement stmt = null; // query
		try { // guarded region , exception may occur here
		connection = CommonDAO.createConnection(); // step -1 connection create
		// step2 - we do a query
		stmt = connection.createStatement();
		//insert into users (userid , password) values('ram' ,'ram123');
		int record = stmt.executeUpdate("insert into users (userid , password) values('"+userDTO.getUserid()+"','"+Encryption.passwordEncrpt(new String(userDTO.getPassword()))+"')"); // Insert , delete , update
		return record;
		}
		finally { // Always executed but did'nt executed if we write system.exit(0)
			if(stmt != null)
			{
		       stmt.close();
			}
			if(connection != null)
			{
			
		      connection.close();
			}
		}
		
	}
}

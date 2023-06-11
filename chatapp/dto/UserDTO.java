package com.radhika.chatapp.dto;
// data transfer object , transfer data from screen to DAO , its a design pattern
public class UserDTO {

	private String userid;
	private char[] password;
	public UserDTO(String userid , char[] password)
	{
		this.userid = userid;
		this.password = password;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public char[] getPassword() {
		return password;
	}
	public void setPassword(char[] password) {
		this.password = password;
	}
	
	
}

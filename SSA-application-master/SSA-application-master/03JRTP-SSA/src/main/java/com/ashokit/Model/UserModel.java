package com.ashokit.Model;

import java.util.Date;

import lombok.Data;

@Data
public class UserModel {
	
	//private Long ssn;

	private String fname;

	private String lname;

	private String gender;

	private Date dob;
	
//	private byte[] photo;
	
	private String state;
	
//private Date createddate;

}

package com.ashokit.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Table(name = "USER_MASTER01")
@Data
public class UserEntity {

	@Id
	@Column(name = "SSN_NUMBER")
	@GenericGenerator(name = "ssn_gen", strategy = "com.ashokit.EntityCustomIdGen.CustomGenerator")
	@GeneratedValue(generator = "ssn_gen")

//	@SequenceGenerator(sequenceName = "SSN_SEQ_TEST", name = "SSN_SEQ", allocationSize = 1)
//	@GeneratedValue(generator = "SSN_SEQ", strategy = GenerationType.SEQUENCE)
	private Long ssn;

	@Column(name = "First_Name")
	private String fname;

	@Column(name = "Last_Name")
	private String lname;

	@Column(name = "Gender")
	private String gender;

	@Temporal(TemporalType.DATE)
	@Column(name = "DateofBirth")
	private Date dob;

//	@Column(name = "PHOTO")
//	private byte[] photo;

	@Column(name = "State")
	private String state;

	@CreationTimestamp
	@Column(name = "Created_Date")
	private Date createddate;

}

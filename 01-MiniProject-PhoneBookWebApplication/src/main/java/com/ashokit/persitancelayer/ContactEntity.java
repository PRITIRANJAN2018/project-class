package com.ashokit.persitancelayer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "contact_dtls")
public class ContactEntity {
	
	
	@Id
	@GeneratedValue
	@Column(name = "contact_id")
	private Integer cid;
	@Column(name = "contact_name")
	private String cname;
	@Column(name = "contact_mail")
	private String cmail;
	@Column(name = "contact_phno")
	private Long phno;

}

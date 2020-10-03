package com.ashokit.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ContactDtlsDTO implements Serializable {
	
	private Integer cid;
	private String cname;
	private String cmail;
	private Long phno;

}

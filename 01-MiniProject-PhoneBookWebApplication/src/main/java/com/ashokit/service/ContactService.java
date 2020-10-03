package com.ashokit.service;

import java.util.List;

import com.ashokit.dto.ContactDtlsDTO;

public interface ContactService {
	
	public boolean saveContact(ContactDtlsDTO dto);
	public List<ContactDtlsDTO> getAllContacts();
	
	public ContactDtlsDTO getContactById(Integer cid);
	public boolean updateContacts(ContactDtlsDTO dto);
	public boolean delateContacts(Integer cid);

}

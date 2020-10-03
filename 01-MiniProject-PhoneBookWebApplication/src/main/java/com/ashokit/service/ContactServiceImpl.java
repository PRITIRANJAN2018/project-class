package com.ashokit.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.dto.ContactDtlsDTO;
import com.ashokit.persitancelayer.ContactDtlsRepository;
import com.ashokit.persitancelayer.ContactEntity;

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactDtlsRepository contactRepo;
	
	@Override
	public boolean saveContact(ContactDtlsDTO dto) {
		ContactEntity entity=new ContactEntity();
		BeanUtils.copyProperties(dto, entity);
		ContactEntity contactEntity = contactRepo.save(entity);//save() call from JpaRepository class for save the data
		
		return contactEntity.getCid()!=null;
	}

	@Override
	public List<ContactDtlsDTO> getAllContacts() {
		//List<ContactDtlsDTO> contactList=new ArrayList<ContactDtlsDTO>();
		List<ContactDtlsDTO> contactList=new ArrayList();
		
		List<ContactEntity> entitesList = contactRepo.findAll();//it gives all the records from table by use findAll() which is present in JpaRepository class
		
		entitesList.forEach(entity->{
			ContactDtlsDTO dto=new ContactDtlsDTO();
			BeanUtils.copyProperties(entity, dto);
			contactList.add(dto);
		});                                             //here entity is a variable
		return contactList;
	}

	@Override
	public ContactDtlsDTO getContactById(Integer cid) {
		
		Optional<ContactEntity> optional = contactRepo.findById(cid); //here by the help of cid we want to edit the data 
		if(optional.isPresent()) {
			ContactEntity entity = optional.get();
			ContactDtlsDTO dto=new ContactDtlsDTO();
			BeanUtils.copyProperties(entity, dto);
			return dto;
		}
		
		return null;
	}

	@Override
	public boolean updateContacts(ContactDtlsDTO dto) {
		
		return false;
	}

	@Override
	public boolean delateContacts(Integer cid) {
		
		contactRepo.deleteById(cid);  //delete single obj by help of pk paticular record delete
		
		return true;
	}

}

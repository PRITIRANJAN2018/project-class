package com.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.dto.ContactDtlsDTO;
import com.ashokit.service.ContactService;

@Controller
public class ViewContactController {

	@Autowired
	private ContactService  contactservice;
	
	
	//  editContact?cid=${contact.cid}
	//  editContact?cid=16?name='rajesh'         here ?cid is same as requestparam key name 
	@GetMapping("/editContact")
	public String editContact(@RequestParam("cid") Integer cid,Model model) {   //@Requestparam=Annotation which indicates that a method parameter should be bound to a webrequest parameter. 
		
		ContactDtlsDTO contactById = contactservice.getContactById(cid);
		model.addAttribute("contact",contactById);
		
		return "index";   //here send the contact obj with data
	}
	
	@GetMapping("/deleteContact")
	public String deleteCntact(@RequestParam("cid") Integer cid,RedirectAttributes attribute) {
		
		boolean isDeleted = contactservice.delateContacts(cid);
		if(isDeleted)
			attribute.addFlashAttribute("deleCont", "delete successfully");
			return "redirect:/viewContacts";   //means it is redirect in view page so mapping happen view all data
											//actualy this is method url pattern
	}
}

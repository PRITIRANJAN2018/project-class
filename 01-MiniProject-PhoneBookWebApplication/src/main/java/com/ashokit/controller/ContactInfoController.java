package com.ashokit.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.dto.ContactDtlsDTO;
import com.ashokit.service.ContactService;


@Controller
public class ContactInfoController {
	
	private static final Logger logger=LoggerFactory.getLogger(ContactInfoController.class);
	
	
	@Autowired
	private ContactService contactService;
	
	
	@GetMapping(value = { "/", "/loadFrom"})//->  /loadForm
	public String loadContactFrom(Model model) {
		
		logger.debug("**loadContactFrom() method execution started**");
		
		ContactDtlsDTO contactdto=new ContactDtlsDTO();
		model.addAttribute("contact", contactdto);
		
		logger.debug("**loadContactFrom() method execution ended**");
		
		logger.info("***loadContactFrom() method executed successfuly ***");
		
		return "index";  //here we send the empty object
	}
	
	@PostMapping("/saveContact")
	public String handleSubmitBtn(@ModelAttribute("contact") ContactDtlsDTO dto, RedirectAttributes attribut) {
		
		logger.debug("***handleSubmitBtn() method started ***");
		
		boolean isSave = contactService.saveContact(dto);
	
		if(isSave) {
			
			if(dto.getCid()!=null) {
			
				attribut.addFlashAttribute("succMsg", "contact  updated");
				logger.info("**contact updated successfully**");
			}
			else {
			
			attribut.addFlashAttribute("succMsg", "contact saved");
			logger.info("**contact saved successfully**");
			}
		}
		else {
			
			attribut.addFlashAttribute("errMsg", "Failed to save msg");
		}
		
		logger.debug("***handleSubmitBtn() method execution completed***");
		
		return "redirect:loadFrom"; 
	}
	
	
	@GetMapping("/viewContacts")
	public String handleViewCtcsHyperLink(Model model) {
		
		logger.debug("***handleViewCtcsHyperLink() method execution started***");
		
		List<ContactDtlsDTO> allContacts = contactService.getAllContacts();
		model.addAttribute("contacts",allContacts);
		logger.debug("***handleViewCtcsHyperLink() method execution completed***");
		
		logger.info("**handleViewCtcsHyperLink() method completed successfully**");
		return "viewContact";
	}

}

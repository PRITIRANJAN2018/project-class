package com.ashokit.controller;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.model.User;

@Controller
public class UserController {
	
	org.slf4j.Logger logger=LoggerFactory.getLogger(UserController.class);

	/**
	 * This method is used to load User Account creation form
	 * 
	 * @param model
	 * @return String
	 */
	
	
	@RequestMapping(value = {"/","createUserAcc"},method = RequestMethod.GET)
	
	public String loadUserForm(Model model) {
		
		model.addAttribute("usermodel", new User());//here value is User class object
		
		//return logical view name
		return "createUserAcc";
	}
	
	/**
	 * This method use for form submission.
	 * @param user
	 * @param model
	 * @return
	 */
	
	@RequestMapping(value = {"/create"},method = RequestMethod.POST)
	public String createUser(@ModelAttribute("usermodel") User user,RedirectAttributes att) {
		logger.info("user submitted"+user);
		
		att.addFlashAttribute("msg", "contact saved");
		return "redirect:useracccreatesuccs";
	}
	/**
	 * 
	 * @return
	 */
	
	@RequestMapping(value = {"/useracccreatesuccs"},method =RequestMethod.GET)
	public String userAccCreateSucc(Model model) {
		logger.info("userAccCreateSucc() creatred ");
		model.addAttribute("usermodel", new User());
		return "createUserAcc";
	}
	
}

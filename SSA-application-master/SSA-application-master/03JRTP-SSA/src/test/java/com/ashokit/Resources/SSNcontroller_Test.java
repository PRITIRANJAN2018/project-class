package com.ashokit.Resources;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ashokit.Model.UserModel;
import com.ashokit.Properties.AppProperties;
import com.ashokit.Service.SSNService;

@WebMvcTest(SSNcontroller.class)
public class SSNcontroller_Test {

	@Autowired
	private MockMvc mvc;

	@MockBean
	SSNService ssnService;

	@MockBean
	private AppProperties prop;

	@Test
	public void verifyreuslt_01() throws Exception {

		UserModel model = new UserModel();
		model.setFname("Anoop");
		model.setLname("Aswal");
		model.setDob(new Date());
		model.setState("UKD");

		when(ssnService.findUserByssn(12345l)).thenReturn(model);
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/verify/12345");

		MvcResult mvcResult = mvc.perform(builder).andReturn();

		MockHttpServletResponse response = mvcResult.getResponse();
		
		int status = response.getStatus();

		assertEquals(200,status);
	}
   
	
	
	@Test
	public void handleform_01() throws Exception {

		UserModel model = new UserModel();
		model.setFname("Anoop");
		model.setLname("Aswal");
		model.setDob(new Date());
		model.setState("UKD");

		when(ssnService.saveUserData(model)).thenReturn(222222l);
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/enroll");

		MvcResult mvcResult = mvc.perform(builder).andReturn();

		MockHttpServletResponse response = mvcResult.getResponse();
		
		int status = response.getStatus();

		assertEquals(201,status);
	}

}

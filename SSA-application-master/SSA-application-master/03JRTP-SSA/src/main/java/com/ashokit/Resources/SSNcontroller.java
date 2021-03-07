package com.ashokit.Resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.Model.UserModel;
import com.ashokit.Properties.AppProperties;
import com.ashokit.Service.SSNService;
import com.ashokit.constants.AppConstants;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="This is an API for SSA ")
public class SSNcontroller {

	@Autowired
	SSNService ssnService;
	
	@Autowired
	private AppProperties prop;

	@PostMapping("/enroll")
	@ApiOperation(value="Enrolment for SSN", notes="provide User details to generate SSN")
	public String handleEnrollForm(@RequestBody UserModel user) {
		long ssn = ssnService.saveUserData(user);
		if (ssn == 0) {

			return prop.getMsg().get(AppConstants.ERR);
		} else {

			StringBuilder str=new StringBuilder();
			StringBuilder formatedssn = str.append(String.valueOf(ssn).substring(0, 3)).
			                    append(",").append(String.valueOf(ssn).substring(3, 5)).
			                    append(",").append(String.valueOf(ssn).substring(5, 9));
			
			    return prop.getMsg().get(AppConstants.SUCC) + formatedssn;
		}

	}

	@GetMapping("/verify/{ssn}")
	@ApiOperation(value="Get Citizen Data" ,notes="provide a valid SSN to See Citizen Data")
	public ResponseEntity<UserModel> getCitizenDataByssn(@PathVariable("ssn") Long ssn) {

		UserModel user = ssnService.findUserByssn(ssn);
		return ResponseEntity.ok(user);

	}

}

package com.ashokit.Service;

import org.springframework.stereotype.Service;

import com.ashokit.Model.UserModel;

@Service
public interface SSNService {

	public long saveUserData(UserModel user);

	public UserModel findUserByssn(Long ssn);

}

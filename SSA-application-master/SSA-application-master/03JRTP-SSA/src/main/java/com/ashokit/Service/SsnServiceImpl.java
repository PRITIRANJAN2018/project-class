package com.ashokit.Service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.Entity.UserEntity;
import com.ashokit.Model.UserModel;
import com.ashokit.Repository.UserRepository;
import com.ashokit.exceptions.NoDataFoundException;

@Service
public class SsnServiceImpl implements SSNService {

	@Autowired
	UserRepository repo;

	@Override
	public long saveUserData(UserModel user) {
		UserEntity entity = new UserEntity();
		BeanUtils.copyProperties(user, entity);
		UserEntity savedentity = repo.save(entity);
		if (savedentity != null && (savedentity.getSsn() != null)) {

			return savedentity.getSsn();
		} else {
			return 0;
		}
	}

	@Override
	public UserModel findUserByssn(Long ssn) {
		Optional<UserEntity> optional = repo.findById(ssn);
		UserModel user = new UserModel();

		if (optional.isEmpty()) {
			
			throw new NoDataFoundException("SSN NOT FOUND");
			
		} else {
			
			UserEntity entity = optional.get();
			BeanUtils.copyProperties(entity, user);
			return user;
			
		}

	}

}

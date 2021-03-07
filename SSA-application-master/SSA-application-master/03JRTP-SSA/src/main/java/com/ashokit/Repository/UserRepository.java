package com.ashokit.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.Entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Serializable> {

}

package com.vinay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinay.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}

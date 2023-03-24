package com.vinay.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vinay.model.Role;
import com.vinay.model.User;
import com.vinay.repository.RoleRepository;
import com.vinay.repository.TaskRepository;
import com.vinay.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	
	 private static final String ADMIN="ADMIN";
	    private static final String USER="USER";

	    @Autowired
	    private UserRepository userRepository;
	    @Autowired
	    private RoleRepository roleRepository;
//	    @Autowired
//	    private PasswordEncoder bCryptPasswordEncoder;


	    @Override
	    public User createUser(User user) {
//	        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	        Role userRole = roleRepository.findByRole(USER);
	        user.setRoles(new ArrayList<>(Collections.singletonList(userRole)));
	        return userRepository.save(user);
	    }

	    @Override
	    public User changeRoleToAdmin(User user) {
	        Role adminRole = roleRepository.findByRole(ADMIN);
	        user.setRoles(new ArrayList<>(Collections.singletonList(adminRole)));
	        return userRepository.save(user);
	    }

	    @Override
	    public List<User> findAll() {
	        return userRepository.findAll();
	    }

	    @Override
	    public User getUserByEmail(String email) {
	        return userRepository.findByEmail(email);
	    }

	    @Override
	    public boolean isUserEmailPresent(String email) {
	        return userRepository.findByEmail(email) != null;
	    }

	    @Override
	    public User getUserById(Long id) {
	        return userRepository.findById(id).orElse(null);
	    }

	    @Override
	    public void deleteUser(Long id) {
	        User user = userRepository.findById(id).get();
	        user.getTasksOwned().forEach(task -> task.setOwner(null));
	        userRepository.delete(user);
	    }


}

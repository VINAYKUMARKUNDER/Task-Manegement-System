package com.vinay.service;

import java.util.List;

import com.vinay.model.Role;

public interface RoleService {
	Role createRole(Role role);

    List<Role> findAll();

}

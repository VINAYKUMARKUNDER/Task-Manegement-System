package com.vinay.service;


import com.vinay.model.Role;

import java.util.List;

public interface RoleService {
	
	/**
	 * 
	 * @param role: role parameter is pass by user 
	 * @return: return a new role first store data in role database table then return
	 */
    Role createRole(Role role);

    /**
     * 
     * @return: return all list of roll by database when we are  fetch value
     */
    List<Role> findAll();
}

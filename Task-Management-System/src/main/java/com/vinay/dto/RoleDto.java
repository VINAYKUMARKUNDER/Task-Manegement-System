package com.vinay.dto;

import java.util.List;

import com.vinay.model.User;

import lombok.Data;

@Data
public class RoleDto {
	
	private Integer id;
    private String role;
    private List<User> users;

}

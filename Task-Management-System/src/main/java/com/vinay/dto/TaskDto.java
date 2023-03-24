package com.vinay.dto;

import java.time.LocalDate;


import com.vinay.model.User;

import lombok.Data;

@Data
public class TaskDto {
	
	private Long id;
    private String name;
    private String description;
    private LocalDate date;
    private boolean isCompleted;
    private String creatorName;
    private User owner;


}

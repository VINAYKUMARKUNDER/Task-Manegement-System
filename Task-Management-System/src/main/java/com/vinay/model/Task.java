package com.vinay.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Task {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "task_id")
	    private Long id;

	    private String name;
	
	    @Column(length = 1200)
	    
	    private String description;
	  
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private LocalDate date;
	    
	    private boolean isCompleted;
	    private String creatorName;
	    
	    @ManyToOne
	    @JoinColumn(name = "OWNER_ID")
	    private User owner;

}

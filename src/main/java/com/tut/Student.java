package com.tut;
// Hibernate using annotation

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
	
	@Id
	private int id;
	private String name;
	private String city;
//	After providing @id go to hibernate.cfg.xml file for mapping the class.
	
	

}

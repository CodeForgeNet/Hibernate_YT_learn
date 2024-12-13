package com.OneToOneMapping;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Question {
	
	@Id
	@Column(name="question_id")
	private int questionId;
	private String questions;
	

//	Start -> One to One 
	@OneToOne
	@JoinColumn(name="a_id")
	private Answer answer;
//	End -> One to One
	
	
	
}

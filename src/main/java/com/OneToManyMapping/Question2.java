package com.OneToManyMapping;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Question2 {
	
	@Id
	@Column(name="question_id")
	private int questionId;
	private String questions;

	@OneToMany(mappedBy = "quest")
	private List<Answer2> answers;
	
	
	
}

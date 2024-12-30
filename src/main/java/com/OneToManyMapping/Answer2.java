package com.OneToManyMapping;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Answer2 {

	@Id
	@Column(name="answer_id")
	private int answerId;
	private String answers;
	
	@ManyToOne
	private Question2 quest;
	
}

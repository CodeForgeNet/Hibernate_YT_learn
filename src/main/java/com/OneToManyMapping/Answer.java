package com.OneToManyMapping;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Answer {

	@Id
	@Column(name="answer_id")
	private int answerId;
	private String answers;
	
//	After creating answer column in question table (i.e; unidirectional oneToOne mapping) . After that
//	Here we create Question column in answer table then we get both directional mapping (i.e; bidirectional oneToOne Mapping)
	
//	After using mappedBy in OneToOne it will create only answer column in question table. Either uni or multi directional mapping
	@OneToOne(mappedBy = "answer") // if we remove mappedBy then in answer table also have questionId column as a foreign key.
	private Question q;
	
}

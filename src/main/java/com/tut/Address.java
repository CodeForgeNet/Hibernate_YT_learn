package com.tut;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="student_address")
public class Address {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  // to use auto increment in id we have to write IDENTITY inside @GeneratedValue.
	@Column(name="add_id")	//To change column id name.
	private int addressId;
	
	@Column(length=50,name="Street")
	private String street;
	
	@Column(name="City",length=100)
	private String city;
	 
	private boolean isOpen;
	
	@Transient	// it didn't create column in table 
	private double x;
	
	@Column(name="Date")
	@Temporal(TemporalType.DATE) // It shows only date not the time.
	private Date addedDate;
	
	@Lob
	@Column(name = "img", columnDefinition="MEDIUMBLOB")
	private byte[] img;
	

}

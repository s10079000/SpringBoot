package com.example.demo.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter @Setter
@ToString
public class Currency {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	int id;
	
	@Id
	private String coinCode;
	
	@Column
	private String cName;
	
}

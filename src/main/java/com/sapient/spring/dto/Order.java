package com.sapient.spring.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class Order {

	private String item;
	private float price;
	
}

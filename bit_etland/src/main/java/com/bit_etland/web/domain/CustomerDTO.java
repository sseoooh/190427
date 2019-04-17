package com.bit_etland.web.domain;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data @Component
public class CustomerDTO {
	private String customerId, customerName, password, ssn, phone, city, address, postalCode, photo;
}

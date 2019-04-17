package com.bit_etland.web.domain;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data @Component
public class EmployeeDTO {
	
	String employeeId, manager, name, birthDate, photo, notes;
}
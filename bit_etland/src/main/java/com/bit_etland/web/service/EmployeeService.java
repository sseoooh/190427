package com.bit_etland.web.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;


import com.bit_etland.web.domain.EmployeeDTO;

@Component
public interface EmployeeService {
		//C
		public void createCustomer(EmployeeDTO empl);
		//R
		public List<EmployeeDTO> findAllCustomers();
		public List<EmployeeDTO> findSomeCustomers(HashMap<String, Object> hash);
		public EmployeeDTO findCustomer(EmployeeDTO empl);
		//U
		public void modifyCustomer(EmployeeDTO empl);
		//D
		public void removeCustomer(EmployeeDTO empl);
	}



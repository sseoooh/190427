package com.bit_etland.web.service;

import java.util.HashMap;
import java.util.List;


import org.springframework.stereotype.Service;

import com.bit_etland.web.domain.EmployeeDTO;


@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	
	@Override
	public void createCustomer(EmployeeDTO empl) {
		
	}

	@Override
	public List<EmployeeDTO> findAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeDTO> findSomeCustomers(HashMap<String, Object> hash) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeDTO findCustomer(EmployeeDTO empl) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyCustomer(EmployeeDTO empl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCustomer(EmployeeDTO empl) {
		// TODO Auto-generated method stub
		
	}

}

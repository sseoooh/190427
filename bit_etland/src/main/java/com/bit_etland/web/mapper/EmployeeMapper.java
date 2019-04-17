package com.bit_etland.web.mapper;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bit_etland.web.domain.EmployeeDTO;



@Repository
public interface EmployeeMapper {
	//C
	public void insertCustomer(EmployeeDTO empl);
	//R
	public List<EmployeeDTO> selectAllCustomers();
	public List<EmployeeDTO> selectSomeCustomers(HashMap<String, Object> hash);
	public EmployeeDTO selectCustomer(EmployeeDTO empl);
	//U
	public void updateCustomer(EmployeeDTO empl);
	//D
	public void deleteCustomer(EmployeeDTO empl);
}

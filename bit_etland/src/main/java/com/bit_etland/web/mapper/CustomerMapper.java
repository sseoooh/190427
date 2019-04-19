package com.bit_etland.web.mapper;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bit_etland.web.domain.CustomerDTO;

@Repository
public interface CustomerMapper {
	//C
	public void insertCustomer(CustomerDTO cust);
	//R
	public List<CustomerDTO> selectAllCustomers(HashMap<String, String> hash);
	public List<CustomerDTO> selectSomeCustomers(HashMap<String, Object> hash);
	public CustomerDTO selectCustomer(CustomerDTO cust);
	public int countCustomers();
	//U
	public void updateCustomer(CustomerDTO cust);
	//D
	public void deleteCustomer(CustomerDTO cust);
}

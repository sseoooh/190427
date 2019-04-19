package com.bit_etland.web.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;


import com.bit_etland.web.domain.CustomerDTO;

@Component
public interface CustomerService {
	//C
	public void createCustomer(CustomerDTO cust);
	//R
	public List<CustomerDTO> findAllCustomers(HashMap<String, String> hash);
	public List<CustomerDTO> findSomeCustomers(HashMap<String, Object> hash);
	public CustomerDTO findCustomer(CustomerDTO cust);
	public int countCustomers();
	//U
	public void modifyCustomer(CustomerDTO cust);
	//D
	public void removeCustomer(CustomerDTO cust);
}

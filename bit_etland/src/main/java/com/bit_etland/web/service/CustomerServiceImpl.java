package com.bit_etland.web.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit_etland.web.domain.CustomerDTO;
import com.bit_etland.web.mapper.CustomerMapper;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired CustomerMapper custMap;
	
	@Override
	public void createCustomer(CustomerDTO cust) {
		custMap.insertCustomer(cust);
	}

	@Override
	public List<CustomerDTO> findSomeCustomers(HashMap<String, Object> hash) {
		return null;
	}

	@Override
	public CustomerDTO findCustomer(CustomerDTO cust) {
		return custMap.selectCustomer(cust);
	}

	@Override
	public int countCustomers() {
		return custMap.countCustomers();
	}

	@Override
	public void modifyCustomer(CustomerDTO cust) {
		custMap.updateCustomer(cust);
	}

	@Override
	public void removeCustomer(CustomerDTO cust) {
		custMap.deleteCustomer(cust);
	}

	@Override
	public List<CustomerDTO> findAllCustomers(HashMap<String, String> hash) {
		custMap.selectAllCustomers(hash);
		return custMap.selectAllCustomers(hash);
	}
	
}

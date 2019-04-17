package com.bit_etland.web.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bit_etland.web.domain.CustomerDTO;

import com.bit_etland.web.service.CustomerServiceImpl;

@RestController
public class CustomerController {
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired CustomerDTO custdto;
	@Autowired CustomerServiceImpl customerService;
	@Autowired List<CustomerDTO> list;
	@Autowired HashMap<String, Object> map;
	
	/*회원가입*/
	@PostMapping("/customers")
	public HashMap<?, ?> join(
			@RequestBody CustomerDTO cust){
		System.out.println("Customer컨트롤러 안에 회원가입탐");
		customerService.createCustomer(cust);
		map.clear();
		map.put("msg", "join success");
		return map;
	}
	/*로그인*/
	@PostMapping("/customers/{userid}")
	public CustomerDTO login(
			@RequestBody CustomerDTO cust,
			@PathVariable String userid) {
		System.out.println("Customer컨트롤안에 로그인탐");
		logger.info("CustomerController에 login진입");
		
		custdto = customerService.findCustomer(cust);
		System.out.println(custdto.toString());
		return custdto;
	}

	/*수정하기*/
	@PutMapping("/customers/{userid}")
	public HashMap<?, ?> update(
			@RequestBody CustomerDTO cust,
			@PathVariable String userid) {
		System.out.println("Customer컨트롤러 안에 업데이트탐");
		customerService.modifyCustomer(cust);
		map.clear();
		map.put("msg", "update success");
		System.out.println("map에 들어있는값"+map.toString());
		return map;
	}
	/*탈퇴*/
	@DeleteMapping("/customers/{userid}")
	public HashMap<?, ?> delete(
			@RequestBody CustomerDTO cust,
			@PathVariable String userid){
		System.out.println("Customer컨트롤러 안에 삭제함");
		customerService.removeCustomer(cust);
		map.clear();
		map.put("msg", "remove 성공");
		return map;
	}
}

package com.bit_etland.web.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bit_etland.web.domain.CustomerDTO;
import com.bit_etland.web.service.CustomerServiceImpl;

@RestController
public class CustomerController {
	private int blockSize;
	private boolean existPrev;
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired CustomerDTO custdto;
	@Autowired CustomerServiceImpl customerService;
	@Autowired List<CustomerDTO> list;
	@Autowired HashMap<String, Object> map;
	
	/*회원목록*/
	@GetMapping("/customers/{page}")
	public HashMap<?, ?> custListAll(
			@PathVariable String page) {
		System.out.println("일단 여기탐?");
		int pageSize = 5; 
		logger.info("=======  CustomerController custlist 진입 ======");
		System.out.println("MyBatis에서 넘어온 페이지번호" + page);
		
		int pageNum = Integer.parseInt(page);
		
		existPrev = (blockSize>=pageNum)?false:true;
		
		/* 게시글 시작하는 번호 */
		String startRowNum = String.valueOf(pageSize * (pageNum - 1));
		System.out.println("startRowNum의 값" + startRowNum);

		/* 전체 게시글 수 가져오기 */
		 int totalPageNum = customerService.countCustomers();
		 System.out.println("totalPageNum의 값" + totalPageNum);
		 
		 /* 게시글 끝나는 번호 */ 
		 String endRowNum = String.valueOf((totalPageNum > pageNum * pageSize) ? pageNum * pageSize : totalPageNum);
		 String totalpageNum2 = String.valueOf(totalPageNum);
		 System.out.println("endRowNum의 값" + endRowNum);

		/* 쿼리로 던져지는 게 String이기 때문에 <String, String> */
		 HashMap<String, String> hash = new HashMap<>();
		 hash.clear();
		 hash.put("page_size", "5");
		 hash.put("totalpageNum2", totalpageNum2);
		 hash.put("block_size", "5");
		 hash.put("startRowNum", startRowNum);
		/* map에 담아서 return하기 */
		 /************************* 여기서부터 문제 ! ***************************/
			list = customerService.findAllCustomers(hash);
			System.out.println("findAllCustomers의 첫번째 페이지" + list.toString());
			map.clear();
			map.put("list", list);
			return map;
	}
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

package kr.co.ch08.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.ch08.service.CustomerService;
@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@GetMapping("/customer/list")
	public String list () {
		return "/customer/list";
	}
	
	@GetMapping("/customer/register")
	public String register () {
		return "/customer/register";
	}
	
	@GetMapping("/customer/modify")
	public String modify() {
		return "/customer/modify";
	}
	
	@GetMapping
	public String delete() {
		return "customer/list";
	}

}

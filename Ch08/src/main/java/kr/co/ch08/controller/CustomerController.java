package kr.co.ch08.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ch08.service.CustomerService;
import kr.co.ch08.vo.CustomerVo;
@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@GetMapping("/customer/list")
	public String list(Model model) {
		List<CustomerVo> customers = service.selectcustomers();
		model.addAttribute("customers",customers);
		return "/customer/list";
	}
	
	@GetMapping("/customer/register")
	public String register() {
		
		return "/customer/register";
	}
	@PostMapping("/customer/register")
	public String register(CustomerVo vo) {
		service.insertcustomer(vo);
		return "redirect:/customer/list";
	}
	
	
	@GetMapping("/customer/modify")
	public String modify(String custid, Model model) {
		CustomerVo vo =service.selectcustomer(custid);
		model.addAttribute(vo);
		return "/customer/modify";
	}
	
	@PostMapping("/customer/modify")
	public String modify(CustomerVo vo) {
		service.updatecustomer(vo);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/customer/delete")
	public String delete(String custid) {
		service.deletecustomer(custid);
		return "redirect:/customer/list";
	}

}

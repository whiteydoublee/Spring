package kr.co.kmarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.kmarket.service.MainService;

@Controller
public class MainController {
	
	private MainService service;
	
	@GetMapping(value={"/","/index"})
	public String index() {
		return "/index";
	}
}

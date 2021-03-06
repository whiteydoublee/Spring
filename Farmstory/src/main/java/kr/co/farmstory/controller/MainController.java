package kr.co.farmstory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping(value= {"/","/index"})
	public String index(String success, Model model) {
		model.addAttribute("success",success);
		
		return "/index";
	}
	
	@GetMapping("/introduction/hello")
	public String hello() {
		return "/introduction/hello";
	}
	
	@GetMapping("/introduction/direction")
	public String direction() {
		return "/introduction/direction";
	}
}

package kr.co.kmarket.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminMainController {
	@GetMapping(value= {"/admin","/admin/index"})
	public String index() {
		return "/admin/index";
	}
	@GetMapping(value= {"/admin/logout"})
	public String logout(HttpSession sess) {
		
		sess.invalidate();
		return "redirect:/index?success=105";
	}
}

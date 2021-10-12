package kr.co.ch04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	@RequestMapping(value={"/","/hello"}, method = RequestMethod.GET)
	public String hello() {
		return "hello";
	}
	
	@RequestMapping(value="/welcome", method = RequestMethod.GET)
	public String welcome() {
		return "welcome";
	}
	@GetMapping("/greeting") //-> Ver4.0 이후부터 적용가능
	public String greeting() {
		return "greeting";
	}
	
}

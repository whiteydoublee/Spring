package kr.co.ch05.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.ch05.service.UserService;
import kr.co.ch05.vo.UserVO;

@Controller
public class UserController {
	
	@Inject
	private UserService service;

	@RequestMapping(value="/user/list", method = RequestMethod.GET)
	public String list(Model model) {
		
		List<UserVO> users = service.selectUSers();
		
		//������ model ��ü�� �̿��Ͽ� ������Ʈ�� �ڷ����
		model.addAttribute("users",users);
		
		return "/user/list";
	}
	
	@RequestMapping(value="/user/modify", method = RequestMethod.GET)
	public String modify(String uid, Model model) {
		
		UserVO user = service.selectUser(uid);
		model.addAttribute(user); // ��ü���� ǥ������ ������ �ҹ��ڷ� ��üŸ��
		
		return "/user/modify";
	}
	
	@PostMapping("/user/modify")
	public String modify(UserVO vo) {
		service.updateUSer(vo);
		return "redirect:/user/list";
	}
	
	@RequestMapping(value="/user/register", method = RequestMethod.GET)
	public String register() {
		return "/user/register";
	}
	@PostMapping("/user/register")
	public String register(UserVO vo) { // �����ε� �޼���
		
		service.insertUSer(vo);
		
		return "redirect:/";
	}
	
	@GetMapping("/user/delete")
	public String delete(String uid) {
		service.deleteUSer(uid);
		return "redirect:/user/list";
	}
	
}

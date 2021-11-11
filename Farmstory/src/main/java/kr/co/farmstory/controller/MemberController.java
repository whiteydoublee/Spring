package kr.co.farmstory.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.co.farmstory.service.MemberService;
import kr.co.farmstory.vo.MemberVo;
import kr.co.farmstory.vo.TermsVo;


@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("/member/login")
	public String login(String success, Model model) {
		model.addAttribute("success", success);
		return "/member/login";
	}
	@PostMapping("/member/login")
	public String login(HttpSession sess,String uid, String pass) {
		MemberVo vo =service.selectMember(uid, pass);
		
		if(vo==null) {
			//회원이 아닐 경우
			return "redirect:/member/login?success=100";
		}else {
			//회원인 경우
			sess.setAttribute("sessMember", vo);
			return "redirect:/index?success=104";
		}
		
	}

	@GetMapping("/member/logout")
	public String logout(HttpSession sess) {
		//현재 사용자 정보객체 세션 삭제
		sess.invalidate();
		return "redirect:/member/login?success=102";
	}
	
	@GetMapping("/member/register")
	public String register() {
		
		return "/member/register";
	}
	@PostMapping("/member/register")
	public String register(MemberVo vo, HttpServletRequest req) {
			String regip = req.getRemoteAddr();
			vo.setRegip(regip);
			
			service.insertMember(vo);
			return "redirect:/member/login?success=102";
	}
	
	
	@GetMapping("/member/terms")
	public String terms(Model model) {
		TermsVo terms= service.selectTerms();
		model.addAttribute(terms);
		
		return "/member/terms";
	}
	
	@ResponseBody
	@GetMapping("/member/checkUid")
	public String checkUid(String uid) throws JsonProcessingException{
		int result = service.selectCountMember(uid);
		
		//Gson 라이브러리로 json 생성
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		//Jackson 라이브러리로 json 생성
		Map<String, Integer> resultMap = new HashMap<>();
		resultMap.put("result", result);
		
		String strJson2 = new ObjectMapper().writeValueAsString(resultMap);
		
		return json.toString();
	}
	
	@ResponseBody
	@GetMapping("/member/checkNick")
	public String checkNick(String nick) throws JsonProcessingException{
		int result = service.selectCountNick(nick);
		
		//Gson 라이브러리로 json 생성
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		//Jackson 라이브러리로 json 생성
		Map<String, Integer> resultMap = new HashMap<>();
		resultMap.put("result", result);
		
		String strJson2 = new ObjectMapper().writeValueAsString(resultMap);
		return json.toString();
	}
	
	@ResponseBody
	@GetMapping("/member/checkEmail")
	public String checkEmail(String email) throws JsonProcessingException{
		int result = service.selectCountEmail(email);
		
		//Gson 라이브러리로 json 생성
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		//Jackson 라이브러리로 json 생성
		Map<String, Integer> resultMap = new HashMap<>();
		resultMap.put("result", result);
		
		String strJson2 = new ObjectMapper().writeValueAsString(resultMap);
		return json.toString();
	}
	
	@ResponseBody
	@GetMapping("/member/checkHp")
	public String checkHp(String hp) throws JsonProcessingException{
		int result = service.selectCountHp(hp);
		
		//Gson 라이브러리로 json 생성
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		//Jackson 라이브러리로 json 생성
		Map<String, Integer> resultMap = new HashMap<>();
		resultMap.put("result", result);
		
		String strJson2 = new ObjectMapper().writeValueAsString(resultMap);
		return json.toString();
	}
	
}

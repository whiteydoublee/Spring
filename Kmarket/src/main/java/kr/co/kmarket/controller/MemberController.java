package kr.co.kmarket.controller;

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
import com.google.gson.JsonObject;

import kr.co.kmarket.service.MemberService;
import kr.co.kmarket.vo.MemberTermsVo;
import kr.co.kmarket.vo.MemberVo;

@Controller
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@GetMapping("/member/join")
	public String join() {
		return "/member/join";
	}
	@GetMapping("/member/login")
	public String login(int productCode, Model model) {
		
		model.addAttribute("productCode", productCode);
		
		return "/member/login";
	}
	@PostMapping("/member/login")
	public String login(HttpSession sess, MemberVo vo) {
		
		MemberVo memberVo = service.selectMember(vo);
		
		if(vo != null) {
			sess.setAttribute("sessMember", memberVo);

			if(vo.getProductCode() > 0) {
				return "redirect:/product/view?productCode="+vo.getProductCode();
			}else {
				return "redirect:/";	
			}
		}else {
			return "redirect:/member/login?success=100";
		}
	}
	
	@GetMapping("/member/logout")
	public String logout(HttpSession sess) {
		sess.invalidate();
		
		
		return "redirect:/index?success=104";
	}
	
	@GetMapping("/member/register")
	public String register() {
		return "/member/register";
	}
	@PostMapping("/member/register")
	public String register(MemberVo vo, HttpServletRequest req) {
		String ip = req.getRemoteAddr();
		vo.setIp(ip);
		
		 service.insertMember(vo);
		
		return "redirect:/member/login?success=101";
	}
	
	
	@GetMapping("/member/register-seller")
	public String registerSeller() {
		return "/member/register-seller";
	}
	
	@PostMapping("/member/register-seller")
	public String registerSeller(MemberVo vo, HttpServletRequest req) {
		String ip = req.getRemoteAddr();
		vo.setIp(ip);
		
		 service.insertSellerMember(vo);
		
		return "redirect:/member/login?success=102";
	}
	
	@GetMapping("/member/signup")
	public String signup(Model model, int type) {
		MemberTermsVo terms = service.selectTerms();
		model.addAttribute("vo",terms);
		model.addAttribute("type",type);
		
		return "/member/signup";
	}
	
	@ResponseBody
	@GetMapping("/member/checkUid")
	public String checkUid(String uid) throws JsonProcessingException{
		int result = service.selectCountUid(uid);
		
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

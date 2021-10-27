package kr.co.farmstory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.farmstory.service.BoardService;
import kr.co.farmstory.vo.ArticleVo;

@Controller
public class BoardController {
	
	private BoardService service;
	
	@GetMapping("/board/list")
	public String list(Model model, String group, String cate) {
		
		model.addAttribute("group",group);
		model.addAttribute("cate",cate);
		
		ArticleVo article = service.selectArticles();
		model.addAttribute("article",article);
		
		return "/board/list";
	}
	@GetMapping("/board/modify")
	public String modify() {
		return "/board/modify";
	}
	@GetMapping("/board/view")
	public String view(Model model, String group, String cate,int seq) {
		
		model.addAttribute("group",group);
		model.addAttribute("cate",cate);
		
		return "/board/view";
	}
	@GetMapping("/board/write")
	public String write(Model model, String group, String cate) {
		
		model.addAttribute("group",group);
		model.addAttribute("cate",cate);

		return "/board/write";
	}
}

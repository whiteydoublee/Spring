package kr.co.farmstory.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.farmstory.service.BoardService;
import kr.co.farmstory.vo.ArticleVo;
import kr.co.farmstory.vo.FileVo;
import kr.co.farmstory.vo.MemberVo;

@Controller
public class BoardController {
	@Autowired
	private BoardService service;
	
	@GetMapping("/board/list")
	public String list(HttpSession sess,Model model, String group, String cate, String pg) {
		int currentPage = service.getCurrentPage(pg);
		int start = service.getLimitStart(currentPage);
		int total = service.selectCountTotal(cate);
		int pageStartNum = service.getPageStartNum(total, start);
		int lastPageNum = service.getLastPageNum(total);
		int groups[] = service.getPageGroup(currentPage, lastPageNum);
		
		model.addAttribute("group",group);
		model.addAttribute("cate",cate);
		
		List<ArticleVo> articles = service.selectArticles(cate,start);
		model.addAttribute("articles",articles);
		model.addAttribute("pageStartNum",pageStartNum);
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("lastPageNum",lastPageNum);
		model.addAttribute("groups",groups);
		
			return "/board/list";
	}
	@GetMapping("/board/modify")
	public String modify() {
		return "/board/modify";
	}
	@GetMapping("/board/view")
	public String view(HttpSession sess,Model model, String group, String cate,int seq) {
		
		model.addAttribute("group",group);
		model.addAttribute("cate",cate);
		
		ArticleVo article = service.selectArticle(seq);
		model.addAttribute("article",article);
		
		MemberVo vo = (MemberVo) sess.getAttribute("sessMember"); // vo가 value 이므로, sess멤버가 키, MemberVo를 반환하여야함.
		if(vo == null) {
			return "redirect:/member/login?success=101";
		}else {
			return "/board/view";
		}
		
	}
	@GetMapping("/board/write")
	public String write(HttpSession sess, Model model, String group, String cate) {
		
		model.addAttribute("group",group);
		model.addAttribute("cate",cate);
		
		MemberVo vo = (MemberVo) sess.getAttribute("sessMember"); // vo가 value 이므로, sess멤버가 키, MemberVo를 반환하여야함.
		if(vo == null) {
			return "redirect:/member/login?success=103";
		}else {
			return "/board/write";
		}
		

	}
	@PostMapping("/board/write")
	public String write(HttpServletRequest req, Model model, String group, ArticleVo vo) {
		String regip = req.getRemoteAddr();
		vo.setRegip(regip);
		model.addAttribute("group",group);
		
		//작성글 Insert
				int seq = 0;// 테스트하기위해 데이터가 들어가는것을 막는다. 
				
				if(vo.getFname().isEmpty()) {
					
					// 파일을 첨부안했을때
					vo.setFile(0);
					seq = service.insertArticle(vo);
				}else {
					// 파일을 첨부했을때
//					System.out.println("파일첨부함");
					// 비니지스 로직은 왠만하면 전부 모델로 넘겨서한다 파일다운로드....등
					vo.setFile(1);// 해당글의 파일이 첨부되었음
					seq = service.insertArticle(vo);//글이 들어가는 동시에
					FileVo fvo = service.fileUpload(vo.getFname(), seq);// 파일업로드하고 
					service.insertFile(fvo);// 파일정보도 들어감 
					
				}
		return "redirect:/board/list?group="+group+"&cate="+vo.getCate();
	}
}

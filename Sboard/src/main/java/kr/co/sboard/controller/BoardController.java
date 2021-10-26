package kr.co.sboard.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.co.sboard.service.BoardService;
import kr.co.sboard.vo.ArticleVo;
import kr.co.sboard.vo.FileVo;
import kr.co.sboard.vo.MemberVo;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping(value={"/", "/index"})
	public String index(HttpSession sess) {
		MemberVo vo = (MemberVo) sess.getAttribute("sessMember");
		
		if(vo == null) {
			return "forward:/member/login";	
		}else {
			return "forward:/list";			
		}
	}

	@GetMapping("/list")
	public String list(String pg, Model model) {
		
		int currentPage = service.getCurrentPage(pg);
		int start = service.getLimitStart(currentPage);
		int total = service.selectCountTotal();
		int pageStartNum = service.getPageStartNum(total, start);
		int lastPageNum = service.getLastPageNum(total);
		int groups[] = service.getPageGroup(currentPage, lastPageNum);
		
		List<ArticleVo> articles = service.selectArticles(start);
		model.addAttribute("articles",articles);
		model.addAttribute("pageStartNum",pageStartNum);
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("lastPageNum",lastPageNum);
		model.addAttribute("groups",groups);
		return "/list";
	}
	
	@GetMapping("/view")
	public String view(int seq, Model model) {
		ArticleVo article = service.selectArticle(seq);
//		List<ArticleVo> comments = service.selectComments(seq);
		model.addAttribute("article",article);
//		model.addAttribute("comments",comments);
		return "/view";
	}
	
	@GetMapping("/write")
	public String write() {
		return "/write";
	}
	
	@PostMapping("/write")
	public String write(HttpServletRequest req, ArticleVo vo) {
		String regip = req.getRemoteAddr();
		vo.setRegip(regip);
		
		//작성글 Insert
		int seq = 0;// 테스트하기위해 데이터가 들어가는것을 막는다. 
		// 파일이 들어가기전 그 글번호를 알아야하기때문에 먼저 글을 넣고 그 글번호를 구한다. 
		// 그리고 insert하고 난후 키값을 받아올수있다는것이 핵심!!!!
		if(vo.getFname().isEmpty()) {
			// 폼양식에서 전송한 fname키워드에 값이 있다면 파일을 첨부했다는 뜻
			// is메서드는 상태값을 확인하는 것이므로 true아니면 false가 있다 null체크 안된다
			// 참조변수는 왠만하면 null체크 가능 
			// 파일을 첨부안했을때
			vo.setFile(0);
			
			seq = service.insertArticle(vo);
		}else {
			// 파일을 첨부했을때
//			System.out.println("파일첨부함");
			// 비니지스 로직은 왠만하면 전부 모델로 넘겨서한다 파일다운로드....등
			vo.setFile(1);// 해당글의 파일이 첨부되었음
			seq = service.insertArticle(vo);//글이 들어가는 동시에
			FileVo fvo = service.fileUpload(vo.getFname(), seq);// 파일업로드하고 
			service.insertFile(fvo);// 파일정보도 들어감 
			
		}
			
		return "redirect:/list";
	}
	
	@GetMapping("/fileDownload")
	public void fileDownload(int fseq, HttpServletResponse resp) {// 리스폰스객체 => 실어서보낼 객체
		
		//다운로드 카운트 +1
		service.updateFileDownload(fseq);
		//파일 정보 가져오기 
		FileVo fileVo = service.selectFile(fseq);
		//파일 다운로드 수행
		service.fileDownload(resp, fileVo);
	}
	
	@PostMapping("/insertComment")
	public String insertComment(ArticleVo vo) {
		
		return "redirect:/view?seq="+vo.getParent();
	}
	
	@GetMapping("/modify")
	public String modify( Model model,int seq) {
		ArticleVo vo = service.selectArticle(seq);
				model.addAttribute("article",vo);
		return "/modify";
	}
	
	@PostMapping("/modify")
	public String modify(ArticleVo vo) {
		service.updateArticle(vo);
		
		//파일이 변경되지 못해도, 파일 첨부만으로 변경으로 간
		int seq = 0;// 테스트하기위해 데이터가 들어가는것을 막는다. 
		// 파일이 들어가기전 그 글번호를 알아야하기때문에 먼저 글을 넣고 그 글번호를 구한다. 
		// 그리고 insert하고 난후 키값을 받아올수있다는것이 핵심!!!!
		if(vo.getFname().isEmpty()) {
			// 폼양식에서 전송한 fname키워드에 값이 있다면 파일을 첨부했다는 뜻
			// is메서드는 상태값을 확인하는 것이므로 true아니면 false가 있다 null체크 안된다
			// 참조변수는 왠만하면 null체크 가능 
			// 파일을 첨부안했을때
			vo.setFile(0);
			
			seq = service.insertArticle(vo);
		}else {
			// 파일을 첨부했을때
//			System.out.println("파일첨부함");
			// 비니지스 로직은 왠만하면 전부 모델로 넘겨서한다 파일다운로드....등
			vo.setFile(1);// 해당글의 파일이 첨부되었음
			seq = service.insertArticle(vo);//글이 들어가는 동시에
			FileVo fvo = service.fileUpload(vo.getFname(), seq);// 파일업로드하고 
			service.insertFile(fvo);// 파일정보도 들어감 
			
		}
		
		return "/modify";
	}
	
}

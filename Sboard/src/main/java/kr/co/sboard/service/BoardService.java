package kr.co.sboard.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.sboard.dao.BoardDao;
import kr.co.sboard.vo.ArticleVo;
import kr.co.sboard.vo.FileVo;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao dao;
	
	//Dao 구현 메서드
	
	public int insertArticle(ArticleVo vo) {
		dao.insertArticle(vo);
		return vo.getSeq();
	}
	public void insertFile(FileVo vo) {
		dao.insertFile(vo);
	};
	public ArticleVo selectArticle(int seq) {
		return dao.selectArticle(seq);
	}
	public List<ArticleVo> selectArticles(int start) {
		return dao.selectArticles(start);
	}
	public int selectCountTotal() {
		return dao.selectCountTotal();
	}
	public void updateArticle(int seq) {
		dao.updateArticle(seq);
	}
	public void deleteArticle(int seq) {
		dao.deleteArticle(seq);
	}
	
	//Business 처리 로직 구현 메서드
	///파일 업로드
	public FileVo fileUpload(MultipartFile fname, int seq) {
		//파일 첨부한 경우
		File file = new File("src/main/resources/static/file/");
		String path = file.getAbsolutePath();
		
		String name = fname.getOriginalFilename();
		String ext = name.substring(name.lastIndexOf("."));
		
		String uName = UUID.randomUUID().toString()+ext;
		
		FileVo fvo = null;
		
		try {
			//첨부파일 저장
			fname.transferTo(new File(path+"/"+uName));
			
			//첨부파일 정보 Insert
			fvo = new FileVo();
			fvo.setParent(seq);
			fvo.setOriName(name);
			fvo.setNewName(uName);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return fvo;
	}
	
	//페이지 리스트 시작번호
	public int getPageStartNum(int total, int start) {
		return total - start;
	}
	//페이지 현재 그룹 번호(이전,다음)
	public int[] getPageGroup(int currentPage, int lastPageNum) {
		int groupCurrent = (int) Math.ceil(currentPage / 10.0);
		int groupStart = (groupCurrent - 1) * 10 +1;
		int groupEnd = groupCurrent * 10;
		
		if(groupEnd > lastPageNum) {
			groupEnd = lastPageNum;
		}
		int[] groups = {groupStart, groupEnd};
		return groups;
	}
	
	public int getCurrentPage(String pg) {
		int currentPage = 1;
		if (pg != null) {
			currentPage = Integer.parseInt(pg);
		}
		return currentPage;
	}
	
	//현재 리스트 SQL start 번호
	public int getLimitStart(int currentPage) {
		return (currentPage -1) * 10;
	}
	
	//리스트 마지막 페이지 번호
	public int getLastPageNum(int total) {
		int lastPageNum = 0;
		
		if(total % 10 == 0) {
			lastPageNum = total / 10;
		}else {
			lastPageNum = total / 10 + 1;
		}
		
		return lastPageNum;
	}

}

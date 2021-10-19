package kr.co.sboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sboard.dao.BoardDao;
import kr.co.sboard.vo.ArticleVo;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao dao;
	
	public void insertArticle(ArticleVo vo) {
		dao.insertArticle(vo);
	}
	public ArticleVo selectArticle(int seq) {
		return dao.selectArticle(seq);
	}
	public List<ArticleVo> selectArticles() {
		return dao.selectArticles();
	}
	public void updateArticle(int seq) {
		dao.updateArticle(seq);
	}
	public void deleteArticle(int seq) {
		dao.deleteArticle(seq);
	}


}

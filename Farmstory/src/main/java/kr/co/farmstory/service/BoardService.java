package kr.co.farmstory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.farmstory.dao.BoardDao;
import kr.co.farmstory.vo.ArticleVo;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao dao;
	
	public ArticleVo selectArticles() {
		return dao.selectArticles();
	}

}

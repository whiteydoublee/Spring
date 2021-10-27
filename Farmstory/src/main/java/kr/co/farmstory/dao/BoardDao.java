package kr.co.farmstory.dao;

import org.springframework.stereotype.Repository;

import kr.co.farmstory.vo.ArticleVo;

@Repository
public interface BoardDao {
	
	public ArticleVo selectArticles();

}

package kr.co.sboard.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.sboard.vo.ArticleVo;

@Repository
public interface BoardDao {
	
	public void insertArticle(ArticleVo vo);
	public ArticleVo selectArticle(int seq);
	public List<ArticleVo> selectArticles();
	public void updateArticle(int seq);
	public void deleteArticle(int seq);

}

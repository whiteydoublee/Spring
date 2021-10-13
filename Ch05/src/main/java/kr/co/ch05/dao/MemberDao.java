package kr.co.ch05.dao;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.ch05.vo.MemberVO;

@Repository
public class MemberDao {
	
	@Inject
	private SqlSessionTemplate mybatis; 
	
	public void insertMember(MemberVO vo) {
		mybatis.insert("mapper.member.insertUser", vo);
	}
	public void selectMember() {}
	public void selectMembers() {}
	public void updateMember() {}
	public void deleteMember() {}
}

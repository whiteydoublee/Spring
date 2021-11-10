package kr.co.kmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.dao.MemberDao;
import kr.co.kmarket.vo.MemberTermsVo;
import kr.co.kmarket.vo.MemberVo;

@Service
public class MemberService {
	
	@Autowired
	MemberDao dao;
	
	public void insertMember(MemberVo vo) {
		dao.insertMember(vo);
		
	}
	public void insertSellerMember(MemberVo vo) {
		dao.insertSellerMember(vo);
		
	}
	public MemberTermsVo selectTerms() {
		return dao.selectTerms();
	}
	
	public MemberVo selectMember(MemberVo vo) {
		return dao.selectMember(vo);
		
	}
	public void selectMembers() {}
	
	public int selectCountUid(String uid) {
		return dao.selectCountUid(uid);
	}
	public int selectCountEmail(String email) {
		return dao.selectCountEmail(email);
	}
	public int selectCountHp(String hp) {
		return dao.selectCountHp(hp);
	}
	public void updateMember() {}
	public void deleteMember() {}

}

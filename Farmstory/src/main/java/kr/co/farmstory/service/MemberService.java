package kr.co.farmstory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.farmstory.dao.MemberDao;
import kr.co.farmstory.vo.MemberVo;
import kr.co.farmstory.vo.TermsVo;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao dao;
	
	public TermsVo selectTerms () {
		return dao.selectTerms();
	}
	public void insertMember(MemberVo vo) {
		dao.insertMember(vo);
	}
	public int selectCountMember(String uid) {
		return dao.selectCountMember(uid);
	}
	public int selectCountNick(String nick) {
		return dao.selectCountNick(nick);
	}
	public int selectCountEmail(String email) {
		return dao.selectCountEmail(email);
	}
	public int selectCountHp(String hp) {
		return dao.selectCountHp(hp);
	}
	public MemberVo selectMember(String uid, String pass) {
		return dao.selectMember(uid, pass);
	}
	public void selectMembers() {}
	public void updateMember() {}
	public void deleteMember() {}
}

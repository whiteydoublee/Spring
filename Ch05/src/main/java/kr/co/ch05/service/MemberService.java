package kr.co.ch05.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.ch05.dao.MemberDao;
import kr.co.ch05.vo.MemberVO;

@Service
public class MemberService {
	
	@Inject
	private MemberDao dao;
	
	public void insertMember(MemberVO vo) {
		dao.insertMember(vo);
	}
	public void selectMember() {}
	public void selectMembers() {}
	public void updateMember() {}
	public void deleteMember() {}
}

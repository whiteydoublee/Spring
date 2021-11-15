package kr.co.kmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.dao.MemberDao;
import kr.co.kmarket.dao.MemberRepo;
import kr.co.kmarket.dao.MemberTermsRepo;
import kr.co.kmarket.vo.MemberTermsVo;
import kr.co.kmarket.vo.MemberVo;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao dao;
	
	@Autowired
	private MemberRepo repo; 
	
	@Autowired
	private MemberTermsRepo termsrepo;
	
	public void insertMember(MemberVo vo) {
//		Mybatis 실행
		// dao.insertMember(vo);
		
//		JPA 실행 
		repo.save(vo); //save = insert query
		
	}
	public void insertSellerMember(MemberVo vo) {
		dao.insertSellerMember(vo);
		
	}
	public MemberTermsVo selectTerms() {
		
//		Mybatis 실행
//		MemberTermsVo termsVo = dao.selectTerms();
//		return dao.selectTerms();
		
//		JPA실행
		MemberTermsVo termsVo = termsrepo.findById(1).get(); 
		return termsVo;
		
		
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

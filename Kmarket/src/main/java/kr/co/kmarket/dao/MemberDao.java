package kr.co.kmarket.dao;

import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.MemberTermsVo;
import kr.co.kmarket.vo.MemberVo;

@Repository
public interface MemberDao {
	
	public void insertMember(MemberVo vo);
	public void insertSellerMember(MemberVo vo);
	public MemberTermsVo selectTerms();
	public MemberVo selectMember(String uid, String pass);
	public void selectMembers();
	public int selectCountUid(String uid);
	public int selectCountEmail(String email);
	public int selectCountHp(String hp);
	public void updateMember();
	public void deleteMember();
	

}

package kr.co.ch08.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.ch08.vo.MemberVo;

@Repository
public interface MemberDao {
	
	public void insertMember(MemberVo vo);
	public MemberVo selectMember(String uid);
	public List<MemberVo> selectMembers();
	public void updateMember(MemberVo vo);
	public void deleteMember(String uid);

}

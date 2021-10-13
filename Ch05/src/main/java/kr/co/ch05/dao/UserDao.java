package kr.co.ch05.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.ch05.vo.UserVO;

@Repository
public class UserDao {
	
	@Inject
	private SqlSessionTemplate mybatis;
	
	public void insertUSer(UserVO vo) {
		mybatis.insert("mapper.user.insertUser", vo);
	}
	
	public UserVO selectUser(String uid) {
		return mybatis.selectOne("mapper.user.selectUser", uid);
	}
	
	public List<UserVO> selectUSers() {
		return mybatis.selectList("mapper.user.selectUsers");
	}
	
	public void updateUSer(UserVO vo) {
		mybatis.update("mapper.user.updateUser", vo);
	}
	public void deleteUSer(String uid) {
		mybatis.delete("mapper.user.deleteUser",uid);
	}
}

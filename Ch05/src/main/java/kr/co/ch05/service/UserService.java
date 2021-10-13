package kr.co.ch05.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch05.dao.UserDao;
import kr.co.ch05.vo.UserVO;

@Service
public class UserService { // Service Component니까, Service 어노테이션
	
	@Autowired
	private UserDao dao;
	
	public void insertUSer(UserVO vo) {
		dao.insertUSer(vo);
	}
	public UserVO selectUser(String uid) {
		return dao.selectUser(uid);
	}
	public List<UserVO> selectUSers() {
		return dao.selectUSers();
	}
	public void updateUSer(UserVO vo) {
		dao.updateUSer(vo);
	}
	public void deleteUSer(String uid) {
		dao.deleteUSer(uid);
	}
}

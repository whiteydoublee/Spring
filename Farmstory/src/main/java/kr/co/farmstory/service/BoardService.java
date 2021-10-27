package kr.co.farmstory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.farmstory.dao.BoardDao;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao dao;

}

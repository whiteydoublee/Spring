package kr.co.kmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.dao.MainDao;

@Service
public class MainService {
	@Autowired 
	private MainDao dao;
}

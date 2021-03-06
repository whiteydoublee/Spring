package kr.co.ch08.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch08.dao.CustomerDao;
import kr.co.ch08.vo.CustomerVo;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDao dao;
	
	public void insertcustomer(CustomerVo vo) {
		dao.insertcustomer(vo);
	}
	public CustomerVo selectcustomer(String custid) {
		return dao.selectcustomer(custid);
	}
	public List<CustomerVo> selectcustomers(){
		return dao.selectcustomers();
	}
	public void updatecustomer(CustomerVo vo) {
		dao.updatecustomer(vo);
	}
	public void deletecustomer(String custid) {
		dao.deletecustomer(custid);
	}
}

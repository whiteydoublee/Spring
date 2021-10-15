package kr.co.ch08.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.ch08.vo.CustomerVo;

@Repository
public interface CustomerDao {
	
	public void insertcustomer(CustomerVo vo);
	public CustomerVo selectcustomer(String custid);
	public List<CustomerVo> selectcustomers();
	public void updatecustomer(CustomerVo vo);
	public void deletecustomer(String custid);

}

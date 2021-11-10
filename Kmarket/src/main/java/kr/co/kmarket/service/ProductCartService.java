package kr.co.kmarket.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.dao.ProductCartDao;
import kr.co.kmarket.vo.ProductCartVo;


@Service
public class ProductCartService {
	@Autowired
	private ProductCartDao dao;
	
	public void insertCart(ProductCartVo vo) {
		dao.insertCart(vo);
	}
	public int selectCountCart(ProductCartVo vo) {
		return dao.selectCountCart(vo);
	}
	public void selectCart() {}
	public void selectCarts() {}
	public void updateCart() {}
	public void deleteCart() {}

}

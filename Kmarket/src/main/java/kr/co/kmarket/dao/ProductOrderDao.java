package kr.co.kmarket.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.ProductCartVo;
import kr.co.kmarket.vo.ProductOrderVo;

@Repository
public interface ProductOrderDao {
	
	public void insertOrder(ProductOrderVo vo);
	public void insertOrderDetail(int orderId, int productCode);
	public int selectCountOrder();
	public void selectOrder();
	public List<ProductOrderVo> selectOrders();
	public void updateOrder();
	public void deleteOrder();

}

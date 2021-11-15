package kr.co.kmarket.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.co.kmarket.service.ProductCartService;
import kr.co.kmarket.service.ProductService;
import kr.co.kmarket.service.productOrderService;
import kr.co.kmarket.vo.CategoriesVo;
import kr.co.kmarket.vo.MemberVo;
import kr.co.kmarket.vo.ProductCartVo;
import kr.co.kmarket.vo.ProductOrderVo;
import kr.co.kmarket.vo.ProductVo;
import kr.co.kmarket.vo.SearchVo;

@Controller
public class ProductController {
	@Autowired
	private ProductService service;
	
	@Autowired
	private ProductCartService cartservice;
	
	@Autowired
	private productOrderService orderservice;
	
	@GetMapping("/product/cart")
	public String cart(HttpSession sess, Model model) {
		
		//로그인 여부 확인
		MemberVo vo = (MemberVo) sess.getAttribute("sessMember");
		
		if(vo != null) {
			
			List<ProductCartVo> cartProducts = cartservice.selectCarts(vo.getUid());
			model.addAttribute("cartProducts", cartProducts);
			return "/product/cart";
		}else {
			return "redirect:/member/login?success=201";
		}
		
		
		
		
	}
	
	@ResponseBody
	@PostMapping("/product/cart")
	public String cart(ProductCartVo vo) {
		
		int result = cartservice.selectCountCart(vo);
		if(result==0) {
			cartservice.insertCart(vo);
		}
		
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		return new Gson().toJson(json);
	}
	
	@ResponseBody
	@GetMapping("/product/cartDelete")
	public String cartDelete(int[] cartIds) {
		
		int result = cartservice.deleteCart(cartIds);
		
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		return new Gson().toJson(json);
	}
	
	@GetMapping("/product/list")
	public String list(ProductVo vo, Model model, String pg) {
		
		// 리스트 번호 처리
				int currentPage = service.getCurrentPage(pg);
				int start = service.getLimitStart(currentPage);
				int total = service.selectProductCountTotal(vo);
				int pageStartNum = service.getPageStartNum(total, start);
				int lastPageNum = service.getLastPageNum(total);
				int groups[] = service.getPageGroup(currentPage, lastPageNum);
				
				vo.setStart(start);
		
		List<ProductVo> products = service.selectProducts(vo);
		CategoriesVo cateVo = service.selectCategoryTitle(vo);
		
		model.addAttribute("products", products);
		model.addAttribute("cateVo",cateVo);
		model.addAttribute("order", vo.getOrder());
		
		model.addAttribute("pageStartNum", pageStartNum);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPageNum", lastPageNum);
		model.addAttribute("groups", groups);
		
		
		return "/product/list";
	}
	
	@GetMapping("/product/order")
	public String order(int orderId, Model model) {
		
		List<ProductCartVo> products = orderservice.selectOrders(orderId);
		
		model.addAttribute("products", products);
		model.addAttribute("productOrderVo", products.get(0));
		model.addAttribute(orderId); 
		
		return "/product/order";
	}
	
	@ResponseBody
	@PostMapping("/product/order")
	public String order(ProductOrderVo vo) {
		
		
		
		//장바구니 주문하기 상품 주문테이블 삭제
		//cartservice.deleteCart(vo.getCartIds());
		
		//장바구니 주문하기 상품 주문테이블 저장
		orderservice.insertOrder(vo);
		
		// 주문 테이블 Insert 후 주문번호 가져오기
		int orderId = vo.getOrderId();
		
		//주무번호 상품 코드 입력하기
		for(int productCode : vo.getProductCodes()) {
			orderservice.insertOrderDetail(orderId, productCode);
		}
		
		JsonObject json = new JsonObject();
		json.addProperty("orderId", orderId);
		
		return new Gson().toJson(json);
	}
	
	@GetMapping("/product/order-complete")
	public String orderComplete() {
		
		return "/product/order-complete";
	}
	
	@ResponseBody
	@PostMapping("/product/order-complete")
	public Map<String, Integer> orderComplete(ProductOrderVo vo) {
		
		//최종 주문 완료하기
		int result = orderservice.updateOrder(vo);
		
		//Jackson 라이브럴ㅣ로 자바 Map 구조체를 Json 데이터로 변환
		Map<String, Integer> map = new HashMap<>();
		map.put("result", result);
		
		return map;
	}
	
	@GetMapping("/product/search")
	public String search(String keyword, Model model) {
		List<ProductVo> products = service.selectProductSearch(keyword);
		model.addAttribute("products", products);
		model.addAttribute("productCount", products.size());
		model.addAttribute("keyword",keyword);
		
		return "/product/search";
	}
	
	@PostMapping("/product/search")
	public String search(SearchVo vo, Model model) {
//		System.out.println("chk1 : "+vo.getChk1());
//		System.out.println("chk2 : "+vo.getChk2());
//		System.out.println("chk3 : "+vo.getChk3());
		
		//List<ProductVo> products = service.selectProductSearch2(vo);
		//model.addAttribute("products", products);
		//model.addAttribute("productCount", products.size());
		//model.addAttribute("keyword",vo.getKeyword());
		
		return "/product/search";
	}
	@GetMapping("/product/view")
	public String view(HttpSession sess ,int productCode, Model model) {
		
		ProductVo product = service.selectProduct(productCode);
		model.addAttribute("product", product);
		
		return "/product/view";
	}
	
	
	
}

package kr.co.kmarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kmarket.service.MainService;
import kr.co.kmarket.vo.CategoriesVo;
import kr.co.kmarket.vo.ProductVo;

@Controller
public class MainController {
	@Autowired
	private MainService service;
	
	@GetMapping(value={"/","/index"})
	public String index(Model model) {
		
		// 히트 상품 조회
		List<ProductVo> productHit= service.selectMainProduct("hit");
//		List<ProductVo> productRecommend= service.selectMainProduct("score");
//		List<ProductVo> productLatest= service.selectMainProduct("rdate");
//		List<ProductVo> productDiscount= service.selectMainProduct("discount");
		List<ProductVo> productBest= service.selectMainProduct("sold");
		
		model.addAttribute("hit", productHit);
//		model.addAttribute("recommend", productRecommend);
//		model.addAttribute("latest", productLatest);
//		model.addAttribute("discount", productDiscount);
		model.addAttribute("best", productBest);
		
		return "/index";
	}
	
	@ResponseBody
	@GetMapping("/getCategories")
	public List<CategoriesVo> getCategories() {
		List<CategoriesVo> cates= service.selectCategories();
		// 알아서 json객체 리스트로 보내준다. 
		return cates;
	}
	
	@ResponseBody
	@GetMapping("/getMainProduct")
	public List<ProductVo> getMainProduct(String order) {
		List<ProductVo> products = service.selectMainProduct(order);
		return products;
	}
	
	
}

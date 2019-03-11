package cn.cuit.product.center.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.cuit.product.center.api.domian.Product;
import cn.cuit.product.center.api.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductService productService;

	// 远程访问的经验，先保证自己访问能访问通，再去整另外一个服务来调这个服务，否则坑是填不完的

	// http://localhost:8088/cuit-product-center-service/api/products/testFeign?a=10&b=20
	@GetMapping("/testFeign")
	public String testFeign(@RequestParam Integer a, @RequestParam Integer b) {
		logger.info(">>>>>>>>>>>>>>>>通过Feign远程调用成功 a = {}, b = {}", a, b);
		return "通过Feign远程调用成功 a + b = " + (a + b);
	}

	// http://localhost:8088/cuit-product-center-service/api/products/getProductById/10
	@GetMapping("/getProductById/{id}")
	public Product getProductById(@PathVariable("id") String id) {
		logger.info(">>>>>>>>>>>>>>>>通过Feign远程调用成功 ");
		return productService.getProductById(id);
	}
}

package cn.cuit.user.center.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.cuit.product.center.api.domian.Product;
import cn.cuit.user.center.service.feign.UserCenterProductFeign;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserCenterProductFeign userCenterProductFeign;

	// http://localhost:8081/cuit-user-center-service/api/users/testFeign?a=10&b=20
	@GetMapping(value = "/testFeign")
	public String testCallUserServiceWithFeign(@RequestParam Integer a, @RequestParam Integer b) {
		LOG.info("in cuit-user-center-service a = {}, b = {}", a, b);
		String msg = userCenterProductFeign.sum(a, b);
		return msg;
	}

	// http://localhost:8081/cuit-user-center-service/api/products/getProductById/10
	@GetMapping(value = "/getProductById/{id}")
	public Product getProductById(@PathVariable("id") String id) {
		LOG.info(".................in cuit-user-center-service id = {}", id);
		Product product = userCenterProductFeign.getProductById(id);
		return product;
	}
}

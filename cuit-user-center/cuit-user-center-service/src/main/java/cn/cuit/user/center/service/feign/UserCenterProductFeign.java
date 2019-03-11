package cn.cuit.user.center.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.cuit.product.center.api.domian.Product;

/**
 * Feign Client
 */
// @FeignClient注解配置 要调用的那个服务
// 如果配置错误会报：
/**
 * java.lang.RuntimeException: com.netflix.client.ClientException: Load balancer
 * does not have available server for client: XXX-Service
 */
@FeignClient("cuit-product-center-service")
public interface UserCenterProductFeign {

	// 远程服务请求的url,
	// 注意这里的神坑，虽然不是问题，但是真的很坑，就是不要忘了Controller类上面的@RequestMapping路径和properties里面的context-path路径
	// 如果没配对本服务报500，Feign报404【404表示找不到资源，一般大多数是请求路径不对，或者参数没对】，
	// SynchronousMethodHandler#executeAndDecode#97行发起调用，到LoadBalancerFeignClient类的57行，就可以看到请求的url
	@RequestMapping(value = "/product-service/api/products/testFeign", method = RequestMethod.GET)
	public String sum(@RequestParam Integer a, @RequestParam Integer b);

	// 旧版Feign不能使用@GetMapping会报错
	@GetMapping("/product-service/api/products/getProductById/{id}")
	public Product getProductById(@PathVariable("id") String id);
}

package cn.cuit.product.center.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cn.cuit.product.center.api.domian.Product;
import cn.cuit.product.center.api.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Override
	public Product getProductById(String id) {
		LOG.info(">>>>>>>>>>>>>id = {}", id);
		return new Product(id, "cuit", 998);
	}

}

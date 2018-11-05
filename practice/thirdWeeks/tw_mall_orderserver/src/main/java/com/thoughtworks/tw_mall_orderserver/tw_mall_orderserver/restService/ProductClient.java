package com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.restService;

import com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.model.ProductModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("product-service")
public interface ProductClient {
    @RequestMapping(
            method= RequestMethod.GET,
            value="/products/{id}")
    ProductModel getProductById(@PathVariable Integer id);

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/products")
    List<ProductModel> getProducts();
}

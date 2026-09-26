package com.easyshopaccount.easyshopaccount.product.service;

import com.easyshopaccount.easyshopaccount.product.dto.ProductInfoDto;

import java.util.List;

public interface ProductInfoService {

    public ProductInfoDto saveProduct(ProductInfoDto dto);
    public List<ProductInfoDto> getAllProducts();
    public ProductInfoDto getAllProductById(long id);
    public ProductInfoDto getAllByProductByProductCode(String code);
    public ProductInfoDto updateProduct(long id,ProductInfoDto dto);

}

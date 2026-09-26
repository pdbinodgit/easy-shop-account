package com.easyshopaccount.easyshopaccount.product.serviceimpl;

import com.easyshopaccount.easyshopaccount.product.dto.ProductInfoDto;
import com.easyshopaccount.easyshopaccount.product.model.ProductInfo;
import com.easyshopaccount.easyshopaccount.product.repository.ProductInfoRepository;
import com.easyshopaccount.easyshopaccount.product.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    ProductInfoRepository productInfoRepository;

    @Override
    public ProductInfoDto saveProduct(ProductInfoDto dto) {
        Random random = new Random();
        int number = random.nextInt(1000);
        String prefix= dto.getProductName().replaceAll("\\+","").substring(0,2).toUpperCase();
        String productCode=prefix+"_"+number;
        ProductInfo info=dtoToEntity(dto);
        info.setProductCode(productCode);
        productInfoRepository.save(info);
        return saveProduct(entityToDto(info));
    }

    @Override
    public List<ProductInfoDto> getAllProducts() {
        List<ProductInfo> productInfoList=productInfoRepository.findAll();
        List<ProductInfoDto> dtoList=new ArrayList<>();
        for (ProductInfo info:productInfoList){
            dtoList.add(entityToDto(info));
        }
        return dtoList;
    }

    @Override
    public ProductInfoDto getAllProductById(long id) {
        Optional<ProductInfo> info=productInfoRepository.findById(id);
        return entityToDto(info.get());
    }

    @Override
    public ProductInfoDto getAllByProductByProductCode(String code) {
        Optional<ProductInfo> info=productInfoRepository.findByProductCode(code);
        return entityToDto(info.get());
    }

    @Override
    public ProductInfoDto updateProduct(long id, ProductInfoDto dto) {
        Optional<ProductInfo> info=productInfoRepository.findById(id);
        if (info.isPresent()){
            info.get().setProductName(dto.getProductName());
            info.get().setQuantity(dto.getQuantity());
            info.get().setPrice(dto.getPrice());
        }
        return entityToDto(info.get());
    }

    public ProductInfo dtoToEntity(ProductInfoDto dto){
        ProductInfo productInfo=new ProductInfo();
        productInfo.setId(dto.getId());
        productInfo.setProductCode(dto.getProductCode());
        productInfo.setProductName(dto.getProductName());
        productInfo.setPrice(dto.getPrice());
        productInfo.setQuantity(dto.getQuantity());
        return productInfo;
    }

    public ProductInfoDto entityToDto(ProductInfo productInfo){
        ProductInfoDto dto=new ProductInfoDto();
        dto.setId(productInfo.getId());
        dto.setProductCode(productInfo.getProductCode());
        dto.setProductName(productInfo.getProductName());
        dto.setPrice(productInfo.getPrice());
        dto.setQuantity(productInfo.getQuantity());
        return dto;
    }
}

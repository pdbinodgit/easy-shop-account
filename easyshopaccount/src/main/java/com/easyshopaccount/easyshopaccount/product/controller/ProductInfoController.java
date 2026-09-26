package com.easyshopaccount.easyshopaccount.product.controller;

import com.easyshopaccount.easyshopaccount.customresponse.ESAResponse;
import com.easyshopaccount.easyshopaccount.product.dto.ProductInfoDto;
import com.easyshopaccount.easyshopaccount.product.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductInfoController {
    @Autowired
    ProductInfoService productInfoService;

    @PostMapping("/saveProduct")
    public ESAResponse<?> saveProduct(@RequestBody ProductInfoDto dto){
        ProductInfoDto productInfoDto= productInfoService.saveProduct(dto);
        return new ESAResponse<>(HttpStatus.OK,"Product save successfully.",productInfoDto, LocalDateTime.now());
    }
    @GetMapping("/findAllProduct")
    public ESAResponse<?> getAllProducts(){
        List<ProductInfoDto> productInfoDtoList= productInfoService.getAllProducts();
        ESAResponse<List<ProductInfoDto>> response=new ESAResponse<>(HttpStatus.OK,"Product retrieve successfully.",productInfoDtoList, LocalDateTime.now());
        return response;

    }

    @GetMapping("/findAllById/{id}")
    public ESAResponse<?> getAllProductById(@PathVariable long id){
        ProductInfoDto productInfoDto= productInfoService.getAllProductById(id);
        ESAResponse<ProductInfoDto> response=new ESAResponse<>(HttpStatus.OK,"Product retrieve successfully.",productInfoDto, LocalDateTime.now());
        return response;
    }
    @GetMapping("/findByProductCode/{code}")
    public ESAResponse<?> getAllByProductByProductCode(@PathVariable String code){
        ProductInfoDto productInfoDto= productInfoService.getAllByProductByProductCode(code);
        ESAResponse<ProductInfoDto> response=new ESAResponse<>(HttpStatus.OK,"Product retrieve successfully.",productInfoDto, LocalDateTime.now());
        return response;
    }

    @PutMapping("/updateProduct/{id}")
    public ESAResponse<?> updateProduct(@PathVariable long id,@RequestBody ProductInfoDto dto){
        ProductInfoDto productInfoDto= productInfoService.updateProduct(id,dto);
        ESAResponse<ProductInfoDto> response=new ESAResponse<>
                (HttpStatus.OK,"Product update successfully.",productInfoDto, LocalDateTime.now());
        return response;
    }


}

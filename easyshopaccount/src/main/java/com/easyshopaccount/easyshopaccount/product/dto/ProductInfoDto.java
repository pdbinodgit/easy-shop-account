package com.easyshopaccount.easyshopaccount.product.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductInfoDto {
    private Long id;
    private String productCode;
    private String productName;
    private BigDecimal price;
    private Integer quantity;
}

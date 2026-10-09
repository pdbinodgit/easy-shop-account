package com.easyshopaccount.easyshopaccount.goodreceivenotedetails.dto;

import com.easyshopaccount.easyshopaccount.goodreceivenotedetails.model.GrnDetails;
import com.easyshopaccount.easyshopaccount.product.model.ProductInfo;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class GrnDetailsDto {
    private Long id;
    private String grnNumber;
    private ProductInfo productInfo;
    private double quantity;
    private BigDecimal price;
}

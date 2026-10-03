package com.easyshopaccount.easyshopaccount.goodreceivenote.dto;

import com.easyshopaccount.easyshopaccount.product.model.ProductInfo;
import com.easyshopaccount.easyshopaccount.vendor.model.VendorInfo;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class GoodReceiveNoteDto {
    private Long id;
    private String GRNNumber;
    private ProductInfo productInfo;
    private VendorInfo vendorInfo;
    private Double quantity;
    private BigDecimal price;
}

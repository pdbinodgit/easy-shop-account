package com.easyshopaccount.easyshopaccount.goodreceivenote.dto;

import com.easyshopaccount.easyshopaccount.goodreceivenotedetails.dto.GrnDetailsDto;
import com.easyshopaccount.easyshopaccount.product.model.ProductInfo;
import com.easyshopaccount.easyshopaccount.vendor.model.VendorInfo;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class GoodReceiveNoteDto {
    private Long id;
    private String GRNNumber;
    private VendorInfo vendorInfo;
    private Double quantity;
    private BigDecimal price;
    private List<GrnDetailsDto> grnDetailsDtos;

}

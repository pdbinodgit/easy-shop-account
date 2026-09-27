package com.easyshopaccount.easyshopaccount.vendor.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendorInfoDto {
    private long id;
    private String vendorName;
    private String vendorCode;
    private String vatNumberOrTaxNumber;
    private String phoneNumber;
}

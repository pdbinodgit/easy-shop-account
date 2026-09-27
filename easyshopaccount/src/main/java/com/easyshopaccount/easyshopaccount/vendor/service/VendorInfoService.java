package com.easyshopaccount.easyshopaccount.vendor.service;

import com.easyshopaccount.easyshopaccount.vendor.dto.VendorInfoDto;

import java.util.List;

public interface VendorInfoService {
    public VendorInfoDto saveVendorInfo(VendorInfoDto dto);
    public List<VendorInfoDto> getAllVendorInfo();
    public VendorInfoDto findById(long id);
    public VendorInfoDto findByVendorCode(String code);
    public VendorInfoDto findByVendorPhoneNumber(String number);
    public VendorInfoDto updateVendor(long id, VendorInfoDto dto);
}

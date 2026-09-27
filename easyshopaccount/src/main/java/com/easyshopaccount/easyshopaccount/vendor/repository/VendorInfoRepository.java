package com.easyshopaccount.easyshopaccount.vendor.repository;

import com.easyshopaccount.easyshopaccount.vendor.model.VendorInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VendorInfoRepository extends JpaRepository<VendorInfo,Long> {
    public Optional<VendorInfo> findByVendorCode(String code);
    public Optional<VendorInfo> findByVendorName(String name);
    public Optional<VendorInfo> findByVendorPhoneNumber(String phnNumber);
}

package com.easyshopaccount.easyshopaccount.vendor.repository;

import com.easyshopaccount.easyshopaccount.vendor.model.VendorInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VendorInfoRepository extends JpaRepository<VendorInfo,Long> {
    public Optional<VendorInfo> findByVendorCode(String code);
    public Optional<VendorInfo> findByPhoneNumber(String phnNumber);
    public Optional<VendorInfo> findByVatNumber(String vatNumberOrTaxNumber);
}

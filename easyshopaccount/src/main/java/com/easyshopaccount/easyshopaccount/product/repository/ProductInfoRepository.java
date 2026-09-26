package com.easyshopaccount.easyshopaccount.product.repository;

import com.easyshopaccount.easyshopaccount.product.model.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductInfoRepository extends JpaRepository<ProductInfo, Long> {

    Optional<ProductInfo> findByProductCode(String code);

}

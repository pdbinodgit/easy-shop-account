package com.easyshopaccount.easyshopaccount.product.repository;

import com.easyshopaccount.easyshopaccount.product.model.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInfoRepository extends JpaRepository<Integer, ProductInfo> {

}

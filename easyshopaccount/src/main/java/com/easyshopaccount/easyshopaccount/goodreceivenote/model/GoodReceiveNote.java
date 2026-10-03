package com.easyshopaccount.easyshopaccount.goodreceivenote.model;

import com.easyshopaccount.easyshopaccount.product.model.ProductInfo;
import com.easyshopaccount.easyshopaccount.vendor.model.VendorInfo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GoodReceiveNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_info_id",referencedColumnName = "id")
    private ProductInfo productInfo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendor_info_id",referencedColumnName = "id")
    private VendorInfo vendorInfo;
    private Double quantity;
    private BigDecimal price;
}

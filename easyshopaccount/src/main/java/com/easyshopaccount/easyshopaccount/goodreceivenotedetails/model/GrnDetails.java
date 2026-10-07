package com.easyshopaccount.easyshopaccount.goodreceivenotedetails.model;

import com.easyshopaccount.easyshopaccount.product.model.ProductInfo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GrnDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String grnNumber;
    @ManyToOne
    @JoinColumn(name = "productInfo_id")
    private ProductInfo productInfo;
    private double quantity;
    private BigDecimal price;

}

package com.easyshopaccount.easyshopaccount.goodreceivenote.model;

import com.easyshopaccount.easyshopaccount.goodreceivenotedetails.model.GrnDetails;
import com.easyshopaccount.easyshopaccount.vendor.model.VendorInfo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GoodReceiveNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String GRNNumber;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendor_info_id",referencedColumnName = "id")
    private VendorInfo vendorInfo;
    @OneToMany(mappedBy = "goodReceiveNote",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<GrnDetails> grnDetailsList;
    private BigDecimal totalAmount;
    private LocalDate date;
}

package com.easyshopaccount.easyshopaccount.vendor.controller;

import com.easyshopaccount.easyshopaccount.customresponse.ESAResponse;
import com.easyshopaccount.easyshopaccount.vendor.dto.VendorInfoDto;
import com.easyshopaccount.easyshopaccount.vendor.model.VendorInfo;
import com.easyshopaccount.easyshopaccount.vendor.service.VendorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/vendorInfo")
public class VendorInfoController {
    @Autowired
    VendorInfoService vendorInfoService;

    @PostMapping("/saveVendorInfo")
    public ESAResponse<?> saveVendorInfo(@RequestBody VendorInfoDto dto){
       VendorInfoDto vendorInfoDto = vendorInfoService.saveVendorInfo(dto);
       return new ESAResponse<>(HttpStatus.OK,"VendorInfo save successfully.",vendorInfoDto, LocalDateTime.now());
    }

    @GetMapping("/findAllVendorInfo")
    public ESAResponse<?> getAllVendorInfo(){
        return new ESAResponse<>(HttpStatus.OK,"VendorInfo retrieve successfully.",vendorInfoService.getAllVendorInfo(), LocalDateTime.now());
    }

    @GetMapping("/findByVendorInfoId/{id}")
    public ESAResponse<?> findById(@PathVariable long id){
        return new ESAResponse<>(HttpStatus.OK,"VendorInfo retrieve successfully.",vendorInfoService.findById(id), LocalDateTime.now());
    }

    @GetMapping("/findByVendorCode/{code}")
    public ESAResponse<?> findByVendorCode(@PathVariable String code){
        return new ESAResponse<>(HttpStatus.OK,"VendorInfo retrieve successfully.",vendorInfoService.findByVendorCode(code), LocalDateTime.now());
    }
    @GetMapping("/findByVendorPhoneNumber/{number}")
    public ESAResponse<?> findByVendorPhoneNumber(@PathVariable String number){
        return new ESAResponse<>(HttpStatus.OK,"VendorInfo retrieve successfully.",vendorInfoService.findByVendorPhoneNumber(number), LocalDateTime.now());

    }
    @PutMapping("/update/{id}")
    public ESAResponse<?> updateVendor(@PathVariable long id, @RequestBody VendorInfoDto dto){
        VendorInfoDto vendorInfoDto=vendorInfoService.updateVendor(id, dto);
        return new ESAResponse<>(HttpStatus.OK,"VendorInfo update successfully.",vendorInfoService.updateVendor(id, dto), LocalDateTime.now());

    }


}

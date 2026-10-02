package com.easyshopaccount.easyshopaccount.vendor.serviceimpl;

import com.easyshopaccount.easyshopaccount.customexception.ESAException;
import com.easyshopaccount.easyshopaccount.vendor.dto.VendorInfoDto;
import com.easyshopaccount.easyshopaccount.vendor.model.VendorInfo;
import com.easyshopaccount.easyshopaccount.vendor.repository.VendorInfoRepository;
import com.easyshopaccount.easyshopaccount.vendor.service.VendorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class VendorInfoServiceImpl implements VendorInfoService {

    @Autowired
    VendorInfoRepository vendorInfoRepository;

    @Override
    public VendorInfoDto saveVendorInfo(VendorInfoDto dto) {
        Random random = new Random();
        int number = random.nextInt(1000);
        String prefix= dto.getVendorName().replaceAll("\\+"," ").substring(0,2).toUpperCase();
        String vendorCode=prefix+"-"+number;
        VendorInfo info=dtoToEntity(dto);
        info.setVendorCode(vendorCode);
        Optional<VendorInfo> vendorInfo=vendorInfoRepository.findByVendorCode(vendorCode);
        Optional<VendorInfo> vendorInfo1=vendorInfoRepository.findByPhoneNumber(dto.getPhoneNumber());
        Optional<VendorInfo> vendorInfo2=vendorInfoRepository.findByVatNumber(dto.getVatNumber());
        Optional<VendorInfo> vendorInfo3=vendorInfoRepository.findByPanNumber(dto.getPanNumber());
        if (vendorInfo.isPresent()){
            throw new ESAException("Vendor code already exist", HttpStatus.BAD_REQUEST,400);
        }
        if (vendorInfo1.isPresent()){
            throw new ESAException("Vendor phone already exist", HttpStatus.BAD_REQUEST,400);
        }
        if (vendorInfo2.isPresent()){
            throw new ESAException("Vendor Vat Number Or Tax Number already exist", HttpStatus.BAD_REQUEST,400);
        }
        if (vendorInfo3.isPresent()){
            throw new ESAException("Vendor Vat Number Or Tax Number already exist", HttpStatus.BAD_REQUEST,400);
        }

        VendorInfo saveInfo=vendorInfoRepository.save(info);
        return entityToDto(saveInfo);
    }

    @Override
    public List<VendorInfoDto> getAllVendorInfo() {
        List<VendorInfo> vendorInfoList=vendorInfoRepository.findAll();
        List<VendorInfoDto> vendorInfoDtos=new ArrayList<>();
        for (VendorInfo info:vendorInfoList){
            vendorInfoDtos.add(entityToDto(info));
        }
        return vendorInfoDtos;
    }

    @Override
    public VendorInfoDto findById(long id) {
        Optional<VendorInfo> info=vendorInfoRepository.findById(id);
        return entityToDto(info.get());
    }

    @Override
    public VendorInfoDto findByVendorCode(String code) {
        Optional<VendorInfo> info=vendorInfoRepository.findByVendorCode(code);
        if (!info.isPresent()){
            throw new ESAException("Vendor code does not exist.",HttpStatus.BAD_REQUEST,400);
        }
        return entityToDto(info.get());
    }

    @Override
    public VendorInfoDto findByVendorPhoneNumber(String number) {
        Optional<VendorInfo> info=vendorInfoRepository.findByPhoneNumber(number);
        if (!info.isPresent()){
            throw new ESAException("Vendor phone does not exist.",HttpStatus.BAD_REQUEST,400);
        }
        return entityToDto(info.get());
    }

    @Override
    public VendorInfoDto updateVendor(long id, VendorInfoDto dto) {
        Optional<VendorInfo> info=vendorInfoRepository.findById(id);
        if (info.isPresent()){
            info.get().setVendorName(dto.getVendorName());
            info.get().setPhoneNumber(dto.getPhoneNumber());
            info.get().setVatNumber(dto.getVatNumber());
        }
        vendorInfoRepository.save(info.get());
        return entityToDto(info.get());
    }

    public VendorInfo dtoToEntity(VendorInfoDto dto){
        VendorInfo info=new VendorInfo();
        info.setId(dto.getId());
        info.setVendorCode(dto.getVendorCode());
        info.setVendorName(dto.getVendorName());
        info.setPhoneNumber(dto.getPhoneNumber());
        info.setVatNumber(dto.getVatNumber());
        info.setPanNumber(dto.getPanNumber());
        return info;
    }

    public VendorInfoDto entityToDto(VendorInfo info){
        VendorInfoDto dto=new VendorInfoDto();
        dto.setId(info.getId());
        dto.setVendorCode(info.getVendorCode());
        dto.setVendorName(info.getVendorName());
        dto.setPhoneNumber(info.getPhoneNumber());
        dto.setVatNumber(info.getVatNumber());
        dto.setPanNumber(info.getPanNumber());
        return dto;
    }
}

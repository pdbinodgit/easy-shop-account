package com.easyshopaccount.easyshopaccount.goodreceivenote.serviceimpl;

import com.easyshopaccount.easyshopaccount.goodreceivenote.dto.GoodReceiveNoteDto;
import com.easyshopaccount.easyshopaccount.goodreceivenote.model.GoodReceiveNote;
import com.easyshopaccount.easyshopaccount.goodreceivenote.repository.GoodReceiveNoteRepository;
import com.easyshopaccount.easyshopaccount.goodreceivenote.service.GoodReceiveNoteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Random;

public class GoodReceiveNoteServiceImpl implements GoodReceiveNoteService {
   @Autowired
    GoodReceiveNoteRepository goodReceiveNoteRepository;

    @Override
    public GoodReceiveNoteDto save(GoodReceiveNoteDto dto) {
        Random random=new Random();
        int number=random.nextInt(1000);
        String grnNumber="GRN-"+number;
        GoodReceiveNote goodReceiveNote=dtoToEntity(dto);
        goodReceiveNote.setGRNNumber(grnNumber);
       GoodReceiveNote saveNote = goodReceiveNoteRepository.save(goodReceiveNote);
        return entityToDto(saveNote);
    }

    @Override
    public List<GoodReceiveNote> findAll() {
        return List.of();
    }

    @Override
    public GoodReceiveNoteDto findById(long id) {
        return null;
    }

    @Override
    public List<GoodReceiveNote> findByGrnNumber(String grnNumber) {
        return List.of();
    }

    @Override
    public GoodReceiveNoteDto update(GoodReceiveNoteDto dto, long id) {
        return null;
    }

    public GoodReceiveNoteDto entityToDto(GoodReceiveNote note){
        GoodReceiveNoteDto dto=new GoodReceiveNoteDto();
        dto.setId(note.getId());
        dto.setGRNNumber(note.getGRNNumber());
        dto.setPrice(note.getPrice());
        dto.setQuantity(note.getQuantity());
        dto.setVendorInfo(note.getVendorInfo());
        dto.setProductInfo(note.getProductInfo());
        return dto;
    }

    public GoodReceiveNote dtoToEntity(GoodReceiveNoteDto dto){
        GoodReceiveNote note=new GoodReceiveNote();
        note.setId(dto.getId());
        note.setGRNNumber(dto.getGRNNumber());
        note.setPrice(dto.getPrice());
        note.setQuantity(dto.getQuantity());
        note.setVendorInfo(dto.getVendorInfo());
        note.setProductInfo(dto.getProductInfo());
        return note;
    }
}

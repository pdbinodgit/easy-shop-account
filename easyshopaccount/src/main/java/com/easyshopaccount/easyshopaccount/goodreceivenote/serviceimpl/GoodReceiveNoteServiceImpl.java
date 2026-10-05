package com.easyshopaccount.easyshopaccount.goodreceivenote.serviceimpl;

import com.easyshopaccount.easyshopaccount.customexception.ESAException;
import com.easyshopaccount.easyshopaccount.goodreceivenote.dto.GoodReceiveNoteDto;
import com.easyshopaccount.easyshopaccount.goodreceivenote.model.GoodReceiveNote;
import com.easyshopaccount.easyshopaccount.goodreceivenote.repository.GoodReceiveNoteRepository;
import com.easyshopaccount.easyshopaccount.goodreceivenote.service.GoodReceiveNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    public List<GoodReceiveNoteDto> findAll() {
        List<GoodReceiveNote> goodReceiveNoteList=goodReceiveNoteRepository.findAll();
        List<GoodReceiveNoteDto> dtoList=new ArrayList<>();
        for (GoodReceiveNote note:goodReceiveNoteList){
            dtoList.add(entityToDto(note));
        }
        return dtoList;
    }

    @Override
    public GoodReceiveNoteDto findById(long id) {
        Optional<GoodReceiveNote> note=goodReceiveNoteRepository.findById(id);
        if (!note.isPresent()){
           throw new ESAException("Good Receive Note is not exist.", HttpStatus.BAD_REQUEST,400);
        }
        return entityToDto(note.get());
    }

    @Override
    public GoodReceiveNoteDto findByGrnNumber(String grnNumber) {
        return null;
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

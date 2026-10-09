package com.easyshopaccount.easyshopaccount.goodreceivenote.serviceimpl;

import com.easyshopaccount.easyshopaccount.customexception.ESAException;
import com.easyshopaccount.easyshopaccount.goodreceivenote.dto.GoodReceiveNoteDto;
import com.easyshopaccount.easyshopaccount.goodreceivenote.model.GoodReceiveNote;
import com.easyshopaccount.easyshopaccount.goodreceivenote.repository.GoodReceiveNoteRepository;
import com.easyshopaccount.easyshopaccount.goodreceivenote.service.GoodReceiveNoteService;
import com.easyshopaccount.easyshopaccount.goodreceivenotedetails.dto.GrnDetailsDto;
import com.easyshopaccount.easyshopaccount.goodreceivenotedetails.model.GrnDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
@Service
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
        Optional<GoodReceiveNote> optionalGoodReceiveNote=goodReceiveNoteRepository.findByGRNNumber(grnNumber);
        if (!optionalGoodReceiveNote.isPresent()){
            throw new ESAException("Good Receive note is not exist for this GRN Number",HttpStatus.BAD_REQUEST,400);
        }
        return entityToDto(optionalGoodReceiveNote.get());
    }

    @Override
    public GoodReceiveNoteDto update(GoodReceiveNoteDto dto, long id) {
        return null;
    }

    public GoodReceiveNoteDto entityToDto(GoodReceiveNote note){
        GoodReceiveNoteDto dto=new GoodReceiveNoteDto();
        dto.setId(note.getId());
        dto.setGRNNumber(note.getGRNNumber());
        dto.setVendorInfo(note.getVendorInfo());
        List<GrnDetailsDto> grnDetailsDtos=new ArrayList<>();
        for (GrnDetails details:note.getGrnDetailsList()){
            GrnDetailsDto grnDetailsDto=new GrnDetailsDto();
            grnDetailsDto.setGrnNumber(details.getGrnNumber());
            grnDetailsDto.setId(details.getId());
            grnDetailsDto.setPrice(details.getPrice());
            grnDetailsDto.setProductInfo(details.getProductInfo());
            grnDetailsDto.setQuantity(details.getQuantity());
            grnDetailsDtos.add(grnDetailsDto);
        }
        dto.setGrnDetailsDtos(grnDetailsDtos);
        return dto;
    }

    public GoodReceiveNote dtoToEntity(GoodReceiveNoteDto dto){
        GoodReceiveNote note=new GoodReceiveNote();
        note.setId(dto.getId());
        note.setGRNNumber(dto.getGRNNumber());
        note.setVendorInfo(dto.getVendorInfo());

        return note;
    }
}

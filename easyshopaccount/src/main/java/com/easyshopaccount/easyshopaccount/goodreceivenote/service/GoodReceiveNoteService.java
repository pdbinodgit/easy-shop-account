package com.easyshopaccount.easyshopaccount.goodreceivenote.service;

import com.easyshopaccount.easyshopaccount.goodreceivenote.dto.GoodReceiveNoteDto;
import com.easyshopaccount.easyshopaccount.goodreceivenote.model.GoodReceiveNote;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GoodReceiveNoteService {
    public GoodReceiveNoteDto save(GoodReceiveNoteDto dto);
    public List<GoodReceiveNoteDto> findAll();
    public GoodReceiveNoteDto findById(long id);
    public GoodReceiveNoteDto findByGrnNumber(String grnNumber);
    public GoodReceiveNoteDto update(GoodReceiveNoteDto dto,long id);

}

package com.easyshopaccount.easyshopaccount.goodreceivenote.controller;

import com.easyshopaccount.easyshopaccount.customresponse.ESAResponse;
import com.easyshopaccount.easyshopaccount.goodreceivenote.dto.GoodReceiveNoteDto;
import com.easyshopaccount.easyshopaccount.goodreceivenote.service.GoodReceiveNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/grn")
public class GoodReceiveNoteController {

    @Autowired
    GoodReceiveNoteService goodReceiveNoteService;

    @PostMapping("/save")
    public ESAResponse<?> save(GoodReceiveNoteDto dto){
        GoodReceiveNoteDto goodReceiveNoteDto= goodReceiveNoteService.save(dto);
        return new ESAResponse<>(HttpStatus.OK,"Good Receive note save successfully.",goodReceiveNoteDto, LocalDateTime.now());

    }

    @GetMapping("/findAll")
    public ESAResponse<?> findAll(){
        return new ESAResponse<>(HttpStatus.OK,"Good Receive note retrieve successfully",goodReceiveNoteService.findAll(),LocalDateTime.now());
    }

    @GetMapping("/findById/{id}")
    public ESAResponse<?> findById(@PathVariable long id){
        return new ESAResponse<>(HttpStatus.OK,"Good Receive note retrieve successfully",goodReceiveNoteService.findById(id),LocalDateTime.now());

    }

    @GetMapping("/findByGrn/{grnNumber}")
    public ESAResponse<?> findById(@PathVariable String grnNumber){
        return new ESAResponse<>(HttpStatus.OK,"Good Receive note retrieve successfully",goodReceiveNoteService.findByGrnNumber(grnNumber),LocalDateTime.now());
    }
}

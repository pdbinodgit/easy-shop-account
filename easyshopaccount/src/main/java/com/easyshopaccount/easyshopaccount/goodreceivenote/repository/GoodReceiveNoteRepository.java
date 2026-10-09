package com.easyshopaccount.easyshopaccount.goodreceivenote.repository;

import com.easyshopaccount.easyshopaccount.goodreceivenote.model.GoodReceiveNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GoodReceiveNoteRepository extends JpaRepository<GoodReceiveNote,Long> {
    Optional<GoodReceiveNote> findByGRNNumber(String grnNumber);
}

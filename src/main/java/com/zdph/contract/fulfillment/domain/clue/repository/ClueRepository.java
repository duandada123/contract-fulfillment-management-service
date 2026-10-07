package com.zdph.contract.fulfillment.domain.clue.repository;

import com.sinogale.jpa.support.BaseRepository;
import com.zdph.contract.fulfillment.domain.clue.Clue;

import java.util.Optional;

public interface ClueRepository extends BaseRepository<Clue, Long> {

    Optional<Clue> findByClueNo(String clueNo);
}
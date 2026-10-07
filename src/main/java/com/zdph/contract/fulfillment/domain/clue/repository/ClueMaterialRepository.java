package com.zdph.contract.fulfillment.domain.clue.repository;

import com.sinogale.jpa.support.BaseRepository;
import com.zdph.contract.fulfillment.domain.clue.ClueMaterial;

import java.util.List;

public interface ClueMaterialRepository extends BaseRepository<ClueMaterial, Long> {


    List<ClueMaterial> findByIdIn(List<Long> ids);

}
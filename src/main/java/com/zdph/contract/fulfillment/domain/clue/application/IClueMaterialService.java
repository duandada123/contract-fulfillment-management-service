package com.zdph.contract.fulfillment.domain.clue.application;

import com.zdph.contract.fulfillment.domain.clue.dto.ClueMaterialDto;
import com.zdph.contract.fulfillment.domain.clue.updater.ClueMaterialUpdater;
import com.zdph.contract.fulfillment.domain.clue.vo.ClueMaterialVo;

public interface IClueMaterialService {
    Long createClueMaterial(ClueMaterialDto dto);

    void updateClueMaterial(ClueMaterialUpdater updater);

    ClueMaterialVo findById(Long id);
}
package com.zdph.contract.fulfillment.domain.clue.application.impl;

import com.sinogale.common.constants.ErrorCode;
import com.sinogale.common.exception.BusinessException;
import com.sinogale.jpa.support.BaseJpaService;
import com.zdph.contract.fulfillment.domain.clue.ClueMaterial;
import com.zdph.contract.fulfillment.domain.clue.application.IClueMaterialService;
import com.zdph.contract.fulfillment.domain.clue.dto.ClueMaterialDto;
import com.zdph.contract.fulfillment.domain.clue.mapper.ClueMaterialMapper;
import com.zdph.contract.fulfillment.domain.clue.repository.ClueMaterialRepository;
import com.zdph.contract.fulfillment.domain.clue.updater.ClueMaterialUpdater;
import com.zdph.contract.fulfillment.domain.clue.vo.ClueMaterialVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
@Slf4j
public class ClueMaterialServiceImpl extends BaseJpaService implements IClueMaterialService {

    private final ClueMaterialRepository clueMaterialRepository;

    public ClueMaterialServiceImpl(ClueMaterialRepository clueMaterialRepository) {
        this.clueMaterialRepository = clueMaterialRepository;
    }

    @Override
    public Long createClueMaterial(ClueMaterialDto dto) {
        Optional<ClueMaterial> clueMaterial = doCreate(clueMaterialRepository)
                .create(() -> ClueMaterialMapper.INSTANCE.dtoToEntity(dto))
                .execute();
        return clueMaterial.isPresent() ? clueMaterial.get().getId() : 0;
    }

    @Override
    public void updateClueMaterial(ClueMaterialUpdater updater) {
        doUpdate(clueMaterialRepository)
                .loadById(updater.getId())
                .update(updater::updateClueMaterial)
                .execute();
    }


    @Override
    public ClueMaterialVo findById(Long id) {
        Optional<ClueMaterial> clueMaterial = clueMaterialRepository.findById(id);
        return new ClueMaterialVo(clueMaterial.orElseThrow(() -> new BusinessException(ErrorCode.NOT_FIND_ERROR)));
    }

}

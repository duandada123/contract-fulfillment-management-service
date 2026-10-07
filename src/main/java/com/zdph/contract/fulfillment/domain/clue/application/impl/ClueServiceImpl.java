package com.zdph.contract.fulfillment.domain.clue.application.impl;

import com.querydsl.core.BooleanBuilder;
import com.sinogale.common.constants.ErrorCode;
import com.sinogale.common.exception.BusinessException;
import com.sinogale.common.model.PageRequestWrapper;
import com.sinogale.jpa.support.BaseJpaService;
import com.zdph.contract.fulfillment.domain.clue.Clue;
import com.zdph.contract.fulfillment.domain.clue.application.IClueService;
import com.zdph.contract.fulfillment.domain.clue.dto.ClueDto;
import com.zdph.contract.fulfillment.domain.clue.mapper.ClueMapper;
import com.zdph.contract.fulfillment.domain.clue.query.ClueQuery;
import com.zdph.contract.fulfillment.domain.clue.repository.ClueRepository;
import com.zdph.contract.fulfillment.domain.clue.updater.ClueUpdater;
import com.zdph.contract.fulfillment.domain.clue.vo.ClueVo;
import com.zdph.contract.fulfillment.infrastructure.util.WaterFlowUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
@Slf4j
public  class ClueServiceImpl extends BaseJpaService implements IClueService {

    private final ClueRepository clueRepository;

    public ClueServiceImpl(ClueRepository clueRepository) {
        this.clueRepository = clueRepository;
    }

    @Override
    public Long saveClue(ClueDto dto) {
        Optional<Clue> clue  = doCreate(clueRepository)
                .create(() -> ClueMapper.INSTANCE.dtoToEntity(dto))
                .init(Clue::init)
                .execute();
        return clue.isPresent() ? clue.get().getId() : 0;
       /* Optional<Clue> clue = Optional.empty();
        if (Objects.isNull(dto.getClueNo())) {
            clue = clueRepository.findByClueNo(dto.getClueNo());
        } else {
            dto.setClueNo(String.valueOf(WaterFlowUtils.nextWaterFlow()));
        }
        if (clue.isPresent()) {
            doUpdate(clueRepository)
                    .load(clue::get)
                    .update(Clue::update)
                    .execute();
        } else {
            clue = doCreate(clueRepository)
                    .create(() -> ClueMapper.INSTANCE.dtoToEntity(dto))
                    .init(Clue::init)
                    .execute();
        }
        return clue.isPresent() ? clue.get().getId() : 0;*/
    }

    @Override
    public void updateClue(ClueUpdater updater) {
        doUpdate(clueRepository)
                .loadById(updater.getId())
                .update(Clue::update)
                .execute();
    }


    @Override
    public ClueVo findById(Long id) {
        Optional<Clue> clue = clueRepository.findById(id);
        return new ClueVo(clue.orElseThrow(() -> new BusinessException(ErrorCode.NOT_FIND_ERROR)));
    }

    @Override
    public Page<ClueVo> findByPage(PageRequestWrapper<ClueQuery> query) {
        BooleanBuilder booleanBuilder = pageCondition(query);
        Page<Clue> page = clueRepository.findAll(booleanBuilder, PageRequest.of(query.getPage() - 1, query.getPageSize(), Sort.by(Sort.Direction.DESC, "createdAt")));
        return new PageImpl<>(page.getContent().stream().map(ClueVo::new).collect(Collectors.toList()), page.getPageable(), page.getTotalElements());
    }

    private BooleanBuilder pageCondition(PageRequestWrapper<ClueQuery> query) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        return booleanBuilder;
    }
}

package com.zdph.contract.fulfillment.domain.clue.application;

import com.sinogale.common.model.PageRequestWrapper;
import com.zdph.contract.fulfillment.domain.clue.dto.ClueDto;
import com.zdph.contract.fulfillment.domain.clue.query.ClueQuery;
import com.zdph.contract.fulfillment.domain.clue.updater.ClueUpdater;
import com.zdph.contract.fulfillment.domain.clue.vo.ClueVo;
import org.springframework.data.domain.Page;

public interface IClueService {
    Long saveClue(ClueDto dto);
    void updateClue(ClueUpdater updater);
    ClueVo findById(Long id);
    Page<ClueVo> findByPage(PageRequestWrapper<ClueQuery> query);
}
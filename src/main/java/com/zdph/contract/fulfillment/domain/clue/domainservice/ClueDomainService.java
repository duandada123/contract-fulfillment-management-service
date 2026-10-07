package com.zdph.contract.fulfillment.domain.clue.domainservice;


import com.zdph.contract.fulfillment.domain.clue.application.IClueService;
import com.zdph.contract.fulfillment.domain.clue.dto.ClueDto;
import com.zdph.contract.fulfillment.domain.clue.mapper.ClueMapper;
import com.zdph.contract.fulfillment.domain.clue.updater.ClueUpdater;
import com.zdph.contract.fulfillment.infrastructure.util.WaterFlowUtils;
import com.zdph.contract.fulfillment.request.ClueCreateRequest;
import com.zdph.contract.fulfillment.request.ClueUpdateRequest;
import org.springframework.stereotype.Service;

@Service
public class ClueDomainService {

    private IClueService clueService;

    public Long registerClue(ClueCreateRequest request) {
        ClueDto dto = ClueMapper.INSTANCE.request2Dto(request);
        dto.setClueNo(String.valueOf(WaterFlowUtils.nextWaterFlow()));
        return clueService.saveClue(dto);
    }

    public void updateClue(ClueUpdateRequest request) {
        ClueUpdater clueUpdater = ClueMapper.INSTANCE.request2Updater(request);
        clueService.updateClue(clueUpdater);
    }
}

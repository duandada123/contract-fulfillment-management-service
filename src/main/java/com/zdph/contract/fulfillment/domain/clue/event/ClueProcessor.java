package com.zdph.contract.fulfillment.domain.clue.event;


import com.zdph.contract.fulfillment.domain.clue.ClueMaterial;
import com.zdph.contract.fulfillment.domain.clue.repository.ClueMaterialRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Component
public class ClueProcessor {

    private final static Logger logger = LoggerFactory.getLogger(ClueProcessor.class);

    private final ClueMaterialRepository ClueMaterialRepository;


    //监听线索保存事件
    @EventListener
    public void handleSavedEventForMaterial(ClueSavedEvent event) {
        List<ClueMaterial> materialList = ClueMaterialRepository.findByIdIn(event.getClueMaterialIds());
        materialList.forEach(material -> {
            if (Objects.isNull(material.getClueId())){
                material.setClueId(event.getId());
                ClueMaterialRepository.save(material);
            }
        });
    }

    @EventListener
    public void handleCreatedEventForMaterial(ClueCreatedEvent event) {
        List<ClueMaterial> materialList = ClueMaterialRepository.findByIdIn(event.getClueMaterialIds());
        materialList.forEach(material -> {
                material.setClueId(event.getId());
                ClueMaterialRepository.save(material);
        });
    }
}

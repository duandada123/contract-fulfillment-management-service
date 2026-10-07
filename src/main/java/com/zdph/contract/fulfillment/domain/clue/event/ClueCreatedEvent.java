package com.zdph.contract.fulfillment.domain.clue.event;

import lombok.Data;

import java.util.List;


@Data
public class ClueCreatedEvent {

    private Long id;

    private List<Long> clueMaterialIds;

    public ClueCreatedEvent(Long id, List<Long> clueMaterialIds) {
        this.id = id;
        this.clueMaterialIds = clueMaterialIds;
    }
}

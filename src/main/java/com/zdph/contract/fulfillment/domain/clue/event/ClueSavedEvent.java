package com.zdph.contract.fulfillment.domain.clue.event;

import lombok.Data;

import java.util.List;

/**
 * @author duanyeweiwu
 */

@Data
public class ClueSavedEvent {

    private Long id;

    private List<Long> clueMaterialIds;

    public ClueSavedEvent(Long id, List<Long> clueMaterialIds) {
        this.id = id;
        this.clueMaterialIds = clueMaterialIds;
    }
}

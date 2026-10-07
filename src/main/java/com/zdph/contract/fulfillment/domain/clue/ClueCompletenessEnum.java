package com.zdph.contract.fulfillment.domain.clue;

import com.sinogale.common.constants.BaseEnum;

import java.util.Optional;

/**
 * 线索信息是否完整。
 */
public enum ClueCompletenessEnum implements BaseEnum<ClueCompletenessEnum> {
    NO(0, "否"),
    YES(1, "是");

    ClueCompletenessEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    private Integer code;

    private String name;

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public static Optional<ClueCompletenessEnum> of(Integer code) {
        if (code == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(BaseEnum.parseByCode(ClueCompletenessEnum.class, code));
    }
}

package com.zdph.contract.fulfillment.domain.clue;

import com.sinogale.common.constants.BaseEnum;

import java.util.Optional;

/**
 * 线索来源是否启用。
 */
public enum ClueSourceEnabledEnum implements BaseEnum<ClueSourceEnabledEnum> {
    NO(0, "否"),
    YES(1, "是");

    ClueSourceEnabledEnum(Integer code, String name) {
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

    public static Optional<ClueSourceEnabledEnum> of(Integer code) {
        if (code == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(BaseEnum.parseByCode(ClueSourceEnabledEnum.class, code));
    }
}

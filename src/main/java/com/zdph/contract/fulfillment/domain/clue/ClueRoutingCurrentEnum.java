package com.zdph.contract.fulfillment.domain.clue;

import com.sinogale.common.constants.BaseEnum;

import java.util.Optional;

/**
 * 是否当前有效归口。
 */
public enum ClueRoutingCurrentEnum implements BaseEnum<ClueRoutingCurrentEnum> {
    NO(0, "否"),
    YES(1, "是");

    ClueRoutingCurrentEnum(Integer code, String name) {
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

    public static Optional<ClueRoutingCurrentEnum> of(Integer code) {
        if (code == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(BaseEnum.parseByCode(ClueRoutingCurrentEnum.class, code));
    }
}

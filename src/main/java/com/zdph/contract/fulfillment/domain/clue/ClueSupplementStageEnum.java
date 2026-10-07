package com.zdph.contract.fulfillment.domain.clue;

import com.sinogale.common.constants.BaseEnum;

import java.util.Optional;

/**
 * 线索补充发起阶段。
 */
public enum ClueSupplementStageEnum implements BaseEnum<ClueSupplementStageEnum> {
    CLUE_REVIEW(1, "线索审核"),
    SPECIALTY_ROUTING(2, "专业归口");

    ClueSupplementStageEnum(Integer code, String name) {
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

    public static Optional<ClueSupplementStageEnum> of(Integer code) {
        if (code == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(BaseEnum.parseByCode(ClueSupplementStageEnum.class, code));
    }
}

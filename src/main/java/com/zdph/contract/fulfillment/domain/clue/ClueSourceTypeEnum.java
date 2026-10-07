package com.zdph.contract.fulfillment.domain.clue;

import com.sinogale.common.constants.BaseEnum;

import java.util.Optional;

/**
 * 线索来源类型。
 */
public enum ClueSourceTypeEnum implements BaseEnum<ClueSourceTypeEnum> {
    CUSTOMER_REPORT(1, "客户举报"),
    SYSTEM_PUSH(2, "系统推送"),
    INTERNAL_DISCOVERY(3, "内部发现"),
    OTHER_SPECIALTY_TRANSFER(4, "其他专业移交");

    ClueSourceTypeEnum(Integer code, String name) {
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

    public static Optional<ClueSourceTypeEnum> of(Integer code) {
        if (code == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(BaseEnum.parseByCode(ClueSourceTypeEnum.class, code));
    }
}

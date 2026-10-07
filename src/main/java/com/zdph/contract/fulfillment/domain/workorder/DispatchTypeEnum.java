package com.zdph.contract.fulfillment.domain.workorder;

import com.sinogale.common.constants.BaseEnum;

import java.util.Optional;

/**
 * 派工类型。
 */
public enum DispatchTypeEnum implements BaseEnum<DispatchTypeEnum> {
    INITIAL_DISPATCH(1, "首次派工"),
    REDISPATCH(2, "重新派工");

    DispatchTypeEnum(Integer code, String name) {
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

    public static Optional<DispatchTypeEnum> of(Integer code) {
        if (code == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(BaseEnum.parseByCode(DispatchTypeEnum.class, code));
    }
}

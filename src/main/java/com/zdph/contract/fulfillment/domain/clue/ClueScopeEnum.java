package com.zdph.contract.fulfillment.domain.clue;

import com.sinogale.common.constants.BaseEnum;

import java.util.Optional;

/**
 * 是否属于合同履约处置范围。
 */
public enum ClueScopeEnum implements BaseEnum<ClueScopeEnum> {
    NO(0, "否"),
    YES(1, "是");

    ClueScopeEnum(Integer code, String name) {
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

    public static Optional<ClueScopeEnum> of(Integer code) {
        if (code == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(BaseEnum.parseByCode(ClueScopeEnum.class, code));
    }
}

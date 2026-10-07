package com.zdph.contract.fulfillment.domain.clue;

import com.sinogale.common.constants.BaseEnum;

import java.util.Optional;

/**
 * 线索审核结果。
 */
public enum ClueReviewResultEnum implements BaseEnum<ClueReviewResultEnum> {
    APPROVED(1, "通过"),
    RETURNED_FOR_SUPPLEMENT(2, "退回补充"),
    LINKED_TO_VALID_CLUE(3, "关联有效线索"),
    VOIDED(4, "作废"),
    TRANSFERRED(5, "转办");

    ClueReviewResultEnum(Integer code, String name) {
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

    public static Optional<ClueReviewResultEnum> of(Integer code) {
        if (code == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(BaseEnum.parseByCode(ClueReviewResultEnum.class, code));
    }
}

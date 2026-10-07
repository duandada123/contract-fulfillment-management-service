package com.zdph.contract.fulfillment.domain.clue;

import com.sinogale.common.constants.BaseEnum;

import java.util.Optional;

/**
 * 线索状态。
 */
public enum ClueStatusEnum implements BaseEnum<ClueStatusEnum> {
    DRAFT(0, "草稿"),
    PENDING_SUPPLEMENT(1, "待补充"),
    PENDING_REVIEW(2, "待审核"),
    PENDING_ROUTING(3, "待归口"),
    PENDING_WORK_ORDER(4, "待生成工单"),
    CONVERTED_TO_WORK_ORDER(5, "已转工单"),
    LINKED(6, "已关联"),
    VOIDED(7, "已作废"),
    TRANSFERRED(8, "已转办");

    ClueStatusEnum(Integer code, String name) {
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

    public static Optional<ClueStatusEnum> of(Integer code) {
        if (code == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(BaseEnum.parseByCode(ClueStatusEnum.class, code));
    }
}

package com.zdph.contract.fulfillment.domain.workorder;

import com.sinogale.common.constants.BaseEnum;

import java.util.Optional;

/**
 * 工单状态。
 */
public enum WorkOrderStatusEnum implements BaseEnum<WorkOrderStatusEnum> {
    PENDING_ASSIGNMENT(1, "待分配"),
    PENDING_INVESTIGATION(2, "待调查"),
    PENDING_DETERMINATION(3, "待认定"),
    IN_APPROVAL(4, "审批中"),
    PENDING_DISPOSAL_RESULTS(5, "待处置结果"),
    PENDING_ARCHIVE(6, "待归档"),
    ARCHIVED(7, "已归档");

    WorkOrderStatusEnum(Integer code, String name) {
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

    public static Optional<WorkOrderStatusEnum> of(Integer code) {
        if (code == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(BaseEnum.parseByCode(WorkOrderStatusEnum.class, code));
    }
}

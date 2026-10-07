package com.zdph.contract.fulfillment.domain.workorder.convert;

import com.zdph.contract.fulfillment.domain.workorder.WorkOrderStatusEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * 工单状态转换器。
 */
@Converter
public class WorkOrderStatusEnumConverter implements AttributeConverter<WorkOrderStatusEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(WorkOrderStatusEnum value) {
        return value == null ? null : value.getCode();
    }

    @Override
    public WorkOrderStatusEnum convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }
        return WorkOrderStatusEnum.of(code).orElse(null);
    }
}

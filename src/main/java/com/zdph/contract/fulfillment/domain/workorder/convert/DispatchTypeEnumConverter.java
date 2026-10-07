package com.zdph.contract.fulfillment.domain.workorder.convert;

import com.zdph.contract.fulfillment.domain.workorder.DispatchTypeEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * 派工类型转换器。
 */
@Converter
public class DispatchTypeEnumConverter implements AttributeConverter<DispatchTypeEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(DispatchTypeEnum value) {
        return value == null ? null : value.getCode();
    }

    @Override
    public DispatchTypeEnum convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }
        return DispatchTypeEnum.of(code).orElse(null);
    }
}

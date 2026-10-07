package com.zdph.contract.fulfillment.domain.clue.convert;

import com.zdph.contract.fulfillment.domain.clue.ClueStatusEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * 线索状态转换器。
 */
@Converter
public class ClueStatusEnumConverter implements AttributeConverter<ClueStatusEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ClueStatusEnum value) {
        return value == null ? null : value.getCode();
    }

    @Override
    public ClueStatusEnum convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }
        return ClueStatusEnum.of(code).orElse(null);
    }
}

package com.zdph.contract.fulfillment.domain.clue.convert;

import com.zdph.contract.fulfillment.domain.clue.ClueSourceEnabledEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * 线索来源是否启用转换器。
 */
@Converter
public class ClueSourceEnabledEnumConverter implements AttributeConverter<ClueSourceEnabledEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ClueSourceEnabledEnum value) {
        return value == null ? null : value.getCode();
    }

    @Override
    public ClueSourceEnabledEnum convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }
        return ClueSourceEnabledEnum.of(code).orElse(null);
    }
}

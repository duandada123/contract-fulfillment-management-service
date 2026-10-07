package com.zdph.contract.fulfillment.domain.clue.convert;

import com.zdph.contract.fulfillment.domain.clue.ClueSourceTypeEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * 线索来源类型转换器。
 */
@Converter
public class ClueSourceTypeEnumConverter implements AttributeConverter<ClueSourceTypeEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ClueSourceTypeEnum value) {
        return value == null ? null : value.getCode();
    }

    @Override
    public ClueSourceTypeEnum convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }
        return ClueSourceTypeEnum.of(code).orElse(null);
    }
}

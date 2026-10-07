package com.zdph.contract.fulfillment.domain.clue.convert;

import com.zdph.contract.fulfillment.domain.clue.ClueValidityEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * 线索是否有效转换器。
 */
@Converter
public class ClueValidityEnumConverter implements AttributeConverter<ClueValidityEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ClueValidityEnum value) {
        return value == null ? null : value.getCode();
    }

    @Override
    public ClueValidityEnum convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }
        return ClueValidityEnum.of(code).orElse(null);
    }
}

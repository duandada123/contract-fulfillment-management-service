package com.zdph.contract.fulfillment.domain.clue.convert;

import com.zdph.contract.fulfillment.domain.clue.ClueDuplicateEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * 是否重复线索转换器。
 */
@Converter
public class ClueDuplicateEnumConverter implements AttributeConverter<ClueDuplicateEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ClueDuplicateEnum value) {
        return value == null ? null : value.getCode();
    }

    @Override
    public ClueDuplicateEnum convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }
        return ClueDuplicateEnum.of(code).orElse(null);
    }
}

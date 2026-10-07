package com.zdph.contract.fulfillment.domain.clue.convert;

import com.zdph.contract.fulfillment.domain.clue.ClueCompletenessEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * 线索信息是否完整转换器。
 */
@Converter
public class ClueCompletenessEnumConverter implements AttributeConverter<ClueCompletenessEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ClueCompletenessEnum value) {
        return value == null ? null : value.getCode();
    }

    @Override
    public ClueCompletenessEnum convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }
        return ClueCompletenessEnum.of(code).orElse(null);
    }
}

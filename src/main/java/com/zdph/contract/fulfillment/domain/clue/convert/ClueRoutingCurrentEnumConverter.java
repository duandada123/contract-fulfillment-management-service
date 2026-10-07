package com.zdph.contract.fulfillment.domain.clue.convert;

import com.zdph.contract.fulfillment.domain.clue.ClueRoutingCurrentEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * 是否当前有效归口转换器。
 */
@Converter
public class ClueRoutingCurrentEnumConverter implements AttributeConverter<ClueRoutingCurrentEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ClueRoutingCurrentEnum value) {
        return value == null ? null : value.getCode();
    }

    @Override
    public ClueRoutingCurrentEnum convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }
        return ClueRoutingCurrentEnum.of(code).orElse(null);
    }
}

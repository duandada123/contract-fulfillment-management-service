package com.zdph.contract.fulfillment.domain.clue.convert;

import com.zdph.contract.fulfillment.domain.clue.ClueSupplementStageEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * 线索补充发起阶段转换器。
 */
@Converter
public class ClueSupplementStageEnumConverter implements AttributeConverter<ClueSupplementStageEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ClueSupplementStageEnum value) {
        return value == null ? null : value.getCode();
    }

    @Override
    public ClueSupplementStageEnum convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }
        return ClueSupplementStageEnum.of(code).orElse(null);
    }
}

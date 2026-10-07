package com.zdph.contract.fulfillment.domain.clue.convert;

import com.zdph.contract.fulfillment.domain.clue.ClueReviewResultEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * 线索审核结果转换器。
 */
@Converter
public class ClueReviewResultEnumConverter implements AttributeConverter<ClueReviewResultEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ClueReviewResultEnum value) {
        return value == null ? null : value.getCode();
    }

    @Override
    public ClueReviewResultEnum convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }
        return ClueReviewResultEnum.of(code).orElse(null);
    }
}

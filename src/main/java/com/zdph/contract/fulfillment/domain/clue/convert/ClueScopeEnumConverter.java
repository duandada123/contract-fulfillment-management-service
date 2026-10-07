package com.zdph.contract.fulfillment.domain.clue.convert;

import com.zdph.contract.fulfillment.domain.clue.ClueScopeEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * 是否属于合同履约处置范围转换器。
 */
@Converter
public class ClueScopeEnumConverter implements AttributeConverter<ClueScopeEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ClueScopeEnum value) {
        return value == null ? null : value.getCode();
    }

    @Override
    public ClueScopeEnum convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }
        return ClueScopeEnum.of(code).orElse(null);
    }
}

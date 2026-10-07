package com.zdph.contract.fulfillment.infrastructure.util;

import jodd.vtor.Violation;
import jodd.vtor.Vtor;
import org.springframework.util.CollectionUtils;

import java.util.List;

public enum CheckParameterUtil {

    INSTANCE;

    public String commonViolation(final Object request) {
        final List<Violation> validates = Vtor.create().validate(request);
        return CollectionUtils.isEmpty(validates) ? null : validates.get(0).getCheck().getMessage();
    }
}

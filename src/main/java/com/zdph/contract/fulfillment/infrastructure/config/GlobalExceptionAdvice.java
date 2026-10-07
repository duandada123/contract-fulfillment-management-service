package com.zdph.contract.fulfillment.infrastructure.config;


import com.sinogale.common.constants.ErrorCode;
import com.sinogale.common.exception.BusinessException;
import com.sinogale.common.exception.SystemException;
import com.sinogale.common.model.OpenAPIResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionAdvice {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionAdvice.class);

    @ExceptionHandler({BusinessException.class})
    public OpenAPIResponse handleBusinessException(BusinessException e) {
        log.error("业务异常", e);
        return OpenAPIResponse.res(e.getMsg(), e.getData());
    }

    @ExceptionHandler({SystemException.class})
    public OpenAPIResponse handleSystemException(SystemException e) {
        log.error("系统异常", e);
        return OpenAPIResponse.fail(ErrorCode.SYSTEM_ERROR);
    }

    @ExceptionHandler({Exception.class})
    public OpenAPIResponse handleException(Exception e) {
        log.error("系统异常", e);
        return OpenAPIResponse.fail(ErrorCode.SYSTEM_ERROR);
    }
}

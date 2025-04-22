package com.cathaybk.handler;

import com.cathaybk.enums.ErrorEnum;
import com.cathaybk.exception.CustomerException;
import com.cathaybk.vo.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomerException.class)
    public ErrorResponse handleCustomerException(CustomerException ex) {
        return new ErrorResponse(ex.getErrorCode(), ex.getErrorMsg());
    }

    @ExceptionHandler(Exception.class)
    public ErrorResponse handleCustomerException(Exception ex) {
        // log ex
        return new ErrorResponse(ErrorEnum.SYSTEM_ERROR.getErrorCode(), ErrorEnum.SYSTEM_ERROR.getErrorMsg());
    }
}

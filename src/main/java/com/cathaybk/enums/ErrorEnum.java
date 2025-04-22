package com.cathaybk.enums;

public enum ErrorEnum {

    CURRENCY_NOT_FOUND("CURRENCY-404", "找不到指定的貨幣"),
    INVALID_INPUT("COMMON-400", "輸入參數錯誤"),
    SYSTEM_ERROR("SYS-500", "系統發生錯誤"),
    API_ERROR("API-500", "CALL API發生錯誤"),
    ;

    private final String errorCode;
    private final String errorMsg;

    ErrorEnum(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}

package com.shunqi.wallet.merchants.constant;

public enum ErrorCode {

    SUCCESS(0, ""),
    DUPLICATE_NAME(1, "Duplicate merchant names"),
    EMPTY_LOGO(2, "Empty merchant logo"),
    INVALID_BUSINESS_LICENSE(3, "Invalid merchant license"),
    INVALID_PHONE_NUM(4, "Invalid phone number"),
    INVALID_ADDRESS(5, "Invalid address"),
    MERCHANT_NOT_EXIST(6, "Merchant does not exist");

    private int errorCode;

    // error description
    private String errorDescription;

    ErrorCode(Integer errorCode, String errorDescription) {
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorDescription() {
        return this.errorDescription;
    }

}

package com.shunqi.wallet.merchants.constant;

public enum CouponColor {

    RED(1, "red"),
    GREEN(2, "green"),
    BLUE(3, "blue");

    // color code
    private int code;

    // color description
    private String color;

    CouponColor(Integer code, String color) {
        this.code = code;
        this.color = color;
    }

    public int getCode() {
        return this.code;
    }

    public String getColor() {
        return this.color;
    }
}

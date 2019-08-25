package com.shunqi.wallet.merchants.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    private int errorCode = 0;

    private String errorMsg = "";

    private Object data;

    /**
     *
     * @param data return object
     */
    public Response(Object data) {
        this.data = data;
    }
}

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

    private Object responseData;

    /**
     *
     * @param responseData return object
     */
    public Response(Object responseData) {
        this.responseData = responseData;
    }
}

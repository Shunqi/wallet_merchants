package com.shunqi.wallet.merchants.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMerchantResponse {

    // return -1 if failed to create a new merchant
    private int merchantId;
}

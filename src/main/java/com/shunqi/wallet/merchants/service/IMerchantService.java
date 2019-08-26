package com.shunqi.wallet.merchants.service;

import com.shunqi.wallet.merchants.vo.Coupon;
import com.shunqi.wallet.merchants.vo.CreateMerchantRequest;
import com.shunqi.wallet.merchants.vo.Response;

public interface IMerchantService {

    /**
     * Create merchant request
     *
     * @param request {@link CreateMerchantRequest}
     * @return {@link Response}
     */
    Response createMerchant(CreateMerchantRequest request);

    /**
     *
     * @param id merchant id
     * @return {@link Response}
     */
    Response findMerchantById(int id);

    /**
     *
     * @param coupon {@link Coupon}
     * @return {@link Response}
     */
    Response releaseCoupon(Coupon coupon);
}

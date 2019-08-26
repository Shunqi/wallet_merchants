package com.shunqi.wallet.merchants.service.impl;

import com.alibaba.fastjson.JSON;
import com.shunqi.wallet.merchants.constant.Constants;
import com.shunqi.wallet.merchants.constant.ErrorCode;
import com.shunqi.wallet.merchants.dao.MerchantDao;
import com.shunqi.wallet.merchants.entity.Merchant;
import com.shunqi.wallet.merchants.service.IMerchantService;
import com.shunqi.wallet.merchants.vo.Coupon;
import com.shunqi.wallet.merchants.vo.CreateMerchantRequest;
import com.shunqi.wallet.merchants.vo.CreateMerchantResponse;
import com.shunqi.wallet.merchants.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class MerchantServiceImpl implements IMerchantService {

    private final MerchantDao merchantDao;

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public MerchantServiceImpl(MerchantDao merchantsDao, KafkaTemplate<String, String> kafkaTemplate) {
        this.merchantDao = merchantsDao;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    @Transactional
    public Response createMerchant(CreateMerchantRequest request) {

        Response response = new Response();
        CreateMerchantResponse merchantResponse = new CreateMerchantResponse();

        ErrorCode errorCode = request.validate(merchantDao);
        if (errorCode != ErrorCode.SUCCESS) {
            merchantResponse.setMerchantId(-1);
            response.setErrorCode(errorCode.getErrorCode());
            response.setErrorMsg(errorCode.getErrorDescription());
        } else {
            merchantResponse.setMerchantId(merchantDao.save(request.toMerchant()).getId());
        }

        response.setResponseData(merchantResponse);

        return response;
    }

    @Override
    public Response findMerchantById(int id) {

        Response response = new Response();

        if (!merchantDao.findById(id).isPresent()) {
            response.setErrorCode(ErrorCode.MERCHANT_NOT_EXIST.getErrorCode());
            response.setErrorMsg(ErrorCode.MERCHANT_NOT_EXIST.getErrorDescription());
        }

        Merchant merchant = merchantDao.findById(id).get();

        response.setResponseData(merchant);

        return response;
    }

    @Override
    public Response releaseCoupon(Coupon coupon) {

        Response response = new Response();
        ErrorCode errorCode = coupon.validate(merchantDao);

        if (errorCode != ErrorCode.SUCCESS) {
            response.setErrorCode(errorCode.getErrorCode());
            response.setErrorMsg(errorCode.getErrorDescription());
        } else {
            String couponString = JSON.toJSONString(coupon);
            kafkaTemplate.send(
                    Constants.COUPON_TOPIC,
                    Constants.COUPON_TOPIC,
                    couponString
            );
            log.info("releaseCoupon: {}", couponString);
        }

        return response;
    }
}

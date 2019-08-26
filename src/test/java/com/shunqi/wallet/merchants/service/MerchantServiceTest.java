package com.shunqi.wallet.merchants.service;

import com.alibaba.fastjson.JSON;
import com.shunqi.wallet.merchants.vo.Coupon;
import com.shunqi.wallet.merchants.vo.CreateMerchantRequest;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MerchantServiceTest {

    @Autowired
    private IMerchantService merchantService;

    @Test
    @Transactional
    public void testCreateMerchantService() {

        CreateMerchantRequest request = new CreateMerchantRequest();
        request.setName("CMU");
        request.setLogoUrl("www.cmu.edu");
        request.setBusinessLicenseUrl("www.cmu.edu");
        request.setPhone("000000");
        request.setAddress("Pittsburgh");

        System.out.println(JSON.toJSONString(merchantService.createMerchant(request)));
    }

    @Test
    public void testBuildMerchantsInfoById() {
        System.out.println(JSON.toJSONString(merchantService.findMerchantById(2)));
    }

    @Test
    public void testReleaseCoupon() {

        Coupon coupon = new Coupon();
        coupon.setMerchantId(2);
        coupon.setTitle("Tuition coupon");
        coupon.setSummary("test");
        coupon.setDesc("test");
        coupon.setLimit(10000L);
        coupon.setColor(2);
        coupon.setStartDate(DateUtils.addDays(new Date(), -10));
        coupon.setEndDate(DateUtils.addDays(new Date(), 10));

        System.out.println(JSON.toJSONString(
                merchantService.releaseCoupon(coupon)
        ));
    }
}

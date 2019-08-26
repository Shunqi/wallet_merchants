package com.shunqi.wallet.merchants.controller;

import com.alibaba.fastjson.JSON;
import com.shunqi.wallet.merchants.service.IMerchantService;
import com.shunqi.wallet.merchants.vo.Coupon;
import com.shunqi.wallet.merchants.vo.CreateMerchantRequest;
import com.shunqi.wallet.merchants.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/merchant")
public class MerchantController {

    private final IMerchantService merchantService;

    @Autowired
    public MerchantController(IMerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @ResponseBody
    @PostMapping("/create")
    public Response createMerchants(@RequestBody CreateMerchantRequest request) {

        log.info("CreateMerchants: {}", JSON.toJSONString(request));
        return merchantService.createMerchant(request);
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Response buildMerchantsInfo(@PathVariable Integer id) {

        log.info("BuildMerchantsInfo: {}", id);
        return merchantService.findMerchantById(id);
    }

    @ResponseBody
    @PostMapping("/release")
    public Response dropPassTemplate(@RequestBody Coupon coupon) {

        log.info("DropPassTemplate: {}", coupon);
        return merchantService.releaseCoupon(coupon);
    }
}

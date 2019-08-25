package com.shunqi.wallet.merchants.vo;

import com.shunqi.wallet.merchants.constant.ErrorCode;
import com.shunqi.wallet.merchants.dao.MerchantDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {

    private int merchantId;    // merchant id
    private String title;
    private String summary;
    private String desc;
    private Long limit;

    private int color;

    private Date startDate;
    private Date endDate;

    /**
     * @param merchantDao {@link MerchantDao}
     * @return {@link ErrorCode}
     */
    public ErrorCode validate(MerchantDao merchantDao) {

        if (!merchantDao.findById(merchantId).isPresent()) {
            return ErrorCode.MERCHANT_NOT_EXIST;
        }

        return ErrorCode.SUCCESS;
    }
}


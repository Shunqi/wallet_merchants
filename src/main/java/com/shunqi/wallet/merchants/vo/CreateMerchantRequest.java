package com.shunqi.wallet.merchants.vo;

import com.shunqi.wallet.merchants.constant.ErrorCode;
import com.shunqi.wallet.merchants.dao.MerchantDao;
import com.shunqi.wallet.merchants.entity.Merchant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMerchantRequest {

    private String name;
    private String logoUrl;
    private String businessLicenseUrl;
    private String phone;
    private String address;

    /**
     *
     * @param merchantsDao {@link MerchantDao}
     * @return {@link ErrorCode}
     */
    public ErrorCode validate(MerchantDao merchantsDao) {

        if (merchantsDao.findByName(this.name) != null) {
            return ErrorCode.DUPLICATE_NAME;
        }

        if (this.logoUrl == null) {
            return ErrorCode.EMPTY_LOGO;
        }

        if (this.businessLicenseUrl == null) {
            return ErrorCode.INVALID_BUSINESS_LICENSE;
        }

        if (this.address == null) {
            return ErrorCode.INVALID_ADDRESS;
        }

        if (null == this.phone) {
            return ErrorCode.INVALID_PHONE_NUM;
        }

        return ErrorCode.SUCCESS;
    }

    /**
     *
     * @return {@link Merchant}
     */
    public Merchant toMerchant() {

        Merchant merchant = new Merchant();

        merchant.setName(name);
        merchant.setLogoUrl(logoUrl);
        merchant.setBusinessLicenseUrl(businessLicenseUrl);
        merchant.setPhone(phone);
        merchant.setAddress(address);

        return merchant;
    }
}


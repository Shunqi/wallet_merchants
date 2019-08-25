package com.shunqi.wallet.merchants.dao;

import com.shunqi.wallet.merchants.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantDao extends JpaRepository<Merchant, Integer> {

    /**
     * find merchant by name
     *
     * @param name merchant name
     * @return {@link Merchant}
     */
    Merchant findByName(String name);
}

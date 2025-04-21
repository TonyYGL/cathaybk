package com.cathaybk.dao;

import com.cathaybk.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    public Currency findByCode(String code);
    public int deleteByCode(String code);
}

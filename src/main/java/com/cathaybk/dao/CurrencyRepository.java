package com.cathaybk.dao;

import com.cathaybk.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    Currency findByCode(String code);
    List<Currency> findByCodeIn(List<String> codes);
    int deleteByCode(String code);
}

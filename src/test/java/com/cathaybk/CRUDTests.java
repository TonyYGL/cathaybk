package com.cathaybk;

import com.cathaybk.entity.Currency;
import com.cathaybk.service.CurrencyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class CRUDTests {

    @Autowired
    private CurrencyService currencyService;

    @Test
    public void findAllTest() {
        Assertions.assertEquals(2, currencyService.findAll().size());
    }

    @Test
    public void findByCodeTest() {
        String code = "USD";
        Currency currency = currencyService.findByCode(code);
        Assertions.assertNotNull(currency);
        Assertions.assertEquals("美元", currency.getName());
    }

    @Test
    public void deleteByCodeTest() {
        int deleteCount = currencyService.deleteByCode("USD");
        Assertions.assertEquals(1, deleteCount);
        Assertions.assertEquals(1, currencyService.findAll().size());
    }

    @Test
    public void addCurrencyTest() {
        Currency currency = new Currency();
        currency.setName("台幣");
        currency.setCode("TWD");
        currencyService.add(currency);
        Assertions.assertEquals(3, currency.getId());
    }
    
    @Test
    public void updateTest() {
        Currency currency = currencyService.findByCode("USD");
        currency.setRate(88.888d);
        long id = currency.getId();
        currencyService.add(currency);
        Optional<Currency> optionalCurrency = currencyService.findById(id);
        Assertions.assertTrue(optionalCurrency.isPresent());
        Assertions.assertEquals(88.888d, optionalCurrency.get().getRate());
    }
}

package com.cathaybk;

import com.cathaybk.dto.CurrencyRequest;
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
        CurrencyRequest currency = new CurrencyRequest();
        currency.setName("台幣");
        currency.setCode("TWD");
        Currency addCurrency = currencyService.add(currency);

        Assertions.assertEquals(4, addCurrency.getId());
    }
    
    @Test
    public void updateTest() {
        CurrencyRequest currency = new CurrencyRequest();
        currency.setId(1L);
        currency.setName("美元-");
        currency.setCode("USD-");
        Currency updatedCurrency = currencyService.updateCurrency(currency);
        Assertions.assertEquals("美元-", updatedCurrency.getName());
    }
}

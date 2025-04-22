package com.cathaybk;

import com.cathaybk.dto.CurrencyRequest;
import com.cathaybk.entity.Currency;
import com.cathaybk.service.CurrencyService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CRUDTests {

    @Autowired
    private CurrencyService currencyService;

    @Order(1)
    @Test
    public void findAllTest() {
        Assertions.assertEquals(3, currencyService.findAll().size());
    }

    @Order(2)
    @Test
    public void findByCodeTest() {
        String code = "USD";
        Currency currency = currencyService.findByCode(code);
        Assertions.assertNotNull(currency);
        Assertions.assertEquals("美元", currency.getName());
    }

    @Order(3)
    @Test
    public void deleteByCodeTest() {
        int deleteCount = currencyService.deleteByCode("USD");
        Assertions.assertEquals(1, deleteCount);
        Assertions.assertEquals(2, currencyService.findAll().size());
    }

    @Order(4)
    @Test
    public void addCurrencyTest() {
        CurrencyRequest currency = new CurrencyRequest();
        currency.setName("台幣");
        currency.setCode("TWD");
        Currency addCurrency = currencyService.add(currency);

        Assertions.assertEquals(4, addCurrency.getId());
    }

    @Order(5)
    @Test
    public void updateTest() {
        CurrencyRequest currency = new CurrencyRequest();
        currency.setId(4L);
        currency.setName("台幣-");
        currency.setCode("TWD-");
        Currency updatedCurrency = currencyService.updateCurrency(currency);
        Assertions.assertEquals("台幣-", updatedCurrency.getName());
    }
}

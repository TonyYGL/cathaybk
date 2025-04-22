package com.cathaybk.controller;

import com.cathaybk.dto.CurrencyRequest;
import com.cathaybk.entity.Currency;
import com.cathaybk.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/currencies")
    public List<Currency> getAllCurrency() {
        return currencyService.findAll();
    }

    @GetMapping("/currency/{code}")
    public Currency findByCode(@PathVariable("code") String code) {
        return currencyService.findByCode(code);
    }

    @PostMapping("/currency")
    public Currency addCurrency(@RequestBody CurrencyRequest request) {
        return currencyService.add(request);
    }

    @PutMapping("/currency")
    public Currency updateCurrency(@RequestBody CurrencyRequest request) {
        return currencyService.updateCurrency(request);
    }

    @DeleteMapping("/currency/{code}")
    public int deleteCurrency(@PathVariable String code) {
        return currencyService.deleteByCode(code);
    }
}

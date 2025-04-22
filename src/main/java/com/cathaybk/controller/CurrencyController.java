package com.cathaybk.controller;

import com.cathaybk.dto.CurrencyRequest;
import com.cathaybk.entity.Currency;
import com.cathaybk.enums.ErrorEnum;
import com.cathaybk.exception.CustomerException;
import com.cathaybk.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/all")
    public List<Currency> getAllCurrency() {
        return currencyService.findAll();
    }

    @GetMapping("/{code}")
    public Currency findByCode(@PathVariable("code") String code) {
        return currencyService.findByCode(code);
    }

    @PostMapping()
    public Currency addCurrency(@RequestBody CurrencyRequest request) {
        if (StringUtils.hasText(request.getCode()) == false || StringUtils.hasText(request.getCode()) == false) {
            throw new CustomerException(ErrorEnum.INVALID_INPUT.getErrorCode(), ErrorEnum.INVALID_INPUT.getErrorMsg());
        }
        return currencyService.add(request);
    }

    @PutMapping()
    public Currency updateCurrency(@RequestBody CurrencyRequest request) {
        return currencyService.updateCurrency(request);
    }

    @DeleteMapping("/{code}")
    public int deleteCurrency(@PathVariable String code) {
        return currencyService.deleteByCode(code);
    }
}

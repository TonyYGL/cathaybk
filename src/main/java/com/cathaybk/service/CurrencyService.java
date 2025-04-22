package com.cathaybk.service;

import com.cathaybk.dao.CurrencyRepository;
import com.cathaybk.dto.CurrencyRequest;
import com.cathaybk.entity.Currency;
import com.cathaybk.enums.ErrorEnum;
import com.cathaybk.exception.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyRepository repository;

    public List<Currency> findAll() {
        return repository.findAll();
    }

    public Currency findByCode(String code) {
        return repository.findByCode(code);
    }

    public List<Currency> findByCodes(List<String> codes) {
        return repository.findByCodeIn(codes);
    }

    public Optional<Currency> findById(Long id) {
        return repository.findById(id);
    }

    public Currency add(CurrencyRequest currencyRequest) {
        Currency currency = new Currency();
        currency.setCode(currencyRequest.getCode());
        currency.setName(currencyRequest.getName());
        return repository.save(currency);
    }

    public Currency updateCurrency(CurrencyRequest currencyRequest) {
        Optional<Currency> optional = repository.findById(currencyRequest.getId());
        if (optional.isPresent() == false) {
            throw new CustomerException(ErrorEnum.CURRENCY_NOT_FOUND.getErrorCode(), ErrorEnum.CURRENCY_NOT_FOUND.getErrorMsg());
        }

        Currency currency = optional.get();
        currency.setCode(currencyRequest.getCode());
        currency.setName(currencyRequest.getName());

        return repository.save(currency);
    }

    @Transactional
    public int deleteByCode(String code) {
        return repository.deleteByCode(code);
    }
}

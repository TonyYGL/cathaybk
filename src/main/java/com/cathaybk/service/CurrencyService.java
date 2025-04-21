package com.cathaybk.service;

import com.cathaybk.dao.CurrencyRepository;
import com.cathaybk.entity.Currency;
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

    public Optional<Currency> findById(Long id) {
        return repository.findById(id);
    }

    public Currency add(Currency currency) {
        return repository.save(currency);
    }

    @Transactional
    public int deleteByCode(String code) {
        return repository.deleteByCode(code);
    }
}

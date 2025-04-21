package com.cathaybk.dto;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class BitcoinResponse {
    private Time time;
    private String disclaimer;
    private String chartName;
    private Map<String, CurrencyDetail> bpi = new HashMap<>();

    @JsonAnySetter
    public void addCurrency(String key, CurrencyDetail value) {
        bpi.put(key, value);
    }
}

package com.cathaybk.service;

import com.cathaybk.dto.BitcoinResponse;
import com.cathaybk.entity.Currency;
import com.cathaybk.enums.ErrorEnum;
import com.cathaybk.exception.CustomerException;
import com.cathaybk.util.DateUtil;
import com.cathaybk.vo.BitcoinVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class APIService {

    @Value("${coindesk.url}")
    private String coindeskUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CurrencyService currencyService;

    public BitcoinResponse getBitcoinData() {
        return restTemplate.getForObject(coindeskUrl, BitcoinResponse.class);
    }

    public BitcoinVo getBitcoinVo() {
        BitcoinResponse response = getBitcoinData();
        if (response == null) {
            throw new CustomerException(ErrorEnum.API_ERROR.getErrorCode(), ErrorEnum.API_ERROR.getErrorMsg());
        }

        return transformData(response);
    }

    public BitcoinVo transformData(BitcoinResponse response) {
        BitcoinVo bitcoinVo = new BitcoinVo();
        bitcoinVo.setUpdateTime(DateUtil.parseToDate(response.getTime().getUpdated()));

        List<String> queryCodes = new ArrayList<>(response.getBpi().keySet());

        List<Currency> currencies = currencyService.findByCodes(queryCodes);
        Map<String, String> currencyMap = currencies.stream()
                .collect(Collectors.toMap(Currency::getCode, Currency::getName));

        response.getBpi().values().forEach(value -> {
            BitcoinVo.BitcoinData bitcoinData = new BitcoinVo.BitcoinData();
            bitcoinData.setCode(value.getCode());
            bitcoinData.setName(currencyMap.getOrDefault(value.getCode(), ""));
            bitcoinData.setRate(value.getRateFloat());
            bitcoinVo.getDatas().add(bitcoinData);
        });

        return bitcoinVo;
    }
}

package com.cathaybk.service;

import com.cathaybk.dto.BitcoinResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class APIService {

    @Autowired
    private RestTemplate restTemplate;

    public BitcoinResponse getBitcoinData() {
        String url = "https://kengp3.github.io/blog/coindesk.json";
        return restTemplate.getForObject(url, BitcoinResponse.class);
    }
}

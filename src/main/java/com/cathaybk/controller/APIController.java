package com.cathaybk.controller;

import com.cathaybk.service.APIService;
import com.cathaybk.vo.BitcoinVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class APIController {

    @Autowired
    private APIService apiService;

    @GetMapping("/bitcoinDetails")
    public BitcoinVo getCoinDeskData() {
        return apiService.getBitcoinVo();
    }

}

package com.cathaybk.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class BitcoinVo {
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "Asia/Taipei")
    private Date updateTime;
    private List<BitcoinData> datas = new ArrayList<>();

    @Data
    public static class BitcoinData {
        private String code;
        private String name;
        private Double rate;
    }
}

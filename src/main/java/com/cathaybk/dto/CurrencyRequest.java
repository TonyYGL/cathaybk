package com.cathaybk.dto;

import lombok.Data;

@Data
public class CurrencyRequest {
    private Long id;
    private String code;
    private String name;
}

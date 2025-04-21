package com.cathaybk;

import com.cathaybk.dto.BitcoinResponse;
import com.cathaybk.service.APIService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class APIServiceTests {

    @Autowired
    private APIService apiService;

    @Test
    public void getBitcoinDataTest() {
        BitcoinResponse response = apiService.getBitcoinData();
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertNotNull(response);
        Assertions.assertEquals("Bitcoin", response.getChartName());
        Assertions.assertEquals(57756.2984, response.getBpi().get("USD").getRateFloat());
    }
}

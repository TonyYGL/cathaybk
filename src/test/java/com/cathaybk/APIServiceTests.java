package com.cathaybk;

import com.cathaybk.dto.BitcoinResponse;
import com.cathaybk.service.APIService;
import com.cathaybk.vo.BitcoinVo;
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

        Assertions.assertNotNull(response);
        Assertions.assertEquals("Bitcoin", response.getChartName());
        Assertions.assertEquals(57756.2984, response.getBpi().get("USD").getRateFloat());
    }

    @Test
    public void transformDataTest() {
        String mockData = "{\n" +
                "  \"time\": {\n" +
                "    \"updated\": \"Sep 2, 2024 07:07:20 UTC\",\n" +
                "    \"updatedISO\": \"2024-09-02T07:07:20+00:00\",\n" +
                "    \"updateduk\": \"Sep 2, 2024 at 08:07 BST\"\n" +
                "  },\n" +
                "  \"disclaimer\": \"just for test\",\n" +
                "  \"chartName\": \"Bitcoin\",\n" +
                "  \"bpi\": {\n" +
                "    \"USD\": {\n" +
                "      \"code\": \"USD\",\n" +
                "      \"symbol\": \"&#36;\",\n" +
                "      \"rate\": \"57,756.298\",\n" +
                "      \"description\": \"United States Dollar\",\n" +
                "      \"rate_float\": 57756.2984\n" +
                "    },\n" +
                "    \"GBP\": {\n" +
                "      \"code\": \"GBP\",\n" +
                "      \"symbol\": \"&pound;\",\n" +
                "      \"rate\": \"43,984.02\",\n" +
                "      \"description\": \"British Pound Sterling\",\n" +
                "      \"rate_float\": 43984.0203\n" +
                "    },\n" +
                "    \"EUR\": {\n" +
                "      \"code\": \"EUR\",\n" +
                "      \"symbol\": \"&euro;\",\n" +
                "      \"rate\": \"52,243.287\",\n" +
                "      \"description\": \"Euro\",\n" +
                "      \"rate_float\": 52243.2865\n" +
                "    }\n" +
                "  }\n" +
                "}";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            BitcoinResponse response = objectMapper.readValue(mockData, BitcoinResponse.class);

            BitcoinVo vo = apiService.transformData(response);
            Assertions.assertEquals(3, vo.getDatas().size());
            Assertions.assertEquals("美元", vo.getDatas().get(0).getName());
            Assertions.assertEquals("英鎊", vo.getDatas().get(1).getName());
            Assertions.assertEquals("歐元", vo.getDatas().get(2).getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

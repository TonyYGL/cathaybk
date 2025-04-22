# 初始化幣別對應表資料 (data.sql)
```
INSERT INTO currency (name, code) VALUES ('美元', 'USD');
INSERT INTO currency (name, code) VALUES ('歐元', 'EUR');
INSERT INTO currency (name, code) VALUES ('英鎊', 'GBP');
```

# 幣別對應表CRUD
- 顯示所有幣別
```
curl --location 'http://localhost:8080/currency/all'
```

- 查詢幣別
```
curl --location 'http://localhost:8080/currency/USD'
```

- 新增幣別
```
curl --location 'http://localhost:8080/currency' \
--header 'Content-Type: application/json' \
--data '{
    "code": "TWD",
    "name": "台幣"
}'
```

- 修改幣別
```
curl --location --request PUT 'http://localhost:8080/currency' \
--header 'Content-Type: application/json' \
--data '{
    "id": 4,
    "code": "TWD-",
    "name": "台幣-"
}'
```

- 刪除幣別
```
curl --location --request DELETE 'http://localhost:8080/currency/TWD-'
```


# coindesk API
- 顯示其內容
```
curl --location 'http://localhost:8080/api/coindesk'
```

- 資料轉換的 API，並顯示其內容。
```
curl --location 'http://localhost:8080/api/transformCoindesk'
```

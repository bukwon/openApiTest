package com.example.openapitest.overseasInv.overseasInv;

import org.springframework.context.annotation.Configuration;

@Configuration
public class OverseasConfig {
    public static final String REST_BASE_URL = "https://openapi.koreainvestment.com:9443";
    public static final String WS_BASE_URL = "ws://ops.koreainvestment.com:29443";
    public static final String APPKEY = "PS0q9L3T5mXrTh52IsIsAbI66mBmdPh83Yrc";       // your APPKEY
    public static final String APPSECRET = "6JJGUXwmr28UCIqheS/NiDhc+0DEGXP1dBcQrGcOsRSXrGBuvePvwvMBtoGEzaqCWbkUCqcuHCL7" +
            "yfVNZ8dqK51r5lwMN+xSCf9/QZ6wNd/MuKtUh3mExwDe+VcU2v+oo0Dz0yGpESjNQ8FX4yasytu8EfA5s2ljcNSXnYJuKxrtBf46XLM=";  // your APPSECRET

    public static final String FHKUP03500100_PATH = "/uapi/domestic-stock/v1/quotations/inquire-daily-indexchartprice";
    public static final String FHKST03030100_PATH = "/uapi/overseas-price/v1/quotations/inquire-daily-chartprice";
}

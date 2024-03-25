package com.example.openapitest.overseasInv.overseasInv;

import com.example.openapitest.overseasInv.model.OauthInfo;
import com.example.openapitest.overseasInv.model.TokenInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class AccessTokenManager {
    private final WebClient webClient;
    public static String ACCESS_TOKEN;
    public static long last_auth_time = 0;

    public AccessTokenManager(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(OverseasConfig.REST_BASE_URL).build();
    }

    public String getAccessToken() {
        if (ACCESS_TOKEN == null) {
            ACCESS_TOKEN = generateAccessToken();
            System.out.println("generate ACCESS_TOKEN: " + ACCESS_TOKEN);
        }
        return ACCESS_TOKEN;
    }


    public String generateAccessToken() {
        String url = OverseasConfig.REST_BASE_URL + "/oauth2/tokenP";
        OauthInfo bodyOauthInfo = new OauthInfo();
        bodyOauthInfo.setGrant_type("client_credentials");
        bodyOauthInfo.setAppkey(OverseasConfig.APPKEY);
        bodyOauthInfo.setAppsecret(OverseasConfig.APPSECRET);

        Mono<TokenInfo> mono = webClient.post()
                .uri(url)
                .header("content-type", "application/json")
                .bodyValue(bodyOauthInfo)
                .retrieve()
                .bodyToMono(TokenInfo.class);

        TokenInfo tokenInfo = mono.block();
        if (tokenInfo == null) {
            throw new RuntimeException("액세스 토큰을 가져올 수 없습니다.");
        }

        ACCESS_TOKEN = tokenInfo.getAccess_token();

        return ACCESS_TOKEN;
    }
}
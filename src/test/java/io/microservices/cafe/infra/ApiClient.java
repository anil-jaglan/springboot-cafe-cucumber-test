package io.microservices.cafe.infra;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class ApiClient {

    private final RestTemplate restTemplate;

    public ApiClient(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseResult get(String url) throws IOException {

        final Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        final HeaderSettingRequestCallback requestCallback = new HeaderSettingRequestCallback(headers);
        final ResponseResultErrorHandler errorHandler = new ResponseResultErrorHandler();

        restTemplate.setErrorHandler(errorHandler);
        return restTemplate.execute(url, HttpMethod.GET, requestCallback, response -> {
            if (errorHandler.hadError) {
                return (errorHandler.getResult());
            } else {
                return (new ResponseResult(response));
            }
        });
    }

}

package io.microservices.cafe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import io.microservices.cafe.infra.ApiClient;

@Configuration
public class TestConfig {

    @Bean
    public ApiClient apiClient(final RestTemplate restTemplate) {
        return new ApiClient(restTemplate);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}

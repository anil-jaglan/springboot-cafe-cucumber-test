package io.microservices.cafe;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;

import io.cucumber.spring.CucumberContextConfiguration;
import io.microservices.cafe.infra.ApiClient;
import io.microservices.cafe.infra.ResponseResult;

@CucumberContextConfiguration
@SpringBootTest(classes = StartCafeApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = TestConfig.class)
public class SpringIntegrationTest {

    protected ResponseResult latestResponse = null;

    @Autowired
    protected ApiClient apiClient;

    public void executeGet(String url) throws IOException {
        this.latestResponse = apiClient.get(url);
    }

    public void executePost(String url) throws IOException {
        this.latestResponse = apiClient.get(url);
    }

}

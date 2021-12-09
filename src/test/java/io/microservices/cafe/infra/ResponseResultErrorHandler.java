package io.microservices.cafe.infra;

import java.io.IOException;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

public class ResponseResultErrorHandler implements ResponseErrorHandler {

    private ResponseResult result = null;

    public Boolean hadError = false;

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        hadError = response.getRawStatusCode() >= 400;
        return hadError;
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        result = new ResponseResult(response);
    }

    public ResponseResult getResult() {
        return this.result;
    }
}
package io.microservices.cafe.steps;

import java.io.IOException;

import org.springframework.http.HttpStatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.microservices.cafe.SpringIntegrationTest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CoffeeStepDefinitions extends SpringIntegrationTest {

    private String coffeeName;

    @Given("the customer wants {word}")
    public void setCoffeeName(String coffee) {
        this.coffeeName = coffee;
    }

    @When("the client makes a call to /coffees")
    public void getCofee() throws IOException {
        String url = "http://localhost:8080/coffees/" + coffeeName;
        log.info("Calling {}",url);
        executeGet(url);
    }

    @Then("the client receives status code of {int}")
    public void statusCode(int statusCode) throws IOException {
        final HttpStatus httpStatus = latestResponse.getTheResponse().getStatusCode();
        assertThat(statusCode, is(httpStatus.value()));
    }
    
    @And("the client receives message as {}")
    public void responseMessage(String message) {
        assertThat(latestResponse.getBody(), is(message));
    }

}

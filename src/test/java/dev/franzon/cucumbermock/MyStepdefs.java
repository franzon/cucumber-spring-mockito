package dev.franzon.cucumbermock;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.Rule;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@CucumberContextConfiguration
@SpringBootTest
public class MyStepdefs {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Autowired
    private Service1 service1;

    @Autowired
    @MockBean
    private Service3 service3;

    String result;

    @When("the service 1 is called")
    public void theService1IsCalled() {
        when(service3.execute()).thenReturn("mocked service 3");

        result = service1.execute();
    }

    @Then("it should call the service 3")
    public void itShouldCallTheService3() {
        verify(service3).execute();

        assertThat(result).contains("mocked service 3");
    }
}

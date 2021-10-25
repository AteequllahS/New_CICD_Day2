package features;

import features.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();

    @Given("user on the login page")
    public void user_on_the_login_page() {
        Driver.getDriver().get(ConfigReader.read("url"));
    }

    @When("user enter valid {string} and {string}")
    public void user_enter_valid_and(String username, String password) {
            loginPage.login(username,password);
    }

    @When("user click login button")
    public void user_click_login_button() {
        loginPage.loginButton.click();
    }

    @Then("user should be at dashboard page")
    public void user_should_be_at_dashboard_page() {
        assertEquals("Dashboard - Trycloud QA", Driver.getDriver().getTitle());
    }

    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String errorMsg) {
        assertEquals(errorMsg, loginPage.warningMessage.getText());


    }
}

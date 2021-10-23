package features;

import features.pages.DashboardPage;
import features.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class DashboardStepDefs {

    @When("user  log in with valid credentials")
    public void user_log_in_with_valid_credentials() {
        new LoginPage().login();
    }
    @Then("Verify the user see the following modules:")
    public void verify_the_user_see_the_following_modules(List<String> expectedMOdules) {
        List<String> actualModules = BrowserUtil.getElementsText(new DashboardPage().allModules);

        Assert.assertEquals(expectedMOdules, actualModules);
    }
}

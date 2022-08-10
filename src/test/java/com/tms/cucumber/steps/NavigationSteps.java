package com.tms.cucumber.steps;

import com.tms.cucumber.pages.shared.NavigationPage;
import com.tms.cucumber.context.ScenarioContext;
import io.cucumber.java.en.Then;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class NavigationSteps {
    NavigationPage navigationPage = new NavigationPage();
    ScenarioContext scenarioContext;
    public NavigationSteps(ScenarioContext context){
        scenarioContext = context;
    }
    @Then("the user is logged into the system successfully")
    public void theUserIsLoggedIntoTheSystemSuccessfully() {
        String username = scenarioContext.getContext("username", String.class);
        assertThat("verify username: ", navigationPage.getUsername(), equalTo(username));
    }

    @Then("all the information of project is shown")
    public void allTheInformationOfProjectIsShown() {
        String projectName = scenarioContext.getContext("projectName", String.class);
        assertThat("verify prject name: ", navigationPage.getProjectName(), equalTo(projectName));
    }

}

package com.tms.cucumber.steps;

import com.tms.cucumber.context.ScenarioContext;
import com.tms.cucumber.pages.NavigationPage;
import com.tms.cucumber.pages.SearchProjectPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchProjectSteps {
    SearchProjectPage searchProjectPage = new SearchProjectPage();
    NavigationPage navigationPage = new NavigationPage();
    ScenarioContext scenarioContext;
    @And("the user navigate the Search Project page")
    public void theUserNavigateTheSearchProjectPage() {

    }

    @When("the user applies some search criteria \\(Name\\/Location\\/Type)")
    public void theUserAppliesSomeSearchCriteriaNameLocationType() {
    }

    @And("the user clicks on Search button")
    public void theUserClicksOnSearchButton() {
    }

    @Then("all projects matched with input criteria will be displayed")
    public void allProjectsMatchedWithInputCriteriaWillBeDisplayed() {
    }
}

package com.tms.cucumber.steps;

import com.tms.cucumber.context.ScenarioContext;
import com.tms.cucumber.pages.NavigationPage;
import com.tms.cucumber.pages.SearchProjectPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class SearchProjectSteps {
    SearchProjectPage searchProjectPage = new SearchProjectPage();
    NavigationPage navigationPage = new NavigationPage();
    ScenarioContext scenarioContext;
    @And("the user navigate the Search Project page")
    public void theUserNavigateTheSearchProjectPage() {
        navigationPage.goToSearchProjectPage();
    }

    @When("the user applies some search criteria Name or Location or Type")
    public void theUserAppliesSomeSearchCriteriaNameOrLocationOrType(List<Map<String, String>> table) {
        String projectName = table.get(0).get("project name");
        String location = table.get(0).get("location");
        String type = table.get(0).get("type");
        scenarioContext.setContext("project name", projectName);
        scenarioContext.setContext("location", location);
        scenarioContext.setContext("type", type);
        searchProjectPage.inputSearchProjectName(projectName);
        searchProjectPage.selectLocation(location);
        searchProjectPage.selectType(type);
    }

    @And("the user clicks on Search button")
    public void theUserClicksOnSearchButton() {
        searchProjectPage.clickSearchButton();
    }

    @Then("all projects matched with input criteria will be displayed")
    public void allProjectsMatchedWithInputCriteriaWillBeDisplayed() {
        String projectNameCriteria = scenarioContext.getContext("project name", String.class);
        String locationCriteria = scenarioContext.getContext("location", String.class);
        String typeCriteria = scenarioContext.getContext("type", String.class);
        searchProjectPage.verifyProjectInDataTable(projectNameCriteria,locationCriteria,typeCriteria);
    }


}

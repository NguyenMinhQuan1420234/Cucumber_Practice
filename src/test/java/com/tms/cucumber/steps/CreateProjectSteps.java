package com.tms.cucumber.steps;

import com.google.gson.stream.JsonReader;
import com.tms.cucumber.context.ScenarioContext;
import com.tms.cucumber.pages.CreateProjectPage;
import com.tms.cucumber.pages.NavigationPage;
import com.tms.cucumber.pages.modal.Project;
import com.tms.cucumber.pages.shared.DatePickerPage;
import com.tms.cucumber.utils.JsonUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;

public class CreateProjectSteps {
    NavigationPage navigationPage = new NavigationPage();
    CreateProjectPage createProjectPage = new CreateProjectPage();
    ScenarioContext scenarioContext;
    Project project;
    DatePickerPage datePickerPage = new DatePickerPage();

    public CreateProjectSteps(ScenarioContext context) {
        scenarioContext = context;
    }

    @And("the user navigates to create Project Page")
    public void theUserNavigatesToCreateProjectPage() {
        createProjectPage.clickCreateProjectOptionFromDropdownList();
    }

    @When("the user fills all project information")
    public void theUserFillsAllProjectInformation() throws FileNotFoundException, InterruptedException {
        project = JsonUtil.convertToJsonObject("project.json", Project.class);
        LocalTime date = java.time.LocalTime.now();
        createProjectPage.inputProjectName(project.name + date);
        createProjectPage.selectProjectType(project.type);
        createProjectPage.selectProjectStatus(project.status);
        datePickerPage.inputStartDay(project.startDate);
        datePickerPage.inputEndDay(project.endDate);
        createProjectPage.inputSizeday(project.sizeDays);
        createProjectPage.selectProjectLocation(project.location);
        createProjectPage.selectProjectManager(project.manager);
        createProjectPage.selectProjectDelieveryManager(project.deliveryProgramManager);
        createProjectPage.selectProjectEngagementManager(project.engagementManager);
        createProjectPage.inputShortDescription(project.shortDescription);
        createProjectPage.inputLongDescription(project.longDescription);
        createProjectPage.inputTechnologies(project.technologies);
        createProjectPage.inputClientname(project.clientName);
        createProjectPage.selectProjectClientIndustry(project.clientIndustrySector);
        createProjectPage.inputClientDescription(project.clientDescription);
        scenarioContext.setContext("projectName", project.name + date);
    }

    @And("the user clicks Create button")
    public void theUserClicksCreateButton() {
        createProjectPage.clickCreateButton();
    }
}

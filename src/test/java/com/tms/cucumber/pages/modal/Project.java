package com.tms.cucumber.pages.modal;

import java.util.HashMap;
import java.util.Map;

public class Project {
    public String name;
    public String type;
    public String status;
    public String startDate;
    public String endDate;
    public Integer sizeDays;
    public String location;
    public String manager;
    public String deliveryProgramManager;
    public String engagementManager;
    public String shortDescription;
    public String longDescription;
    public String technologies;
    public String clientName;
    public String clientIndustrySector;
    public String clientDescription;
    private  Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}


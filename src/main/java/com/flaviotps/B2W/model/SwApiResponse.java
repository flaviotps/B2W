package com.flaviotps.B2W.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class SwApiResponse {

    @JsonProperty("results")
    private List<SwPlanetInformation> results = new ArrayList<>(0);

    public List<SwPlanetInformation> getResults() {
        return results;
    }

    public void setResults(List<SwPlanetInformation> results) {
        this.results = results;
    }
}

package com.solify.server.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SolinstralningResponse {

    @JsonProperty
    private String takyta;

    public String getTakyta() {
        return takyta;
    }

    public void setTakyta(String takyta) {
        this.takyta = takyta;
    }
}

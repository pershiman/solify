package com.solify.server.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SolinstralningResponse {

    @JsonProperty
    private Integer takyta;

    public Integer getTakyta() {
        return takyta;
    }

    public void setTakyta(Integer takyta) {
        this.takyta = takyta;
    }
}

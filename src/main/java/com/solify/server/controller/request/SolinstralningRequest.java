package com.solify.server.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SolinstralningRequest {

    @JsonProperty("telephone")
    private String telephone;

    @JsonProperty("amount")
    private Integer amount;

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}

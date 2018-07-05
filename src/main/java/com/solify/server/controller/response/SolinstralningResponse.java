package com.solify.server.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SolinstralningResponse {

    @JsonProperty
    private Integer takyta;

    @JsonProperty
    private Integer nbr_of_modules;

    @JsonProperty
    private Integer tot_price;

    @JsonProperty
    private Integer sys_size;

    @JsonProperty
    private Integer subsidy;

    @JsonProperty
    private Integer tot_earnings;

    @JsonProperty
    private Double env_win;

    public Integer getTakyta() {
        return takyta;
    }

    public void setTakyta(Integer takyta) {
        this.takyta = takyta;
    }

    public Integer getSys_size() {
        return sys_size;
    }

    public void setSys_size(int sys_size) {
        this.sys_size = sys_size;
    }

    public Integer getNbr_of_modules() {
        return nbr_of_modules;
    }

    public void setNbr_of_modules(Integer nbr_of_modules) {
        this.nbr_of_modules = nbr_of_modules;
    }

    public Integer getTot_price() {
        return tot_price;
    }

    public void setTot_price(Integer tot_price) {
        this.tot_price = tot_price;
    }

    public Integer getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(Integer subsidy) {
        this.subsidy = subsidy;
    }

    public Integer getTot_earnings() {
        return tot_earnings;
    }

    public void setTot_earnings(Integer tot_earnings) {
        this.tot_earnings = tot_earnings;
    }

    public Double getEnv_win() {
        return env_win;
    }

    public void setEnv_win(Double env_win) {
        this.env_win = env_win;
    }
}

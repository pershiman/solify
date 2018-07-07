package com.solify.server.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SolinstralningResponse {

    @JsonProperty
    private Integer takyta;

    @JsonProperty
    private Integer tak_1000;

    @JsonProperty
    private Integer tak_950_10;

    @JsonProperty
    private Integer sol_1000;

    @JsonProperty
    private Integer sol_950_10;

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

    @JsonProperty
    private Integer profit;

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

    public Integer getProfit() {
        return profit;
    }

    public void setProfit(Integer profit) {
        this.profit = profit;
    }

    public Integer getSol_950_10() {
        return sol_950_10;
    }

    public void setSol_950_10(Integer sol_950_10) {
        this.sol_950_10 = sol_950_10;
    }

    public Integer getSol_1000() {
        return sol_1000;
    }

    public void setSol_1000(Integer sol_1000) {
        this.sol_1000 = sol_1000;
    }

    public Integer getTak_950_10() {
        return tak_950_10;
    }

    public void setTak_950_10(Integer tak_950_10) {
        this.tak_950_10 = tak_950_10;
    }

    public Integer getTak_1000() {
        return tak_1000;
    }

    public void setTak_1000(Integer tak_1000) {
        this.tak_1000 = tak_1000;
    }
}

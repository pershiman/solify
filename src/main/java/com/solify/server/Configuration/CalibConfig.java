package com.solify.server.Configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
@ConfigurationProperties
public class CalibConfig {

    private int el_price;
    private int certificate;
    private int taxredux;
    private int maintainace_cost;
    private int gridbenefit;
    private int lifelength;

    public int getEl_price() {
        return el_price;
    }

    public void setEl_price(int el_price) {
        this.el_price = el_price;
    }

    public int getCertificate() {
        return certificate;
    }

    public void setCertificate(int certificate) {
        this.certificate = certificate;
    }

    public int getTaxredux() {
        return taxredux;
    }

    public void setTaxredux(int taxredux) {
        this.taxredux = taxredux;
    }

    public int getMaintainace_cost() {
        return maintainace_cost;
    }

    public void setMaintainace_cost(int maintainace_cost) {
        this.maintainace_cost = maintainace_cost;
    }

    public int getGridbenefit() {
        return gridbenefit;
    }

    public void setGridbenefit(int gridbenefit) {
        this.gridbenefit = gridbenefit;
    }

    public int getLifelength() {
        return lifelength;
    }

    public void setLifelength(int lifelength) {
        this.lifelength = lifelength;
    }

    private Double solarcellmodule_area;
    private int module_price;
    private int perc_of_roof_area;
    private int elecComp_price;
    private int armature_price;
    private int assembly_price;

    public Double getSolarcellmodule_area() {
        return solarcellmodule_area;
    }

    public void setSolarcellmodule_area(Double solarcellmodule_area) {
        this.solarcellmodule_area = solarcellmodule_area;
    }

    public int getModule_price() {
        return module_price;
    }

    public void setModule_price(int module_price) {
        this.module_price = module_price;
    }

    public int getElecComp_price() {
        return elecComp_price;
    }

    public void setElecComp_price(int elecComp_price) {
        this.elecComp_price = elecComp_price;
    }

    public int getArmature_price() {
        return armature_price;
    }

    public void setArmature_price(int armature_price) {
        this.armature_price = armature_price;
    }

    public int getAssembly_price() {
        return assembly_price;
    }

    public void setAssembly_price(int assembly_price) {
        this.assembly_price = assembly_price;
    }

    public int getPerc_of_roof_area() {
        return perc_of_roof_area;
    }

    public void setPerc_of_roof_area(int perc_of_roof_area) {
        this.perc_of_roof_area = perc_of_roof_area;
    }
}

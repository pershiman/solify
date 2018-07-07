package com.solify.server.Configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
@ConfigurationProperties
public class CalibConfig {

    private double bbox_lng_add;
    private double bbox_lat_add;

    private double el_price;
    private double certificate;
    private double taxredux;
    private double maintainace_cost;
    private double gridbenefit;
    private int lifelength;

    public double getEl_price() {
        return el_price;
    }

    public void setEl_price(double el_price) {
        this.el_price = el_price;
    }

    public double getCertificate() {
        return certificate;
    }

    public void setCertificate(double certificate) {
        this.certificate = certificate;
    }

    public double getTaxredux() {
        return taxredux;
    }

    public void setTaxredux(double taxredux) {
        this.taxredux = taxredux;
    }

    public double getMaintainace_cost() {
        return maintainace_cost;
    }

    public void setMaintainace_cost(double maintainace_cost) {
        this.maintainace_cost = maintainace_cost;
    }

    public double getGridbenefit() {
        return gridbenefit;
    }

    public void setGridbenefit(double gridbenefit) {
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

    public double getBbox_lng_add() {
        return bbox_lng_add;
    }

    public void setBbox_lng_add(double bbox_lng_add) {
        this.bbox_lng_add = bbox_lng_add;
    }

    public double getBbox_lat_add() {
        return bbox_lat_add;
    }

    public void setBbox_lat_add(double bbox_lat_add) {
        this.bbox_lat_add = bbox_lat_add;
    }
}

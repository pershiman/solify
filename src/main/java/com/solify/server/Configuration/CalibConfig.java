package com.solify.server.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class CalibConfig {

    @Value("${wms.bbox_lng}")
    private double bbox_lng_add;
    @Value("${wms.bbox_lat}")
    private double bbox_lat_add;

    @Value("${el.el_price}")
    private double el_price;
    @Value("${el.certificate}")
    private double certificate;
    @Value("${el.taxredux}")
    private double taxredux;
    @Value("${el.maintainace_cost}")
    private double maintainace_cost;
    @Value("${el.gridbenefit}")
    private double gridbenefit;

    @Value("${misc.lifelength}")
    private int lifelength;
    @Value("${misc.solarcellmodule_area}")
    private Double solarcellmodule_area;
    @Value("${misc.perc_of_roof_area}")
    private int perc_of_roof_area;


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


    @Value("${cost.module_price}")
    private int module_price;
    @Value("${cost.elecComp_price}")
    private int elecComp_price;
    @Value("${cost.armature_price}")
    private int armature_price;
    @Value("${cost.assembly_price}")
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

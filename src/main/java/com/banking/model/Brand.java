package com.banking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Brand {

    @JsonProperty("BrandName")
    private String brandName;

    @JsonProperty("ATM")
    private List<ATM> atms;

    public Brand() {
    }

    public Brand(String brandName, List<ATM> atms) {
        this.brandName = brandName;
        this.atms = atms;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public List<ATM> getAtms() {
        return atms;
    }

    public void setAtms(List<ATM> atms) {
        this.atms = atms;
    }
}

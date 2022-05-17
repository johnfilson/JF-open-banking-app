package com.banking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Meta {

    @JsonProperty("lastUpdated")
    private String lastUpdated;

    @JsonProperty("TotalResults")
    private String totalResults;

    @JsonProperty("Agreement")
    private String agreement;

    @JsonProperty("License")
    private String license;

    @JsonProperty("TermsOfUse")
    private String termsOfUse;

    public Meta(String lastUpdated, String totalResults, String agreement, String license, String termsOfUse) {
        this.lastUpdated = lastUpdated;
        this.totalResults = totalResults;
        this.agreement = agreement;
        this.license = license;
        this.termsOfUse = termsOfUse;
    }

    public Meta() {

    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getTermsOfUse() {
        return termsOfUse;
    }

    public void setTermsOfUse(String termsOfUse) {
        this.termsOfUse = termsOfUse;
    }
}

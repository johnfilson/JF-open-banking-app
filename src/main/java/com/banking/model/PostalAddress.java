package com.banking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PostalAddress {

    @JsonProperty("AddressLine")
    private List<String> addressLine;

    @JsonProperty("Streetname")
    private String streetName;

    @JsonProperty("TownName")
    private String townName;

    @JsonProperty("CountrySubDivision")
    private List<String> countrySubDivision;

    @JsonProperty("Country")
    private String country;

    @JsonProperty("PostCode")
    private String postCode;

    public PostalAddress() {
    }

    public PostalAddress(List<String> addressLine, String streetName, String townName, List<String> countrySubDivision, String country, String postCode) {
        this.addressLine = addressLine;
        this.streetName = streetName;
        this.townName = townName;
        this.countrySubDivision = countrySubDivision;
        this.country = country;
        this.postCode = postCode;
    }

    public List<String> getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(List<String> addressLine) {
        this.addressLine = addressLine;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public List<String> getCountrySubDivision() {
        return countrySubDivision;
    }

    public void setCountrySubDivision(List<String> countrySubDivision) {
        this.countrySubDivision = countrySubDivision;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}

package com.banking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * ATM Model
 */
@Data
public class ATM {

    @JsonProperty("Identification")
    private String identification;

    @JsonProperty("SupportedCurrencies")
    private List<String> supportedCurrencies;

    @JsonProperty("Location")
    private Location location;

    public ATM() {
    }

    /**Added ATM Constructor
     * @param identification  is key used to access user ATM information
     * @param supportedCurrencies  List of currencies supported each ATM
     * @param location  is information of where the ATM is located
     */
    public ATM(String identification, List<String> supportedCurrencies, Location location) {
        this.identification = identification;
        this.supportedCurrencies = supportedCurrencies;
        this.location = location;
    }

    /**
     * Getters, and Setters should be set for all model objects
     *
     */

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public List<String> getSupportedCurrencies() {
        return supportedCurrencies;
    }

    public void setSupportedCurrencies(List<String> supportedCurrencies) {
        this.supportedCurrencies = supportedCurrencies;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}

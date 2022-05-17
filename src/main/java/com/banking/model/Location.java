package com.banking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Location {

    @JsonProperty("PostalAddress")
    private PostalAddress postalAddress;

    public Location() {
    }

    public Location(PostalAddress postalAddress) {
        this.postalAddress = postalAddress;
    }

    public PostalAddress getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(PostalAddress postalAddress) {
        this.postalAddress = postalAddress;
    }
}

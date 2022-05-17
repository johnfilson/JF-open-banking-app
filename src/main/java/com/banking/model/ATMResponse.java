package com.banking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ATMResponse {

    @JsonProperty("meta")
    private Meta meta;

    @JsonProperty("data")
    private List<ATMData> data;

    public ATMResponse() {
    }

    public ATMResponse(Meta meta, List<ATMData> data) {
        this.meta = meta;
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<ATMData> getData() {
        return data;
    }

    public void setData(List<ATMData> data) {
        this.data = data;
    }
}

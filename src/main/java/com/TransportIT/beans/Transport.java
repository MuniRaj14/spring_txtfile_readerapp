package com.TransportIT.beans;

import org.springframework.stereotype.Component;

@Component
public class Transport {

    private int TransportId;
    private String FromLocation;
    private String ToLocation;
    private Double TransportFee;

    public int getTransportId() {
        return TransportId;
    }

    public void setTransportId(int transportId) {
        TransportId = transportId;
    }

    public String getFromLocation() {
        return FromLocation;
    }

    public void setFromLocation(String fromLocation) {
        FromLocation = fromLocation;
    }

    public String getToLocation() {
        return ToLocation;
    }

    public void setToLocation(String toLocation) {
        ToLocation = toLocation;
    }

    public Double getTransportFee() {
        return TransportFee;
    }

    public void setTransportFee(Double transportFee) {
        TransportFee = transportFee;
    }
}

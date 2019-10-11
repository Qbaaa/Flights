package com.qbaaa.flights.Request;

import java.time.LocalTime;

public class FlightForm {
    private String type;
    private Long startAirport;
    private Long endAirport;
    private LocalTime timeStart;
    private Long durationTimeMinutes;
    private Double priceForOnePlace;
    private Double maxWightBaggageForOnePerson;
    private Double feeConst;
    private Double feeForKiloPack;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getStartAirport() {
        return startAirport;
    }

    public void setStartAirport(Long startAirport) {
        this.startAirport = startAirport;
    }

    public Long getEndAirport() {
        return endAirport;
    }

    public void setEndAirport(Long endAirport) {
        this.endAirport = endAirport;
    }

    public LocalTime getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(LocalTime timeStart) {
        this.timeStart = timeStart;
    }

    public Long getDurationTimeMinutes() {
        return durationTimeMinutes;
    }

    public void setDurationTimeMinutes(Long durationTimeMinutes) {
        this.durationTimeMinutes = durationTimeMinutes;
    }

    public Double getPriceForOnePlace() {
        return priceForOnePlace;
    }

    public void setPriceForOnePlace(Double priceForOnePlace) {
        this.priceForOnePlace = priceForOnePlace;
    }

    public Double getMaxWightBaggageForOnePerson() {
        return maxWightBaggageForOnePerson;
    }

    public void setMaxWightBaggageForOnePerson(Double maxWightBaggageForOnePerson) {
        this.maxWightBaggageForOnePerson = maxWightBaggageForOnePerson;
    }

    public Double getFeeConst() {
        return feeConst;
    }

    public void setFeeConst(Double feeConst) {
        this.feeConst = feeConst;
    }

    public Double getFeeForKiloPack() {
        return feeForKiloPack;
    }

    public void setFeeForKiloPack(Double feeForKiloPack) {
        this.feeForKiloPack = feeForKiloPack;
    }

    @Override
    public String toString() {
        return "FlightForm{" +
                "type='" + type + '\'' +
                ", startAirport=" + startAirport +
                ", endAirport=" + endAirport +
                ", timeStart=" + timeStart +
                ", durationTimeMinutes=" + durationTimeMinutes +
                ", priceForOnePlace=" + priceForOnePlace +
                ", maxWightBaggageForOnePerson=" + maxWightBaggageForOnePerson +
                ", feeConst=" + feeConst +
                ", feeForKiloPack=" + feeForKiloPack +
                '}';
    }
}

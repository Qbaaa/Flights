package com.qbaaa.flights.Response;
import com.qbaaa.flights.Model.FlightPersonal;

import java.util.List;
import java.util.stream.Collectors;

public class MinConnectBetweenTwoAirportsResponse
{
    private List<FlightPersonal> listConnect;
    private int amountChange;
    private double sumPriceForOnePerson;
    private double maxBaggageForonePerson;

    public MinConnectBetweenTwoAirportsResponse() { }

    public MinConnectBetweenTwoAirportsResponse(List<FlightPersonal> listConnect) {
        this.listConnect = listConnect;
        this.amountChange = this.listConnect.size()-1;

        List<Double> tempSum = this.listConnect.stream().map(x->x.getPriceForOnePlace()).collect(Collectors.toList());
        this.sumPriceForOnePerson = tempSum.stream().mapToDouble(Double::doubleValue).sum();

        List<Double> tempMax = this.listConnect.stream().map(ele->ele.getMaxwWightBaggageForOnePerson()).collect(Collectors.toList());
        this.maxBaggageForonePerson= tempMax.stream().min(Double::compare).get();
    }

    public List<FlightPersonal> getListConnect() {
        return listConnect;
    }

    public void setListConnect(List<FlightPersonal> listConnect) {
        this.listConnect = listConnect;
    }

    public int getAmountChange() {
        return amountChange;
    }

    public void setAmountChange(int amountChange) {
        this.amountChange = amountChange;
    }

    public double getSumPriceForOnePerson() {
        return sumPriceForOnePerson;
    }

    public void setSumPriceForOnePerson(double sumPriceForOnePerson) {
        this.sumPriceForOnePerson = sumPriceForOnePerson;
    }

    public double getMaxBaggageForonePerson() {
        return maxBaggageForonePerson;
    }

    public void setMaxBaggageForonePerson(double maxBaggageForonePerson) {
        this.maxBaggageForonePerson = maxBaggageForonePerson;
    }
}

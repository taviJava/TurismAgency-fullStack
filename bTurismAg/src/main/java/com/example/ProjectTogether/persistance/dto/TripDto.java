package com.example.ProjectTogether.persistance.dto;

import com.example.ProjectTogether.persistance.model.FlightModel;
import com.example.ProjectTogether.persistance.model.ParticipantModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.sql.Date;
import java.util.List;

public class TripDto {
    private Long id;
    private Date departureDate;
    private Date returnDate;
    private int numberOfDays;
    private double priceForAdults;
    private double priceForChildren;
    private boolean promoted;
    private List<ParticipantDto> participantModels;
    private FlightDto flightModel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public double getPriceForAdults() {
        return priceForAdults;
    }

    public void setPriceForAdults(double priceForAdults) {
        this.priceForAdults = priceForAdults;
    }

    public double getPriceForChildren() {
        return priceForChildren;
    }

    public void setPriceForChildren(double priceForChildren) {
        this.priceForChildren = priceForChildren;
    }

    public boolean isPromoted() {
        return promoted;
    }

    public void setPromoted(boolean promoted) {
        this.promoted = promoted;
    }

    public List<ParticipantDto> getParticipantModels() {
        return participantModels;
    }

    public void setParticipantModels(List<ParticipantDto> participantModels) {
        this.participantModels = participantModels;
    }

    public FlightDto getFlightModel() {
        return flightModel;
    }

    public void setFlightModel(FlightDto flightModell) {
        flightModel = flightModell;
    }
}

package com.example.ProjectTogether.persistance.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class TripModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date departureDate;
    private Date returnDate;
    private int numberOfDays;
    private double priceForAdults;
    private double priceForChildren;
    private boolean promoted;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("tripModels")
    private List<ParticipantModel> participantModels;

    @OneToOne(cascade = CascadeType.ALL)
    private FlightModel flightModel;

    public FlightModel getFlightModel() {
        return flightModel;
    }

    public void setFlightModel(FlightModel flightModel) {
        this.flightModel = flightModel;
    }

    public TripModel(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ParticipantModel> getParticipantModels() {
        return participantModels;
    }

    public void setParticipantModels(List<ParticipantModel> participantModels) {
        this.participantModels = participantModels;
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
}

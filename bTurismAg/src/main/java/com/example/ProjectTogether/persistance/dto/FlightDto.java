package com.example.ProjectTogether.persistance.dto;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class FlightDto {
    private Long id;
    private String name;
    private int vacancies;
    private Date departureDay;
    private Date returnDay;
    private Time departureHour;
    private Time arriveHour;
    private double seatPrice;
    private int rowsNumber;
    private int seatsRowNumber;
    private AirportDto airportDeparture;
    private AirportDto airportArrival;
    private TripDto tripModel;
    private List<SeatDto> seats;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVacancies() {
        return vacancies;
    }

    public void setVacancies(int vacancies) {
        this.vacancies = vacancies;
    }

    public Date getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(Date departureDay) {
        this.departureDay = departureDay;
    }

    public Date getReturnDay() {
        return returnDay;
    }

    public void setReturnDay(Date returnDay) {
        this.returnDay = returnDay;
    }

    public Time getDepartureHour() {
        return departureHour;
    }

    public void setDepartureHour(Time departureHour) {
        this.departureHour = departureHour;
    }

    public Time getArriveHour() {
        return arriveHour;
    }

    public void setArriveHour(Time arriveHour) {
        this.arriveHour = arriveHour;
    }

    public double getSeatPrice() {
        return seatPrice;
    }

    public void setSeatPrice(double seatPrice) {
        this.seatPrice = seatPrice;
    }

    public int getRowsNumber() {
        return rowsNumber;
    }

    public void setRowsNumber(int rowsNumber) {
        this.rowsNumber = rowsNumber;
    }

    public int getSeatsRowNumber() {
        return seatsRowNumber;
    }

    public void setSeatsRowNumber(int seatsRowNumber) {
        this.seatsRowNumber = seatsRowNumber;
    }

    public AirportDto getAirportDeparture() {
        return airportDeparture;
    }

    public void setAirportDeparture(AirportDto airportDep) {
        airportDeparture = airportDep;
    }

    public AirportDto getAirportArrival() {
        return airportArrival;
    }

    public void setAirportArrival(AirportDto airportArr) {
        airportArrival = airportArr;
    }

    public TripDto getTripModel() {
        return tripModel;
    }

    public void setTripModel(TripDto trip) {
        tripModel = trip;
    }

    public List<SeatDto> getSeats() {
        return seats;
    }

    public void setSeats(List<SeatDto> seats) {
        this.seats = seats;
    }
}

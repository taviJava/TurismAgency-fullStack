package com.example.ProjectTogether.persistance.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "Flights")
public class FlightModel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
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

  @ManyToOne(fetch = FetchType.EAGER)
  @JsonIgnoreProperties("flightDepartures")
  private AirportModel airportDeparture;

  @ManyToOne(fetch = FetchType.EAGER)
  @JsonIgnoreProperties("flightArrival")
  private AirportModel airportArrival;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "flight", orphanRemoval = true)
  @JsonIgnoreProperties("flight")
  private List<SeatModel> seats;





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

  public Time getReturnHour() {
    return arriveHour;
  }

  public void setReturnHour(Time arriveHour) {
    this.arriveHour = arriveHour;
  }

  public AirportModel getAirportDeparture() {
    return airportDeparture;
  }

  public void setAirportDeparture(AirportModel airportDeparture) {
    this.airportDeparture = airportDeparture;
  }

  public AirportModel getAirportArrival() {
    return airportArrival;
  }

  public void setAirportArrival(AirportModel airportArrival) {
    this.airportArrival = airportArrival;
  }

  public Time getArriveHour() {
    return arriveHour;
  }

  public void setArriveHour(Time arriveHour) {
    this.arriveHour = arriveHour;
  }

  public List<SeatModel> getSeats() {
    return seats;
  }

  public void setSeats(List<SeatModel> seats) {
    this.seats = seats;
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

  public double getSeatPrice() {
    return seatPrice;
  }

  public void setSeatPrice(double seatPrice) {
    this.seatPrice = seatPrice;
  }
}

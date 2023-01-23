package com.flight.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String source;
	private String destination;
	private int departure_date;
	private double fare;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getDeparture_date() {
		return departure_date;
	}

	public void setDeparture_date(int departure_date) {
		this.departure_date = departure_date;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", source=" + source + ", destination=" + destination + ", departure_date="
				+ departure_date + ", fare=" + fare + "]";
	}

}

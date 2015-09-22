package Model.Entity;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by Δενθρ on 12.09.2015.
 */
public class Trip {
    private long id;
    private Route route;
    private Date departure_date;
    private Time departure_time;
    private Date arrival_date;
    private Time arrival_time;
    private Bus bus;

    public Trip(long id, Route route, Bus bus, Date departure_date, Time departure_time, Date arrival_date, Time arrival_time) {
        this.id = id;
        this.route = route;
        this.departure_date = departure_date;
        this.departure_time = departure_time;
        this.arrival_date = arrival_date;
        this.arrival_time = arrival_time;
        this.bus = bus;
    }

    public Trip(long id, Route route, Date departure, Date arrival, Bus bus) {
        this.id = id;
        this.route = route;
        this.departure_date = departure;
        this.arrival_date = arrival;
        this.bus = bus;
    }

    public Trip(Route route, Date departure, Date arrival, Bus bus) {
        this.route = route;
        this.departure_date = departure;
        this.arrival_date = arrival;
        this.bus = bus;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public long getId() {
        return id;
    }

    public Date getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(Date departure_date) {
        this.departure_date = departure_date;
    }

    public Time getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(Time departure_time) {
        this.departure_time = departure_time;
    }

    public Date getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(Date arrival_date) {
        this.arrival_date = arrival_date;
    }

    public Time getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(Time arrival_time) {
        this.arrival_time = arrival_time;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }
}

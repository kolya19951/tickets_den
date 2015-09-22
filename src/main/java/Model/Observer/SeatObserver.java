package Model.Observer;

import Model.Entity.Seat;
import Model.Entity.TripViewer;
import database.DBWorker;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Δενθρ on 12.09.2015.
 */
public abstract class SeatObserver {
    public static ArrayList<Seat> selectSeats(int tripId) {
        ArrayList<Seat> seats = new ArrayList<Seat>();
        DBWorker dbWorker = new DBWorker();
        ResultSet resultSet = dbWorker.executeQuery("SELECT * FROM seats WHERE trip = " + tripId);
        try {
            while (resultSet.next()) {
                //trips.add(new Trip(resultSet.getInt("Id")));
                seats.add(new Seat(resultSet.getInt("Id"), tripId, resultSet.getInt("seat_num"), resultSet.getDouble("price"), resultSet.getInt("availability")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seats;
    }

    public static ArrayList<SeatPlaceWithPrice> selectSeatsWithPrice(long tripId) {
        ArrayList<SeatPlaceWithPrice> res = new ArrayList<SeatPlaceWithPrice>();
        ResultSet resultSet = null;
        String query = "SELECT seats.Id, seats.seat_num, seats.price, seats.availability, bus_config.row, bus_config.place FROM bus_config, seats, trips WHERE bus_config.bus = trips.bus " +
                "AND bus_config.seat = seats.seat_num " +
                "AND trips.Id = " + tripId;
        DBWorker dbWorker = new DBWorker();
        resultSet = dbWorker.executeQuery(query);
        try {
            while (resultSet.next()) {
                res.add(new SeatPlaceWithPrice(resultSet.getLong(1), resultSet.getInt(2), resultSet.getInt(5), resultSet.getInt(6), resultSet.getDouble(3), resultSet.getByte(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}

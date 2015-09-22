package Model.Manager;

import database.DBWorker;

/**
 * Created by Δενθρ on 16.09.2015.
 */
public abstract class SeatManager {
    static public void add(long trip, int seat_num, double price, int available) {
        String query = "INSERT INTO seats (trip, seat_num, price, availability) VALUES ("+ trip +", "+ seat_num +", "+ price +", "+ available +")";
        DBWorker dbWorker = new DBWorker();
        dbWorker.execute(query);
        dbWorker.closeConnection();
    }

    static public void update(long id, long trip, int seat_num, double price, int available) {
        String query = "UPDATE seats SET trip = " + trip + ", seat_num = "+ seat_num +", "+ price +", "+ available +" WHERE Id = " + id;
        DBWorker dbWorker = new DBWorker();
        dbWorker.execute(query);
        dbWorker.closeConnection();
    }

    static public void delete(long id) {
        String query = "DELETE FROM seats WHERE Id = " + id;
        DBWorker dbWorker = new DBWorker();
        dbWorker.execute(query);
        dbWorker.closeConnection();
    }

}

package Model.Manager;

import Model.Entity.Bus;
import database.DBWorker;

/**
 * Created by Δενθρ on 16.09.2015.
 */
public abstract class BusConfigManager {
    static public void addOneSeat(long bus, long seat, long row, long place) {
        String query = "INSERT INTO bus_config (bus, seat, row, place) VALUES ("+ bus +", "+ seat +", "+ row +", "+ place +")";
        DBWorker dbWorker = new DBWorker();
        dbWorker.execute(query);
        dbWorker.closeConnection();
    }

    static public void buildStandardConfig(Bus bus) {
        DBWorker dbWorker = new DBWorker();
        int counter = 1;
        for (int row = 1; row <= bus.getSeats()/4 + 1; row++) {
            for (int place = 1; place <= 2; place++) {
                String query = "INSERT INTO bus_config (bus, seat, row, place) VALUES ("+ bus.getId() +", "+ counter +", "+ row +", "+ place +")";
                dbWorker.execute(query);
                if(++counter > bus.getSeats())
                    break;
            }
            
            for (int place = 4; place <= 5; place++) {
                String query = "INSERT INTO bus_config (bus, seat, row, place) VALUES ("+ bus.getId() +", "+ counter +", "+ row +", "+ place +")";
                dbWorker.execute(query);
                if (++counter > bus.getSeats())
                    break;
            }
        }
        dbWorker.closeConnection();
    }


    static public void delete(long id) {
        String query = "DELETE FROM bus_config WHERE Id = " + id;
        DBWorker dbWorker = new DBWorker();
        dbWorker.execute(query);
        dbWorker.closeConnection();
    }
}

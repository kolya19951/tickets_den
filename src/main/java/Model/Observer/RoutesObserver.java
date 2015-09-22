package Model.Observer;

import Model.Entity.City;
import Model.Entity.Route;
import Model.Entity.Station;
import database.DBWorker;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Δενθρ on 13.09.2015.
 */
public abstract class RoutesObserver {
    public static ArrayList<Route> selectRoutes(String lang) {
        ArrayList<Route> routes = new ArrayList<Route>();
        DBWorker dbWorker = new DBWorker();
        ResultSet resultSet = null;
        String query = "SELECT c1.name_"+lang+", c1.Id, c2.name_"+lang+", c2.Id, s1.name_"+lang+", s1.Id, s2.name_"+lang+", s2.Id, routes.Id FROM cities c1, cities c2, stations s1, stations s2, routes WHERE routes.from_station = s1.Id " +
                "AND routes.to_station = s2.Id " +
                "AND s1.city = c1.Id " +
                "AND s2.city = c2.Id";

        resultSet = dbWorker.executeQuery(query);
        try {
            while (resultSet.next()) {
                City c1 = new City(resultSet.getLong(2), resultSet.getString(1));
                City c2 = new City(resultSet.getLong(4), resultSet.getString(3));
                Station s1 = new Station(resultSet.getLong(6), c1, resultSet.getString(5));
                Station s2 = new Station(resultSet.getLong(8), c2, resultSet.getString(7));
                routes.add(new Route(resultSet.getLong(9), s1, s2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return routes;
    }

    public static ArrayList<Route> selectRoutesByCities(long from, long to, String lang) {
        ArrayList<Route> routes = new ArrayList<Route>();
        DBWorker dbWorker = new DBWorker();
        ResultSet resultSet = null;
        String query = "SELECT c1.name_"+lang+", c1.Id, c2.name_"+lang+", c2.Id, s1.name_"+lang+", s1.Id, s2.name_"+lang+", s2.Id, routes.Id FROM cities c1, cities c2, stations s1, stations s2, routes WHERE routes.from_station = s1.Id " +
                "AND routes.to_station = s2.Id " +
                "AND s1.city = c1.Id " +
                "AND s2.city = c2.Id " +
                "AND c1.Id = " + from +
                " AND c2.Id = " + to;

        resultSet = dbWorker.executeQuery(query);
        try {
            while (resultSet.next()) {
                City c1 = new City(resultSet.getLong(2), resultSet.getString(1));
                City c2 = new City(resultSet.getLong(4), resultSet.getString(3));
                Station s1 = new Station(resultSet.getLong(6), c1, resultSet.getString(5));
                Station s2 = new Station(resultSet.getLong(8), c2, resultSet.getString(7));
                routes.add(new Route(resultSet.getLong(9), s1, s2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return routes;
    }

    public static ArrayList<String> selectCitiesNames(String lang) {
        ArrayList<String> cities = new ArrayList<String>();
        ResultSet resultSet = null;
        String query = "SELECT name FROM cities";
        DBWorker dbWorker = new DBWorker();
        resultSet = dbWorker.executeQuery(query);
        try {
            while (resultSet.next()) {
                cities.add(new City(resultSet.getString("name_"+lang+"")).getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }
}

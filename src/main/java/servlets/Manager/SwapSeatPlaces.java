package servlets.Manager;

import database.DBWorker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Δενθρ on 22.09.2015.
 */
@WebServlet("/swap_seats")
public class SwapSeatPlaces extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long firstId = (long) req.getAttribute("first_id");
        long secondId = (long) req.getAttribute("second_id");

        DBWorker dbWorker = new DBWorker();
        String query = "UPDATE bus_config SET row = 0, place = 0 WHERE " +
                "bus = (SELECT trips.bus FROM trips, seats WHERE trips.Id = seats.trip AND seats.Id = "+firstId+") " +
                "AND seat = (SELECT seat_num FROM seats WHERE Id = "+firstId+")";
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}

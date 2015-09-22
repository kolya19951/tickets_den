package servlets.Manager;

import Model.Entity.City;
import Model.Observer.BusConfigObserver;
import Model.Observer.CitiesObserver;
import Model.Observer.SeatPlace;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Δενθρ on 18.09.2015.
 */
@WebServlet("/show_bus_config")
public class ShowBusConfig extends HttpServlet {
    private ServletContext context;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        if (session.isNew()) {
            session.setAttribute("lang", "en");
        }
        String lang = (String) session.getAttribute("lang");

        long tripId = Long.parseLong(request.getParameter("tripId"));

        ArrayList<SeatPlace> seatPlaces = BusConfigObserver.busConfig(tripId);

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < seatPlaces.size(); i++) {
            sb.append("<seat>");
            sb.append("<id>" + seatPlaces.get(i).getSeatId() + "</id>");
            sb.append("<place_num>" + seatPlaces.get(i).getSeat_num() + "</place_num>");
            sb.append("<row>" + seatPlaces.get(i).getRow() + "</row>");
            sb.append("<place>" + seatPlaces.get(i).getPlace() + "</place>");
            sb.append("</seat>");
        }

        response.setContentType("text/xml");
        response.setHeader("Cache-Control", "no-cache");
        response.getWriter().write("<seats>" + sb.toString() + "</seats>");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        HttpSession session = request.getSession();
        if (session.isNew()) {
            session.setAttribute("lang", "en");
        }
        String lang = (String) session.getAttribute("lang");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();
    }
}

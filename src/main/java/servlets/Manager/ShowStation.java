package servlets.Manager;

import Model.Entity.Bus;
import Model.Entity.City;
import Model.Entity.Station;
import Model.Hash.ComposerData;
import Model.Manager.BusManager;
import Model.Observer.BusObserer;
import Model.Observer.StationsObserver;

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
import java.util.HashMap;
import java.util.Iterator;

@WebServlet("/show_station")
public class ShowStation extends HttpServlet {

    private ServletContext context;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        if (session.isNew()) {
            session.setAttribute("lang", "en");
        }
        String lang = (String) session.getAttribute("lang");


        ArrayList<Station> stations = StationsObserver.select(lang);

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < stations.size(); i++) {
            sb.append("<station>");
            sb.append("<id>" + stations.get(i).getId() + "</id>");
            sb.append("<name>" + stations.get(i).getName() + "</name>");
            sb.append("<city_id>" + stations.get(i).getCity().getId() + "</city_id>");
            sb.append("<city_name>" + stations.get(i).getCity().getName() + "</city_name>");
            sb.append("</station>");
        }

        response.setContentType("text/xml");
        response.setHeader("Cache-Control", "no-cache");
        response.getWriter().write("<stations>" + sb.toString() + "</stations>");
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

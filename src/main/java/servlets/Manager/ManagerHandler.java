package servlets.Manager;

import Model.Entity.Bus;
import Model.Entity.City;
import Model.Hash.ComposerData;
import Model.Manager.BusManager;
import Model.Manager.CitiesManager;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by ����� on 13.09.2015.
 */
@WebServlet("/manager_handler")
public class ManagerHandler extends HttpServlet {
    private ServletContext context;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        HttpSession session = request.getSession();
        if(session.isNew()) {
            session.setAttribute("lang", "en");
        }
        String lang = (String) session.getAttribute("lang");

        if (action.equals("add")) {
            String name = request.getParameter("name");
            CitiesManager.add(name, lang);
        } else if (action.equals("delete")) {
            long id = Long.parseLong(request.getParameter("id"));
            CitiesManager.delete(id);
        } else if (action.equals("edit")) {
            long id = Long.parseLong(request.getParameter("id"));
            String name = request.getParameter("name");
            CitiesManager.update(id, name, lang);
        } else {
            System.out.println("Illegal action");
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        HttpSession session = request.getSession();
        if(session.isNew()) {
            session.setAttribute("lang", "en");
        }
        String lang = (String) session.getAttribute("lang");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();
    }

    private void handle_action(HttpServletRequest request, HttpServletResponse response) {

    }
}
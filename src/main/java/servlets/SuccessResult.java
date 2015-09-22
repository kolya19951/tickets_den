package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by ���� on 16.09.2015.
 */
@WebServlet("/success")
public class SuccessResult extends HttpServlet {

    private static Mail.tls.Sender tlsSender = new Mail.tls.Sender("kolya.simotyuk@gmail.com", "kolya18121995");
    private static Mail.ssl.Sender sslSender = new Mail.ssl.Sender("kolya.simotyuk@gmail.com", "kolya18121995");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.isNew()) {
            session.setAttribute("lang", "en");
        }
        String lang = (String) session.getAttribute("lang");


        request.setCharacterEncoding("UTF-8");
        sslSender.send("This is Subject", "SSL: This is text!", "kolya.simotyuk@gmail.com", "denis.drabchuk@gmail.com");
        tlsSender.send("This is Subject", "TLS: This is text!", "kolya.simotyuk@gmail.com", "denis.drabchuk@gmail.com");
        String ik_co_id = request.getParameter("ik_co_id");
        String ik_co_prs_id = request.getParameter("ik_co_prs_id");
        String ik_inv_id = request.getParameter("ik_inv_id");
        String ik_inv_st = request.getParameter("ik_inv_st");
        String ik_inv_crt = request.getParameter("ik_inv_crt");
        String ik_inv_prc = request.getParameter("ik_inv_prc");
        String ik_trn_id = request.getParameter("ik_trn_id");
        String ik_pm_no = request.getParameter("ik_pm_no");
        String ik_pw_via = request.getParameter("ik_pw_via");
        String ik_am = request.getParameter("ik_am");
        String ik_co_rfn = request.getParameter("ik_co_rfn");
        String ik_ps_price = request.getParameter("ik_ps_price");
        String ik_cur = request.getParameter("ik_cur");
        String ik_desc = request.getParameter("ik_desc");
        String ik_sign = request.getParameter("ik_sign");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.isNew()) {
            session.setAttribute("lang", "en");
        }
        String lang = (String) session.getAttribute("lang");

        sslSender.send("This is Subject", "SSL: This is text!", "kolya.simotyuk@gmail.com", "denis.drabchuk@gmail.com");
        tlsSender.send("This is Subject", "TLS: This is text!", "kolya.simotyuk@gmail.com", "denis.drabchuk@gmail.com");
    }
}

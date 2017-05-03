package com.rate.cycle;

import java.awt.List;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.SortedMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RateController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/rate.jsp";
    private static String LIST_USER = "/listRate.jsp";
    private RateDao dao;

    public RateController() throws ClassNotFoundException, SQLException {
        super();
        dao = new RateDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
        if (action.isEmpty()== false)
        {
	        if (action.equalsIgnoreCase("delete")){
	            int userId = Integer.parseInt(request.getParameter("rateid"));
	            dao.deleteRate(userId);
	            forward = LIST_USER;
	            request.setAttribute("rates", dao.getAllRates());    
	        } else if (action.equalsIgnoreCase("edit")){
	            forward = INSERT_OR_EDIT;
	            int userId = Integer.parseInt(request.getParameter("rateid"));
	            Rate user = dao.getRateById(userId);
	            request.setAttribute("rate", user);
	        
	        } else if (action.equalsIgnoreCase("listRate")){
	            forward = LIST_USER;
	            request.setAttribute("rates", dao.getAllRates());
	        }
	        else
	        {
	        	forward = INSERT_OR_EDIT;
	        	ArrayList custid = new ArrayList();
				try {
					custid = (ArrayList) dao.findcustomers();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            request.setAttribute("custid", custid);
	        }
        }
        else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Rate rate = new Rate();
        rate.setCustomerid(request.getParameter("custid"));
        rate.setDestination(request.getParameter("destination"));
        rate.setSource(request.getParameter("source"));
        rate.setLoadType(request.getParameter("loadtype"));
        rate.setRate(request.getParameter("rate"));
        rate.setRateType(request.getParameter("ratetype"));
 

        String rateid = request.getParameter("rateid");
        if(rateid == null || rateid.isEmpty())
        {
            dao.addRate(rate);
        }
        else
        {
        	rate.setRateid(Integer.parseInt(rateid));
            dao.updateRate(rate);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("users", dao.getAllRates());
        view.forward(request, response);
    }
}
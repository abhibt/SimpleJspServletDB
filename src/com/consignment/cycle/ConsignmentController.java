package com.consignment.cycle;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vehicle.cycle.Vehicle;
import com.vehicle.cycle.VehicleDao;

public class ConsignmentController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/consignment.jsp";
    private static String LIST_USER = "/listConsignment.jsp";
    private ConsignmentDao dao;

    public ConsignmentController() throws ClassNotFoundException, SQLException {
        super();
        dao = new ConsignmentDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
        if (action.isEmpty()== false)
        {
	        if (action.equalsIgnoreCase("delete")){
	            int vehicleid = Integer.parseInt(request.getParameter("consignmentid"));
	            dao.deleteVehicle(vehicleid);
	            forward = LIST_USER;
	            request.setAttribute("consignments", dao.getAllConsignments());    
	        } else if (action.equalsIgnoreCase("edit")){
	            forward = INSERT_OR_EDIT;
	            int vehicleId = Integer.parseInt(request.getParameter("consignmentid"));;
	            Consignment consignment = dao.getConsignmentById(vehicleId);
	            request.setAttribute("consignment", consignment);
	        } else if (action.equalsIgnoreCase("listConsignment")){
	            forward = LIST_USER;
	            request.setAttribute("consignments", dao.getAllConsignments());
	        }
	        else
	        {
	        	forward = INSERT_OR_EDIT;
	        }
        }
        else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Consignment consignment = new Consignment();
        String consignmentid = request.getParameter("consignmentid");
        
        try {
            Date registrationdate = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("registrationdate"));
            consignment.setRegistrationdate(registrationdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }      
		//consignment.setConsignmentid(request.getParameter("consignmentid"));
		consignment.setConsignerid(request.getParameter("consignerid"));
		consignment.setConsigneeid(request.getParameter("consigneeid"));
		consignment.setvehicleid(request.getParameter("vehicleid"));
		consignment.setRateid(request.getParameter("rateid"));
		consignment.setTransportid(request.getParameter("transportid"));
        try {
            Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("registrationdate"));
            consignment.setRegistrationdate(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }
		consignment.setBoxcount(request.getParameter("boxcount"));
		consignment.setBoxdescription(request.getParameter("boxdescription"));
		consignment.setCapacity_weight(request.getParameter("capacity_weight"));
		consignment.setLoadtype(request.getParameter("loadtype"));
		consignment.setPaidby(request.getParameter("paidby"));
		consignment.setAmount(request.getParameter("amount"));
		consignment.setTotal(request.getParameter("total"));
		consignment.setAddl_charges(request.getParameter("addl_charges"));
		consignment.setHandling_charges(request.getParameter("handling_charges"));
		consignment.setStatistical_charges(request.getParameter("statistical_charges"));
		consignment.setDeclared_value(request.getParameter("declared_value"));
		consignment.setBilled_at(request.getParameter("billed_at"));
		consignment.setVehicle_type(request.getParameter("vehicle_type"));
		consignment.setArticletypedescription(request.getParameter("articletypedescription"));
		consignment.setLoading_percentage(request.getParameter("loading_percentage"));
        
		if(consignmentid == null || consignmentid.isEmpty())
        {
            dao.addConsignment(consignment);
        }
        else
        {
        	consignment.setvehicleid(Integer.parseInt(consignmentid));
            dao.addConsignment(consignment);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("consignments", dao.getAllConsignments());
        view.forward(request, response);
    }
}
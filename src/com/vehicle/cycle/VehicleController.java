package com.vehicle.cycle;

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

import com.user.cycle.User;
import com.user.cycle.UserDao;

public class VehicleController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/vehicle.jsp";
    private static String LIST_USER = "/listVehicle.jsp";
    private VehicleDao dao;

    public VehicleController() throws ClassNotFoundException, SQLException {
        super();
        dao = new VehicleDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
        if (action.isEmpty()== false)
        {
	        if (action.equalsIgnoreCase("delete")){
	            int vehicleid = Integer.parseInt(request.getParameter("vehicleid"));
	            dao.deleteVehicle(vehicleid);
	            forward = LIST_USER;
	            request.setAttribute("vehicles", dao.getAllVehicles());    
	        } else if (action.equalsIgnoreCase("edit")){
	            forward = INSERT_OR_EDIT;
	            int vehicleId = Integer.parseInt(request.getParameter("vehicleid"));;
				Vehicle vehicle = dao.getVehicleById(vehicleId);
	            request.setAttribute("vehicle", vehicle);
	        } else if (action.equalsIgnoreCase("listVehicle")){
	            forward = LIST_USER;
	            request.setAttribute("vehicles", dao.getAllVehicles());
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
        Vehicle vehicle = new Vehicle();
        vehicle.settypeormake(request.getParameter("typeormake"));
        vehicle.setvehicleidnumber(request.getParameter("vehicleidnumber"));
        vehicle.setservicedetails(request.getParameter("servicedetails"));
        String vehicleid = request.getParameter("vehicleid");
        
        try {
            Date registrationdate = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("registrationdate"));
            vehicle.setRegistrationdate(registrationdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }      
        try {
            Date insurancedate = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("insurancedate"));
            vehicle.setInsurancedate(insurancedate);
        } catch (ParseException e) {
            e.printStackTrace();
        }  
        try {
            Date expirydate = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("expirydate"));
            vehicle.setInsurancedate(expirydate);
        } catch (ParseException e) {
            e.printStackTrace();
        }  
        try {
            Date fcdate = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("fcdate"));
            vehicle.setInsurancedate(fcdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }  
        try {
            Date fcexpirydate = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("fcexpirydate"));
            vehicle.setInsurancedate(fcexpirydate);
        } catch (ParseException e) {
            e.printStackTrace();
        }  
        try {
            Date servicedate = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("servicedate"));
            vehicle.setInsurancedate(servicedate);
        } catch (ParseException e) {
            e.printStackTrace();
        }  
        if(vehicleid == null || vehicleid.isEmpty())
        {
            dao.addVehicle(vehicle);
        }
        else
        {
        	vehicle.setvehicleid(Integer.parseInt(vehicleid));
            dao.addVehicle(vehicle);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("vehicles", dao.getAllVehicles());
        view.forward(request, response);
    }
}
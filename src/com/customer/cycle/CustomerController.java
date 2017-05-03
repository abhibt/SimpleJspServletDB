package com.customer.cycle;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomerController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/customer.jsp";
    private static String LIST_USER = "/listCustomer.jsp";
    private CustomerDao dao;

    public CustomerController() throws ClassNotFoundException, SQLException {
        super();
        dao = new CustomerDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
        if (action.isEmpty()== false)
        {
	        if (action.equalsIgnoreCase("delete")){
	            int custid = Integer.parseInt(request.getParameter("custid"));
	            dao.deleteCustomer(custid);
	            forward = LIST_USER;
	            request.setAttribute("customers", dao.getAllCustomers());    
	        } else if (action.equalsIgnoreCase("edit")){
	            forward = INSERT_OR_EDIT;
	            int custId = Integer.parseInt(request.getParameter("custid"));;
				Customer cust = dao.getCustomerById(custId);
	            request.setAttribute("cust", cust);
	        } else if (action.equalsIgnoreCase("listCustomer")){
	            forward = LIST_USER;
	            request.setAttribute("customers", dao.getAllCustomers());
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
        Customer cust = new Customer();
        cust.setname(request.getParameter("name"));
        cust.setcustcode(request.getParameter("custcode"));
        cust.setaddress(request.getParameter("address"));
        String custid = request.getParameter("custid");
        if(custid == null || custid.isEmpty())
        {
            dao.addCustomer(cust);
        }
        else
        {
        	cust.setcustid(Integer.parseInt(custid));
            dao.addCustomer(cust);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("customers", dao.getAllCustomers());
        view.forward(request, response);
    }
}
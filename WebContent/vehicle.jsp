<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>Add new vehicle</title>
</head>
<body>
    <script>
        $(function() {
            $('input[name=registrationdate]').datepicker();
        });
        $(function() {
            $('input[name=expirydate]').datepicker();
        });
        $(function() {
            $('input[name=insurancedate]').datepicker();
        });
        $(function() {
            $('input[name=fcdate]').datepicker();
        });
        $(function() {
            $('input[name=fcexpirydate]').datepicker();
        });
        $(function() {
            $('input[name=servicedate]').datepicker();
        });
    </script>

    <form method="POST" action='VehicleController' name="frmAddVehicle">
        Vehicle ID : <input type="text" readonly="readonly" name="vehicleid"
            value="<c:out value="${vehicle.vehicleid}" />" /> <br /> 
        Vehicle Number : <input
            type="text" name="vehicleidnumber"
            value="<c:out value="${vehicle.vehicleidnumber}" />" /> <br /> 

        Type or Make : <input type="text" name="typeormake"
            value="<c:out value="${vehicle.typeormake}" />" /> <br /> 
        Registration Date : <input
            type="text" name="registrationdate"
            value="<fmt:formatDate pattern="MM/dd/yyyy" value="${vehicle.registrationdate}" />" /> <br /> 
        Expiry Date : <input
            type="text" name="expirydate"
            value="<fmt:formatDate pattern="MM/dd/yyyy" value="${vehicle.expirydate}" />" /> <br /> 
        Insurance Date : <input
            type="text" name="insurancedate"
            value="<fmt:formatDate pattern="MM/dd/yyyy" value="${vehicle.insurancedate}" />" /> <br /> 
        FC Date : <input
            type="text" name=fcdate
            value="<fmt:formatDate pattern="MM/dd/yyyy" value="${vehicle.fcdate}" />" /> <br /> 
        FC Expiry Date : <input
            type="text" name="fcexpirydate"
            value="<fmt:formatDate pattern="MM/dd/yyyy" value="${vehicle.fcexpirydate}" />" /> <br /> 
        Service Date : <input
            type="text" name="servicedate"
            value="<fmt:formatDate pattern="MM/dd/yyyy" value="${vehicle.servicedate}" />" /> <br /> 
        Service Details: <input
            type="text" name="servicedetails"
            value="<c:out value="${vehicle.servicedetails}" />" /> <br />              
            <br /> <input
            type="submit" value="Submit" />
    </form>
</body>
</html>
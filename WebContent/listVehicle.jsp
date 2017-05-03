<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Show All Vehicles</title>
</head>
<body>
    <table border=1>
        <thead>
            <tr>
                <th>Vehicle Id</th>
                <th>Vehicle Number</th>
                <th>Type or Make</th>
                <th>RegistrationDate</th>
                <th>Expiry Date</th>
                <th>Insurance Date</th>
                <th>Fc Date</th>
                <th>Fc Expiry Date</th>
                <th>Service Date</th>
                <th>Service Details</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${vehicles}" var="vehicle">
                <tr>
                    <td><c:out value="${vehicle.vehicleid}" /></td>
                    <td><c:out value="${vehicle.vehicleidnumber}" /></td>
                    <td><c:out value="${vehicle.typeormake}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${vehicle.registrationdate}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${vehicle.expirydate}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${vehicle.insurancedate}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${vehicle.fcdate}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${vehicle.fcexpirydate}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${vehicle.servicedate}" /></td>
                    <td><c:out value="${vehicle.servicedetails}" /></td>
                    <td><a href="VehicleController?action=edit&vehicleId=<c:out value="${vehicle.vehicleid}"/>">Update</a></td>
                    <td><a href="VehicleController?action=delete&vehicleId=<c:out value="${vehicle.vehicleid}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="VehicleController?action=insert">Add Vehicle</a></p>
</body>
</html>
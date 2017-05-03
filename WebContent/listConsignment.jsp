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
                <th>Consignment ID </th>
                <th>Consignee ID </th>                
                <th>Consignee ID </th>
                <th>Vehicle ID</th>
                <th>Rate ID</th>
                <th>Transporter ID</th> 
                <th>RegistrationDate</th>
                <th>Box Count</th>
                <th>Box Details</th>
                <th>Capacity_weight</th>
                <th>Load Type</th>
                <th>Paid By </th>
                <th>amount</th>
                <th>total</th>
                <th>addl_charges</th>
                <th>handling_charges</th>
                <th>statistical_charges</th>
                <th>declared_value</th>
                <th>billed_at</th>
                <th>vehicle_type</th>
                <th>articletypedescription</th>
                <th>loading_percentage</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${consignments}" var="consignment">
                <tr>
                    <td><c:out value="${consignment.consignmentid}" /></td>
                    <td><c:out value="${consignment.consignerid}" /></td>
                    <td><c:out value="${consignment.consigneeid}" /></td>
                    <td><c:out value="${consignment.vehicleid}" /></td>
                    <td><c:out value="${consignment.rateid}" /></td>
                    <td><c:out value="${consignment.transportid}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${consignment.registrationdate}" /></td>
                    <td><c:out value="${consignment.boxcount}" /></td>
                    <td><c:out value="${consignment.boxdescription}" /></td>
                    <td><c:out value="${consignment.capacity_weight}" /></td>
                    <td><c:out value="${consignment.loadtype}" /></td>
                    <td><c:out value="${consignment.paidby}" /></td>
                    <td><c:out value="${consignment.amount}" /></td>
                    <td><c:out value="${consignment.total}" /></td>
                    <td><c:out value="${consignment.addl_charges}" /></td>
                    <td><c:out value="${consignment.handling_charges}" /></td>
                    <td><c:out value="${consignment.statistical_charges}" /></td>
                    <td><c:out value="${consignment.declared_value}" /></td>
                    <td><c:out value="${consignment.billed_at}" /></td>
                    <td><c:out value="${consignment.vehicle_type}" /></td>
                    <td><c:out value="${consignment.articletypedescription}" /></td>
                    <td><c:out value="${consignment.loading_percentage}" /></td>                                        
                    <td><a href="consignmentController?action=edit&consignmentId=<c:out value="${consignment.consignmentid}"/>">Update</a></td>
                    <td><a href="consignmentController?action=delete&consignmentId=<c:out value="${consignment.consignmentid}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="consignmentController?action=insert">Add Vehicle</a></p>
</body>
</html>
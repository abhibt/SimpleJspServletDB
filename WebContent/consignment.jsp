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
    </script>

    <form method="POST" action='ConsignmentController' name="frmAddVehicle">
        Consignment ID : <input type="text" readonly="readonly" name="consignmentid"
            value="<c:out value="${consignment.consignmentid}" />" /> <br /> 
        Consigner ID : <input
            type="text" name="consignerid"
            value="<c:out value="${consignment.consignerid}" />" /> <br /> 
        Consignee ID : <input
            type="text" name="consigneeid"
            value="<c:out value="${consignment.consigneeid}" />" /> <br />
        Vehicle ID : <input
            type="text" name="vehicleid"
            value="<c:out value="${consignment.vehicleid}" />" /> <br />  
        Rate ID : <input
            type="text" name="rateid"
            value="<c:out value="${consignment.rateid}" />" /> <br />  
        Transporter ID : <input
            type="text" name="transportid"
            value="<c:out value="${consignment.transportid}" />" /> <br /> 
        Registration Date : <input
            type="text" name="registrationdate"
            value="<fmt:formatDate pattern="MM/dd/yyyy" value="${consignment.registrationdate}" />" /> <br /> 
        Box Count : <input
            type="text" name="boxcount"
            value="<c:out value="${consignment.boxcount}" />" /> <br /> 
        Box Details: <input
            type="text" name="boxdescription"
            value="<c:out value="${consignment.boxdescription}" />" /> <br />    
        Capacity_weight : <input
            type="text" name="capacity_weight"
            value="<c:out value="${consignment.capacity_weight}" />" /> <br /> 
        Load Type : <input
            type="text" name="loadtype"
            value="<c:out value="${consignment.loadtype}" />" /> <br />     
        Paid By : <input
            type="text" name="paidby"
            value="<c:out value="${consignment.paidby}" />" /> <br />                   
            <br /> 
        amount : <input
            type="text" name="amount"
            value="<c:out value="${consignment.amount}" />" /> <br />     
            
        total : <input
            type="text" name="total"
            value="<c:out value="${consignment.total}" />" /> <br />                   
        addl_charges : <input
            type="text" name="addl_charges"
            value="<c:out value="${consignment.addl_charges}" />" /> <br />               
            <br /> 
        handling_charges : <input
            type="text" name="handling_charges"
            value="<c:out value="${consignment.handling_charges}" />" /> <br />               
            <br /> 
        statistical_charges : <input
            type="text" name="statistical_charges"
            value="<c:out value="${consignment.statistical_charges}" />" /> <br />               
            <br />                        
        declared_value : <input
            type="text" name="declared_value"
            value="<c:out value="${consignment.declared_value}" />" /> <br />               
            <br />   
        billed_at : <input
            type="text" name="billed_at"
            value="<c:out value="${consignment.billed_at}" />" /> <br />               
            <br />  
        vehicle_type : <input
            type="text" name="vehicle_type"
            value="<c:out value="${consignment.vehicle_type}" />" /> <br />               
            <br />  
        articletypedescription : <input
            type="text" name="articletypedescription"
            value="<c:out value="${consignment.articletypedescription}" />" /> <br />               
            <br />  
        loading_percentage : <input
            type="text" name="loading_percentage"
            value="<c:out value="${consignment.loading_percentage}" />" /> <br />               
            <br />  

           
            <input
            type="submit" value="Submit" />
    </form>
</body>
</html>
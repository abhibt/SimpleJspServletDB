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
<title>Add new user</title>
</head>
<body>
    <form method="POST" action='RateController' name="frmAddUser">
        Rate ID : <input type="text" readonly="readonly" name="rateid"
            value="<c:out value="${rate.rateid}" />" /> <br /> 
        Load Type : <input
            type="text" name="loadtype"
            value="<c:out value="${rate.loadtype}" />" /> <br /> 
<!--       Cust Id : <input
            type="text" name="custid"
            value="<c:out value="${rate.custid}" />" /> <br /> 
-->
		Cust Id :
        <select id="custid" name="custid">
            <c:forEach var="CustomerList" items="${rate.custid}">
                <option value="${CustomerList.custid}">${CustomerList.custid}}</option>
            </c:forEach>

        </select>    
        <br /> 
        Rate :  <input
            type="text" name="rate"
            value="<c:out value="${rate.rate}" />" /> <br /> 
        Destination : <input type="text" name="destination"
            value="<c:out value="${rate.destination}" />" /> <br /> 
        Source :  <input
            type="text" name="source"
            value="<c:out value="${rate.source}" />" /> <br /> 
<!--        Rate Type : <input type="text" name="ratetype"
            value="<c:out value="${user.ratetype}" />" /> <br /> 
  
    Rate Type: <select name="ratetype">
    <c:forEach var="item" items="${user.ratetype}">
        <option value="<c:out value="${user.ratetype}"/>">
        <c:out value="${item.ratetype}"/></option>
    </c:forEach>
     </select>
     --> 
       Rate Type: 
            <c:set var="ratetypes" value="fixed,boxes" scope="application" />
            <c:out value="Before : ${rate.ratetype}"/>
            <select id="ratetype" name="ratetype">
                <c:forEach items="${ratetypes}" var="ratetype">
                    <option value="${ratetype}" ${ratetype == rate.ratetype ? 'selected' : ''}>${ratetype}</option>
                </c:forEach>
            </select>
            
             <br /> <input
            type="submit" value="Submit" />
    </form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Show All Customers</title>
</head>
<body>
    <table border=1>
        <thead>
            <tr>
                <th>Cust Id</th>
                <th>Cust Code</th>
                <th>Cust Name</th>
                <th>Cust Address</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${customers}" var="customer">
                <tr>
                    <td><c:out value="${customer.custid}" /></td>
                    <td><c:out value="${customer.custcode}" /></td>
                    <td><c:out value="${customer.name}" /></td>
                    <td><c:out value="${customer.address}" /></td>
                    <td><a href="CustomerController?action=edit&custid=<c:out value="${customer.custid}"/>">Update</a></td>
                    <td><a href="CustomerController?action=delete&custid=<c:out value="${customer.custid}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="CustomerController?action=insert">Add Customer</a></p>
</body>
</html>
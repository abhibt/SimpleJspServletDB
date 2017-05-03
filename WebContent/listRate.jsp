<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Show All Rates</title>
</head>
<body>
	<table border=1>
		<thead>
			<tr>
				<th>Rate Id</th>
				<th>Load Type</th>
				<th>Cust Id</th>
				<th>Rate</th>
				<th>Destination</th>
				<th>Source</th>
				<th>Rate Type</th>
				<th colspan=2>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${rates}" var="rate">
				<tr>
					<td><c:out value="${rate.rateid}" /></td>
					<td><c:out value="${rate.loadtype}" /></td>
					<td><c:out value="${rate.custid}" /></td>
					<td><c:out value="${rate.rate}" /></td>
					<td><c:out value="${rate.destination}" /></td>
					<td><c:out value="${rate.source}" /></td>
					<td><c:out value="${rate.ratetype}" /></td>
					<td><a
						href="RateController?action=edit&rateid=<c:out value="${rate.rateid}"/>">Update</a></td>
					<td><a
						href="RateController?action=delete&rateid=<c:out value="${rate.rateid}"/>">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a href="RateController?action=insert">Add User</a>
	</p>
</body>
</html>
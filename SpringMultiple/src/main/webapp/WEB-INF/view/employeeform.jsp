<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Application</title>
</head>
<body>
  <form:form  id="myform" action="addPerson" method="POST" commandName="employee">
       <h3> <c:if test="${employee.id==0}">
			         Add New Person
	        </c:if>
			<c:if test="${employee.id!=0}">
			         Update Person for Id: <c:out value="${employee.id}"/>
					 <form:hidden path="id"/>
	        </c:if>
       </h3>
       	  <table>
	    <tr> <td>User Name:</td> <td><form:input  path="username"/><form:errors path="username" cssClass="error-msg"/> </td> </tr>
	    <tr> <td>Password:</td> <td><form:password path="password"/><form:errors path="password" cssClass="error-msg"/> </td> </tr>
	     <tr> <td>First Name: </td> <td><form:input path="firstName"/><form:errors path="firstName" cssClass="error-msg"/> </td> </tr>
	    <tr> <td>Last Name: </td> <td><form:input path="lastName"/><form:errors path="lastName" cssClass="error-msg"/> </td> </tr>
	    <tr> <td>Age: </td> <td><form:input path="age"/><form:errors path="age" cssClass="error-msg"/> </td> </tr>
	    <tr> <td>Address: </td> <td><form:input path="employee.address.addressLine"/><form:errors path="employee.address.address_line" cssClass="error-msg"/> </td> </tr>
	    <tr> <td>ZipCode: </td> <td><form:input path="employee.address.zipcode"/><form:errors path="employee.address.zipcode" cssClass="error-msg"/> </td> </tr>
	    <tr> <td>City: </td> <td><form:input path="employee.address.city"/><form:errors path="employee.address.city" cssClass="error-msg"/> </td> </tr>
	     <tr> <td>State: </td> <td><form:input path="employee.address.state"/><form:errors path="employee.address.state" cssClass="error-msg"/> </td> </tr>
	     <tr> <td>Country: </td> <td><form:input path="employee.address.country"/><form:errors path="employee.address.country" cssClass="error-msg"/> </td> </tr>
	    <tr> <td>Gender: </td> 
	         <td> <form:radiobuttons path="gender" items="${genderOptions}"/>
	             <form:errors path="gender" cssClass="error-msg"/> </td> </tr>    

	    <tr> <td colspan="2">
    	     <c:if test="${employee.id==0}">
			      <input type="button" value="Add" id="btn-add"> 
	         </c:if>
			 <c:if test="${employee.id!=0}">
			      <input type="button" value="Update" id="btn-update"> 
	         </c:if>
		</td> </tr>
		<tr> <td colspan="2" class="success-msg">
		   <c:out value="${msg}"/>
		</td> </tr>
	  </table>
	  <table>   
	      <tr>   <td> ID </td>
		         <td> UserName </td>
		         <td> FirstName</td>
		         <td> LastName</td>
				 <td> Age </td>
				 <td> Gender </td>
				
		  </tr>
    	  <c:forEach var="obj" items="${allData}">
		      <tr>
		         <td> <c:out value="${obj.id}"/> </td>
		         <td> <c:out value="${obj.username}"/> </td>
		         <td> <c:out value="${obj.firstName}"/> </td>
		         <td> <c:out value="${obj.lastName}"/> </td>
				 <td> <c:out value="${obj.age}"/> </td>
				 <td> <c:out value="${obj.gender}"/> </td>
				
				 <td> <a href="${pageContext.request.contextPath}/deletePerson?id=${obj.id}">Delete </a> |
				     <a href="${pageContext.request.contextPath}/personById?id=${obj.id}">Edit</a> 
				 </td>
		      </tr>
	      </c:forEach>
      </table> 

  </form:form>
  <script src="${pageContext.request.contextPath}/app-resources/js/lib/jquery-2.2.3.min.js"></script>
  <script src="${pageContext.request.contextPath}/app-resources/js/myapp.js"></script>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-resources/css/style.css"/>
</body>
</html>
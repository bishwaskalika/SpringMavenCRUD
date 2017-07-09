<%-- 
    Document   : index
    Created on : Jul 7, 2017, 12:59:27 PM
    Author     : dell
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring Maven Crud</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        
        <div class="container">
            <h1 >Users</h1>
            <br><br>
            <a href="${pageContext.request.contextPath}/add"><button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-plus">    Add User</span></button></a>
            <br><br><br><br><br>
            
            <table border="1" class="table table-striped">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Address</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach var="user" items="${users}" >
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.address}</td>
                    <td><a href="${pageContext.request.contextPath}/edit/${user.id}"><button type="button" class="btn btn-success"><span class="glyphicon glyphicon-pencil">   Edit</span></button></a></td>
                    <td><a href="${pageContext.request.contextPath}/delete/${user.id}" onclick=" return confirm('Are you sure to delete?')"><button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-pencil">   Delete</span></button></a></td>
                </tr>  
            </c:forEach>

        </table>
</div>
    </body>
</html>

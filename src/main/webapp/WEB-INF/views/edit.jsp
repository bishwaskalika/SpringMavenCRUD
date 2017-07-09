<%-- 
    Document   : edit
    Created on : Jul 7, 2017, 6:31:10 PM
    Author     : dell
--%>

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
        <h1>Edit Users</h1>
        <div class="container">
        <form method="post" action="${pageContext.request.contextPath}/save" class="table table-striped">
            <div>
                <label>User Name</label>
                <input type="text" name="name" value="${user.name}" /> 
            </div>
            <div>
                <label>Address</label>
                <input type="text" name="address" value="${user.address}" /> 
            </div>
            <input type="hidden" name="id" value="${user.id}"/>
            <button type="submit" class="btn btn-success">Save</button>
        </form>
            </div>
    </body>
</html>

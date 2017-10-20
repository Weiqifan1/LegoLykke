<%-- 
    Document   : customerpage
    Created on : Oct 10, 2017, 10:13:18 AM
    Author     : Christian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
    </head>
    <body>
        <h1>Hello <%=request.getAttribute("email" )%>
        
        </h1>
        <h4> <%=request.getAttribute("neworder" )%></h4>
        You are now logged in as a customer of our wonderful site.
        
        
        
        <form name="form1" action="FrontController" method="POST">
            <input type="hidden" name="command" value="wantorderlist">
            <input type="submit" value="show Orders">
            
        </form>
        
        <form name="form2" action="FrontController" method="POST">
            <input type="hidden" name="command" value="writeorder">
            Length: <br>
            <input type="number" name="length" value="">
            <br>
            Width: <br>
            <input type="number" name="width" value="">
            <br>
            Height: <br>
            <input type="number" name="height" value="">
            <br>
            <input type="submit" value="Create New Order">
        </form>
        
    </body>
</html>

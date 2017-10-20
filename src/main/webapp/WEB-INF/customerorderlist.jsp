<%-- 
    Document   : customerorderlist
    Created on : Oct 12, 2017, 2:17:48 PM
    Author     : Christian
--%>

<%@page import="PresentationLayer.RenderOrder"%>
<%@page import="java.util.List"%>
<%@page import="FunctionLayer.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World! her er customerorderlist.jsp</h1>
        
        <h1>Hello <%=request.getAttribute( "username" )%> </h1>
        
        <h1>here are the orders: </h1>
        
        <%
                    ArrayList<Order> OL2 = (ArrayList<Order>) request.getAttribute( "showorderlist" );
        %>
        
        <%=RenderOrder.renderOrderList(OL2) %>
            
        
        
    </body>
</html>


<%-- 
    Document   : customerorder
    Created on : Oct 19, 2017, 4:08:37 PM
    Author     : Christian
--%>

<%@page import="FunctionLayer.Calc"%>
<%@page import="FunctionLayer.Order"%>
<%@page import="PresentationLayer.RenderOrder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World! her er customerOrder, det er her enkelte ordre skal skrives</h1>
        
        <%
                
                    Calc song = (Calc) request.getAttribute( "cmdorderresult" );
                    
        %>
        
        <%= RenderOrder.renderSingleOrder(song) %>
        
    </body>
</html>

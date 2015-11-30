<%-- 
    Document   : editAgentError
    Created on : Nov 22, 2015, 3:34:23 PM
    Author     : Dordi
--%>

<%@page import="tp3.action.login.Authentificate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>                <% if (Authentificate.getSession() == null || Authentificate.getSession().isEmpty()) {
            response.sendRedirect("Login.action");
        }%>                
        <h1>Error while editing the agent</h1>
    </body>
</html>

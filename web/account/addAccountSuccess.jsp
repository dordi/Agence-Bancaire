<%@page import="tp3.action.login.Authentificate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account added successfully</title>
    </head>
    <body>                <% if(Authentificate.getSession() == null || Authentificate.getSession().isEmpty())  response.sendRedirect("Login.action");%>                
        <hr/>
        <h4>The account <s:property value="rib" /> has been successfully inserted for client <s:property value="clientCin" /></h4>
        <hr/>
        <s:url id="mainActions" action="mainActions"></s:url>
        <p><s:a href="%{mainActions}">Go back</s:a>.</p>
        <hr/>
    </body>
</html>
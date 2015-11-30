<%@page import="tp3.action.login.Authentificate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete an account</title>
    </head>
    <body>                <% if(Authentificate.getSession() == null || Authentificate.getSession().isEmpty())  response.sendRedirect("Login.action");%>                
        <hr/>
        <h4>Account deleted successfully</h4>
        <hr/>
        <p>The account <s:property value="rib"/> was deleted successfully</p>
        <hr/>
        <s:url id="delete" action="deleteAccountInit"/>
        <s:a href="%{delete}">Go back</s:a>
        <hr/>
    </body>
</html>
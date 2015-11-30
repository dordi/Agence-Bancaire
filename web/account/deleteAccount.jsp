<%@page import="tp3.action.login.Authentificate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Delete account</title>
        <link rel="stylesheet" type="text/css" href="css/layout.css">
        <link rel="icon" type="image/png" href="images/icon.png" />
    </head>
    <body>                <% if(Authentificate.getSession() == null || Authentificate.getSession().isEmpty())  response.sendRedirect("Login.action");%>                 
        <div id="page">
            <div class="title">
                <h1>Delete account</h1>
            </div>
            <jsp:include page="../mainMenu.jsp"/>
            <div id="content">
                <h4>Delete an account</h4>
                <table border="1" cellpadding="10" cellspacing="0">
                    <tr style="background-color: #DDD">
                        <td width="200px">RIB</td>
                        <td width="200px">Client</td>
                        <td width="100px">Solde</td>
                        <td width="75px">&nbsp;</td>
                    </tr>
                    <s:iterator value="accountsList">
                        <tr>
                            <td><s:property value="rib" default="" /></td>
                            <td><s:property value="client.firstName" default="" /> <s:property
                                    value="client.lastName" default="" /></td>
                            <td><s:property value="solde" default="" /></td>
                            <s:url id="delete" action="deleteAccount">
                                <s:param name="rib" value="%{rib}" />
                            </s:url>
                            <td><s:a href="%{delete}">Delete</s:a></td>
                            </tr>
                    </s:iterator>
                </table>
            </div>
        </div>
    </body>
</html>
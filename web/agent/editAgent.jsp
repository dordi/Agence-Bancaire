<%@page import="tp3.action.login.Authentificate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="s" uri="/struts-tags"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Edit agent</title>
        <link rel="stylesheet" type="text/css" href="css/layout.css">
        <link rel="icon" type="image/png" href="images/icon.png" />
    </head>
    <body>                <% if(Authentificate.getSession() == null || Authentificate.getSession().isEmpty())  response.sendRedirect("Login.action");%>                

        <div class="wrapper row1">

            <div id="logo" class="fl_left" style="float: left;margin-right: 100px">
                <h1>Edit agent</h1>
            </div>
            <jsp:include page="../mainMenu.jsp"/>
        </div>
    <center><div style="width: 800px">
            <s:form action="editAgent" >
                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                    <h4>Enter the agent details:</h4>
                    <tr><td><s:textfield name="id" label="id  *" readonly="true" /></td></tr>
                    <tr><td><s:textfield name="login" label="Login  *" /></td></tr>
                    <tr><td><s:password name="password" label="Password *" /></td></tr>
                    <tr><td><s:textfield name="firstName" label="First Name *" /></td></tr>
                    <tr><td><s:textfield name="lastName" label="Last Name *" /></td></tr>
                    <tr><td><s:select list="#{'0':'NO','1':'YES'}" value="0" name ="admin" label="Admin *"></s:select></td></tr>
                    <tr><td><s:submit /></td></tr>
                </table>
            </s:form>
        </div></center>

</body>
</html>
<%@page import="tp3.action.login.Authentificate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="s" uri="/struts-tags"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Edit account</title>
        <link rel="stylesheet" type="text/css" href="css/layout.css">
        <link rel="icon" type="image/png" href="images/icon.png" />
    </head>
    <body>                <% if(Authentificate.getSession() == null || Authentificate.getSession().isEmpty())  response.sendRedirect("Login.action");%>                

    <div class="wrapper row1">

        <div id="logo" class="fl_left" style="float: left;margin-right: 100px">
            <h1>Edit account</h1>
        </div>
        <jsp:include page="../mainMenu.jsp"/>
    </div>
    <center><div style="width: 800px">
            <s:form action="editAccount" >
                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                    <h4>Enter the account details:</h4>
                    <tr><td><s:textfield name="rib" label="RIB" readonly="readonly" /></td></tr>
                    <tr><td><s:select name="clientCin" label="Client CIN" list="#session.cinList" /></td></tr>
                    <tr><td><s:textfield name="solde" label="Initial balance" /></td></tr>
                    <tr><td><s:submit /></td></tr>
                </table>
            </s:form>
        </div></center>

</body>
</html>
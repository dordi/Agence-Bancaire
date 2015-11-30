<%@page import="tp3.action.login.Authentificate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="s" uri="/struts-tags"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title><s:text name="main.welcome"/></title>
  <link rel="stylesheet" type="text/css" href="css/layout.css">
  <link rel="icon" type="image/png" href="images/icon.png" />
</head>
<body>                <% if(Authentificate.getSession() == null || Authentificate.getSession().isEmpty())  response.sendRedirect("Login.action");%>                
  <div id="page">
    <div class="title">
      <h1><s:text name="main.welcome"/> <s:property value="agentBancaire.firstName" /></h1>
    </div>
    <jsp:include page="mainMenu.jsp"/>
    <div id="content">
      <h3><s:text name="main.chooseaction"/>.</h3>
    </div>
  </div>
</body>
</html>
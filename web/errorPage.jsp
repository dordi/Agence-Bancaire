<%@page import="tp3.action.login.Authentificate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="s" uri="/struts-tags"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title><s:text name="main.login.error"/></title>
        <link rel="stylesheet" type="text/css" href="css/layout.css">
        <link rel="icon" type="image/png" href="images/icon.png" />
    </head>
    <body>                <% if(Authentificate.getSession() == null || Authentificate.getSession().isEmpty())  response.sendRedirect("Login.action");%>                
        <div class="wrapper row0" style="margin-top: 20px; margin-right: 80px">
            <div id="topbar" class="clear"> 
                <div class="fl_right">
                    <ul class="faico clear">
                        <li>
                            <h1><s:text name="main.login.error"/></h1></li>
                    </ul>
                </div>   
            </div> 
        </div>  
                    <nav id="mainav" class="fl_right">
            <center> <ul class="clear">
                    <s:url id="indexEN" action="Login" >
                        <s:param name="request_locale" >en</s:param>
                    </s:url>
                    <s:url id="indexFR" action="Login" >
                        <s:param name="request_locale" >fr</s:param>
                    </s:url>
                    <li style="margin-right: 2px"><s:a href="%{indexEN}" ><img src="images/english.png" width="20px" height="20px"></s:a></li>
                    <li style="margin-left: 2px"><s:a href="%{indexFR}" ><img src="images/frensh.png" width="20px" height="20px"></s:a></li>
                    </ul></center>
            </nav>
            <div id="content">
                <p><s:text name="main.login.error.msg1" /></p>
            <p><s:text name="main.login.error.msg2" /></p>
            <hr/>
            <s:url id="loginPage" action="loginPage"></s:url>
            <p><s:a href="%{loginPage}"><s:text name="main.goback.tologin"/></s:a>.</p>
        </div>
    </body>
</html>
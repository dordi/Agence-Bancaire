<%@page import="tp3.action.login.Authentificate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Accounts list</title>
        <link rel="stylesheet" type="text/css" href="css/layout.css">
        <link rel="stylesheet" type="text/css" href="css/body.css">

        <link rel="icon" type="image/png" href="images/icon.png" />
    </head>
    <body>                
        <% if (Authentificate.getSession() == null || Authentificate.getSession().isEmpty()) {
                response.sendRedirect("Login.action");
            }%>                 

        <div class="wrapper row0" style="margin-top: 20px; margin-right: 80px">
            <div id="topbar" class="clear"> 
                <div class="fl_right">
                    <ul class="faico clear">
                        <s:url id="Logout" action="Logout"></s:url>
                            <li><s:a href="%{Logout}"  cssClass="faicon-google-plus"><img src="images/ne.png" width="25px" height="25px"/></s:a></li>
                            </ul>
                        </div>   
                    </div> 
                </div>

                <div class="wrapper row1">

                    <div id="logo" class="fl_left" style="float: left;margin-right: 50px">
                        <h1><s:text name="main.menu.listaccounts"/></h1>
                    </div>
                <jsp:include page="../mainMenu.jsp"/>
            </div>
        <center><h4 style="margin: 20px">List of all accounts</h4></center>
        <center><div style="width: 800px">
                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                    <thead>
                        <tr>
                            <th>RIB</th>
                            <th>Client</th>
                            <th>Solde</th>
                        </tr>
                    </thead>
                    <s:iterator value="accountsList">
                        <tr>
                            <td><s:property value="rib" default="" /></td>
                            <td><s:property value="client.firstName" default="" /> <s:property
                                    value="client.lastName" default="" /></td>
                            <td><s:property value="solde" default="" /></td>
                            <s:url id="edit" action="editAccountInit">
                                <s:param name="rib" value="%{rib}" />
                            </s:url>
                            <s:url id="delete" action="deleteAccount">
                                <s:param name="rib" value="%{rib}" />
                            </s:url>
                            <td><s:a href="%{edit}">Edit</s:a></td>
                            <td><s:a href="%{delete}">Delete</s:a></td>
                            </tr>
                    </s:iterator>
                </table>
            </div></center>
    </body>
</html>
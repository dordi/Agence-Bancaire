<%@page import="tp3.action.login.Authentificate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Agents list</title>
        <link rel="stylesheet" type="text/css" href="css/layout.css">
        <link rel="stylesheet" type="text/css" href="css/body.css">
        <link rel="icon" type="image/png" href="images/icon.png" />
    </head>
    <body>   
        <% if(Authentificate.getSession() == null || Authentificate.getSession().isEmpty())  response.sendRedirect("Login.action");%>
        <div class="wrapper row0" style="margin-top: 20px; margin-right: 80px">
            <div id="topbar" class="clear"> 
                <div class="fl_right">
                    <ul class="faico clear">
                        <s:url id="Logout" action="Logout"></s:url>
                        <li><s:a href="./%{Logout}"  cssClass="faicon-google-plus"><img src="images/ne.png" width="25px" height="25px"/></s:a></li>
                        </ul>
                    </div>   
                </div> 
            </div>  

            <div class="wrapper row1">

                <div id="logo" class="fl_left" style="float: left;margin-right: 50px">
                    <h1><s:text name="main.menu.listagents"/></h1>
                </div>
                <nav id="mainav" class="fl_right">

                    <ul class="clear">
                    <s:url id="listAccountsUrl" action="listAccounts" />
                    <li ><s:a href="%{listAccountsUrl}">
                            <s:text name="main.menu.listaccounts" />
                        </s:a></li>
                        <s:url id="addAccountUrl" action="AddAccountInit" />
                    <li><s:a href="%{addAccountUrl}">
                            <s:text name="main.menu.addaccount" />
                        </s:a></li>
                        <s:url id="listClientUrl" action="listClients" />
                    <li><s:a href="%{listClientUrl}">
                            <s:text name="main.menu.listclients" />
                        </s:a></li>
                        <s:url id="addClientUrl" action="createClientJSP" />
                    <li><s:a href="%{addClientUrl}">
                            <s:text name="main.menu.addclient" />
                        </s:a></li>
                        <c:if test="${(not empty sessionScope.isAdmin) && (sessionScope.isAdmin == true)}">
                            <s:url id="listAdminsUrl" action="listAgents" />
                        <li class="active"><s:a href="%{listAdminsUrl}">
                                <s:text name="main.menu.listagents" />
                            </s:a></li>
                            <s:url id="addAdminUrl" action="createAgentJSP" />
                        <li><s:a href="%{addAdminUrl}">
                                <s:text name="main.menu.addagent" />
                            </s:a></li>

                    </c:if>
                </ul>

            </nav>
        </div>

    <center><h4 style="margin: 20px">List of all agents</h4></center>
    <center><div style="width: 800px">
            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                <thead>
                    <tr>
                        <th>Login</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Admin</th>
                    </tr>
                </thead>
                <s:iterator value="agentList">
                    <tr>
                        <td width="150px"><s:property value="login" default="" /></td>
                        <td width="150px"><s:property value="firstName" default="" /></td>
                        <td width="150px"><s:property value="lastName" default="" /></td>
                        <td width="100px">
                            <c:choose>
                                <c:when test="${ admin == 1 }">
                                    YES
                                </c:when>
                                <c:otherwise>
                                    NO
                                </c:otherwise>
                            </c:choose>            
                        </td>
                        <s:url id="edit" action="editAgentInit">
                            <s:param name="id" value="%{id}" />
                        </s:url>
                        <s:url id="delete" action="deleteAgent">
                            <s:param name="id" value="%{id}" />
                        </s:url>
                        <td><s:a href="%{edit}">Edit</s:a></td>
                        <td><s:a href="%{delete}">Delete</s:a></td>
                        </tr>
                </s:iterator>
            </table>
        </div>
    </body>
</html>
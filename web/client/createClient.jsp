<%@page import="tp3.action.login.Authentificate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="s" uri="/struts-tags"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Create a client</title>
        <link rel="stylesheet" type="text/css" href="css/layout.css">
        <link rel="icon" type="image/png" href="images/icon.png" />
    </head>
    <body>                <% if(Authentificate.getSession() == null || Authentificate.getSession().isEmpty())  response.sendRedirect("Login.action");%>                
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

                <div id="logo" class="fl_left" style="float: left;margin-right: 20px">
                    <h1><s:text name="main.menu.addclient"/></h1>
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
                    <li accesskey=""class="active"><s:a href="%{addClientUrl}">
                            <s:text name="main.menu.addclient" />
                        </s:a></li>
                    <c:if test="${(not empty sessionScope.isAdmin) && (sessionScope.isAdmin == true)}">
                        <s:url id="listAdminsUrl" action="listAgents" />
                        <li ><s:a href="%{listAdminsUrl}">
                                <s:text name="main.menu.listagents" />
                            </s:a></li>
                            <s:url id="addAdminUrl" action="createAgentJSP" />
                        <li><s:a href="%{addAdminUrl}">
                                <s:text name="main.menu.addagent" />
                            </s:a></li>

                    </c:if>
                </ul>
                </ul>

            </nav>
        </div>
    <center><h4>Create a new client:</h4></center>

    <center><div style="width: 800px">
            <s:form action="AddClient">
                <h4>Enter the client details:</h4>

                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                    <tr><td><s:textfield name="client.firstName" label="First Name *" /></td></tr>
                    <tr><td><s:textfield name="client.lastName" label="Last Name *" /></td></tr>
                    <tr><td><s:textfield name="client.cin" label="CIN *" /></td></tr>
                    <tr><td><s:textfield name="client.address" label="Address *" /></td></tr>
                    <tr><td><s:textfield name="client.phoneNumber" label="Phone Number *" /></td></tr>
                    <tr><td><s:textfield name="client.job" label="Job" /></td></tr>
                    <tr><td><s:submit /></td></tr>
                </table>
            </s:form>
        </div>  
    </body>
</html>
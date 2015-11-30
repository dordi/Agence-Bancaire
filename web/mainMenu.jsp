<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="s" uri="/struts-tags"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav id="mainav" class="fl_right">

    <ul class="clear">
        <s:url id="listAccountsUrl" action="listAccounts" />
        <li class="active"><s:a href="%{listAccountsUrl}">
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
            <li><s:a href="%{listAdminsUrl}">
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
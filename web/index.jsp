<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="s" uri="/struts-tags"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<s:action name="Login" executeResult="true" />
<!-- 
Intercepteurs:
  - Confirmation de suppression
  - Journalisation
  - Redirection si non authentifié
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title><s:text name="main.login"/></title>
        <!--<link rel="stylesheet" type="text/css" href="css/layout.css">-->
        <link rel="icon" type="image/png" href="images/icon.png" />
    </head>    <!-- Body CSS -->
    <link href="css/body.css" rel="stylesheet">

    <!-- Menu CSS -->
    <link href="css/menu.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/custom.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="css/font.css" rel="stylesheet" type="text/css">


</head>

<body>                

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading" align="center">
                        <h3 class="panel-title"><s:text name="main.login.title"/></h3>
                    </div>
                    <div class="panel-body" style="alignment-adjust: central">
                        <center> <s:form action="Login">
                                <div class="form-group" >
                                    <s:textfield name="username" id="username" key="main.login.yourname" cssClass="form-control" cssStyle="margin-bottom: 20px"/>
                                </div>
                                <div class="form-group">
                                    <s:password name="password" id="password" key="main.login.yourpass" cssClass="form-control" cssStyle="margin-bottom: 20px" />
                                </div>
                                <s:submit cssClass="btn btn-lg btn-success btn-block" key="main.login.submit"  />
                            </s:form> </center>
                        <br>
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
                    </div>
                </div>
            </div>
        </div>
    </div>
    <style type="text/css">
        label[for="username"] {
            color: black;
        }

        label[for="password"] {
            color: black;
        }

        li{
            display: inline
        }
    </style>
</body>
</html>
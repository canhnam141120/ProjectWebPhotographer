<%-- 
    Document   : Header
    Created on : May 31, 2021, 11:40:55 AM
    Author     : DELL
--%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/header.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="nav">
            <div class= "nav-inner">
                <ul>
                    <li> <a class="${active=="0"?"activeMenu":""}" href="HomeServlet">My front page</a></li>
                        <c:forEach items="${top3}" var="i" >
                        <li> <a class="${active==i.ID?"activeMenu":""}" href="GaLeryServlet?galeryID=${i.ID}">${i.name}</a> </li>
                        </c:forEach>
                    <li> <a class="${active=="4"?"activeMenu":""}" href="ContactServlet">Contact</a> </li>
                </ul>
            </div>

        </div>
        <div class="header">
            <div class="header-inner">
                <div class="img"> </div>
                <!--<img rel="nofollow" src="./images/logo.png"/>-->
                <div class="title ">
                    PHOTOGRAPHER
                </div>
                <div class="subtitle">
                    Welcome to this website
                </div>
            </div>
        </div>
    </body>
</html>

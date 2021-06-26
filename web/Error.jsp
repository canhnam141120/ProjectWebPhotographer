<%-- 
    Document   : Error
    Created on : May 31, 2021, 11:20:45 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link href="css/header.css" rel="stylesheet" type="text/css"/>
<link href="css/footer.css" rel="stylesheet" type="text/css"/>
<link href="css/home.css" rel="stylesheet" type="text/css"/>
<link href="css/right.css" rel="stylesheet" type="text/css"/>
<div class="container">
    <jsp:include page="Header.jsp"/>
    <div class="main">
        <div class="left">
            <h1>${error}</h1>
        </div>
    </div>

</div>
<jsp:include page="Footer.jsp"/>

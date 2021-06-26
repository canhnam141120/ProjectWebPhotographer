<%-- 
    Document   : Footer
    Created on : May 31, 2021, 11:25:45 AM
    Author     : DELL
--%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/footer.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="footer">
            <div class="link">
                <a href="#">Created with SimpleSite </a>
                <%--<span class="totalView">${totalView}</span>--%>
                <c:forEach begin="0" end="${totalView.length()-1}" var="i">
                    <button class="totalView">${totalView.charAt(i)} </button>
                </c:forEach>    

            </div>

        </div>

    </body>
</html>

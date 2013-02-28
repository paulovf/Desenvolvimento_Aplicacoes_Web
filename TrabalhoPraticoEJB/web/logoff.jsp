<%-- 
    Document   : logoff
    Created on : 28/02/2013, 20:29:48
    Author     : paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%          
            session.invalidate();
            response.sendRedirect("index.jsp");
        %>
    </body>
</html>

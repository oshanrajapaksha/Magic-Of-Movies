<%@page import="DatAcc.UserDatAcc"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            
            UserDatAcc data = new UserDatAcc();
            String uemail = request.getParameter("eUmail");
            int n = data.deleteUserRequest(uemail);
            response.sendRedirect("reqs.jsp");
        
        %>
    </body>
</html>

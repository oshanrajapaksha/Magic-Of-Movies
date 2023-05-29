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
            String uemail = request.getParameter("eUmail");
            UserDatAcc dat = new UserDatAcc();
            int m = dat.upgradeUserToAnAdmin(uemail);
            response.sendRedirect("reqs.jsp");
        
        %>
    </body>
</html>


<%@page import="DatAcc.TickDataAcc"%>
<%@page import="jv.Ticket"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% Ticket tick1 = new Ticket();
            TickDataAcc data = new TickDataAcc();
            tick1.setId(Integer.parseInt(request.getParameter("tid")));
            
            if(data.deleteTicketRecord(tick1) > 0){
                response.sendRedirect("Adashboard.jsp");
            } %>
    </body>
</html>

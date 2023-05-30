<%@page import="jv.Movies"%>
<%@page import="DatAcc.MovieDataAccess"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% Movies movie2 = new Movies();
            MovieDataAccess data = new MovieDataAccess();
            movie2.setM_id(Integer.parseInt(request.getParameter("mid")));
            
            if(data.deleteMoviesRecord(movie2) > 0){
                response.sendRedirect("editDetails.jsp");
            } %>
    </body>
</html>

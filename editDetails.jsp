<%@page import="java.util.List"%>
<%@page import="jv.Movies"%>
<%@page import="DatAcc.MovieDataAccess"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% if (session.getAttribute("role") == "User"){response.sendRedirect("index.jsp");}%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movie Details</title><!-- comment -->
        <style>body{
            background-color: black;
}</style>
    </head>
    <body>
        <%@include file="header.jsp"%>
        <h1 style="color: white;">Movie Information</h1><br>
        
        <table style="width: 1400px;" class="table table-hover table-bordered table-dark table-sm mx-auto">
  <thead>
  <style>table thead th{
      color: darkgoldenrod;
      }
  </style>
    <tr>
      <th scope="col">Movie ID</th>
      <th scope="col">Movie Name</th>
      <th scope="col">Ticket Price</th>
      <th scope="col">Expire Date</th>
      <th scope="col">Inserted Time</th>
      <th scope="col">Watch Hours</th>
      <th scope="col">Director</th>
      <th scope="col">Category</th>
      <th scope="col">IMBD</th>
      <th scope="col">Rotten Tomatoes</th>
      <th scope="col">Movie  Description</th>
      <th scope="col">Options</th>
    </tr>
  </thead>
  <tbody>
      <%
                    MovieDataAccess movie3 = new MovieDataAccess();
                    List<Movies> movList = movie3.getAllMoviesRecords();
                    int i=0;
                    while(i<movList.size()){
		%>
    <tr>
      <th scope="row"><%=movList.get(i).getM_id()%></th>
      <td><%=movList.get(i).getName() %></td>
      <td><%=movList.get(i).getTicket_price() %></td>
      <td><%=movList.get(i).getExpire_time() %></td>
      <td><%=movList.get(i).getTime_inserted() %></td>
      <td><%=movList.get(i).getWatch_hrs() %></td>
      <td><%=movList.get(i).getDirector() %></td>
      <td><%=movList.get(i).getCategory() %></td>
      <td><%=movList.get(i).getImbd_rate() %></td>
      <td><%=movList.get(i).getRott_rate() %></td>
      <td><%=movList.get(i).getMov_desc() %></td>
      <td>
              <a href="editMovie.jsp?mid=<%=movList.get(i).getM_id() %>" class="badge badge-success">Edit</a>
              <a href="deleteMovie.jsp?mid=<%=movList.get(i).getM_id() %>" class="badge badge-danger">Delete</a>
      </td>
    </tr><%i++; } %>
    
  </tbody>
</table>
    </body>
</html>

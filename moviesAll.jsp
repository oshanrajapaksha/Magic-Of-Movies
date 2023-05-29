<%@page import="java.util.List"%>
<%@page import="jv.Movies"%>
<%@page import="DatAcc.MovieDataAccess"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link rel='stylesheet' href='https://fonts.googleapis.com/css2?family=Secular+One&amp;display=swap'>
          <link rel="stylesheet" href="movStyle.css">
        <title>All Movies</title>
    </head>
    <body style="background-color: black">
        
        <section>
            <%@include file="header.jsp"%>
        <h1 style="color: white"><span></span></h1>
        
<!--        <div class="content">
            
            <ul class="team"style="position: relative;">-->
                
<!--                   <li class="member" style="height: auto;padding-right: 10px;width: 150%;">
			<div class="thumb"><img src="Thumbs/<%//=movList.get(i).getThumb()%>"width="150px" 
     height="150px"></div>
			<div class="description">
				<h3><%//=movList.get(i).getName() %></h3>
                                <h4>IMBD: <%//=movList.get(i).getImbd_rate() %></h4>
                                <h4>Rotten Tomatoe: <%//=movList.get(i).getRott_rate() %></h4>
                                
                                <h4>Play Time: <%//=movList.get(i).getWatch_hrs() %></h4>
                                <h4>Expire on <%//=movList.get(i).getExpire_time() %></h4>
                                <h4>Ticket Price: <span style="color: red; font-size: 150%"><%//=movList.get(i).getTicket_price() %>0 LKR</span></h4>
				<p><%//=movList.get(i).getMov_desc()%><br><a href="BookTicket.jsp?id=<%//=movList.get(i).getM_id() %>">Book Now!</a></p>
                                
                        </div>
                   </li>
                   
            </ul>
             
     
        </div>--><%
                    MovieDataAccess movie3 = new MovieDataAccess();
                    List<Movies> movList = movie3.getAllMoviesRecords();
                    int i=0;
                    while(i<movList.size()){
		%>
                   <div class="browse-movie-wrap col-xs-10 col-sm-5" href="BookTicket.jsp?mId=<%=movList.get(i).getM_id() %>">
                       <a href="BookTicket.jsp?mId=<%=movList.get(i).getM_id() %>" class="browse-movie-link">
                        <figure>
                            <img class="img-responsive" src="Thumbs/<%=movList.get(i).getThumb()%>" width="210" height="315">
                        </figure>
                        </a>
                    <div class="browse-movie-bottom"><%=movList.get(i).getName()%>
                       <%
                            //session.setAttribute("mname", movList.get(i).getName());
        //session.setAttribute("desc", movList.get(i).getMov_desc());
       // session.setAttribute("tickP", movList.get(i).getTicket_price());
       // session.setAttribute("mpic", movList.get(i).getThumb());
       // session.setAttribute("direc", movList.get(i).getDirector());
      //  session.setAttribute("wathr", movList.get(i).getWatch_hrs());
       // session.setAttribute("imbd", movList.get(i).getImbd_rate());
       // session.setAttribute("rott", movList.get(i).getRott_rate());
       // session.setAttribute("categ", movList.get(i).getCategory());
      //  session.setAttribute("Expire", movList.get(i).getExpire_time());
                       // %>
                    </div>
                    </div><%i++; } %>
             </section>
    </body>
</html>
<%@page import="jv.Movies"%>
<%@page import="DatAcc.MovieDataAccess"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Movie</title>
        <style>@import url("https://fonts.googleapis.com/css?family=Montserrat&display=swap");

@import url("https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css");

@import url('https://fonts.googleapis.com/css?family=Poppins:400,500,600,800&display=swap');



.cn {
    position: relative;
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
    width: 900px;
    height: 600px;
    background: #fff;
    margin: 20px;
}

.cn .imgBx {
    position: relative;
    display: flex;
    justify-content: center;
    align-items: center;
    width: 50%;
    height: 100%;
    background: #212121;
    transition: .3s linear;
}

.cn .imgBx:before {
    content: 'Nike';
    position: absolute;
    top: 0px;
    left: 24px;
    color: #000;
    opacity: 0.2;
    font-size: 8em;
    font-weight: 800;
}

.cn .imgBx img {
    position: relative;
    width: 700px;
    transform: rotate(-30deg);
    left: -50px;
    transition: .9s linear;
}

.cn .det {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 50%;
    height: 100%;
    box-sizing: border-box;
    padding: 40px;
}

.cn .det h2{
    margin: 0;
    padding: 0;
    font-size: 2.4em;
    line-height: 1em;
    color: #444;
}

.cn .det h2 span {
    font-size: 0.4em;
    text-transform: uppercase;
    letter-spacing: 2px;
    color: #999;
}

.cn .det p {
    max-width: 85%;
    margin-left: 15%;
    color: #333;
    font-size: 15px;
    margin-bottom: 36px;
}

.cn .det h3 {
    margin: 0;
    padding: 0;
    font-size: 2.5em;
    color: #a2a2a2;
    float: left;
}
.cn .det button {
    background: #000;
    color: #fff;
    border: none;
    outline: none;
    padding: 15px 20px;
    margin-top: 5px;
    font-size: 16px;
    letter-spacing: 1px;
    text-transform: uppercase;
    font-weight: 600;
    border-radius: 40px;
    float: right;
}

/* responsive */
@media (max-width: 1080px) {
    .cn {
        height: auto;
    }
    .cn .imgBx {
        padding: 40px;
        box-sizing: border-box;
        width: 100% !important;
        height: auto;
        text-align: center;
        overflow: hidden;
    }
    .cn .imgBx img {
        left: initial;
        max-width: 100%;
        transform: rotate(0deg);
    }
    .det {
        width: 100% !important;
        height: auto;
        padding: 20px;
    }
    .cn .det p {
        margin-left: 0;
        max-width: 100%;
    }
}
</style>
    </head>
    <body>
        <%@include file="header.jsp"%>
        <section>
            
            <div class="cn"><%
                
                int movId = Integer.parseInt(request.getParameter("mId"));
                
                MovieDataAccess movie = new MovieDataAccess();
                Movies m = new Movies();
                m = movie.getMovieData(movId);
                %>
        
                <img width="50%" height="92%" src="Thumbs/<% out.println(m.getThumb()); %>">
        
        <div class="det">
            <div class="content">
                <h2 style="color: #04befe;"><% out.println(m.getName()); %>
                </h2><br>
                <p style="color: darkslateblue;">
                   <% out.println(m.getMov_desc()); %>
                </p>
                <h4>Director : <% out.println(m.getDirector()); %></h4>
                <h4>Watch Hours : <% out.println(m.getWatch_hrs()); %></h4>
                <h4 style="color: darkblue">IMBD : <% out.println(m.getImbd_rate()); %></h4>
                <h4 style="color: darkblue">Rotten Tomatoes : <% out.println(m.getRott_rate()); %></h4>
                <h4>Category : <% out.println(m.getCategory()); %></h4>
                <h4>Expire Time : <% out.println(m.getExpire_time()); %></h4>
                <h3 style="color: red">Ticket Price : <span name="tPrice"><% out.println(m.getTicket_price()); %></span></h3>
            </div>
        </div>
    </div>
            
        </section><section>
            <div style="width: 600px; margin-left: auto; margin-right: auto; margin-bottom: 50px">
            <form action="bookingServ" method="post">
                <input type="hidden" name="mName" value="<%=m.getName()%>">
                <input type="hidden" name="mPrice" value="<%=m.getTicket_price()%>">
                <input type="hidden" name="mId" value="<%=movId%>">
                <input type="hidden" name="email" value="<% out.println(session.getAttribute("email"));%>">
                <div class="form-group">
                <label >How many tickets?</label>
                <input name="nTick" type="number" class="form-control" id="formGroupExampleInput" placeholder="No of Tickets">
                </div>
                <div class="col-auto my-1">
                    <button type="submit" name="Book" class="btn btn-primary">Book Now</button>
    </div>
            </form></div>
            
        </section><%@include file="footer.jsp" %>
    </body>
</html>

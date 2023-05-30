<style>
    @import 'https://fonts.googleapis.com/css?family=Raleway';

html, body
{
    margin: 0px;
}

header
{
    font-family: Raleway;
    margin: 0 auto;
    text-align: center;
    background: #555;
    color: #AAA;
    font-size: 40px;
    font-weight: lighter;
    margin-bottom: 2px;
    color: #222;
}

div.sd
{
    font-family: Raleway;
    margin: 0 auto;
	padding: 20px 5px;
	text-align: right;
}

div.sd a
{
    color: #FFF;
    text-decoration: none;
    font: 20px Raleway;
    margin: 0px 10px;
    padding: 10px 10px;
    position: relative;
    z-index: 0;
    cursor: pointer;
}

.black
{
    background: #222;
}
/* Circle behind */
div.circleBehind a:before, div.circleBehind a:after
{
    position: absolute;
    top: 22px;
    left: 50%;
    width: 50px;
    height: 50px;
    border: 4px solid #4e4d4d;
    transform: translateX(-50%) translateY(-50%) scale(0.8);
    border-radius: 50%;
    background: transparent;
    content: "";
    opacity: 0;
    transition: all 0.3s;
    z-index: -1;
}

div.circleBehind a:after
{
    border-width: 2px;
    transition: all 0.4s;
}

div.circleBehind a:hover:before
{
    opacity: 1;
    transform: translateX(-50%) translateY(-50%) scale(1);
}

div.circleBehind a:hover:after
{
    opacity: 1;
    transform: translateX(-50%) translateY(-50%) scale(1.3);
}
</style>
<header>
    
  <div class="sd black circleBehind">
      <a href="index.jsp">Home</a>
  <a href="moviesAll.jsp">ALL Movies</a>
  <a href="about.jsp">About Us</a>
  <% if(session.getAttribute("role") == "Admin" ){
        out.println("<a href='Adashboard.jsp'>Control Panel</a>");
      }else if(session.getAttribute("role") == "User"){
           out.println("<a href='uBoard.jsp'>Dashboard</a>");
    }
      %>
  <% if (session.getAttribute("email") == null){
            out.println("<a href='LoginRegis.jsp'>Sign In</a>");
        }else{
          out.println("<a href='index.jsp'>"); 
          out.println(String.valueOf(session.getAttribute("email")));
          out.print("</a>");
    }%>
    <a href="logout.jsp"><% if (session.getAttribute("email") == null){
            out.println("");
        }else{
            out.println("Logout");
    }%></a>
    
</div>
</header>
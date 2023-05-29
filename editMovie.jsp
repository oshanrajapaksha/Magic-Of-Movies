<%@page import="jv.Movies"%>
<%@page import="DatAcc.MovieDataAccess"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Movie Information</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <style>
            .dd{
                border: 1px transparent;
                width: 90%;
                height: 90%;
                margin-top: auto;
                margin-bottom: auto;
                margin: auto;
            }
        </style>
    </head>
    <body><%@include file="header.jsp" %><br><h1>Edit Movie details</h1><% 

        int id = Integer.parseInt(request.getParameter("mid"));
        Movies mov = new Movies();
        MovieDataAccess dta = new MovieDataAccess();
        mov = dta.getMovieData(id);
        session.setAttribute("mid", id);
        
        %>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
        <div class="dd">
            <form action="editMovieRecord" method="post" enctype="multipart/form-data">
  <div class="form-group md-6">
      <label for="formGroupExampleInput" >Movie Name</label>
      <input type="hidden" name="mid" value="<%=id%>">
    <input type="disable" class="form-control" name="mName" id="formGroupExampleInput" value="<%=mov.getName()%>">
  </div><br>
  <div class="form-group">
    <label for="formGroupExampleInput2">Ticket Price</label>
    <input type="number" class="form-control" name="tPrice" value="<%=mov.getTicket_price()%>">
  </div><br>
   <div class="form-group">
    <label for="formGroupExampleInput2">Expire Date</label>
    <input type="date" class="form-control" name="eDate">
  </div><br>
  <div class="form-row">
    <label class="col">Watch Hours</label>
   
       <div class="col"> <input type="text" name="WHrs" class="form-control" placeholder="Hours"></div><div class="col">
    <input type="text" name="WMin" style="flex: 1" class="form-control" placeholder="Minutes"></div>
    
    </div><br>
    <div class="form-group">
    <label for="formGroupExampleInput2">Director</label>
    <input type="text" class="form-control" name="direc" value="<%=mov.getDirector()%>" id="formGroupExampleInput2">
  </div><br>
   
                <div class="col-md-6">
                 <label class="form-label">Category</label>
                 
                 <div class="dropdown">
  <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="true">
    Choose Category
  </button>
        <ul class="dropdown-menu" style="overflow: hidden;">
    <li><a class="dropdown-item"><input type="hidden" name="category" value="Action">Action</a></li>
    <li><a class="dropdown-item"><input type="hidden" name="category" value="Adventure">Adventure</a></li>
    <li><a class="dropdown-item"><input type="hidden" name="category" value="Comedy">Comedy</a></li>
    <li><a class="dropdown-item"><input type="hidden" name="category" value="Fantasy">Fantasy</a></li>
    <li><a class="dropdown-item"><input type="hidden" name="category" value="Crime">Crime</a></li>
    <li><a class="dropdown-item"><input type="hidden" name="category" value="Horror">Horror</a></li>
    <li><a class="dropdown-item"><input type="hidden" name="category" value="Romance">Romance</a></li>
    <li><a class="dropdown-item"><input type="hidden" name="category" value="Science Fiction">Science Fiction</a></li>
    <li><a class="dropdown-item"><input type="hidden" name="category" value="Documentary">Documentary</a></li>
    <li><a class="dropdown-item"><input type="hidden" name="category" value="Drama">Drama</a></li>
    <li><a class="dropdown-item"><input type="hidden" name="category" value="Animation">Animation</a></li>
    <li><a class="dropdown-item"><input type="hidden" name="category" value="Thriller">Thriller</a></li>
    <li><a class="dropdown-item"><input type="hidden" name="category" value="War">War</a></li>
    <li><a class="dropdown-item"><input type="hidden" name="category" value="Mystery">Mystery</a></li>
  </ul>
</div></div><br>
       <div class="form-group">
    <label for="formGroupExampleInput2">IMBD Scroe</label>
    <input type="text" value="<%=mov.getImbd_rate()%>" class="form-control" name="imbd">
  </div>  <br>
                <div class="form-group">
    <label for="formGroupExampleInput2">Rotten Tomatoes</label>
    <input type="text" class="form-control" value="<%=mov.getRott_rate()%>" name="rott">
  </div><br>
                <div class="mb-3">
  <label for="exampleFormControlTextarea1" class="form-label">Movie Description</label>
  <textarea class="form-control" type="text" style="resize: none;height: 140px;" value="<%=mov.getMov_desc()%>" name="mov_desc"></textarea>
</div><br>
                <div class="col-md-6">
    <label class="form-label">Choose a thumbnail</label>
    <input style="width: 100%;" type="file" name="thumb2" class="form-control">
  </div><br>
                <div class="d-grid gap-2">
      <button class="btn btn-primary" name="addUMovie" type="submit">Submit</button>
    
  </div><br>
</form></div>
    </body>
</html>

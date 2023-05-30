
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <style>
/* Chrome, Safari, Edge, Opera */
.num::-webkit-outer-spin-button,
.num::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
}
</style>
        <title>Add New Movie</title>
    </head>
    <body>
        <%@include file="header.jsp"%><h1> Add New Movie</h1><br>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
        <style>.t{
            top: 65%;
}</style>
        <div class="position-absolute t start-50 translate-middle">
        <div style="width: 700px;
  height: 750px;
  border: 1px transparent;
  padding: 20px;top: 0%;
  margin: 0 auto;
  display: flex;
  justify-content: center;
  align-items: center;">
            <br><form action="AddNewMovieU" method="post" enctype="multipart/form-data" class="row g-3">
  <div class="col-md-6">
    <label class="form-label">Movie Name</label>
    <input type="text" name="Mname" class="form-control"  placeholder="Interstellar">
  </div>
  <div class="col-md-6">
    <label class="form-label">Ticket Price</label>
    
    
    <div class="input-group mb-3">
  <span class="input-group-text">LKR</span>
  <input type="number" class="form-control num" name="tprice" aria-label="Amount (to the nearest dollar)">
  <span class="input-group-text">.00</span>
</div>
    
    
    
  </div>
  <div style="width: 250px" class="col-12">
    <label class="form-label">Expire Date</label>
    <input type="date" name="ExDate" class="form-control">
  </div>
  
                <div class="col-md-6" style="float: right;">
    <label class="form-label">Watch Hours</label>
    <div style="display: flex;">
        <input type="text" name="WHrs" style="flex: 1;width: 10%;margin-right: 4px;" class="form-control p-2 g-col-6" placeholder="Hours">
    <input type="text" name="WMin" style="flex: 1" class="form-control p-2 g-col-6 " placeholder="Minutes">
    </div>
    </div>
  <div class="col-md-6">
    <label class="form-label">Director</label>
    <input type="text" name="direc" class="form-control">
  </div>
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
</div>
  </div>
  <div class="col-md-6">
    <label class="form-label">IMBD Score</label>
    <input type="text" name="imbd" class="form-control">
  </div>
  <div class="col-md-6">
    <label class="form-label">Rotten Tomatoes</label>
    <input type="text" name="rott" class="form-control">
  </div>
  <div class="mb-3">
  <label for="exampleFormControlTextarea1" class="form-label">Movie Description</label>
  <textarea class="form-control" type="text" style="resize: none;height: 140px;" name="mov_desc" id="exampleFormControlTextarea1" rows="3"></textarea>
</div>
  <div class="col-md-6">
    <label class="form-label">Choose a thumbnail</label>
    <input style="width: 100%;" type="file" name="thumb" class="form-control">
  </div>
            <br>
  
                <div class="d-grid gap-2">
      <button class="btn btn-primary" name="addMovie" type="submit">Submit</button>
    
  </div>
</form>
            </div>
        </div>
    </body>
</html>

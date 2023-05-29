
package Servlets;

import DatAcc.MovieDataAccess;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.time.LocalDate;
import jv.Movies;

@MultipartConfig
@WebServlet("/editMovieRecord")
public class editMovieRecord extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        
                
        
        if(req.getParameter("addUMovie") != null){
            MovieDataAccess movData = new MovieDataAccess();
            Movies movie1 = new Movies();
            
            LocalDate currDate = LocalDate.now();
            
                Part file = req.getPart("thumb2");
                String imageName = file.getSubmittedFileName();
                String imagePath = "C:/Users/user/Desktop/New folder (3)/WebApplication1/web/Thumbs/"+imageName;
                
                try{
                    FileOutputStream fos = new FileOutputStream(imagePath);
                    InputStream is = file.getInputStream();
                
                    byte[] data = new byte[is.available()];
                    is.read(data);
                    fos.write(data);
                    fos.close();
                }catch(IOException e){
                       System.out.println(e.getMessage());
                }
                
                
                movie1.setM_id(Integer.parseInt(req.getParameter("mid")));
                movie1.setName(req.getParameter("mName"));
                movie1.setExpire_time(String.valueOf(req.getParameter("eDate")));
                movie1.setTime_inserted(String.valueOf(currDate));
                movie1.setTicket_price(Double.parseDouble(req.getParameter("tPrice")));
                String watch_hrs = req.getParameter("WHrs") + "h " + req.getParameter("WMin")+"m";
                movie1.setWatch_hrs(watch_hrs);
                movie1.setDirector(req.getParameter("direc"));
                movie1.setCategory(req.getParameter("category"));
                movie1.setImbd_rate(req.getParameter("imbd")+"/10");
                movie1.setRott_rate(req.getParameter("rott")+"%");
                movie1.setThumb(imageName);
                movie1.setMov_desc(req.getParameter("mov_desc"));
                
                
                if(movData.updateMoviesRecord(movie1) > 0){
                    resp.sendRedirect("editDetails.jsp");
                }else{
                    out.print("nathooo");
                }
        }else{
            out.print("noooooooo");
            out.println();
        }
    }
}

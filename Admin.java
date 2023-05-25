package jv;
import DatAcc.MovieDataAccess;
import java.sql.Date;

public class Admin extends User{
    public String userRole;

    public Admin(){
        super();
    }

    public Admin(String email, String name, Date dob, String address, String password, String profPic) {
        super(email, name, dob, address, password, profPic);
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole){
        this.userRole = userRole;
    }
    
    public int insertNewMovieDetails(Movies movie) {
                int numRows;
		MovieDataAccess movieDat = new MovieDataAccess();
		numRows = movieDat.insertMoviesRecord(movie);
		return numRows;
	}
    
    public int updateMovieDetails(Movies movie) {
        int numRows;
        MovieDataAccess movieDat = new MovieDataAccess();
        numRows = movieDat.updateMoviesRecord(movie);
        return numRows;
    }
    
    public int deleteMovieDetails(Movies movie) {
        int numRows;
        MovieDataAccess movieDat = new MovieDataAccess();
        numRows = movieDat.deleteMoviesRecord(movie);
        return numRows;
    }
}
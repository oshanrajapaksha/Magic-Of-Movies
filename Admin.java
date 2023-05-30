package jv;
import DatAcc.MovieDataAccess;
import DatAcc.UserDatAcc;


public class Admin extends User{
    public String userRole;

    public Admin(){
        super();
    }

    public Admin(String email, String name, String dob, String address, String password, String profPic,String role, String adMsg) {
        super(email, name, dob, address, password, profPic, role, adMsg);
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
    
    public int makeAdmin(String uEmail){
        int numRows;
        
        UserDatAcc data = new UserDatAcc();
        
        numRows = data.upgradeUserToAnAdmin(uEmail);
        
        return numRows;
    }
}
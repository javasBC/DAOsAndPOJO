package DAO;

import POJO.MoviesPOJO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MoviesDAO {
    String url = "C:\\Users\\IITC\\Desktop\\DB\\movie.db";
    List<MoviesPOJO> moviesPOJOList = new ArrayList<>();
    SqliteConnection sqliteConnection = new SqliteConnection();
    Connection connection = sqliteConnection.getConnection(url);
    Statement stm = sqliteConnection.getStatement();

    public List<MoviesPOJO> getAllMovies() {
        try {
            ResultSet result = stm.executeQuery
                    ("SELECT * FROM Movies");
            while (result.next()) {
                moviesPOJOList.add(new MoviesPOJO
                        (result.getInt("id"),
                                result.getString("title")
                                , result.getInt("len")
                                , result.getInt("year")
                                , result.getLong("cost")
                                , result.getString("genre")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return moviesPOJOList;
    }

    public MoviesPOJO getMovieById(int id) {
        MoviesPOJO movie1=null;
        try {
            var result = stm.executeQuery
                    ("SELECT * FROM Movies WHERE id=" + id);
            result.next();
            movie1=new MoviesPOJO(result.getInt("id")
                    ,result.getString("title")
                    ,result.getInt("len")
                    ,result.getInt("year")
                    ,result.getLong("cost")
                    ,result.getString("genre"));


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movie1;
    }

    public boolean removeMovie(int id){
        int res=0;
        try {
            res=stm.executeUpdate("DELETE from Movies WHERE id = "+id);
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        //if (res==0)
        //    return false;
        //else
        //    return true;
        //int x = 13%2==0 ? 12:13;
        return (res ==0?false:true) ;
    }

    public boolean addMovie(MoviesPOJO movie){
        int result=0;
        try {
            result=stm.executeUpdate("INSERT INTO Movies (title,len,year,cost,genre) " +
                                                    "VALUES " +
                    "(\""+movie.title+"\","+movie.len+","+movie.year+","+movie.cost+",\""+movie.genre+"\")");
        } catch (SQLException e) {
            System.out.println("please be more aware !!!!!!!!");
        }
        return  result==0?false:true;
    }

    public boolean updateMovie(MoviesPOJO movies,int id){
        int x= 0;
        try {
            x=stm.executeUpdate("UPDATE Movies SET title= \""+movies.title+"\", cost="+ movies.cost+"" +
                    ",year="+movies.year+", len ="+movies.len+" , genre=\""+movies.genre+"\"" +
                    "where id="+id+"");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return x!=0;
    }

}

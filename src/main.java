import java.sql.*;
import java.util.Scanner;

import DAO.MoviesDAO;
import POJO.MoviesPOJO;
import SqliteConnection.*;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       MoviesDAO m = new MoviesDAO();
       //System.out.println("please enter id ");
       //int id = scanner.nextInt();

       //System.out.println(m.getMovieById(id));

        //System.out.println("please enter id to delete ");
        //int id1 = scanner.nextInt();
        //System.out.println(m.removeMovie(id1));

        MoviesPOJO movieInput=new MoviesPOJO();

        System.out.println(m.addMovie(movieInput));

//update
        var movieList= m.getAllMovies();
        for(var movie : movieList){
            System.out.println(movie);
        }

        MoviesPOJO movieInput2=new MoviesPOJO();
        System.out.println("witch movie you want modify");
        int idToMod= scanner.nextInt();

        System.out.println("please enter movie title");
        movieInput2.title=scanner.next();
        System.out.println("please enter movie len");
        movieInput2.len=scanner.nextInt();
        System.out.println("please enter the year");
        movieInput2.year=scanner.nextInt();
        System.out.println("please enter the cost");
        movieInput2.cost=scanner.nextLong();
        System.out.println("please enter the genre");
        movieInput2.genre=scanner.next();
        m.updateMovie(movieInput2,idToMod);

//add
        System.out.println("please enter movie title");
        movieInput.title=scanner.next();
        System.out.println("please enter movie len");
        movieInput.len=scanner.nextInt();
        System.out.println("please enter the year");
        movieInput.year=scanner.nextInt();
        System.out.println("please enter the cost");
        movieInput.cost=scanner.nextLong();
        System.out.println("please enter the genre");
        movieInput.genre=scanner.next();


    }
}

package SqliteConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Actors {
    public static void showActors() {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection
                    ("jdbc:sqlite:C:\\Users\\IITC\\Desktop\\DB\\movie.db");//db db3 sql sql3
            System.out.println("Done!!");
            Statement stm = connection.createStatement();

            ResultSet result = stm.executeQuery("SELECT * FROM Actors");
            //[{key: value}.{}.{}]
            while (result.next()) {
                System.out.println(
                        "id = " + result.getInt("id") +
                         "\n name = " + result.getString("name") +
                         "\n birthDate = " + result.getInt("birthDate") +
                         "\n firstMovie = " + result.getInt("firstMovie") +
                         "\n cityOfBirth = " + result.getLong("cityOfBirth") +
                         "\n isMarried = " + result.getString("isMarried") +
                         "\n ///////////////////////////////////////////////////////////"
                );
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

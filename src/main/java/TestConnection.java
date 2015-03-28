import java.sql.*;
import java.util.ArrayList;

public class TestConnection {
    // Класс java.sql.Connection представляет в JDBC сеанс работы с базой данных.
    // Предоставляет приложению объекты Statement (PrepareStatement) для  сеанса.
    private static Connection conn = null;

    //Доступ к БД: Login/Password/URL
    private static String LOGIN = "root";
    private static String PASSWORD = "root";
    private static String URL = "jdbc:mysql://localhost:3306/mydbtest";

    public static void main(String[] args) {

        try {
            /** Загрузка Драйвера JDBC */
            //1й способ
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //2й способ
//          DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //3й способ
//          Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, LOGIN, PASSWORD);

            // Statement
            Statement stat = conn.createStatement();
            ResultSet resultSets = stat.executeQuery("SELECT * FROM account");

            while (resultSets.next()) {
                System.out.print(resultSets.getInt("id") + " ");
                System.out.print(resultSets.getString("login") + " ");
                System.out.print(resultSets.getString("password") + " ");
                System.out.println("");
            }


            if (resultSets != null) resultSets.close();
            if (stat != null) stat.close();
            close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}

import java.sql.*;

public class TestConnectionTryResourse {

    //Доступ к БД: Login/Password/URL
    private static String LOGIN = "root";
    private static String PASSWORD = "root";
    private static String URL = "jdbc:mysql://localhost:3306/mydbtest";


    public static void main(String[] args) throws SQLException {

        DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        try (Connection conn = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement stmt = conn.createStatement()) {

            try(ResultSet resultSets = stmt.executeQuery("SELECT * FROM account")){
                while (resultSets.next()) {
                    System.out.print(resultSets.getInt("id") + " ");
                    System.out.print(resultSets.getString("login") + " ");
                    System.out.print(resultSets.getString("password") + " ");
                    System.out.println("");
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}

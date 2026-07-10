import java.sql.*;

public class TestConnection {
    public static void main(String[] args) {

        try {

            Connection con = DatabaseConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs =
                    st.executeQuery("SELECT * FROM students");

            while(rs.next()) {

                System.out.println(
                        rs.getInt("id") + " "
                        + rs.getString("name") + " "
                        + rs.getInt("age") + " "
                        + rs.getString("department")
                );

            }

            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
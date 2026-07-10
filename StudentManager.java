import java.sql.*;

public class StudentManager {

    // ADD STUDENT
    public void addStudent(Student student) {
        try {
            Connection con = DatabaseConnection.getConnection();

            String sql =
                    "INSERT INTO students VALUES (?, ?, ?, ?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getAge());
            ps.setString(4, student.getDepartment());

            ps.executeUpdate();

            System.out.println("Student Added Successfully!");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DISPLAY ALL STUDENTS
    public void displayStudents() {
        try {

            Connection con =
                    DatabaseConnection.getConnection();

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery("SELECT * FROM students");

            while (rs.next()) {

                System.out.println(
                        "ID: " + rs.getInt("id")
                                + ", Name: " + rs.getString("name")
                                + ", Age: " + rs.getInt("age")
                                + ", Department: " + rs.getString("department")
                );
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // SEARCH STUDENT
    public void searchStudent(int id) {
        try {

            Connection con =
                    DatabaseConnection.getConnection();

            String sql =
                    "SELECT * FROM students WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println(
                        "ID: " + rs.getInt("id")
                                + ", Name: " + rs.getString("name")
                                + ", Age: " + rs.getInt("age")
                                + ", Department: " + rs.getString("department")
                );

            } else {
                System.out.println("Student not found.");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE STUDENT
    public void updateStudent(
            int id,
            String name,
            int age,
            String department) {

        try {

            Connection con =
                    DatabaseConnection.getConnection();

            String sql =
                    "UPDATE students SET name=?, age=?, department=? WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, department);
            ps.setInt(4, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Updated.");
            } else {
                System.out.println("Student not found.");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE STUDENT
    public void deleteStudent(int id) {

        try {

            Connection con =
                    DatabaseConnection.getConnection();

            String sql =
                    "DELETE FROM students WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Deleted.");
            } else {
                System.out.println("Student not found.");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
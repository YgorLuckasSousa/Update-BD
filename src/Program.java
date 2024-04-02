import java.sql.*;



public class Program {
    public static void main(String[] args) {

        Connection conn;
        PreparedStatement st = null;

        try {
            conn = DB.getConn();
            st = conn.prepareStatement(
                    "" +
                            " SET BaseSalary = BaseSalary + ?" +
                            " WHERE " +
                            "(DepartmentId = ?)");

            st.setDouble(1, 350);
            st.setInt(2, 4);

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Rows affected: " + rowsAffected);
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
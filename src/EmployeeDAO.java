import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeDAO
{
    public static void insertData(int employeeId, String employeeName, String employeeEmail,long employeeSalary, int employeedeptid) {

        try {

            Connection conObj = DBConnection.establishConnection();

            String query = "insert into employees values(?,?,?,?,?)";
            PreparedStatement stmt = conObj.prepareStatement(query);

            stmt.setInt(1, employeeId);
            stmt.setString(2, employeeName);
            stmt.setString(3, employeeEmail);
            stmt.setLong(4, employeeSalary);
            stmt.setInt(5, employeedeptid);



            int count = stmt.executeUpdate();

            System.out.println("insertion Successful");
            System.out.println(count + " : Rows Inserted");

            conObj.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

public static void updateData (int employeeId, long employeeSalary) {
    try {

        Connection conObj = DBConnection.establishConnection();

        String query = "update employees set salary = ? where emp_id = ?;";

        PreparedStatement stmt = conObj.prepareStatement(query);
        stmt.setLong(1, employeeSalary);
        stmt.setInt(2, employeeId);

        int count = stmt.executeUpdate();

        System.out.println("Updation Successful");
        System.out.println(count + " : Rows Updated");

        conObj.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public static void deleteData(int employeeId) {

        try {
            Connection conObj = DBConnection.establishConnection();

            String query = "delete from employees where id =?;";

            PreparedStatement stmt = conObj.prepareStatement(query);
            stmt.setInt(1, employeeId);

            int count = stmt.executeUpdate();

            System.out.println("Deletion  Successful");
            System.out.println(count + " : Rows Deleted");

            conObj.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void selectData(int employeeId) {

        try {
            Connection conObj = DBConnection.establishConnection();

            String query = "select * from employees where id = ?;";

            PreparedStatement stmt = conObj.prepareStatement(query);
            stmt.setInt(1, employeeId);

            ResultSet rs = stmt.executeQuery();



            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  ");
                System.out.println(rs.getString(2) + "  ");
                System.out.println(rs.getString(3) + "  ");
                System.out.println(rs.getInt(4) + "  ");
            }

            System.out.println("Selection  Successful");

            conObj.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

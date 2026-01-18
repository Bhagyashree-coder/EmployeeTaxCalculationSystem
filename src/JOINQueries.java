import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JOINQueries
{

    public static void join()
    {

        try {
            Connection conObj = DBConnection.establishConnection();

            String query = "  SELECT e.emp_id, e.name, d.dept_name, e.salary, t.tax_amount, t.financial_year\n" +
                    "    FROM employees e\n" +
                    "    JOIN departments d ON e.dept_id = d.dept_id\n" +
                    "    JOIN taxes t ON e.emp_id = t.emp_id;";

            PreparedStatement stmt = conObj.prepareStatement(query);


            ResultSet rs = stmt.executeQuery();

            while(rs.next())
            {
                System.out.print(rs.getInt(1)+"   ");
                System.out.print(rs.getString(2)+"   ");
                System.out.print(rs.getString(3)+"   ");
                System.out.print(rs.getLong(4)+"   ");
                System.out.print(rs.getDouble(5)+"   ");
                System.out.print(rs.getString(6)+"   ");


            }



            conObj.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TaxDAO {


    public static void calculateTax(int employeeId,String employee_Financial_Year) {
        try {

            Connection conObj = DBConnection.establishConnection();


            String query = "select salary from employees where emp_id = ?";

            PreparedStatement stmt = conObj.prepareStatement(query);
            stmt.setInt(1, employeeId);

            ResultSet rs = stmt.executeQuery();
            rs.next();
            long sal = rs.getInt("salary");

            double tax;

            if(sal <= 250000)
                tax = 0;
            else if(sal <= 500000)
                tax = sal * 0.05;
            else if(sal<= 1000000)
                tax = sal * 0.20;
            else
                tax = sal * 0.30;


System.out.println("Calculated Tax :  "+tax);
            String  queryForStoringTax = "insert into taxes  values(seq_tax_id.nextval,?,?,?)";

          PreparedStatement stmt2 = conObj.prepareStatement(queryForStoringTax);

          //It needs variables while defining parameters . And if we provide sequence name
            // then java dont know the sequence because it is not any variable , database knowswhat it is .
            //So let databae handle it.

          stmt2.setInt(1,employeeId);
            stmt2.setDouble(2,tax);
            stmt2.setString(3,employee_Financial_Year);


          int count  = stmt2.executeUpdate();


          conObj.close();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

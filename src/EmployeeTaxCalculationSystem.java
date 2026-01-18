import java.util.Scanner;

class EmployeeTaxCalculationSystem
{
public static void main(String ar[])
{
int input;
        do {
                System.out.println("1 : Add Employee.");
            System.out.println("2 : View Employees.");
            System.out.println("3 : Update Employee details.");
            System.out.println("4 : Delete Employee.");
            System.out.println("5 : Calculate and store Tax.");
            System.out.println("6 : Exit");


           Scanner scan = new Scanner(System.in);
           System.out.println("Enter operation : ");
           input = scan.nextInt();

           Employees emp = new Employees();
           Taxes tax = new Taxes();



            switch (input) {
             case 1:
               System.out.println("Enter Employee Id : ");
                emp.emp_id= scan.nextInt();

                    System.out.println("Enter employee name : ");
                 emp.name = scan.next();

                    System.out.println("Enter employee's email : ");
                 emp.email = scan.next();

                   System.out.println("Enter student's  salary : ");
                 emp.salary = scan.nextLong();


                    System.out.println("Enter dept id for employees table : ");
                  emp.dept_id = scan.nextInt();


                  EmployeeDAO.insertData(emp.emp_id, emp.name, emp.email, emp.salary,emp.dept_id);
                    break;

                            case 2:


                                System.out.println("Enter employee id for Selection : ");
                                emp.emp_id = scan.nextInt();

                                EmployeeDAO.selectData(emp.emp_id);
                                break;

                case 3:

                    System.out.println("Enter employee id for Updation : ");
                    emp.emp_id = scan.nextInt();

                    System.out.println("Enter employee salary  for Updation : ");
                    emp.salary = scan.nextLong();

                    EmployeeDAO.updateData(emp.emp_id, emp.salary);
                    break;



                case 4:


                    System.out.println("Enter course id for Deletion : ");
                    emp.emp_id = scan.nextInt();

                    EmployeeDAO.deleteData(emp.emp_id);
                    break;


                case 5:



                    System.out.println("Enter employee id to calculate tax and store tax : ");
                    emp.emp_id = scan.nextInt();

                    System.out.println("Enter year  to calculate tax and store tax : ");
                    tax.financial_year = scan.next();


                    TaxDAO.calculateTax(emp.emp_id,tax.financial_year);
                    break;


                    default:
                    System.out.println("No operation selected to perform.");
                    break;

            }
                    } while (input < 6);
        }
}
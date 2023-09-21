package hibernateCRUD;

 
 import dao.DaoImpFactoryHbm;
 
public class EmployeeCrudFactoryHbm {

	public static void main(String[] args) {

		{
 

			DaoImpFactoryHbm ME = new DaoImpFactoryHbm();

			/* Add a few Employee records in the database */
			ME.addEmployee("hibernate", "haouari", 999);
			ME.addEmployee("employee", "hosni", 666);
			ME.addEmployee("hbm", "princes", 7777);
			
			ME.listEmployees();
			
			
			 // List down all the Employees 
			  
			 // Update Employee's records 
			  ME.updateEmployee(3,880);
			  
			 // Delete an Employee from the database
			  ME.deleteEmployee(1);
			  
			 // list down new list of Employees
			  ME.listEmployees();
			 

		}
	}

}
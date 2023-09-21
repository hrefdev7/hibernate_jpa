package hibernateCRUD;

 
 import java.util.Date;

import dao.DaoImpFactoryAnnotationFactory;
import dao.DaoImpJavaConfigFactory;
 
public class Employee1CrudJavaConfigFactory {

	public static void main(String[] args) {

		{
 

			DaoImpJavaConfigFactory ME = new DaoImpJavaConfigFactory();

			/* Add a few Employee1 records in the database */
			ME.addEmployee1("MOOOOOO", "haouari", new Date());
			ME.addEmployee1("saOOOOOOOOOOmi", "VOLEUR", new Date());
			ME.addEmployee1("javaconfig", "factory", new Date());
			
			ME.listEmployee1s();
			
			
			 // List down all the Employee1s 
			  
				/*
				 * // Update Employee1's records ME.updateEmployee1(24,"Manager");
				 * 
				 * // Delete an Employee1 from the database ME.deleteEmployee1(19);
				 */
			  
			 // list down new list of Employee1s
			  ME.listEmployee1s();
			 

		}
	}

}
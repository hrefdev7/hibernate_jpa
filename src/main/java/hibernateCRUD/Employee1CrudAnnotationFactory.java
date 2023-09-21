package hibernateCRUD;

 
 import java.util.Date;

import dao.DaoImpFactoryAnnotationFactory;
 
public class Employee1CrudAnnotationFactory {

	public static void main(String[] args) {

		{
 

			DaoImpFactoryAnnotationFactory ME = new DaoImpFactoryAnnotationFactory();

			/* Add a few Employee1 records in the database */
			ME.addEmployee1("achref", "haouari", new Date());
			ME.addEmployee1("FactoryAnnotation", "Factory", new Date());
			ME.addEmployee1("jpa", "annotation", new Date());
			
			ME.listEmployee1s();
			
			
			 // List down all the Employee1s 
			  
			 // Update Employee1's records 
			  ME.updateEmployee1(24,"Manager");
			  
			 // Delete an Employee1 from the database
			  ME.deleteEmployee1(19);
			  
			 // list down new list of Employee1s
			  ME.listEmployee1s();
			 

		}
	}

}
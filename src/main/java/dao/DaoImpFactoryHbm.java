package dao;



import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Employee;
import hibernateUtil.HibernateUtil;
 

/**
* @author Achref Hawari
 *
 */
public class DaoImpFactoryHbm {	 
	static SessionFactory sessionFactory;
	
 	  //**************************************Method Ajouter an employee from the records **************************************


	public void addEmployee(String fname, String lname, int salary) {
		
		sessionFactory = HibernateUtil.getSessionFactoryHbm();//connection base donnee
		Session session = sessionFactory.openSession();//ouveerture d'une session

		Transaction tx = null;
		 
		try {
			tx = session.beginTransaction();
			Employee employee = new Employee(fname, lname, salary);
			session.save(employee);
			tx.commit();
			System.out.println("Employee records successfully persisted");
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

 
	 //**************************************lire la list employee *******************************************************************
	  
	  public void listEmployees( ){ 
		  
			sessionFactory = HibernateUtil.getSessionFactoryHbm();
			Session session = sessionFactory.openSession();
        Transaction tx = null;
	  
	  try {  
		  tx = session.beginTransaction(); 
	  List employees =  session.createQuery("FROM Employee").list(); 
	  for (Iterator iterator =  employees.iterator();
			  iterator.hasNext();)
	  { Employee employee = (Employee)
	  iterator.next(); 
	  System.out.print("First Name: " + employee.getFirstName());
	  System.out.print("  Last Name: " + employee.getLastName());
	  System.out.println("  Salary: " + employee.getSalary()); }
	  tx.commit();
		System.out.println("Employee records successfully listed");
	  
	  }
	  
	  catch (HibernateException e) 
	  { if (tx!=null) tx.rollback();
	  e.printStackTrace(); } 
	  finally { session.close(); } 
	  }
	  
	  
	// ************************************** Method to UPDATE salary for an employee ************************************************* 
	  
	  public void updateEmployee(Integer  EmployeeID, int salary )
	  	  { 
			sessionFactory = HibernateUtil.getSessionFactoryHbm();
			Session session = sessionFactory.openSession();
	  Transaction tx = null;	  
	  try { 
		  tx = session.beginTransaction();
	  Employee employee = (Employee)session.get(Employee.class, EmployeeID);
	  employee.setSalary( salary ); 
	  session.update(employee); tx.commit();
		System.out.println("Employee records successfully updated");

	  } 
	  catch (HibernateException e) { 
		  if (tx!=null) tx.rollback(); e.printStackTrace(); } 
	  finally { session.close(); 
	  }
	  }
	  
 
	  //**************************************Method to DELETE an employee from the records  ******************************************
	  
	  public void  deleteEmployee(Integer EmployeeID)  {	
		
		Session session = HibernateUtil.getSessionFactoryHbm().openSession();
	  Transaction tx = null;
	   Employee employee =  (Employee)session.get(Employee.class, EmployeeID); 
	  try { 
		  tx = session.beginTransaction();
		  if (employee != null) {
			  session.delete(employee);
				System.out.println("Employee records successfully deleted");
 
			}
		  else{  
		        System.out.println("Employee records néxiste pas");  
		    }  
	  tx.commit(); } 
	  catch (HibernateException e)
	  { if (tx!=null) tx.rollback();
	  e.printStackTrace(); } 
	  finally { session.close(); } }	  
	  
		  
	  //**************************************Method to afficher an employee from the id  ***************************************************************
	  //**************************************Method to afficher List employee   ***************************************************************

	 
	  
}

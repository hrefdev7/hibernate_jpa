package dao;



import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Employee1;
import hibernateUtil.HibernateUtil;
 

/**
* @author Achref Hawari
 *
 */
public class DaoImpFactoryAnnotationFactory {	 
	static SessionFactory sessionFactory;
	
 	  //**************************************Method Ajouter an Employee1 from the records **************************************


	public void addEmployee1(String name, String role, Date insertTime) {
		
		sessionFactory = HibernateUtil.getSessionAnnotationFactory();
		Session session = sessionFactory.openSession();

		Transaction tx = null;
		 
		try {
			tx = session.beginTransaction();
			Employee1 Employee1 = new Employee1(name, role,insertTime);
			session.save(Employee1);
			tx.commit();
			System.out.println("Employee1 records successfully persisted");
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

 
	 //**************************************lire la list Employee1 *******************************************************************
	  
	  public void listEmployee1s( ){ 
		  
			sessionFactory = HibernateUtil.getSessionAnnotationFactory();
			Session session = sessionFactory.openSession();
        Transaction tx = null;
	  
	  try {  
		  tx = session.beginTransaction(); 
	  List Employee1s =  session.createQuery("FROM Employee1").list(); 
	  for (Iterator iterator =  Employee1s.iterator();
			  iterator.hasNext();)
	  { Employee1 Employee1 = (Employee1) iterator.next(); 
	  System.out.print("First Name: " + Employee1.getName());
	  System.out.print("  Last Name: " + Employee1.getRole());
	  System.out.println("  Salary: " + Employee1.getInsertTime()); }
	  tx.commit();
		System.out.println("Employee1 records successfully listed");
	  
	  }
	  
	  catch (HibernateException e) 
	  { if (tx!=null) tx.rollback();
	  e.printStackTrace(); } 
	  finally { session.close(); } 
	  }
	  
	  
	// ************************************** Method to UPDATE salary for an Employee1 ************************************************* 
	  
	  public void updateEmployee1(Integer  Employee1ID, String role )
	  	  { 
			sessionFactory = HibernateUtil.getSessionFactoryHbm();
			Session session = sessionFactory.openSession();
	  Transaction tx = null;	  
	  try { 
		  tx = session.beginTransaction();
	  Employee1 Employee1 = (Employee1)session.get(Employee1.class, Employee1ID);
	  Employee1.setRole( role ); 
	  session.update(Employee1); tx.commit();
		System.out.println("Employee1 records successfully updated");

	  } 
	  catch (HibernateException e) { 
		  if (tx!=null) tx.rollback(); e.printStackTrace(); } 
	  finally { session.close(); 
	  }
	  }
	  
 
	  //**************************************Method to DELETE an Employee1 from the records  ******************************************
	  
	  public void  deleteEmployee1(Integer Employee1ID)  {	
		
		Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
	  Transaction tx = null;
	   Employee1 Employee1 =  (Employee1)session.get(Employee1.class, Employee1ID); 
	  try { 
		  tx = session.beginTransaction();
		  if (Employee1 != null) {
			  session.delete(Employee1);
				System.out.println("Employee1 records************************** successfully deleted");
 
			}
		  else{  
		        System.out.println("Employee1 records néxiste************************** pas");  
		    }  
	  tx.commit(); } 
	  catch (HibernateException e)
	  { if (tx!=null) tx.rollback();
	  e.printStackTrace(); } 
	  finally { session.close(); } }	  
	  
		  
	  //**************************************Method to afficher an Employee1 from the id  ***************************************************************
	  //**************************************Method to afficher List Employee1   ***************************************************************

	 
	  
}

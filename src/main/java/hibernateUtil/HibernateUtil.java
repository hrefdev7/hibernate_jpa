package hibernateUtil;


import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import entity.Employee1;

 
/**
* @author Achref Hawari
 *
 */



public class HibernateUtil {
	
	
	
	
	protected void setUp() throws Exception {  
	    // A SessionFactory is set up once for an application
	    sessionFactory = new Configuration()
	            .configure() // configures settings from hibernate.cfg.xml
	            .buildSessionFactory();
	}
	
	
	
    private static final String TIME_ZONE = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	//XML based configuration => HIBERNATE NATIVE
	private static SessionFactory sessionFactory;
	
	//Annotation JPA HIBERNATE
	private static SessionFactory sessionAnnotationFactory;
	
	// JAVACONFIGURATION TYPESTRUCTURE MAP
	private static SessionFactory sessionJavaConfigFactory;
	
	public static SessionFactory getSessionFactoryHbm() {//creation instance session fichier mapping -->declaration des attribut dans un fichier Xml
		if(sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
	
	public static SessionFactory getSessionAnnotationFactory() {//mapping -->declaration des attribut avec des annotaion JPA 
		if(sessionAnnotationFactory == null) sessionAnnotationFactory = buildSessionAnnotationFactory();
        return sessionAnnotationFactory;
    }
	
	public static SessionFactory getSessionJavaConfigFactory() {//mapping -->declaration des proprietes avec JAVA class
		if(sessionJavaConfigFactory == null) sessionJavaConfigFactory = buildSessionJavaConfigFactory();
        return sessionJavaConfigFactory;
    }

	
	//SServiceRegistry serviceRegistry  SINCE VERSION 4.1 OF HIBERNATE 
    private static SessionFactory buildSessionFactory() {
        try {
            // creation SessionFactory par le ficher de configuration hibernate.cfg.xml
        	Configuration configuration = new Configuration();
        	configuration.configure("hibernate.cfg.xml");
        	System.out.println("Configuration Hibernate chargée");
        	//SERVICE REGISTRY IS APPLIEED SINCE VERSION 4
        	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        	System.out.println("Hibernate serviceRegistry crée");
        	
        	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        	
            return sessionFactory;
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory buildSessionAnnotationFactory() {
    	try {
            // Create the SessionFactory from hibernate.cfg.xml
        	Configuration configuration = new Configuration();
        	configuration.configure("hibernate.cfg.xml");
        	System.out.println("Hibernate Annotation Configuration chargée avec succes");
        	
        	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        	System.out.println("Hibernate Annotation serviceRegistry crée");
        	
        	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        	
            return sessionFactory;
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
	}

    private static SessionFactory buildSessionJavaConfigFactory() {
    	try {
    	Configuration configuration = new Configuration();
    	 
		//Create Properties, can be read from property files too
		Properties proprties = new Properties();
		proprties.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		proprties.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/mydb2"+TIME_ZONE);
		proprties.put("hibernate.connection.username", "root");
		proprties.put("hibernate.connection.password", "href77**");
		//configuration.setProperty("hibernate.current_session_context_class", "thread");
		proprties.put("dialect", "org.hibernate.dialect.MySQLDialect");
		proprties.put("hibernate.hbm2ddl.auto", "update");
		proprties.put("show_sql", "true");
		proprties.put(" hibernate.connection.pool_size", "10");
		
		configuration.setProperties(proprties);
		
		//Deuxieme facon de mapper la class employee et la table employee dans la base de donnee
		// addClasss va rechercher la class annonté employee1
		
		configuration.addAnnotatedClass(Employee1.class);
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
    	System.out.println("Hibernate Java Config serviceRegistry created");
    	
    	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    	
        return sessionFactory;
    	}
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
	}
    
	
	
}

package evaluationSystemPG1.db;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import evaluationSystemPG1.abstracts.Option;
import evaluationSystemPG1.entities.Alternative;
import evaluationSystemPG1.entities.Question;
import evaluationSystemPG1.entities.Radiobutton;
import evaluationSystemPG1.entities.TextOption;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public static void initHibernate(File configFile){
	    	if( null == sessionFactory){
	    		AnnotationConfiguration annotationConfiguration = new AnnotationConfiguration()
	    												.addAnnotatedClass(Question.class)
	    												.addAnnotatedClass(Option.class)
	    												.addAnnotatedClass(TextOption.class)
	    												.addAnnotatedClass(Radiobutton.class)
	    												.addAnnotatedClass(Alternative.class)
	    												.configure(configFile);
	    		sessionFactory = annotationConfiguration.buildSessionFactory();
	    	}
	    }

	public static SessionFactory getSessionFactory(){
		
		return sessionFactory;
	}
	
	public static Session getSession(){
		
		return sessionFactory.openSession();
	}
}

package evaluationSystemPG1.db;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import evaluationSystemPG1.abstracts.Option;
import evaluationSystemPG1.entities.Label;
import evaluationSystemPG1.entities.CheckboxAnswerValue;
import evaluationSystemPG1.entities.CheckboxPanel;
import evaluationSystemPG1.entities.CheckboxPanelAnswer;
import evaluationSystemPG1.entities.Question;
import evaluationSystemPG1.entities.RadiobuttonPanel;
import evaluationSystemPG1.entities.RadiobuttonPanelAnswer;
import evaluationSystemPG1.entities.TextOption;
import evaluationSystemPG1.entities.TextOptionAnswer;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static Session session;
	public static void initHibernate(File configFile){
	    	if( null == sessionFactory){
	    		AnnotationConfiguration annotationConfiguration = new AnnotationConfiguration()
	    												.addAnnotatedClass(Question.class)
	    												.addAnnotatedClass(Option.class)
	    												.addAnnotatedClass(TextOptionAnswer.class)
	    												.addAnnotatedClass(RadiobuttonPanel.class)
	    												.addAnnotatedClass(RadiobuttonPanelAnswer.class)
	    												.addAnnotatedClass(Label.class)
	    												.addAnnotatedClass(CheckboxPanel.class)
	    												.addAnnotatedClass(CheckboxPanelAnswer.class)
	    												.addAnnotatedClass(CheckboxAnswerValue.class)
	    												.addAnnotatedClass(TextOption.class)	    												.addAnnotatedClass(CheckboxPanelAnswer.class)
	    												
	    												.configure(configFile);
	    		sessionFactory = annotationConfiguration.buildSessionFactory();
	    	}
	    }

	public static SessionFactory getSessionFactory(){
		
		return sessionFactory;
	}
	
	public static Session getSession(){
		if (session == null){
			session = sessionFactory.openSession();
		}
		return session;
		
	}
	public static void closeSession(){
		if (session != null){
			session.close();
		}
		session = null;
	};
}

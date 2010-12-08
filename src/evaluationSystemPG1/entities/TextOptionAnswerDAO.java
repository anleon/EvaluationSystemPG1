package evaluationSystemPG1.entities;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import evaluationSystemPG1.db.HibernateUtil;

public class TextOptionAnswerDAO {

	public static List<TextOptionAnswer> getAllTextOptions(){
		Session herbSession = HibernateUtil.getSession();
		herbSession.beginTransaction();

		Query query = herbSession.createQuery("from evaluationSystemPG1.entitys.TextOption");
//		Query query = herbSession.createCriteria("from se.kyh.guestbook.entities.Post");
		
		herbSession.getTransaction().commit();
		List<TextOptionAnswer> textOptions = query.list();

		return textOptions;
	}

	public static void saveOption(TextOptionAnswer textOption){
		Session herbSession = HibernateUtil.getSession();
		herbSession.beginTransaction();

		herbSession.save(textOption);
		
		herbSession.getTransaction().commit();
	}

}

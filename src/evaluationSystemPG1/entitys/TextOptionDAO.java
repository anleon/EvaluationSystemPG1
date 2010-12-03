package evaluationSystemPG1.entitys;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import evaluationSystemPG1.db.HibernateUtil;

public class TextOptionDAO {

	public static List<TextOption> getAllTextOptions(){
		Session herbSession = HibernateUtil.getSession();
		herbSession.beginTransaction();

		Query query = herbSession.createQuery("from evaluationSystemPG1.entitys.TextOption");
//		Query query = herbSession.createCriteria("from se.kyh.guestbook.entities.Post");
		
		herbSession.getTransaction().commit();
		List<TextOption> textOptions = query.list();

		return textOptions;
	}

	public static void saveOption(TextOption textOption){
		Session herbSession = HibernateUtil.getSession();
		herbSession.beginTransaction();

		herbSession.save(textOption);
		
		herbSession.getTransaction().commit();
	}

}

package evaluationSystemPG1.entitys;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import evaluationSystemPG1.db.HibernateUtil;

public class QuestionDAO {
	

	public static List<Question> getQuestions(){
		Session herbSession = HibernateUtil.getSession();
		herbSession.beginTransaction();

		Query query = herbSession.createQuery("from se.kyh.guestbook.entities.Post");
		
		herbSession.getTransaction().commit();
		List<Question> posts = query.list();

		return posts;
	}
	
	public static void saveQuestion(Question question){
		Session herbSession = HibernateUtil.getSession();
		herbSession.beginTransaction();

		herbSession.save(question);
		
		herbSession.getTransaction().commit();
	}
}


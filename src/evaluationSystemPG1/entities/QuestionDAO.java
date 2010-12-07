package evaluationSystemPG1.entities;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import evaluationSystemPG1.db.HibernateUtil;

public class QuestionDAO {
	

	public static List<Question> getAllQuestions(){
		Session herbSession = HibernateUtil.getSession();
		herbSession.beginTransaction();

		Query query = herbSession.createQuery("from evaluationSystemPG1.entitys.Question");
//		Query query = herbSession.createCriteria("from se.kyh.guestbook.entities.Post");
		
		herbSession.getTransaction().commit();
		List<Question> posts = query.list();

		return posts;
	}

	public static void saveQuestion(Question question){
		Session herbSession = HibernateUtil.getSession();
		herbSession.beginTransaction();
//		IOptionDAO.saveOption(question.getIOption());

		herbSession.save(question);
		
		herbSession.getTransaction().commit();
	}
}


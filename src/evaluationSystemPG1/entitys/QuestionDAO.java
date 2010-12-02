package evaluationSystemPG1.entitys;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import evaluationSystemPG1.db.HibernateUtil;

public class QuestionDAO {
	

	public static List<Question> getPosts(){
		Session herbSession = HibernateUtil.getSession();
		herbSession.beginTransaction();

		Query query = herbSession.createQuery("from se.kyh.guestbook.entities.Post");
		
		herbSession.getTransaction().commit();
		List<Question> posts = query.list();

		return posts;
	}
	
	public static void savePosts(Question post){
		Session herbSession = HibernateUtil.getSession();
		herbSession.beginTransaction();

		herbSession.save(post);
		
		herbSession.getTransaction().commit();
	}
}


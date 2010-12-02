package se.kyh.guestbook.entities;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import se.kyh.guestbook.db.HibernateUtil;

public class PostDAO {
	

	public static List<Post> getPosts(){
		Session herbSession = HibernateUtil.getSession();
		herbSession.beginTransaction();

		Query query = herbSession.createQuery("from se.kyh.guestbook.entities.Post");
		
		herbSession.getTransaction().commit();
		List<Post> posts = query.list();

		return posts;
	}
	
	public static void savePosts(Post post){
		Session herbSession = HibernateUtil.getSession();
		herbSession.beginTransaction();

		herbSession.save(post);
		
		herbSession.getTransaction().commit();
	}
}


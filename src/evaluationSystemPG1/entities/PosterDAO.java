package se.kyh.guestbook.entities;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import se.kyh.guestbook.db.HibernateUtil;

public class PosterDAO {
	

	public static List<Poster> getPosters(){
		Session herbSession = HibernateUtil.getSession();
		herbSession.beginTransaction();

		Query query = herbSession.createQuery("from se.kyh.guestbook.entities.Poster");
		
		herbSession.getTransaction().commit();
		List<Poster> posters = query.list();

		return posters;
	}
	
	public static void savePosters(Poster poster){
		Session herbSession = HibernateUtil.getSession();
		herbSession.beginTransaction();

		herbSession.save(poster);
		
		herbSession.getTransaction().commit();
	}
	
	public static List<PosterNumOfPost> getPosterNumOfPost(){
		List<PosterNumOfPost> posterNumOfPostList = new ArrayList<PosterNumOfPost>();
		Session herbSession = HibernateUtil.getSession();
		herbSession.beginTransaction();
		// SELECT *,count(Name) as numOfPost FROM poster GROUP BY name
//		Query query = herbSession.createQuery("from se.kyh.guestbook.entities.Poster" );
		Query query = herbSession.createQuery("select *, count(Poster.name) from Poster join cat.kittens kitten group by cat.id, cat.weight" );
		
		herbSession.getTransaction().commit();
		List<PosterNumOfPost> posters = query.list();

		
		
		
		return posterNumOfPostList;
	}
}


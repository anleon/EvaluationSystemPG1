package evaluationSystemPG1.abstracts;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import evaluationSystemPG1.db.HibernateUtil;
import evaluationSystemPG1.entitys.Question;

public abstract class EntityDAO<T extends IEntity > {
				
	public List<T> getAll(){
		Session herbSession = HibernateUtil.getSession();
		herbSession.beginTransaction();
		
		Query query = herbSession.createQuery("from "+  this.getClass().getName());
		
		herbSession.getTransaction().commit();
		List<T> objects = query.list();

		return objects;
	}
	
	public void saveAll(List<T> object){
		Session herbSession = HibernateUtil.getSession();
		herbSession.beginTransaction();

		herbSession.save(object);
		
		herbSession.getTransaction().commit();
	}
	
	public T get(int id){
		Session herbSession = HibernateUtil.getSession();
		herbSession.beginTransaction();
		
		Criteria criteria = herbSession.createCriteria(this.getClass());
		criteria.add(Restrictions.idEq(id));
		herbSession.getTransaction().commit();
		List<T> objects = criteria.list();
		return objects.get(0);
	}

	public void save(T object){
		Session herbSession = HibernateUtil.getSession();
		herbSession.beginTransaction();

		herbSession.save(object);
		
		herbSession.getTransaction().commit();
	}

}

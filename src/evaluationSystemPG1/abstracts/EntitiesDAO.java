package evaluationSystemPG1.abstracts;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import evaluationSystemPG1.db.HibernateUtil;
import evaluationSystemPG1.entities.Question;

public abstract class EntitiesDAO<T extends IEntity > {
				
	private Class<T> entityClass;
	
	protected EntitiesDAO(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	
	public List<T> getAll(){
		Session herbSession = HibernateUtil.getSession();
		herbSession.beginTransaction();;
		Query query = herbSession.createQuery("from "+  this.entityClass.getName());
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
		
		Criteria criteria = herbSession.createCriteria(this.entityClass);
		criteria.add(Restrictions.idEq(id));
		herbSession.getTransaction().commit();
		T object = (T)criteria.uniqueResult();
		
		return object;
	}

	public void save(T object){
		Session herbSession = HibernateUtil.getSession();
		herbSession.beginTransaction();

		herbSession.save(object);
		
		herbSession.getTransaction().commit();
	}
	
	
//Variation 	
	
//	protected abstract Class<T> myEntityClass();
	
/*	
 * tvingad överlagring 
 * public static IEntity getInstance() throws Exception {
		return null;
	}*/
}

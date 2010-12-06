package evaluationSystemPG1.entities;

import org.hibernate.Query;
import org.hibernate.Session;

import evaluationSystemPG1.db.HibernateUtil;

public class EvalTemplateDAO {

	public static EvalTemplate getEvalTemplate(int id){
		Session herbSession = HibernateUtil.getSession();
		herbSession.beginTransaction();

		Query query = herbSession.createQuery("from evaluationSystemPG1.entities.EvalTemplate as et where et.name = :id");
		query.setString(id,"id");
		
		herbSession.getTransaction().commit();
		EvalTemplate post = (EvalTemplate) query.uniqueResult();

		return post;
	}

}

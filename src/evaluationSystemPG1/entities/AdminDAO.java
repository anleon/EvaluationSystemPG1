package evaluationSystemPG1.entities;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import evaluationSystemPG1.abstracts.EntitiesDAO;
import evaluationSystemPG1.db.HibernateUtil;

public class AdminDAO extends EntitiesDAO<Admin> {

	private AdminDAO() {
		super(Admin.class);
	}
	
	private static class AdminDAOHolder {
		public static final AdminDAO INSTANCE = new AdminDAO();
	}

	public static AdminDAO getInstance() {
		return AdminDAOHolder.INSTANCE;
	}
	
	public static boolean hasPermissions(String accountName, String password){
		Session herbSession = HibernateUtil.getSession();
		herbSession.beginTransaction();
		
		String query = "select count(*) from admin where password = :password and accountName = :accountName";
		// FIXME plain-text passwords, DANGER! No time to check the Java-way of applying hashing+salt properly.
		String hashed_password = password;
		
		// Nice Trick to just check if there is a result or not.
	    Long has_permissions = ( (Long) herbSession.createQuery(query)
	    			.setString("accountName", accountName)
	    			.setString("password",hashed_password)
	    			.iterate().next() ).longValue();
		
		herbSession.getTransaction().commit();
		
		return has_permissions > 0;
	}
}

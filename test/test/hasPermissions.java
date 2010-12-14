package test;

import java.io.File;

import evaluationSystemPG1.db.HibernateUtil;
import evaluationSystemPG1.entities.AdminDAO;

public class hasPermissions {

	public static void main(String[] args) {
		init();
		// AdminDAO adminDAO = AdminDAO.getInstance();
		String accountName = "Test";
		String password = "test";
		
		System.out.println("accountName:" + accountName);
		System.out.println("password:" + password);		
		
		boolean check = AdminDAO.hasPermissions(accountName, password);
		if (check) {
			System.out.println("Inloggad!");
		} else {
		 System.out.println("Fel kombination av användarnamn och lösenord.");
		}
		
		accountName = "Test";
		password = "fest";
		
		System.out.println("accountName:" + accountName);
		System.out.println("password:" + password);		
		
		check = AdminDAO.hasPermissions(accountName, password);
		if (check) {
			System.out.println("Inloggad!");
		} else {
		 System.out.println("Fel kombination av användarnamn och lösenord.");
		}
		
	}		
	
	public static void init() {
		// Olles sökväg till konfigfil
		// String olle_path = "/Users/ollesvensson/Programering/helios/EvaluationSystemPG1/WebContent/WEB-INF/hibernate/hibernate.cfg.xml";
		String sten_path = "C://Users/Public/Documents/Workspace/EvaluationSystemPG1/WebContent/WEB-INF/hibernate/hibernate.cfg.xml";
		File configFile = new File(sten_path);
		HibernateUtil.initHibernate(configFile);
	}

}

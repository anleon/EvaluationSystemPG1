package test;
import java.io.File;

import evaluationSystemPG1.db.HibernateUtil;
import evaluationSystemPG1.entities.Label;
import evaluationSystemPG1.entities.LabelDAO;

public class PopulateDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Olles sökväg till konfigfil /Users/ollesvensson/Programering/helios/EvaluationSystemPG1/WebContent/WEB-INF/hibernate/hibernate.cfg.xml
		File configFile = new File("/Users/ollesvensson/Programering/helios/EvaluationSystemPG1/WebContent/WEB-INF/hibernate/hibernate.cfg.xml");
		HibernateUtil.initHibernate(configFile);

		LabelDAO altDAO = LabelDAO.getInstance();
		for (int i = 1; i < 7; i++) {
			Label alt = new Label();
			alt.setLabel(Integer.toString(i));
			altDAO.save(alt);
		}
	}
}

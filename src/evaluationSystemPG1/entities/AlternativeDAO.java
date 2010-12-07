package evaluationSystemPG1.entities;

import evaluationSystemPG1.abstracts.EntityDAO;
import evaluationSystemPG1.entities.AlternativeDAO;

public class AlternativeDAO extends EntityDAO<Alternative> {
	private AlternativeDAO() {
	}

	/**
	 * AlternativeDAOHolder is loaded on the first execution of
	 * AlternativeDAO.getInstance() or the first access to AlternativeDAOHolder.INSTANCE,
	 * not before.
	 */
	private static class AlternativeDAOHolder {
		public static final AlternativeDAO INSTANCE = new AlternativeDAO();
	}

	public static AlternativeDAO getInstance() {
		return AlternativeDAOHolder.INSTANCE;
	}
	
}


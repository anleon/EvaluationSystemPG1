package evaluationSystemPG1.entities;

import evaluationSystemPG1.abstracts.EntitiesDAO;
import evaluationSystemPG1.entities.AlternativeDAO;

public class AlternativeDAO extends EntitiesDAO<Alternative> {

	private AlternativeDAO() {
		super(Alternative.class);
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

/*
 * Variation
 * 
 * 	@Override
	protected Class<Alternative> myEntityClass() {
		// TODO Auto-generated method stub
		return Alternative.class;
	}*/


	
}


package evaluationSystemPG1.entities;

import evaluationSystemPG1.abstracts.EntitiesDAO;
import evaluationSystemPG1.entities.LabelDAO;

public class LabelDAO extends EntitiesDAO<Label> {

	private LabelDAO() {
		super(Label.class);
	}

	/**
	 * LabelDAOHolder is loaded on the first execution of
	 * LabelDAO.getInstance() or the first access to LabelDAOHolder.INSTANCE,
	 * not before.
	 */
	private static class LabelDAOHolder {
		public static final LabelDAO INSTANCE = new LabelDAO();
	}

	public static LabelDAO getInstance() {
		return LabelDAOHolder.INSTANCE;
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


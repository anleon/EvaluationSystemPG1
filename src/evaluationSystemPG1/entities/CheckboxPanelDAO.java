package evaluationSystemPG1.entities;

import evaluationSystemPG1.abstracts.EntitiesDAO;
import evaluationSystemPG1.abstracts.IEntity;

public class CheckboxPanelDAO extends EntitiesDAO<CheckboxPanel>{

	private CheckboxPanelDAO() {
		super(CheckboxPanel.class);
	}

	/**
	 * CheckboxPanelDAOHolder is loaded on the first execution of
	 * CheckboxPanelDAO.getInstance() or the first access to CheckboxPanelDAOHolder.INSTANCE,
	 * not before.
	 */
	private static class CheckboxPanelDAOHolder {
		public static final CheckboxPanelDAO INSTANCE = new CheckboxPanelDAO();
	}

	public static CheckboxPanelDAO getInstance() {
		return CheckboxPanelDAOHolder.INSTANCE;
	}

}

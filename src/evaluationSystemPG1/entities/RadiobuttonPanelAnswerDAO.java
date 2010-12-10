
package evaluationSystemPG1.entities;

import java.util.ArrayList;
import java.util.List;

import evaluationSystemPG1.abstracts.EntitiesDAO;
import evaluationSystemPG1.abstracts.IEntity;
import evaluationSystemPG1.entities.LabelDAO;

public class RadiobuttonPanelAnswerDAO extends EntitiesDAO<RadiobuttonPanelAnswer> implements IEntity {

	private RadiobuttonPanelAnswerDAO() {
		super(RadiobuttonPanelAnswer.class);
	}

	/**
	 * RadiobuttonDAOHolder is loaded on the first execution of
	 * RadiobuttonDAO.getInstance() or the first access to RadiobuttonDAOHolder.INSTANCE,
	 * not before.
	 */
	private static class RadiobuttonPanelAnswerDAOHolder {
		public static final RadiobuttonPanelAnswerDAO INSTANCE = new RadiobuttonPanelAnswerDAO();
	}

	public static RadiobuttonPanelAnswerDAO getInstance() {
		return RadiobuttonPanelAnswerDAOHolder.INSTANCE;
	}
}
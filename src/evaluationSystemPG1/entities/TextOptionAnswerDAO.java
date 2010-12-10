package evaluationSystemPG1.entities;

import java.io.Serializable;
import evaluationSystemPG1.abstracts.EntitiesDAO;

public class TextOptionAnswerDAO extends EntitiesDAO<TextOptionAnswer> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8154042991863989266L;

	TextOptionAnswerDAO() {
		super(TextOptionAnswer.class);
	}

	/**
	 * RadiobuttonDAOHolder is loaded on the first execution of
	 * RadiobuttonDAO.getInstance() or the first access to RadiobuttonDAOHolder.INSTANCE,
	 * not before.
	 */
	private static class TextOptionAnswerDAOHolder {
		public static final TextOptionAnswerDAO INSTANCE = new TextOptionAnswerDAO();
	}

	public static TextOptionAnswerDAO getInstance() {
		return TextOptionAnswerDAOHolder.INSTANCE;
	}
}

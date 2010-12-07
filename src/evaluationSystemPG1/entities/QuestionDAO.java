package evaluationSystemPG1.entities;

import evaluationSystemPG1.abstracts.EntityDAO;

public class QuestionDAO extends EntityDAO<Question> {

	private QuestionDAO() {
	}

	/**
	 * QuestionDAOHolder is loaded on the first execution of
	 * QuestionDAO.getInstance() or the first access to QuestionDAOHolder.INSTANCE,
	 * not before.
	 */
	private static class QuestionDAOHolder {
		public static final QuestionDAO INSTANCE = new QuestionDAO();
	}

	public static QuestionDAO getInstance() {
		return QuestionDAOHolder.INSTANCE;
	}

}

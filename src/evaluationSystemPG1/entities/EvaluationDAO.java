package evaluationSystemPG1.entities;

import evaluationSystemPG1.abstracts.EntitiesDAO;

public class EvaluationDAO extends EntitiesDAO<Evaluation> {

	private EvaluationDAO() {
		super(Evaluation.class);
	}

	/**
	 * SurveyDAOHolder is loaded on the first execution of
	 * SurveyDAO.getInstance() or the first access to SurveyDAOHolder.INSTANCE,
	 * not before.
	 */
	private static class EvaluationDAOHolder {
		public static final EvaluationDAO INSTANCE = new EvaluationDAO();
	}

	public static EvaluationDAO getInstance() {
		return EvaluationDAOHolder.INSTANCE;
	}
}
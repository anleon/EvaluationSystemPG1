package evaluationSystemPG1.entities;

import evaluationSystemPG1.abstracts.EntitiesDAO;

public class TextOptionDAO extends EntitiesDAO<TextOption> {

	private TextOptionDAO() {
		super(TextOption.class);
	}

	/**
	 * TextOptionDAOHolder is loaded on the first execution of
	 * TextOptionDAO.getInstance() or the first access to TextOptionDAOHolder.INSTANCE,
	 * not before.
	 */
	private static class TextOptionDAOHolder {
		public static final TextOptionDAO INSTANCE = new TextOptionDAO();
	}

	public static TextOptionDAO getInstance() {
		return TextOptionDAOHolder.INSTANCE;
	}


}

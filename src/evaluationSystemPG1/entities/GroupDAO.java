package evaluationSystemPG1.entities;

import evaluationSystemPG1.abstracts.EntitiesDAO;

public class GroupDAO extends EntitiesDAO<Group> {

	private GroupDAO() {
		super(Group.class);
	}

	/**
	 * GroupDAOHolder is loaded on the first execution of
	 * GroupDAO.getInstance() or the first access to GroupDAOHolder.INSTANCE,
	 * not before.
	 */
	private static class GroupDAOHolder {
		public static final GroupDAO INSTANCE = new GroupDAO();
	}

	public static GroupDAO getInstance() {
		return GroupDAOHolder.INSTANCE;
	}
}
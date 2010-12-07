package evaluationSystemPG1.entities;

import java.util.ArrayList;
import java.util.List;

import evaluationSystemPG1.abstracts.EntitiesDAO;
import evaluationSystemPG1.abstracts.IEntity;
import evaluationSystemPG1.entities.AlternativeDAO;

public class RadiobuttonDAO extends EntitiesDAO<Radiobutton> implements IEntity {

	private RadiobuttonDAO() {
		super(Radiobutton.class);
	}

	/**
	 * RadiobuttonDAOHolder is loaded on the first execution of
	 * RadiobuttonDAO.getInstance() or the first access to RadiobuttonDAOHolder.INSTANCE,
	 * not before.
	 */
	private static class RadiobuttonDAOHolder {
		public static final RadiobuttonDAO INSTANCE = new RadiobuttonDAO();
	}

	public static RadiobuttonDAO getInstance() {
		return RadiobuttonDAOHolder.INSTANCE;
	}

	
	
	public static Radiobutton getRadiobutton1to6() {
		Radiobutton radioOpt = new Radiobutton();
		List<Alternative> alts = new ArrayList<Alternative>();
		AlternativeDAO alternativeDAO = AlternativeDAO.getInstance();
		for (int i=1 ; i < 7 ;i ++){
			alts.add(alternativeDAO.get(i));
		}
		radioOpt.setAlternatives(alts);
		return radioOpt;
	}

/*
 * variation
 * 
 * 	@Override
 
	protected  Class<Radiobutton> myEntityClass() {
		return Radiobutton.class;
	}
	*/
}

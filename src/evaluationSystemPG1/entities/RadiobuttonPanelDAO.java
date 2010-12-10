package evaluationSystemPG1.entities;

import java.util.ArrayList;
import java.util.List;

import evaluationSystemPG1.abstracts.EntitiesDAO;
import evaluationSystemPG1.abstracts.IEntity;
import evaluationSystemPG1.entities.LabelDAO;

public class RadiobuttonPanelDAO extends EntitiesDAO<RadiobuttonPanel> implements IEntity {

	private RadiobuttonPanelDAO() {
		super(RadiobuttonPanel.class);
	}

	/**
	 * RadiobuttonDAOHolder is loaded on the first execution of
	 * RadiobuttonDAO.getInstance() or the first access to RadiobuttonDAOHolder.INSTANCE,
	 * not before.
	 */
	private static class RadiobuttonDAOHolder {
		public static final RadiobuttonPanelDAO INSTANCE = new RadiobuttonPanelDAO();
	}

	public static RadiobuttonPanelDAO getInstance() {
		return RadiobuttonDAOHolder.INSTANCE;
	}

	
	
	public static RadiobuttonPanel getRadiobutton1to6() {
		RadiobuttonPanel radioOpt = new RadiobuttonPanel();
		List<Label> alts = new ArrayList<Label>();
		LabelDAO alternativeDAO = LabelDAO.getInstance();
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

package evaluationSystemPG1.entitys;

import java.util.HashSet;
import java.util.Set;

public class Radiobutton1to6 extends Radiobutton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4282029992541735688L;
	
	public Radiobutton1to6(){
		Radiobutton radioOpt = new Radiobutton();
		Set<Alternative> alts = new HashSet<Alternative>();
		AlternativeDAO alternativeDAO = AlternativeDAO.getInstance();
		for (int i=0 ; i < 6 ;i ++){
			alts.add(alternativeDAO.get(i));
		}
		radioOpt.setAlternatives(alts);
		
	}
}

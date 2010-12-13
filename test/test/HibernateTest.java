package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import evaluationSystemPG1.abstracts.Option;
import evaluationSystemPG1.db.HibernateUtil;
import evaluationSystemPG1.entities.Evaluation;
import evaluationSystemPG1.entities.EvaluationDAO;
import evaluationSystemPG1.entities.Label;
import evaluationSystemPG1.entities.LabelDAO;
import evaluationSystemPG1.entities.CheckboxPanel;
import evaluationSystemPG1.entities.CheckboxPanelAnswer;
import evaluationSystemPG1.entities.Question;
import evaluationSystemPG1.entities.QuestionDAO;
import evaluationSystemPG1.entities.RadiobuttonPanel;
import evaluationSystemPG1.entities.RadiobuttonPanelAnswer;
import evaluationSystemPG1.entities.RadiobuttonPanelDAO;
import evaluationSystemPG1.entities.TextOption;
import evaluationSystemPG1.entities.TextOptionAnswer;

public class HibernateTest {

	public static void main(String[] arg) {
		init();
		
		LabelDAO altDAO = LabelDAO.getInstance();
		for (int i = 1; i < 7; i++) {
			Label alt = new Label();
			alt.setLabel(Integer.toString(i));
			altDAO.save(alt);
		}
		
		Evaluation eval = new Evaluation();
	
		
		QuestionDAO qDAO = QuestionDAO.getInstance();
	// FRÅGA 1 
		Question q = new Question();
		// question text
		q.setText("AA textOption och radiobutton1to6");
		q.setDate(new Date());
		q.setTextOption(getTextOption("Freetext till q1: "));
		RadiobuttonPanel radioOpt1 = RadiobuttonPanelDAO.getRadiobutton1to6();
		q.setMultiOption(radioOpt1);

		eval.getParts().add(q);

		// Fråga 2 utan textOption 
		Question q2 = new Question();
		q2.setText("BBBBBBBBBBBBBBBBB ");
		q2.setDate(new Date());
		String[] alts = {"dåligt","ok","bra","utmärkt"};
		RadiobuttonPanel radioOpt2 = getRadiobutton(alts);		
		q2.setMultiOption(radioOpt2);

		eval.getParts().add(q2);
		
		//Fråga 3 text opt checkbox
		Question question3 = new Question();
		question3.setText("CCCCCCCCCCCCCCCCCCCC");
		question3.setDate(new Date());
		String[] alts2 = {"utåtriktad","glad","målfokuserad"};
		CheckboxPanel checkbox = getCheckboxPanel(alts2);
		question3.setTextOption(getTextOption("Freetext till q3: "));
		question3.setMultiOption(checkbox);
		
		eval.getParts().add(question3);

		//Fråga 4 textopt ingen multioption
		Question question4 = new Question();
		question4.setText("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
		question4.setDate(new Date());
		
		question4.setTextOption(getTextOption("Freetext till q4: "));
		eval.getParts().add(question4);
		
		EvaluationDAO eDao = EvaluationDAO.getInstance();
		eDao.save(eval);
	}
	
	private static CheckboxPanel getCheckboxPanel(String[] alternatives){ 
		CheckboxPanel radioOpt = new CheckboxPanel();
		List<Label> alts = new ArrayList<Label>();
		for (String alt : alternatives){
			Label alter = new Label();
			alter.setLabel(alt);
			alts.add(alter);
		}
		radioOpt.setAlternatives(alts);
		return radioOpt;
	}
	
	private static RadiobuttonPanel getRadiobutton(String[] alternatives){ 
		RadiobuttonPanel radioOpt = new RadiobuttonPanel();
		List<Label> alts = new ArrayList<Label>();
		for (String alt : alternatives){
			Label alter = new Label();
			alter.setLabel(alt);
			alts.add(alter);
		}
		radioOpt.setAlternatives(alts);
	return radioOpt;
	}


private static TextOption getTextOption(String bla) {
	TextOption tO = new TextOption();
	Label alt = new Label();
	alt.setLabel(bla);
	tO.setAlternative(alt);
	
	return tO;
	
}
	public static void init() {
		// Olles sökväg till konfigfil
		// /Users/ollesvensson/Programering/helios/EvaluationSystemPG1/WebContent/WEB-INF/hibernate/hibernate.cfg.xml
		File configFile = new File(
				"/Users/ollesvensson/Programering/helios/EvaluationSystemPG1/WebContent/WEB-INF/hibernate/hibernate.cfg.xml");
		HibernateUtil.initHibernate(configFile);
	}

}

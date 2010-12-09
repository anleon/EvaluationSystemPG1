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
import evaluationSystemPG1.entities.Alternative;
import evaluationSystemPG1.entities.AlternativeDAO;
import evaluationSystemPG1.entities.CheckboxPanel;
import evaluationSystemPG1.entities.CheckboxPanelAnswer;
import evaluationSystemPG1.entities.Question;
import evaluationSystemPG1.entities.QuestionDAO;
import evaluationSystemPG1.entities.Radiobutton;
import evaluationSystemPG1.entities.RadiobuttonAnswer;
import evaluationSystemPG1.entities.RadiobuttonDAO;
import evaluationSystemPG1.entities.TextOption;
import evaluationSystemPG1.entities.TextOptionAnswer;

public class HibernateTest {

	public static void main(String[] arg) {
		init();
		
		AlternativeDAO altDAO = AlternativeDAO.getInstance();
		for (int i = 1; i < 7; i++) {
			Alternative alt = new Alternative();
			alt.setLabel(Integer.toString(i));
			altDAO.save(alt);
		}

		
		QuestionDAO qDAO = QuestionDAO.getInstance();
	// FRÅGA 1 
		Question q = new Question();
		// question text
		q.setText("AA textOption och radiobutton1to6");
		q.setDate(new Date());
		q.setTextOption(getTextOption("Freetext till q1: "));
		Radiobutton radioOpt1 = RadiobuttonDAO.getRadiobutton1to6();
		q.setMultiOption(radioOpt1);

		qDAO.save(q);
/*
		// Fråga 2 utan textOption 
		Question q2 = new Question();
		q2.setText("BBBBBBBBBBBBBBBBB ");
		q2.setDate(new Date());
		String[] alts = {"dåligt","ok","bra","utmärkt"};
		Radiobutton radioOpt2 = getRadiobutton(alts);		
		q2.setMultiOption(radioOpt2);

		qDAO.save(q2);
*/		
		//Fråga 3 text opt checkbox
		Question question3 = new Question();
		question3.setText("CCCCCCCCCCCCCCCCCCCC");
		question3.setDate(new Date());
		String[] alts2 = {"utåtriktad","glad","målfokuserad"};
		CheckboxPanel checkbox = getCheckboxPanel(alts2);
		question3.setTextOption(getTextOption("Freetext till q3: "));
		question3.setMultiOption(checkbox);
		
		qDAO.save(question3);

		//Fråga 4 textopt ingen multioption
/*		Question question4 = new Question();
		question4.setText("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
		question4.setDate(new Date());
		
		question4.setTextOption(getTextOption("Freetext till q4: "));
		qDAO.save(question4);*/
	}
	
	private static CheckboxPanel getCheckboxPanel(String[] alternatives){ 
		CheckboxPanel radioOpt = new CheckboxPanel();
		List<Alternative> alts = new ArrayList<Alternative>();
		for (String alt : alternatives){
			Alternative alter = new Alternative();
			alter.setLabel(alt);
			alts.add(alter);
		}
		radioOpt.setAlternatives(alts);
		return radioOpt;
	}
	
	private static Radiobutton getRadiobutton(String[] alternatives){ 
		Radiobutton radioOpt = new Radiobutton();
		List<Alternative> alts = new ArrayList<Alternative>();
		for (String alt : alternatives){
			Alternative alter = new Alternative();
			alter.setLabel(alt);
			alts.add(alter);
		}
		radioOpt.setAlternatives(alts);
	return radioOpt;
	}


private static TextOption getTextOption(String bla) {
	TextOption tO = new TextOption();
	Alternative alt = new Alternative();
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

package test;

import java.io.File;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import evaluationSystemPG1.abstracts.Option;
import evaluationSystemPG1.db.HibernateUtil;
import evaluationSystemPG1.entitys.Question;
import evaluationSystemPG1.entitys.QuestionDAO;
import evaluationSystemPG1.entitys.Alternative;
import evaluationSystemPG1.entitys.Radiobutton;
import evaluationSystemPG1.entitys.TextOption;

public class HibernateTest {

	public static void main(String[] arg) {
		init();
		Question q = new Question();
		q.setText("Vad är tredje frågan");
		q.setDate(new Date());
		TextOption textOpt = new TextOption();
		textOpt.setAnswerString("Det vet jag inte");
		q.setIOption(textOpt);
		QuestionDAO.saveQuestion(q);

		Question q2 = new Question();
		q2.setText("Detta är radiofrågan frågan");
		q2.setDate(new Date());
		Radiobutton radioOpt = new Radiobutton();
		Set<Alternative> alts = new HashSet<Alternative>();
		
		addAltLabel("minst",alts);
		addAltLabel("liten",alts);
		addAltLabel("mitten",alts);
		addAltLabel("stor",alts);
		addAltLabel("större",alts);
		addAltLabel("störst",alts);

		radioOpt.setAlternatives(alts);
		radioOpt.setAnswer(3);
		q2.setIOption(radioOpt);
		QuestionDAO.saveQuestion(q2);

		List<Question> questions = QuestionDAO.getAllQuestions();
		for (Question question : questions) {
			System.out.print(question.getText() + " Svar: ");
			System.out.println(question.getIOption().getAnswerString());
		}
	}

	public static void init() {
		// Olles sökväg till konfigfil /Users/ollesvensson/Programering/helios/EvaluationSystemPG1/WebContent/WEB-INF/hibernate/hibernate.cfg.xml
		File configFile = new File("/Users/ollesvensson/Programering/helios/EvaluationSystemPG1/WebContent/WEB-INF/hibernate/hibernate.cfg.xml");
		HibernateUtil.initHibernate(configFile);
	}
	
	private static void addAltLabel(String s, Set<Alternative> altSet){
		Alternative a = new Alternative();
		a.setLabel(s);
		altSet.add(a);
	}

}

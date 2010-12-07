package test;

import java.io.File;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import evaluationSystemPG1.abstracts.EntityDAO;
import evaluationSystemPG1.abstracts.Option;
import evaluationSystemPG1.db.HibernateUtil;
import evaluationSystemPG1.entities.Alternative;
import evaluationSystemPG1.entities.Question;
import evaluationSystemPG1.entities.QuestionDAO;
import evaluationSystemPG1.entities.Radiobutton;
import evaluationSystemPG1.entities.Radiobutton1to6;
import evaluationSystemPG1.entities.TextOption;

public class HibernateTest {

	public static void main(String[] arg) {
		init();
		Question q = new Question();
		q.setText("Vad är tredje frågan");
		q.setDate(new Date());
		TextOption textOpt = new TextOption();
		textOpt.setAnswerString("Det vet jag inte");
		q.setTextOption(textOpt);
		QuestionDAO qDAO = QuestionDAO.getInstance(); 
		qDAO.save(q);

		Question q2 = new Question();
		q2.setText("Detta är radiofrågan frågan");
		q2.setDate(new Date());
		Radiobutton radioOpt = new Radiobutton1to6();
		Set<Alternative> alts = new HashSet<Alternative>();
		

		radioOpt.setAlternatives(radioOpt.getAlternatives());
		radioOpt.setAnswer(3);
		q2.setMultiOption(radioOpt);
		qDAO.save(q2);

		List<Question> questions = qDAO.getAll();
		for (Question question : questions) {
			System.out.print(question.getText() + " Svar: ");
			System.out.println(question.getMultiOption().getAnswerString());
		}
	}

	public static void init() {
		// Olles sökväg till konfigfil /Users/ollesvensson/Programering/helios/EvaluationSystemPG1/WebContent/WEB-INF/hibernate/hibernate.cfg.xml
		File configFile = new File("/Users/ollesvensson/Programering/helios/EvaluationSystemPG1/WebContent/WEB-INF/hibernate/hibernate.cfg.xml");
		HibernateUtil.initHibernate(configFile);
	}
	

}

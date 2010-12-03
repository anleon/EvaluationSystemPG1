import java.io.File;
import java.util.Date;
import java.util.List;


import evaluationSystemPG1.db.HibernateUtil;
import evaluationSystemPG1.entitys.Question;
import evaluationSystemPG1.entitys.QuestionDAO;
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

}

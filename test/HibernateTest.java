import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import evaluationSystemPG1.abstracts.EntitiesDAO;
import evaluationSystemPG1.abstracts.Option;
import evaluationSystemPG1.db.HibernateUtil;
import evaluationSystemPG1.entities.Alternative;
import evaluationSystemPG1.entities.Question;
import evaluationSystemPG1.entities.QuestionDAO;
import evaluationSystemPG1.entities.Radiobutton;
import evaluationSystemPG1.entities.RadiobuttonDAO;
import evaluationSystemPG1.entities.TextOption;

public class HibernateTest {

	public static void main(String[] arg) {
		init();
		QuestionDAO qDAO = QuestionDAO.getInstance();
		// FRÅGA 1
		Question q = new Question();
		// question text
		q.setText("Vad är tredje frågan");
		q.setDate(new Date());
		TextOption textOpt = new TextOption();
		q.setTextOption(textOpt);
		Radiobutton radioOpt1 = RadiobuttonDAO.getRadiobutton1to6();
		q.setMultiOption(radioOpt1);

		qDAO.save(q);

		// Fråga 2
		Question q2 = new Question();
		q2.setText("Detta är frågan2");
		q2.setDate(new Date());
		textOpt = new TextOption();
		// q2.setTextOption(textOpt);
		Radiobutton radioOpt2 = new Radiobutton();
		List<Alternative> alternatives = new ArrayList<Alternative>();
		Alternative alternative1 = new Alternative();
		alternative1.setLabel("Dåligt");
		alternatives.add(alternative1);
		Alternative alternative2 = new Alternative();
		alternative2.setLabel("Mindre dåligt");
		alternatives.add(alternative2);
		Alternative alternative3 = new Alternative();
		alternative3.setLabel("OK");
		alternatives.add(alternative3);
		radioOpt2.setAlternatives(alternatives);
		q2.setMultiOption(radioOpt2);

		qDAO.save(q2);

		List<Question> questions = qDAO.getAll();
		for (Question question : questions) {
			System.out.println("Fråga 1");
			System.out.println(question.getText() + ":");
			System.out.print(question.getMultiOption().getAlternativesString()
					+ " Svar Textoption: ");
			if (question.getTextOption() != null) {
				System.out.println("Fritext svar: ");
				String freeTextAnswer = "";
				BufferedReader br = new BufferedReader(new InputStreamReader(
						System.in));
				try {
					freeTextAnswer = br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				question.getTextOption().setAnswerString(freeTextAnswer);
			}
			if (question.getMultiOption() != null) {
				Option option = question.getMultiOption();
				if (option instanceof Radiobutton) {
					Radiobutton radio = (Radiobutton) option;
					System.out.println("Radiobutton svar: ");
					String radiobuttonAnswer = "";
					BufferedReader br = new BufferedReader(
							new InputStreamReader(System.in));
					while (true) {
						try {
							radiobuttonAnswer = br.readLine();
							int radioAnsInt = Integer.parseInt(radiobuttonAnswer);
							radio.setAnswer(radioAnsInt);
							break;
						} catch (Exception e) {
							System.out.println("Enter numeric value ");
						}
					}
				}
			}
		}
	}

	public static void init() {
		// Olles sökväg till konfigfil
		// /Users/ollesvensson/Programering/helios/EvaluationSystemPG1/WebContent/WEB-INF/hibernate/hibernate.cfg.xml
		File configFile = new File(
				"/Users/ollesvensson/Programering/helios/EvaluationSystemPG1/WebContent/WEB-INF/hibernate/hibernate.cfg.xml");
		HibernateUtil.initHibernate(configFile);
	}

}

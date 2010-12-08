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
import evaluationSystemPG1.entities.CheckboxPanel;
import evaluationSystemPG1.entities.CheckboxPanelAnswer;
import evaluationSystemPG1.entities.Question;
import evaluationSystemPG1.entities.QuestionDAO;
import evaluationSystemPG1.entities.Radiobutton;
import evaluationSystemPG1.entities.RadiobuttonAnswer;
import evaluationSystemPG1.entities.RadiobuttonDAO;
import evaluationSystemPG1.entities.TextOptionAnswer;

public class HibernateTest {

	public static void main(String[] arg) {
		init();
		QuestionDAO qDAO = QuestionDAO.getInstance();
		// FRÅGA 1
		Question q = new Question();
		// question text
		q.setText("AAAAAAAAAAAAAAAAAAAAAA");
		q.setDate(new Date());
		List <TextOptionAnswer> textOpt = new ArrayList<TextOptionAnswer>();
		q.setTextOption(textOpt);
		Radiobutton radioOpt1 = RadiobuttonDAO.getRadiobutton1to6();
		q.setMultiOption(radioOpt1);

		qDAO.save(q);

		// Fråga 2
		Question q2 = new Question();
		q2.setText("BBBBBBBBBBBBBBBBBBBBBBB");
		q2.setDate(new Date());
		//textOpt = new TextOption();
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

		//Fråga 3
		Question question3 = new Question();
		question3.setText("CCCCCCCCCCCCCCCCCCCC");
		question3.setDate(new Date());
		List <TextOptionAnswer> textOpt3 = new ArrayList<TextOptionAnswer>();
		question3.setTextOption(textOpt3);
		CheckboxPanel checkbox = new CheckboxPanel();
		
		List<Alternative> alternatives2 = new ArrayList<Alternative>();
		Alternative alternative21 = new Alternative();
		alternative21.setLabel("regn");
		alternatives2.add(alternative21);
		Alternative alternative22 = new Alternative();
		alternative22.setLabel("mulet");
		alternatives2.add(alternative22);
		Alternative alternative23 = new Alternative();
		alternative23.setLabel("Sol");
		alternatives2.add(alternative23);
		checkbox.setAlternatives(alternatives2);
		question3.setMultiOption(checkbox);
		qDAO.save(question3);
		
		List<Question> questions = qDAO.getAll();
		int i = 0;
		for (Question question : questions) {
			System.out.println("Fråga "+i);
			i++;
			System.out.println(question.getText() + ":");
			System.out.print(question.getMultiOption().getAlternativesString());
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
				TextOptionAnswer tAnswer = new TextOptionAnswer();
				tAnswer.setAnswerString(freeTextAnswer);
				question.getTextOption().add(tAnswer);
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
							RadiobuttonAnswer rAnswer = new RadiobuttonAnswer();
							rAnswer.setAnswer(radioAnsInt);
							radio.getAnswer().add(rAnswer);
							break;
						} catch (Exception e) {
							System.out.println("Enter numeric value ");
						}
					}
				}
				if (option instanceof CheckboxPanel) {
					CheckboxPanel check = (CheckboxPanel) option;
					System.out.println("CheckboxPanel svar: ");
					String checkboxPanelAnswer = "";
					BufferedReader br = new BufferedReader(
							new InputStreamReader(System.in));
					while (true) {
						try {
							checkboxPanelAnswer = br.readLine();
							String[] answerArray = checkboxPanelAnswer.split(";");
							List<CheckboxPanelAnswer> checkAnsInt = new ArrayList<CheckboxPanelAnswer>();
							for (String answer : answerArray){
								CheckboxPanelAnswer checkboxAnswer = new CheckboxPanelAnswer();
								checkboxAnswer.setValue(Integer.parseInt(answer)); 	
								checkAnsInt.add(checkboxAnswer);
							}
							check.setAnswer(checkAnsInt);
							break;
						} catch (Exception e) {
							System.out.println("Enter numeric value ");
						}
					}
				}

			}
			qDAO.save(question);
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

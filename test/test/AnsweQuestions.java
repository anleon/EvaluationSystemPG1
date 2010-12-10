package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import evaluationSystemPG1.abstracts.Option;
import evaluationSystemPG1.db.HibernateUtil;
import evaluationSystemPG1.entities.CheckboxAnswerValue;
import evaluationSystemPG1.entities.CheckboxPanel;
import evaluationSystemPG1.entities.CheckboxPanelAnswer;
import evaluationSystemPG1.entities.Question;
import evaluationSystemPG1.entities.QuestionDAO;
import evaluationSystemPG1.entities.RadiobuttonPanel;
import evaluationSystemPG1.entities.RadiobuttonPanelAnswer;
import evaluationSystemPG1.entities.TextOptionAnswer;

public class AnsweQuestions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		init();
		QuestionDAO qDAO = QuestionDAO.getInstance();
		List<Question> questions = qDAO.getAll();
		int i = 1;
		for (Question question : questions) {
			System.out.println("Fråga "+i);
			i++;
//			Print question
			System.out.println(question.getText() + ":");
			if (question.getMultiOption() != null)
				System.out.print(question.getMultiOption().getAlternativesString());
			//if exist print freetext answer label and collect answer
			if (question.getTextOption() != null) {
				System.out.println(question.getTextOption().getAlternative().getLabel());
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
				question.getTextOption().getTextAnswers().add(tAnswer);
			}
			// if multioption exsist print Alternatives
			if (question.getMultiOption() != null) {
				Option option = question.getMultiOption();
				// if multioption is Radiobutton collect answer
				if (option instanceof RadiobuttonPanel) {
					RadiobuttonPanel radio = (RadiobuttonPanel) option;
					System.out.println("Radiobutton svar: ");
					String radiobuttonAnswer = "";
					BufferedReader br = new BufferedReader(
							new InputStreamReader(System.in));
					while (true) {
						try {
							radiobuttonAnswer = br.readLine();
							int radioAnsInt = Integer.parseInt(radiobuttonAnswer);
							RadiobuttonPanelAnswer rAnswer = new RadiobuttonPanelAnswer();
							rAnswer.setAnswer(radioAnsInt);
							radio.getAnswer().add(rAnswer);
							break;
						} catch (Exception e) {
							System.out.println("Enter numeric value ");
						}
					}
				}
				// if multioption is Checkbox collect answer
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
								CheckboxAnswerValue cBV = new CheckboxAnswerValue();
								cBV.setValue(Integer.parseInt(answer));
								System.out.println("före " + cBV);
								checkboxAnswer.getValues().add(cBV); 	
								System.out.println("efter ");
								checkAnsInt.add(checkboxAnswer);
							}
							check.setAnswer(checkAnsInt);
							break;
						} catch (Exception e) {
							System.out.println("Enter numeric value ");
							e.printStackTrace();
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

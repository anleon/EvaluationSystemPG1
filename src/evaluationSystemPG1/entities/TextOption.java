/**
 * 
 */
package evaluationSystemPG1.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import evaluationSystemPG1.abstracts.Answer;
import evaluationSystemPG1.abstracts.IEntity;
import evaluationSystemPG1.abstracts.Option;

/**
 * @author ollesvensson
 * 
 */
@Entity(name = "text_options")
public class TextOption implements Serializable, IEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4835492913976660769L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String textAnswer;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	/*
	 * public void setAnswer(Answer answer) {
	 * System.out.println("not implemented"); }
	 */
	public String getAnswerString() {
		return textAnswer;
	}

	public void setAnswerString(String s) {
		this.textAnswer = s;
	}

}

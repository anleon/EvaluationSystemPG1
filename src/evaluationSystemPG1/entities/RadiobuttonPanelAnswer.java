package evaluationSystemPG1.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import evaluationSystemPG1.abstracts.IEntity;

@Entity(name = "radiobutton_answer")
public class RadiobuttonPanelAnswer implements Serializable,IEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3214767370811152775L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int answer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}

}

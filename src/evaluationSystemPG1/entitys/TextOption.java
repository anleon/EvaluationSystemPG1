/**
 * 
 */
package evaluationSystemPG1.entitys;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


import evaluationSystemPG1.abstracts.IOption;

/**
 * @author ollesvensson
 *
 */
@Entity(name="text_options")
public class TextOption implements IOption,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4835492913976660769L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@JoinColumn(name="question_id")
	@OneToOne
	private Question question;
	private String textAnswer; 
	
	public int getId() {
		return id;
	}
	private void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String getAnswerString() {
		return textAnswer;
	}
	public void setAnswerString(String textAnswer) {
		this.textAnswer = textAnswer;
	}
	
}

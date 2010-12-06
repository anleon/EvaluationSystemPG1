/**
 * 
 */
package evaluationSystemPG1.entitys;

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
import evaluationSystemPG1.abstracts.Option;

/**
 * @author ollesvensson
 *
 */
@Entity(name="text_options")
@Inheritance(strategy=InheritanceType.JOINED)
public class TextOption extends Option implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4835492913976660769L;
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private int textId;
	
	private String textAnswer; 
	
	@Override
	public void setAnswer(Answer answer) {
		System.out.println("not implemented");
	}

	@Override
	public String getAnswerString() {
		return textAnswer;
	}
	
	public void setAnswerString(String s) {
		this.textAnswer = s;
	}

/*	public void setId(int id) {
		this.textId = id;
	}
	public int getId() {
		return textId;
	}
*/
	
}

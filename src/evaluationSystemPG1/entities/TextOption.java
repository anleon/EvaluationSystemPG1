package evaluationSystemPG1.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import evaluationSystemPG1.abstracts.IEntity;

@Entity(name="text_options")
public class TextOption implements Serializable, IEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7734255418595078708L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Alternative alternative; 
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "text_option_id")
	private List<TextOptionAnswer> textAnswers;
	
	public void setAlternative(Alternative alternative) {
		this.alternative = alternative;
	}
	public Alternative getAlternative() {
		return alternative;
	}
	public void setTextAnswers(List<TextOptionAnswer> textAnswers) {
		this.textAnswers = textAnswers;
	}
	public List<TextOptionAnswer> getTextAnswers() {
		return textAnswers;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
}

package evaluationSystemPG1.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import evaluationSystemPG1.abstracts.IEntity;
import evaluationSystemPG1.abstracts.Option;

@Entity(name="questions")
public class Question implements Serializable,IEntity{

	private static final long serialVersionUID = 544334524525425L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String text;
	private Date date;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "text_option_id")
	private List<TextOptionAnswer> textOption; 

	@OneToOne(cascade = CascadeType.ALL)
	private Option multiOption;
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setMultiOption(Option multiOption) {
		this.multiOption = multiOption;
	}

	public Option getMultiOption() {
		return multiOption;
	}

	public void setTextOption(List<TextOptionAnswer> textOption) {
		this.textOption = textOption;
	}

	public List<TextOptionAnswer> getTextOption() {
		return textOption;
	}

	public static List<Question> make(String eval_tag,
			Map<String, String[]> question_map) {
		// TODO Auto-generated method stub
		return null;
	}

}

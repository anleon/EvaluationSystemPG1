package evaluationSystemPG1.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import evaluationSystemPG1.abstracts.IEntity;
import evaluationSystemPG1.abstracts.Option;

@Entity(name = "radiobutton_panel")
public class RadiobuttonPanel extends Option implements Serializable,IEntity {

	private static final long serialVersionUID = 4242256775914443344L;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "radio_option_id")
	private List<RadiobuttonPanelAnswer> answer = new ArrayList<RadiobuttonPanelAnswer>();

	public void setAnswer(List<RadiobuttonPanelAnswer> answer) {
		this.answer = answer;
	}

	public List<RadiobuttonPanelAnswer> getAnswer() {
		return answer;
	}

	@Override
	public String getAnswerString() {
		// TODO Auto-generated method stub
		return null;
	}
	



}

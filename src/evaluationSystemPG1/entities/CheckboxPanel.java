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

@Entity(name = "checkbox_panel")
public class CheckboxPanel extends Option implements Serializable,IEntity {

	private static final long serialVersionUID = 4256614776600856748L;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "checkbox_id")
	private List<CheckboxPanelAnswer> answers = new ArrayList<CheckboxPanelAnswer>();
	
	public void setAnswer(List<CheckboxPanelAnswer> answer) {
/*		if (answer < 0 || answer > alternatives.size()) {
			System.out.println("answer out of bound");
		} else {*/
		this.answers = answer;
		//}
	}

	public List<CheckboxPanelAnswer> getAnswer() {
		return answers;
	}

	@Override
	public String getAnswerString() {
		// TODO Auto-generated method stub
		return null;
	}
}

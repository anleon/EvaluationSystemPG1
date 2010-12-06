package evaluationSystemPG1.entitys;

import java.io.Serializable;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;

import evaluationSystemPG1.abstracts.Answer;
import evaluationSystemPG1.abstracts.Option;

@Entity(name = "radio_options")
//@Inheritance(strategy=InheritanceType.JOINED)
public class Radiobutton extends Option implements Serializable {

	private static final long serialVersionUID = 4242256775914443344L;

	private int answer;
	private final int numberOfAlternatives = 5;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<Alternative> alternatives; 
	
	public void setAnswer(int answer) {
		this.answer = answer;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAlternatives(Set<Alternative> alternatives ) {
		this.alternatives = alternatives;
	}

	public Set<Alternative> getAlternatives() {
		return alternatives;
	}

	@Override
	public String getAnswerString() {
		return Integer.toString(answer+1);
	}

	@Override
	public void setAnswer(Answer answer) {
		// TODO Auto-generated method stub
		
	}
}

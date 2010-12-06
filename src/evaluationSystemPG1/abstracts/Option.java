package evaluationSystemPG1.abstracts;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity(name = "options" )
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Option {
		
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	public abstract String getAnswerString();
	public abstract void setAnswer(Answer answer);

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

}

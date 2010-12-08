package evaluationSystemPG1.abstracts;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

import evaluationSystemPG1.entities.Alternative;

@Entity(name = "options" )
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Option {
		
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@ManyToMany(cascade=CascadeType.ALL)
	private List<Alternative> alternatives; 

	public abstract String getAnswerString();

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getAlternativesString() {
		String s = "";
		int i = 1;
		System.out.println(this.alternatives.size());
		
		for (Alternative alt : this.alternatives){
			s += "alt "+ i +" : "+ alt.getLabel() + ": \n";
			i++;
		}
		return s;
	}

	public void setAlternatives(List<Alternative> alternatives ) {
		this.alternatives = alternatives;
	}

	public List<Alternative> getAlternatives() {
		return alternatives;
	}

}

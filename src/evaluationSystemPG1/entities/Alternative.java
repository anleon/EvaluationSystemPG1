package evaluationSystemPG1.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;

@Entity(name = "alternatives")
public class Alternative implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3182046882205881869L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String label;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}

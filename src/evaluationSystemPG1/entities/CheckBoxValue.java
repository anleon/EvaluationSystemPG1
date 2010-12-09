package evaluationSystemPG1.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import evaluationSystemPG1.abstracts.IEntity;

@Entity(name= "checkbox_answer_values")
public class CheckBoxValue implements Serializable, IEntity {

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -4845958587847339502L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int value;
}

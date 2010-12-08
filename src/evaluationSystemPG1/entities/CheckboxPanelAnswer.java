package evaluationSystemPG1.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import evaluationSystemPG1.abstracts.IEntity;

@Entity(name = "checkbox_option_answer")
public class CheckboxPanelAnswer implements Serializable, IEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 58406583467221816L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private int value;
	
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

	/*	public void setChekbox(CheckboxPanel chekbox) {
		this.chekbox = chekbox;
	}
	public CheckboxPanel getChekbox() {
		return chekbox;
	}
	*/
}

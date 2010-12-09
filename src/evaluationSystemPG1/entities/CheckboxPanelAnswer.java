package evaluationSystemPG1.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "checkbox_answer")
	private List<CheckBoxValue> values = new ArrayList<CheckBoxValue>();;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setValues(List<CheckBoxValue> values) {
		this.values = values;
	}
	public List<CheckBoxValue> getValues() {
		return values;
	}

	/*	public void setChekbox(CheckboxPanel chekbox) {
		this.chekbox = chekbox;
	}
	public CheckboxPanel getChekbox() {
		return chekbox;
	}
	*/
}

package evaluationSystemPG1.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

import evaluationSystemPG1.abstracts.Option;

@Entity(name="questions")
public class Question implements Serializable{

	private static final long serialVersionUID = 544334524525425L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String text;
	private Date date;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Option option;

	@OneToOne(cascade = CascadeType.ALL)
	private Option radioPanel;
	
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

	private void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setIOption(Option iOption) {
		this.option = iOption;
	}

	public Option getIOption() {
		return option;
	}

	public void setRadioPanel(Option radioPanel) {
		this.radioPanel = radioPanel;
	}

	public Option getRadioPanel() {
		return radioPanel;
	}
	
}

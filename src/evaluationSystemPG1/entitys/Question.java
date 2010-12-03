package evaluationSystemPG1.entitys;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

import evaluationSystemPG1.abstracts.IOption;

@Entity(name="questions")
public class Question implements Serializable{

	private static final long serialVersionUID = 544334524525425L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String text;
	private Date date;
	
	@JoinColumn()	
	@OneToOne
	private IOption IOption;
	
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

	public void setIOption(IOption iOption) {
		IOption = iOption;
	}

	public IOption getIOption() {
		return IOption;
	}
	
}

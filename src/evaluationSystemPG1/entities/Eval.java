package evaluationSystemPG1.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="evals")
public class Eval implements Serializable{

	private static final long serialVersionUID = 8588320328568853034L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	// TODO Rename date to what it actually means.
	private Date date;
	
	// TODO Change parts from List<Question> to List<IEvalComponent>.
	// TODO Add hibernate join annotations here.
	private List<Question> parts;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Question> getParts() {
		return parts;
	}

	public void setParts(List<Question> parts) {
		this.parts = parts;
	}
	
}
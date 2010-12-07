package evaluationSystemPG1.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="eval_templates")
public class EvalTemplate implements Serializable{

	private static final long serialVersionUID = -4796461068442539025L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	private Group group;
	// TODO Rename date to what it actually means.
	private Date date;
	// TODO Change parts from List<Question> to List<IEvalComponent>.
	// TODO Add hibernate join annotations here.
	private List<Question> parts;
	// TODO Add hibernate join annotations here.
	private Set<Eval> evals;
	// TODO Change status from int to Enum.
	private int status;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
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
	public Set<Eval> getEvals() {
		return evals;
	}
	public void setEvals(Set<Eval> evals) {
		this.evals = evals;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}  
}

package evaluationSystemPG1.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import evaluationSystemPG1.abstracts.IEntity;

@Entity(name="groups")
public class Group implements Serializable,IEntity {

	private static final long serialVersionUID = -6234881273701238057L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;	
	private String groupName;
	private String members;
	//TODO change to member List<String> 
	
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setMembers(String members) {
		this.members = members;
	}
	public String getMembers() {
		return members;
	}
	
}

package evaluationSystemPG1.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import evaluationSystemPG1.abstracts.IEntity;

@Entity(name="evaluations")
public class Evaluation implements Serializable,IEntity{

	private static final long serialVersionUID = -4796461068442539025L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	@Column(name = "group_id" )
	private Group group;
	// TODO Rename date to what it actually means.
	private Date date;
	// TODO Change parts from List<Question> to List<IEvalComponent>.
	// TODO Add hibernate join annotations here.
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "evaluation_id")
	private List<Question> parts = new ArrayList<Question>();
	// TODO Add hibernate join annotations here.
	private int status;

	
	public static List<Evaluation> make(String tag,Map<String, String[]> map){
		/* incoming tag should be "".
		 * Tag to handle is: eval_{id}. The {id} is optional.
		 * Get the id.
		 * Note that there is only one Evaluation to save at a time, 
		 * so it not neccessary to look at more than one of them.
		 */
		Pattern p_eval = Pattern.compile("^eval_(\\d*)");
		Iterator<String> it = map.keySet().iterator();
		boolean found_eval = true;
		boolean has_id = false;
		int id = 0;
		// Not everything begins with eval, for example the submit button.
		while (!found_eval && it.hasNext()) {
			String s = it.next();
			Matcher m = p_eval.matcher(s);
			found_eval = !m.lookingAt();
			if (found_eval) {
				try {
					id = Integer.parseInt(m.group(1));
					has_id = true;
				} catch (Exception e) {
					id = 0;
				}
			}
		} 
		// Dont bother if not found any Evaluation. 
		if (!found_eval) {
			return new LinkedList<Evaluation>();
		}
		
		// If empty, create a new instance. else update the existing one.
		Evaluation et;
		if (has_id) {
			et = EvalTemplateDAO.getEvalTemplate(id);
		} else {
			et = new Evaluation();
			id = et.getId();
		}
		
		// We will build up this in a cascading way, so that every class just handle itself.
		String eval_tag = "eval_" + id + ".";
		
		// make all the fields. Note that it will in turn call the dependant classes make function.
		et.makeFields(tag,eval_tag,map);
		
		List<Evaluation> et_list = new LinkedList<Evaluation>();
		et_list.add(et);
		return et_list;
	}
	

	private void makeFields(String tag,String eval_tag,Map<String, String[]> map) {
		// date
		Calendar c = Calendar.getInstance();
		Date d = c.getTime();
		setDate(d);
		// title
		String[] title_param = map.get(tag + "title");
		if (title_param != null) {
			setTitle(title_param[0]);
		}
		// status
		String[] status_param = map.get(tag + "status");
		if (status_param != null) {
			setStatus(Integer.parseInt(status_param[0]));
		}
		// group
		/*
		String[] group_param;
		group_param = map.get(tag + "group");
		GroupDAO g_dao = GroupDAO.getInstance();
		Group group = g_dao.get(Integer.parseInt(group_param[0]));
		this.setGroup(group);
		*/
		// parts ...
		Iterator<String> it = map.keySet().iterator();
		//TODO We are currently skipping out sections. Change this if we introduce them.
		// Map<String, String[]> section_map = new HashMap<String, String[]>();
		Map<String, String[]> question_map  = new HashMap<String, String[]>();
		while(it.hasNext()){
			String param = it.next();
			/*
			if (param.startsWith(tag + "section_")) {
				section_map.put(param,map.get(param));
			}
			*/
			if (param.startsWith(tag + "question_")) {
				question_map.put(param,map.get(param));
			}
		}
		List<Question> parts = Question.make(eval_tag,question_map);
		setParts(parts);
	}


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

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}  
}

package evaluationSystemPG1.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

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

	public static List<EvalTemplate> make(String tag,Map<String, String[]> map){
		/* tag = eval_{id}. The {id} is optional.
		 * If empty, create a new instance. else update the existing one.
		 */
		Pattern p = Pattern.compile("^eval_(\\d*)");
		// matches, get id, ...
		// Note that there is only one EvalTemplate to save at a time.
		
		//FIXME Temporary code
		boolean has_id = false;
		int id = 1;
		String eval_tag = "eval_" + id + ".";
		// End temporary code
		
		EvalTemplate et;
		if (has_id) {
			et = EvalTemplateDAO.getEvalTemplate(id);
		} else {
			et = new EvalTemplate();
		}
		
		et.makeFields(tag,eval_tag,map);
		
		List<EvalTemplate> et_list = new LinkedList<EvalTemplate>();
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

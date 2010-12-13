package evaluationSystemPG1.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import evaluationSystemPG1.abstracts.IEntity;
import evaluationSystemPG1.abstracts.Option;

@Entity(name="questions")
public class Question implements Serializable,IEntity{

	private static final long serialVersionUID = 544334524525425L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String text;
	private Date date;
	
	@OneToOne(cascade = CascadeType.ALL)
	private TextOption textOption; 

	@OneToOne(cascade = CascadeType.ALL)
	private Option multiOption;
	
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

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setMultiOption(Option multiOption) {
		this.multiOption = multiOption;
	}

	public Option getMultiOption() {
		return multiOption;
	}

	public void setTextOption(TextOption textOption) {
		this.textOption = textOption;
	}

	public TextOption getTextOption() {
		return textOption;
	}

	public static List<Question> make(String tag,Map<String, String[]> map){
		/* incoming tag should be "eval_{id}.".
		 * Tag to handle is: question_ord{ord}_{id}.
		 * All of them should already be pre-screened. 
		 * The {id} is optional.
		 * The order is not optional.
		 * Get the order.
		 */
		Pattern p_question = Pattern.compile(tag + "question_ord(\\d+)_(\\d*)");
		Iterator<String> it = map.keySet().iterator();
		
		/* We have to group the param_strings so we create/update one question for every order.
		 * We use a HashMap<Integer,List<String>> for that purpose, with order as the key Integer.
		 */
		HashMap<Integer,List<String>> question_in_order = new HashMap<Integer,List<String>>();
		while (it.hasNext()) {
			Integer order;
			String param_string = it.next();
			Matcher m = p_question.matcher(param_string);
			boolean found_question = !m.lookingAt();
			
			if (found_question) {
				order = new Integer(Integer.parseInt(m.group(1)));
				List<String> one_question_param_strings = question_in_order.get(order);
				if (one_question_param_strings == null) {
					one_question_param_strings = new LinkedList<String>();
				}
				one_question_param_strings.add(param_string);
				question_in_order.put(order,one_question_param_strings);
			}
		} 
		
		/* Now that they are grouped by order, we can look at the id. 
		 * Then we can create it or update it as needed.
		 * Note that it is enough to look at the first in each group to get the id. */
		Iterator<Integer> it_grouped = question_in_order.keySet().iterator();
		// return value
		List<Question> q_list = new LinkedList<Question>();
		
		while (it_grouped.hasNext()) {
			Integer order_key = it_grouped.next();
			int order = order_key.intValue();
			List<String> param_strings = question_in_order.get(order_key);

			// Get the id. The first is enough.
			Matcher m = p_question.matcher("question_ord" + order + "_(\\d*)");
			m.lookingAt();
			
			boolean has_id = false;
			int id = 0;
			try {
				id = Integer.parseInt(m.group(1));
				has_id = true;
			} catch (Exception e) {
				id = 0;
			}

			// If empty, create a new instance. else update the existing one.
			Question q;
			if (has_id) {
				QuestionDAO qDAO = QuestionDAO.getInstance();
				q = qDAO.get(id);
			} else {
				q = new Question();
			}
			
			// We will build up this in a cascading way, so that every class just handle itself.
			String id_string = has_id ? id + "" : "";
			String question_tag = "question_ord" + order + "_" + id_string + ".";
			// make all the fields. Note that it will in turn call the dependant classes make function.
			q.makeFields(tag,question_tag,map);
			
			q_list.add(q);	
		}
		
		return q_list;
	}
	

	private void makeFields(String tag,String eval_tag,Map<String, String[]> map) {
		/*
		String text;
		Date date;
		TextOption textOption; 
		Option multiOption;
		*/
		
		// date
		// NOW()
		Calendar c = Calendar.getInstance();
		Date d = c.getTime();
		setDate(d);
		// text
		String[] text_param = map.get(tag + "text");
		if (text_param != null) {
			setText(text_param[0]);
		}
		// textOption & multiOption 
		//TODO Refactor out a method for this...
		Iterator<String> it = map.keySet().iterator();
		Map<String, String[]> textOption_map  = new HashMap<String, String[]>();
		Map<String, String[]> multiOption_map  = new HashMap<String, String[]>();
		
		while(it.hasNext()){
			String param = it.next();
			if (param.startsWith(tag + "textOption_")) {
				textOption_map.put(param,map.get(param));
			}
			if (param.startsWith(tag + "multiOption_")) {
				multiOption_map.put(param,map.get(param));
			}
		}
			
		List<TextOption> text_options = TextOption.make(eval_tag,textOption_map);
		setTextOption(text_options.get(0));
				
		List<Option> multi_options = Option.make(eval_tag,textOption_map);
		setMultiOption(multi_options.get(0));
	}

}

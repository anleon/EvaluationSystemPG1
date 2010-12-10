package evaluationSystemPG1.abstracts;

import java.util.HashMap;

import evaluationSystemPG1.exceptions.EvaluationParamsException;

public interface IHtml {
	
	public abstract String toHtml(String parentIdTag , int myIndex);
	public abstract void answerParams(HashMap<String,String[]> params) throws EvaluationParamsException;
	
}

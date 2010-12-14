package evaluationSystemPG1;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;

import evaluationSystemPG1.abstracts.EntitiesDAO;
import evaluationSystemPG1.db.HibernateUtil;
import evaluationSystemPG1.entities.Evaluation;
import evaluationSystemPG1.entities.EvaluationDAO;
import evaluationSystemPG1.entities.Group;
import evaluationSystemPG1.entities.GroupDAO;
import evaluationSystemPG1.entities.Question;

/**
 * Servlet implementation class Guestbook
 */
public class AdminServlet extends HttpServlet {
    	
    /**
	 * 
	 */
	private static final long serialVersionUID = 6535687373602746205L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
    }
    
    public void init(ServletContext servletContext){
    	File configFile = new File(servletContext.getRealPath("WEB-INF/hibernate/hibernate.cfg.xml"));	  			
    	HibernateUtil.initHibernate(configFile);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*HttpSession session = request.getSession();
		GuestbookSession guestSession = (GuestbookSession) session.getAttribute("session");
		if (session.getAttribute("session")==null){
			guestSession = new GuestbookSession();
		}*/		
		init(this.getServletContext());
		/*
		 * These pages are handled by this servlet:
		 * /Login
		 * /Evaluations
		 * /Evaluations/{id}
		 * /Groups
		 * /Groups/{id}
		 * 
		 * /Evaluations/Create
		 * /Groups/Create
		 * 
		 * */
		
		String s = request.getRequestURI();
		String[] ss = s.split("/");
	
		// String projectName = ss[1];
		// String servletName = ss[2];
		String pageUrlName = "";
		String identifier = "";
		if (ss.length > 3) {
			pageUrlName = ss[3];
		}
		if (ss.length > 4) {
			identifier = ss[4];
		}
		
		if ("Evaluations".equals(pageUrlName)){
			if (!identifier.isEmpty()){
				int id = 0;
				try {
					id = Integer.parseInt(identifier);
				} catch (Exception e) {
					id = 0;
				}
				pageEvaluation(request, response, id);
			}
			else {
				pageEvaluationList(request, response);
			}	
		} else if ("Groups".equals(pageUrlName)){
			if (!identifier.isEmpty()){
				int id = 0;
				try {
					id = Integer.parseInt(identifier);
				} catch (Exception e) {
					id = 0;
				}
				pageGroup(request, response, id);
			}
			else {
				pageGroupList(request, response);
			}
		} else if ("Login".equals(pageUrlName)){
			pageLogin(request, response);
		} else {
			pageLogin(request, response);			
		}
		
		
		
		
/*		if ("Evaluations".equals(pageName)) {
			pageEval(request,response,identifier);
		} else if ("Groups".equals(pageName)) {
			request.getRequestDispatcher("/Groups.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		
		
		Writer wr = response.getWriter();
		wr.write(pageUrlName + "<br />");
		for(String string: ss) {
			wr.write(string);
			wr.write(",");
		}
	*/	
	}

	private void pageEvaluation(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		EvaluationDAO etDAO = EvaluationDAO.getInstance();
		GroupDAO gDAO = GroupDAO.getInstance();
		List<Group> groups = gDAO.getAll();
		request.setAttribute("groups", groups);
		
		if (id == 0) {
			Evaluation et = new Evaluation();
			
			request.getRequestDispatcher("/Evaluation.jsp").include(request, response);
		} else {
			Evaluation et = etDAO.get(id);
			System.out.println(et.getParts().get(0).getText());
			if (et != null) {
				request.setAttribute("evaluation", et);
			} else {
				et = new Evaluation();
			}
			request.getRequestDispatcher("/Evaluation.jsp").include(request, response);
		}
	}

	private void pageEvaluationList(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		EvaluationDAO etDAO = EvaluationDAO.getInstance();
		List<Evaluation> evaluationList = etDAO.getAll();
		request.setAttribute("evaluationList", evaluationList);
		request.getRequestDispatcher("EvalvaluationList.jsp").forward(request, response);
	}

	private void pageLogin(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void pageGroupList(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void pageGroup(HttpServletRequest request,
			HttpServletResponse response, int id) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// init(this.getServletContext());
		
		// Save the Evaluation. 
		//NOTE  It does check after a button named "save_eval".
		boolean do_save_eval = request.getParameter("save_eval") != null ? true : false;
		if (do_save_eval) {
			Map<String,String[]> map = (Map<String, String[]>) request.getParameterMap();
			List<Evaluation> et_list = Evaluation.make("",map);
			EvaluationDAO etDAO = EvaluationDAO.getInstance();
			etDAO.saveAll(et_list);
			Evaluation et = et_list.get(0);
			request.setAttribute("evalTemplate", et);
			request.getRequestDispatcher("EvalTemplate.jsp").forward(request, response);
		}
	}
}

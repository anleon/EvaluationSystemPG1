package evaluationSystemPG1;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;

import evaluationSystemPG1.db.HibernateUtil;
import evaluationSystemPG1.entities.Evaluation;
import evaluationSystemPG1.entities.EvalTemplateDAO;

/**
 * Servlet implementation class Guestbook
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	
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
		String pageName = "";
		String identifier = "";
		if (ss.length > 3) {
			pageName = ss[3];
		}
		if (ss.length > 4) {
			identifier = ss[4];
		}
		
		if ("Evaluations".equals(pageName)) {
			pageEval(request,response,identifier);
		} else if ("Groups".equals(pageName)) {
			request.getRequestDispatcher("/Groups.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		
		
		Writer wr = response.getWriter();
		wr.write(pageName + "<br />");
		for(String string: ss) {
			wr.write(string);
			wr.write(",");
		}
		
	}

	private void pageEval(HttpServletRequest request, HttpServletResponse response, String identifier) throws ServletException, IOException {
		int id;
		try {
			id = Integer.parseInt(identifier);
		} catch (Exception e) {
			id = 0;
		}
		if (id == 0) {
			request.getRequestDispatcher("EvalTemplates.jsp").forward(request, response);
		} else {
			Evaluation et = EvalTemplateDAO.getEvalTemplate(id);
			request.setAttribute("EvalTemplate", et);
			request.getRequestDispatcher("EvalTemplate.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		init(this.getServletContext());
		
		request.getRequestDispatcher("QuestionTest.jsp").include(request, response);
		
		// TODO Auto-generated method stub
	}

}

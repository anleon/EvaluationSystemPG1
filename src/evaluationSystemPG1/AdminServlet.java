package evaluationSystemPG1;

import java.io.File;
import java.io.IOException;
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
		System.out.println("japp");
		request.getRequestDispatcher("/QuestionTest.jsp").include(request, response);
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

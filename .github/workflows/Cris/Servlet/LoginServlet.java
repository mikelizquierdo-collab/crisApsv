package es.upm.dit.apsv.cris.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import es.upm.dit.apsv.cris.dao.ResearcherDAOOfyImplementation;
import es.upm.dit.apsv.cris.model.Researcher;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet({"/LoginServlet", "/"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
 	final String ADMIN = "root";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
                    throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/LoginView.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
                    throws ServletException, IOException {

		UserService userService = UserServiceFactory.getUserService();
		
		if (null == request.getUserPrincipal()) {
			request.getSession().invalidate();
			request.setAttribute("message", "Invalid user or password");
			getServletContext().getRequestDispatcher("/LoginView.jsp").forward(request, response);
		} else {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			Researcher researcher = ResearcherDAOOfyImplementation.getInstance().readAsUser(email, "");
			if (ADMIN.equals(email) && ADMIN.equals(password)) {
				Researcher root = new Researcher();
				root.setId("root");
				request.getSession().setAttribute("user", root);
				response.sendRedirect(request.getContextPath() + "/AdminServlet");
			} else if (null != researcher) {
				request.getSession().setAttribute("user", researcher);
				response.sendRedirect(request.getContextPath() + "/ResearcherServlet" + "?id=" + researcher.getId());
			} else {
				request.getSession().invalidate();
				request.setAttribute("message", "Invalid user or password");
				getServletContext().getRequestDispatcher("/LoginView.jsp").forward(request, response);
			}
		}
	}
}

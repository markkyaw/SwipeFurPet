package testing;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		int exists = Sql.validateLogin(email, password);
		
		if(exists == 0) {
			request.setAttribute("exists", "0");
			RequestDispatcher rd = request.getRequestDispatcher("main.html");  
	        rd.forward(request, response);  
			
		}
		//success
		else {
			RequestDispatcher rd = request.getRequestDispatcher("main.html");  
	        rd.forward(request, response);  
			
		}
        
	}

}

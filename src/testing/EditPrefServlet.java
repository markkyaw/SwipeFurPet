package testing;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditPrefServlet")
public class EditPrefServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		String email = request.getParameter("email");
		String petType = request.getParameter("petType");
		String size = request.getParameter("size");
		String age = request.getParameter("age");
		int children = Integer.parseInt(request.getParameter("children"));
		int dogs = Integer.parseInt(request.getParameter("dogs"));
		int cats = Integer.parseInt(request.getParameter("cats"));
		
		Sql.updatePreferences(email, petType, size, age, children, dogs, cats);
	
        RequestDispatcher rd = request.getRequestDispatcher("edit.html");  
        rd.forward(request, response);  
	}

}

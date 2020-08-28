package testing;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdopterRegister
 */
@WebServlet("/AdopterRegister")
public class AdopterRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//make sure user doesn't already exists
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		
		//user does not exist
		int exists = Sql.checkExists(email); 
		if(exists == 0) {
			out.write("DNE");; 
			return; 
		}
		//user exists
		else {
			out.write("exists");
			return; 
		} */
		
	}

	//see if user already exists
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("bitch"); 
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		//hard code
		String zipcode = "90089"; 
		String city = request.getParameter("location");
		String password = request.getParameter("password");
		
		int exists = Sql.createAdopter(fname, lname, email, phone, zipcode, city, password);
		
		if(exists == 1) {
			request.setAttribute("exists", 1);
			RequestDispatcher rd = request.getRequestDispatcher("adopterRegister.html");  
	        rd.forward(request, response);  
		}
		//user DNE and we can proceed
		else {
			RequestDispatcher rd = request.getRequestDispatcher("adopterRegisterPreferences.html");  
	        rd.forward(request, response); 
		}

	}

}

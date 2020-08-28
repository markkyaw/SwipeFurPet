package testing;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.google.gson.JsonObject;

@WebServlet("/AdopterPreference")
public class AdopterPreference extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email"); 
		
		System.out.println("the email is: " + email); 
		Preferences pref = Sql.getPreference(email);
		JSONObject json = new JSONObject(); 
		
		try {
			json.put("type", pref.petType());
			json.put("size", pref.getSize());
			json.put("age", pref.getAge());
			json.put("children", pref.children()); 
			json.put("dogs", pref.dogs()); 
			json.put("cats", pref.cats()); 
		
		} catch (Exception e) {
			System.out.println("");
		}
		
		response.getWriter().print(json);
		
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
		
		Sql.createPreferences(email, petType, size, age, children, dogs, cats);
		System.out.println("didu happen");
		//check which attributes we need and then pass it in 
        RequestDispatcher rd = request.getRequestDispatcher("main.html");  
        rd.forward(request, response);  
	}

}

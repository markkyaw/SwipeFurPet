package testing;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MatchServlet
 */
@WebServlet("/MatchServlet")
public class MatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	//posting a swipe right
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int petID, String petName, String petType, String age, String size, String gender, String Rescue_ID, String ImgLink,
		//int children, int dogs, int cats) {
		//we get the json object for the pet
		String userEmail = request.getParameter("userEmail");
		
		int petID = Integer.parseInt(request.getParameter("petID"));
		String name = request.getParameter("pet_name");
		String petType = request.getParameter("petType");
		String age = request.getParameter("age");
		String size = request.getParameter("size");
		String rescueID = request.getParameter("rescueID");
		String imgLink = request.getParameter("imgLink");
		int children = Integer.parseInt(request.getParameter("children"));
		int dogs = Integer.parseInt(request.getParameter("dogs"));
		int cats = Integer.parseInt(request.getParameter("cats"));
		
		Sql.createPet(petID, name, petType, age, size, rescueID, imgLink, children, dogs, cats);
		//show interest
		Sql.match(userEmail, petID); 
	}

}


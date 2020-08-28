package testing;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChatServlet
 */
@WebServlet("/chatServlet")
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	//from ajax
	//creating a message in the base, does not need a response
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); 
		
		//should be 1
		int sender = Integer.parseInt(request.getParameter("userSend"));; 
		String email = request.getParameter("userEmail"); 
		int petID = Integer.parseInt(request.getParameter("petID"));
		//is this okay? 
		String timeStamp = request.getParameter("timeStamp");
		Timestamp ts = Timestamp.valueOf(timeStamp);
		String content = request.getParameter("content");
		
		Sql.createMessage(sender, petID, email, ts, content);

	}

}

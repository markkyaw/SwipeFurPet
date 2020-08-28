package testing;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/RescueRegister")
public class RescueRegister extends javax.servlet.http.HttpServlet {
    //make sure rescue organization doesn't already exist
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        
    }
    //initialize rescue organization
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String link = request.getParameter("link");
        String city = request.getParameter("city");
        String zipcode = request.getParameter("zipcode");

        Sql.createRescue(id, name, email, phone, link, city, zipcode);

        RequestDispatcher rd = request.getRequestDispatcher("rescueRegisterPreferences.html");
        rd.forward(request, response);
    }
}

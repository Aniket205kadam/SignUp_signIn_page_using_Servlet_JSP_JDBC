package App.Registration;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/Register")
public class Register extends HttpServlet {


	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//user info
		String name = request.getParameter("userName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String city = request.getParameter("userCity");
		
		Model model = new Model(name, email, password, city);
		
		
		int rowsAffected = model.register();
		
		//create a session
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		
		if(rowsAffected == 0) {
			response.sendRedirect("/RegistrationAppUsingMVC/failure.jsp");
		}
		else {
			response.sendRedirect("/RegistrationAppUsingMVC/success.jsp");
		}
	}
}

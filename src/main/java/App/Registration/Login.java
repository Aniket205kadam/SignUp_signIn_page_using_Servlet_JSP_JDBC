package App.Registration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		LoginChecker loginChecker = new LoginChecker(userName, password);
		int pass_code = loginChecker.login();
		
		//create the session
		HttpSession session = request.getSession();
		session.setAttribute("name", userName);
		
		/*
		 * loginChecker return 
		 * 2 means user enter password is correct,
		 * -2 means password is wrong, 
		 * -3 means userName is not exist
		 * */
		
		if(pass_code == 2) {
			//password is correct
			response.sendRedirect("/RegistrationAppUsingMVC/correctPassword.jsp");
		} 
		else if (pass_code == -2) {
			//password is wrong
			response.sendRedirect("/RegistrationAppUsingMVC/wrongPassword.jsp");
		}
		else {
			//user name is not exist
			response.sendRedirect("/RegistrationAppUsingMVC/notExist.jsp");
		}
	}

}

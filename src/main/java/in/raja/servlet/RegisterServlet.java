package in.raja.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.raja.validate.UserValidate;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("userName");
		String userMail = request.getParameter("userMail");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String phoneNumber = request.getParameter("phoneNumber");

		
		boolean isValid = UserValidate.validateUser(username, userMail, password1, password2, phoneNumber);
		
	
		

		if (isValid) {

			
			response.sendRedirect("Login.jsp");
		} else {
			response.sendRedirect("Register.jsp?errorMessage=Invalid Login Credentials");
		}
	}
}

package in.raja.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.raja.service.DogManager;

/**
 * Servlet implementation class forgotPasswordServlet
 */
@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForgotPasswordServlet() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		try {

			session.removeAttribute("Message");
			String phoneNumber = request.getParameter("phoneNumber");

			String password = request.getParameter("password");
			String confirmPassword = request.getParameter("confirmPassword");
			boolean success = DogManager.forgotUserDetails(phoneNumber, password, confirmPassword);

			if (success) {

				String errorMessage = "User password update Successfully";
				response.sendRedirect("Login.jsp?infoMessage=" + errorMessage);
			} else {

				String errorMessage = "Can't Change your password";
				response.sendRedirect("ForgotPassword.jsp?errorMessage=" + errorMessage);
			}

		}

		catch (Exception e) {

			String errorMessage = "Invalid User";
			response.sendRedirect("ForgotPassword.jsp?errorMessage=" + errorMessage);
		}

	}
}

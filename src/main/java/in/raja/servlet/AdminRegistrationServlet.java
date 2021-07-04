package in.raja.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.raja.model.UserDetails;
import in.raja.service.UserService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/AdminRegistrationServlet")
public class AdminRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String userMail = request.getParameter("userMail");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String city = request.getParameter("city");
		HttpSession session = request.getSession();

		try {
			session.removeAttribute("Message");

			long phoneNumber = Long.parseLong(request.getParameter("phoneNumber"));

			UserDetails registerDetails = new UserDetails(userName, userMail, password, confirmPassword, phoneNumber,
					city);

			UserService adduserDetails = new UserService();

			boolean success = adduserDetails.addUser(registerDetails);

			if (success) {

				String errorMessage = "User Added Successfully";
				response.sendRedirect("Admin.jsp?infoMessage=" + errorMessage);
			} else {

				String errorMessage = "Invalid User";
				response.sendRedirect("AdminRegistration.jsp?errorMessage=" + errorMessage);
			}

		}

		catch (Exception e) {

			String errorMessage = e.getMessage();
			response.sendRedirect("Register.jsp?errorMessage=" + errorMessage);
		}

	}
}

package in.raja.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.raja.dao.UserDAO;
import in.raja.exception.DbException;
import in.raja.exception.ServiceException;
import in.raja.model.UserDetails;
import in.raja.service.UserRegister;

/**
 * Servlet implementation class UserLoginServlet
 */

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		UserDetails user = null;
		boolean isValid = false;
		try {
			isValid = UserRegister.checkUser(username, password);
			user = UserDAO.findUserByUsername(username);

			if (isValid) {
				HttpSession session = request.getSession();
				session.setAttribute("LOGGED_IN_USER", username);
				session.setAttribute("LOGGED_IN_USEREMAIL", user.getUserMail());
				session.setAttribute("ROLE", "user");

				response.sendRedirect("ListDogByPriceUser.jsp");
			} else {
				response.sendRedirect("Login.jsp?errorMessage=Invalid Login Credentials");
			}
		} catch (ServiceException e) {
			response.sendRedirect("Login.jsp?errorMessage=" + e.getMessage());
		} catch (DbException e) {
			e.printStackTrace();
		}
	}
}
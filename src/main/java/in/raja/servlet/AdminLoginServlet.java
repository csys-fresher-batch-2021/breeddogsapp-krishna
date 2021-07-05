package in.raja.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.raja.exception.DbException;
import in.raja.exception.ServiceException;
import in.raja.service.UserRegister;

/**
 * Servlet implementation class UserLoginServlet
 */

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
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
		UserRegister userRegister = new UserRegister();
		boolean isValid = false;
		try {
			isValid = userRegister.checkAdmin(username, password);

			if (isValid) {
				HttpSession session = request.getSession();
				session.setAttribute("LOGGED_IN_USER", "ADMIN");
				session.setAttribute("ADMINROLE", "admin");
				response.sendRedirect("AdminPage.jsp");
			} else {
				response.sendRedirect("Admin.jsp?errorMessage=Invalid Login Credentials");
			}
		} catch (ServiceException e) {
			response.sendRedirect("Admin.jsp?errorMessage=" + e.getMessage());

		} catch (DbException e) {
			e.printStackTrace();
		}
	}
}
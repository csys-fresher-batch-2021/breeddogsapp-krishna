package in.raja.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserRegister userRegister = new UserRegister();
		boolean isValid = userRegister.checkUser(username, password);
		if (isValid) {
			HttpSession session = request.getSession();
			session.setAttribute("LOGGED_IN_USER", username);
			response.sendRedirect("placeOrder.jsp");
		} else {
			response.sendRedirect("Index.jsp?errorMessage=Invalid Login Credentials");
		}
	}
}
package in.raja.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.raja.model.forgotUser;
import in.raja.service.DogManager;

/**
 * Servlet implementation class forgotPasswordServlet
 */
@WebServlet("/forgotPasswordServlet")
public class forgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public forgotPasswordServlet() {
        super();
    }

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		try {
			
			session.removeAttribute("Message");
		String phoneNumber=request.getParameter("phoneNumber");

		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		

			
		

			boolean success= DogManager.forgotUserDetails(phoneNumber , password1 , password2);
			
			
			
			if (success) {

				String errorMessage = "User password update Successfully";
				response.sendRedirect("Login.jsp?infoMessage=" + errorMessage);
			} else {

				String errorMessage = "Can't Change your password";
				response.sendRedirect("forgotPassword.jsp?errorMessage=" + errorMessage);
			}

		}

		catch (Exception e) {

			String errorMessage ="Invalid User" ;
			response.sendRedirect("forgotPassword.jsp?errorMessage=" + errorMessage);
		}

    
    }
}























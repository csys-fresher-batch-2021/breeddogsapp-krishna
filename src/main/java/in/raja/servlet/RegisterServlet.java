package in.raja.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.raja.model.UserDetails;
import in.raja.service.DogManager;

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
		long phoneNumber=Long.parseLong(request.getParameter("phoneNumber"));
		String city = request.getParameter("city");


		try {
			
			
		UserDetails registerDetails = new UserDetails(username, userMail, password1,password2, phoneNumber, city);
		
		
		
		

		DogManager adduserDetails = new DogManager();
		
		
		boolean success=adduserDetails.addUser(registerDetails);
		
		
		if (success) {

			String errorMessage = "User Added Successfully";
			response.sendRedirect("UserDogDisplay.jsp?infoMessage=" + errorMessage);
		} else {

			String errorMessage = "Invalid User";
			response.sendRedirect("adddog.jsp?errorMessage=" + errorMessage);
		}

	}

	catch (Exception e) {

		String errorMessage = e.getMessage();
		response.sendRedirect("adddog.jsp?errorMessage=" + errorMessage);
	}

		
		
		
		
	}
}

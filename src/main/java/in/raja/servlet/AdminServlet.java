

package in.raja.servlet;




import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.raja.service.AdminService;





@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public AdminServlet() {
        super();
       
    }


    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String userId = request.getParameter("userId");
			String password = request.getParameter("password");
			try {
				
				
					boolean username = AdminService.checkAdmin(userId, password);
					if(username) {
      				HttpSession session = request.getSession();
		    		session.setAttribute("LOGGED_IN_USER", username);
			    	session.setAttribute("ROLE", "ADMIN");
					response.sendRedirect("adddog.jsp");
					
					
				} 
					
					else {
						response.sendRedirect("Login.jsp?errorMessage=Invalid Login Credentials");
					}

			}

			catch (Exception e) {
				response.sendRedirect("Login.jsp?errorMessage=Please Enter All Details");
			}
		}
	}



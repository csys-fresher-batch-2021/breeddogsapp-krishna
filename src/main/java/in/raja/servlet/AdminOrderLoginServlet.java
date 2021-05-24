package in.raja.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.raja.service.AdminService;
import in.raja.validate.AdminValidate;



/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminOrderLoginServlet")
public class AdminOrderLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminOrderLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String userId = request.getParameter("userId");
			String password = request.getParameter("password");
			try {
				
				
					boolean username = AdminService.checkAdmin(userId, password);
					if(username) {
      				HttpSession session = request.getSession();
		    		session.setAttribute("LOGGED_IN_USER", username);
			    	session.setAttribute("ROLE", "ADMIN");
					response.sendRedirect("orderDetail.jsp");
					
					
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


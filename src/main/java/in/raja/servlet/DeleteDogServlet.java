package in.raja.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteDonorServlet
 */
@WebServlet("/DeleteDogServlet")
public class DeleteDogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		System.out.println("Deleted feature");
		
		
		String donorName=request.getParameter("donorName");
		out.println(donorName);
		out.println("feature");
		/**String donorBlood=request.getParameter("bloodGroup");
		Long donorNumber=Long.parseLong(request.getParameter("mobileNumber"));
		Integer donorAge=Integer.parseInt(request.getParameter("age"));
		DonorManager.addDonor(donorBlood,donorName,donorNumber,donorAge);
		response.sendRedirect("donordetails.jsp");**/

}
}

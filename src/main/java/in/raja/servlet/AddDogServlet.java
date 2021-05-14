package in.raja.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.raja.service.DogManager;
/**
 * Servlet implementation class AddDonorServlet
 */
@WebServlet("/AddDogServlet")
public class AddDogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Integer dogno=Integer.parseInt(request.getParameter("dogno"));
		String dogname=request.getParameter("dogname");
		String age=request.getParameter("age");
		String gender=request.getParameter("gender");
		String place=request.getParameter("place");
		Integer price=Integer.parseInt(request.getParameter("price"));

		String insurance=request.getParameter("insurance");
		DogManager.addDog(dogno,dogname,age,gender,place,price,insurance);
		response.sendRedirect("dogdetails.jsp");
		
	}



}

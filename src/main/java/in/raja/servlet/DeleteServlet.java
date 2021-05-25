package in.raja.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.raja.service.DogManager;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
  			 
			   Integer dogno=Integer.parseInt(request.getParameter("dogno"));
				
			   boolean deleted = DogManager.deleteDog(dogno);
			   if(deleted){
			      response.sendRedirect("dogdetails.jsp");
			   }
			  
		   }
		   catch(Exception e)
		   {
			   
              String error = "unable to delete";
              response.sendRedirect("dogdetails.jsp?error=" + error);

		   }
		 
	   }
	 
		
  


	}



package in.raja.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.raja.model.DogDetails;
import in.raja.service.DogManager;


@WebServlet("/DeleteOrderServlet")
public class DeleteOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
  			 
			   Integer dogNo=Integer.parseInt(request.getParameter("dogno"));
			   
			   
				DogDetails product = new DogDetails(dogNo);

				
			   boolean deleted = DogManager.deleteOrder(dogNo);
			   
			   

			   if(deleted){
			      response.sendRedirect("orderDetail.jsp");
			   }
			  
		   }
		   catch(Exception e)
		   {
			   
              String error = "unable to delete";
              response.sendRedirect("orderDetail.jsp?error=" + error);

		   }
		 
	   }
	 
		
  


	}


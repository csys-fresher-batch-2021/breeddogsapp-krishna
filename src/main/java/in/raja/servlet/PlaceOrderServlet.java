package in.raja.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.raja.dao.OrderDAO;
import in.raja.model.AdminOrderList;
import in.raja.service.DogManager;

/**
 * Servlet implementation class placeOrderServlet
 */
@WebServlet("/PlaceOrderServlet")
public class PlaceOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    

	@Override
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		

			Integer dogno=Integer.parseInt(request.getParameter("dogno"));
			long phoneno=Long.parseLong(request.getParameter("phoneno"));
		    String address = request.getParameter("address");
		    
		    
		   
			
		    AdminOrderList placeOrderDetails = new AdminOrderList(dogno, phoneno, address);
		    		    

			
			boolean isvalid = false;
		
				try {
				
					isvalid = DogManager.checkAvailable(dogno);
					
	               if(isvalid==true)	{
					OrderDAO.saveOrder(placeOrderDetails);
			
								
					 response.sendRedirect("billUser.jsp?dogno="+dogno+"&phoneno="+phoneno+"&address="+address);
	               }
					
					else
					{
				response.sendRedirect("AdminOrderLogin.jsp");
					
			}
					
		} 	catch (Exception e) {
					e.printStackTrace();
			}
	

			
			
	

}
}


	
			




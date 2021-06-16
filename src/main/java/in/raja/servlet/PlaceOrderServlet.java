package in.raja.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.raja.dao.OrderDAO;
import in.raja.model.AdminOrderList;
import in.raja.service.AdminOrderListService;

/**
 * Servlet implementation class placeOrderServlet
 */
@WebServlet("/PlaceOrderServlet")
public class PlaceOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    

	@Override
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		try {
			
			HttpSession sess = request.getSession();
			String userName = (String) sess.getAttribute("LOGGED_IN_USER");
			
			
			
			
			
            int id = OrderDAO.getId(userName);
            String status = "Pending";




			Integer dogno=Integer.parseInt(request.getParameter("dogno"));
			long phoneno=Long.parseLong(request.getParameter("phoneno"));
		    String address = request.getParameter("address");
		    
		    AdminOrderList obj=new AdminOrderList(id , phoneno , address , status , dogno ,  );
		    
		    

		    
		   boolean added = AdminOrderListService.addOrder( obj );
			
		   if(added) {
			   
				 response.sendRedirect("billUser.jsp?dogno="+dogno+"&phoneno="+phoneno+"&address="+address);

		   }
			
			
					else
					{
				response.sendRedirect("placeOrder.jsp");
					
			}
					
		} 	catch (Exception e) {
					e.printStackTrace();
			}
	
	

}
}


	
			




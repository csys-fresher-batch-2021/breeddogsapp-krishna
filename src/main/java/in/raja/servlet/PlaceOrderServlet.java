package in.raja.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.raja.service.AdminOrderListService;
import in.raja.service.DogManager;

/**
 * Servlet implementation class placeOrderServlet
 */
@WebServlet("/PlaceOrderServlet")
public class PlaceOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		Integer dogno=Integer.parseInt(request.getParameter("dogno"));
		String address = request.getParameter("address");
		boolean isvalid=DogManager.checkAvailable(dogno);
		
		if(isvalid) {
			AdminOrderListService.addOrder(dogno,address);
			response.sendRedirect("orderDetail.jsp");
		}
		else{
		response.sendRedirect("AdminOrderList.java");
		
		}
	}

}

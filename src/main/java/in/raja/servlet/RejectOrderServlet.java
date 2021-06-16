package in.raja.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.raja.service.AdminOrderListService;


@WebServlet("/RejectOrderServlet")
public class RejectOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
    	try {
			int orderId = Integer.parseInt(request.getParameter("orderId"));
			System.out.println(orderId);
			boolean updated = AdminOrderListService.rejectOrder(orderId);
			if(updated) {
				response.sendRedirect("orderDetail.jsp");
			}
		}catch(Exception e) {
			response.sendRedirect("orderDetail.jsp?errorMessage=No orders available");
		}

    	

    }
}
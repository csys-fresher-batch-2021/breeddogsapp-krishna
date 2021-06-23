package in.raja.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.raja.service.AdminOrderListService;

/**
 * Servlet implementation class AcceptOrderServlet
 */
@WebServlet("/AcceptOrderServlet")
public class AcceptOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int orderId = Integer.parseInt(request.getParameter("orderId"));
			int dogNo = Integer.parseInt(request.getParameter("DogNo"));

			boolean updated = AdminOrderListService.acceptOrder(orderId, dogNo);
			if (updated) {
				response.sendRedirect("OrderDetail.jsp");
			}
		} catch (IOException e) {
			response.sendRedirect("OrderDetail.jsp?errorMessage=No orders available");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}

package in.raja.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.raja.service.DogManager;

@WebServlet("/DeleteOrderServlet")
public class DeleteOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String value = request.getParameter("orderId");
			Integer orderId = Integer.parseInt(value);
			boolean deleted = DogManager.deleteOrder(orderId);
			if (deleted) {
				response.sendRedirect("UserOrderView.jsp");
			}

		} catch (Exception e) {
			String error = "unable to delete";
			response.sendRedirect("UserOrderView.jsp?error=" + error);

		}

	}

}

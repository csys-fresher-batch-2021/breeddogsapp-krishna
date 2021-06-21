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
			System.out.println("1st"+value);
			Integer orderId = Integer.parseInt(value);
			System.out.println("1st"+orderId);
			boolean deleted = DogManager.deleteOrder(orderId);
			System.out.println("3rd"+deleted);
			if (deleted) {
				System.out.println("success");
				response.sendRedirect("UserOrderView.jsp");
			}

		} catch (Exception e) {
			System.out.println("Failed");
			String error = "unable to delete";
			response.sendRedirect("UserOrderView.jsp?error=" + error);

		}

	}

}

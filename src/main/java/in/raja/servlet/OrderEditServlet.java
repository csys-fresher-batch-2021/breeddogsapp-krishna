package in.raja.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import in.raja.dao.UserDAO;
import in.raja.service.UserService;

@WebServlet("/OrderEditServlet")
public class OrderEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OrderEditServlet() {
		super();
	}

	@Override

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String order = request.getParameter("dt");
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("LOGGED_IN_USER");

		try {
			JsonObject obj = new JsonParser().parse(order).getAsJsonObject();
			int id = UserDAO.findByUsername(user);

			String obj1 = obj.get("phnoneNo").getAsString();

			long mobileNo = Long.parseLong(obj1);

			String address = obj.get("address").getAsString();
			int orderId = obj.get("orderId").getAsInt();

			UserService.editOrderDetails(mobileNo, address, id, orderId);
			response.sendRedirect("UserOrderView.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package in.raja.servlet;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.raja.dao.UserDAO;
import in.raja.model.AdminOrderList;
import in.raja.service.AdminOrderListService;

/**
 * Servlet implementation class placeOrderServlet
 */
@WebServlet("/PlaceOrderServlet")
public class PlaceOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			HttpSession sess = request.getSession();

			String userName = (String) sess.getAttribute("LOGGED_IN_USER");
			AdminOrderList obj = new AdminOrderList();

			obj.setUserId(UserDAO.findByUsername(userName));
			obj.setStatus("Pending");

			obj.setDogNo(Integer.parseInt(request.getParameter("dogNo")));
			obj.setPhoneNo(Long.parseLong(request.getParameter("phoneNo")));
			obj.setAddress(request.getParameter("address"));
			obj.setOrderDate(LocalDateTime.now());
			obj.setDeliveryDate(LocalDateTime.now().plusDays(5));
			boolean added = AdminOrderListService.addOrder(obj);

			if (added) {

				response.sendRedirect("BillUser.jsp?dogNo=" + obj.getDogNo() + "&phoneNo=" + obj.getPhoneNo()
						+ "&address=" + obj.getAddress());

			}

			else {
				response.sendRedirect("PlaceOrder.jsp");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

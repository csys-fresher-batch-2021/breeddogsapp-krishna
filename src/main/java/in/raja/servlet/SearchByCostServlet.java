package in.raja.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import in.raja.model.DogDetail;
import in.raja.service.DogManager;

/**
 * Servlet implementation class SearchByCostServlet
 */
@WebServlet("/SearchByCostServlet")
public class SearchByCostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String cost = request.getParameter("cost");
			int type = Integer.parseInt(cost);
			List<DogDetail> added = DogManager.searchDogByCost(type);
			Gson gson = new Gson();
			String obj = gson.toJson(added);
			PrintWriter out = response.getWriter();
			out.println(obj);
			out.flush();

		} catch (Exception e) {
			String errorMessage = "Unable to add Breeds ";
			response.sendRedirect("ListDogsByPriceUser.jsp?errorMessage=" + errorMessage);
		}

	}

}
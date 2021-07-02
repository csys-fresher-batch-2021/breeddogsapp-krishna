package in.raja.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.raja.model.DogDetail;
import in.raja.service.DogManager;

/**
 * Servlet implementation class AddDonorServlet
 */
@WebServlet("/AddDogServlet")
public class AddDogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddDogServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String dogImage = request.getParameter("imageSource");
			String dogName = request.getParameter("dogName");
			int age = Integer.parseInt(request.getParameter("age"));
			String gender = request.getParameter("gender");
			String place = request.getParameter("place");
			Integer price = Integer.parseInt(request.getParameter("price"));
			String insurance = request.getParameter("insurance");
		
			DogDetail dogDetail = new DogDetail(dogImage, dogName, age, gender, place, price, insurance);
			

			boolean success = DogManager.addDog(dogDetail);

			if (success) {

				String infoMessage = "Dog Added Successfully";
				response.sendRedirect("DogDetails.jsp?infoMessage=" + infoMessage);
			} else {

				String errorMessage = "Invalid DogDetails";
				response.sendRedirect("AddDog.jsp?errorMessage=" + errorMessage);
			}

		}

		catch (Exception e) {

			String errorMessage = e.getMessage();
			response.sendRedirect("AddDog.jsp?errorMessage=" + errorMessage);
		}

	}

}

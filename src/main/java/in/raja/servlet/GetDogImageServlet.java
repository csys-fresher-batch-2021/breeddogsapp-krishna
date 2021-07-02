package in.raja.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.raja.service.DogManager;

/**
 * Servlet implementation class GetDogImageServlet
 */
@WebServlet("/GetDogImageServlet")
public class GetDogImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetDogImageServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String imageName = request.getParameter("imageName");
		try {
			byte[] image = DogManager.retireveImage(imageName);
			OutputStream obj = response.getOutputStream();
			System.out.println(obj);
			obj.write(image);
		} catch (IOException e) {
			String errorMessage = "unable to retireve image";
			response.sendRedirect("index.jsp?errorMessage=" + errorMessage);
		}
	}

}

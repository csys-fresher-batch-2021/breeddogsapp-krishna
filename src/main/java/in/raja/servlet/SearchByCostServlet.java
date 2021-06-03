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

import in.raja.model.DogDetails;
import in.raja.service.DogManager;
/**
 * Servlet implementation class SearchByCostServlet
 */
@WebServlet("/SearchByCostServlet")
public class SearchByCostServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	System.out.println("Heloo");
		
		try {
			String cost = request.getParameter("cost");
			int type = Integer.parseInt(cost);
			List<DogDetails> added = DogManager.searchBreedByCost(type);
		//	HttpSession session = request.getSession();
			//session.setAttribute("CostList",added.get(0));
			Gson gson = new Gson();		
			String obj = gson.toJson(added);
			PrintWriter out = response.getWriter();
			out.println(obj);
			out.flush();			
			
			
			
				
			
			
		}
		catch(Exception e)
		{
			String errorMessage = "Unable to add Breeds ";
			response.sendRedirect("ListDogsByPrice.jsp?errorMessage=" + errorMessage);
		}
		
		
	}
	
}
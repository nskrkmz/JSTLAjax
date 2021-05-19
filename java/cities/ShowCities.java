package cities;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowCities
 */
@WebServlet("/ShowCities")
public class ShowCities extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCities() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma","no-cache"); 
		
		String cityType = request.getParameter("city-type-1");
		//String cityType = request.getAttribute("city-type-1");
		List<City> cities = findCities(cityType);
		request.setAttribute("cities", cities);
		
		String format = request.getParameter("format");
		String outputPage = null;
		
		if ("xml".equals(format)||("XML".equals(format))) {
			response.setContentType("text/xml");
			outputPage = "/WEB-INF/results/cities-xml.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(outputPage);
		dispatcher.include(request, response);
		//dispatcher.forward(request, response);
		
	}

	public List<City> findCities(String cityType) {
		
		List<City> list = new ArrayList<City>();
		
		if(cityType.equals("top-5-cities")) {
			
			list.add(new City("New York","01:38:33 PM" ,8250567));
			list.add(new City ("Los Angeles", "10:38:33 AM", 3849368 ));
			list.add(new City("Chicago","12:38:33 PM",2873326));
			list.add(new City("Houston","01:38:33 PM",2144491));
			list.add(new City("phonix","11:38:33 AM",1512986));
			
			return list;
			
		}
		
		else{
			
			list.add(new City ("Los Angeles", "10:38:33 AM", 3849368 ));
			list.add(new City("phonix","11:38:33 AM",1512986));
			list.add(new City("New York","01:38:33 PM" ,8250567));
			list.add(new City("Houston","01:38:33 PM",2144491));
			list.add(new City("Chicago","12:38:33 PM",2873326));
			
			return list;
		}
		
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

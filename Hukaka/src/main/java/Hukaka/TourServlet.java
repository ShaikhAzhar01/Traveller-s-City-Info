package Hukaka;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

/**
 * Servlet implementation class TourServlet
 */
public class TourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TourServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext sc = request.getServletContext();
        Connection con = (Connection) sc.getAttribute("oracle");
        String s = request.getParameter("cityName");
        PrintWriter pw = response.getWriter();

        if (s != null && s.trim().equalsIgnoreCase("bangalore"))
        {
            // If the city entered by the user matches "bangalore", forward the request to azh.jsp
        	
            RequestDispatcher rd = request.getRequestDispatcher("/azh.jsp");
            rd.forward(request, response);
        } 
        else if(s != null && s.trim().equalsIgnoreCase("mumbai"))
        {
        	RequestDispatcher rd = request.getRequestDispatcher("/azh1.jsp");
            rd.forward(request, response);
        }
        else if(s != null && s.trim().equalsIgnoreCase("kerala"))
        {
        	RequestDispatcher rd = request.getRequestDispatcher("/azh2.jsp");
            rd.forward(request, response);
        }
        else if(s != null && s.trim().equalsIgnoreCase("ooty"))
        {
        	RequestDispatcher rd = request.getRequestDispatcher("/azh3.jsp");
            rd.forward(request, response);
        }
        else if(s != null && s.trim().equalsIgnoreCase("leh"))
        {
        	RequestDispatcher rd = request.getRequestDispatcher("/azh4.jsp");
            rd.forward(request, response);
        }
        else if(s != null && s.trim().equalsIgnoreCase("jammu"))
        {
        	RequestDispatcher rd = request.getRequestDispatcher("/azh5.jsp");
            rd.forward(request, response);
        }
        else
        {
            // If the city entered by the user does not match "bangalore", display a message
            response.setContentType("text/html");
           
            pw.println("<html><head></head><body bgcolor=black text=white>");
            pw.println("<script>alert('Invalid City')</script>");
            RequestDispatcher rd = request.getRequestDispatcher("tour.html");
	        rd.include(request, response);
            pw.println("</body></html>");
        }
		
	}

}

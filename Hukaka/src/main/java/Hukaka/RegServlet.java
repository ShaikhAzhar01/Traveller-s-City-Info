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
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class RegServlet
 */
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
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
	    try {
			String s1 = request.getParameter("fname");
			String s2 = request.getParameter("lname");
			String s3 = request.getParameter("uname");
			String s4 = request.getParameter("pword");
			PreparedStatement ps = con.prepareStatement("insert into info values(?,?,?,?)");
			  ps.setString(1, s1);
		        ps.setString(2, s2);
		        ps.setString(3, s3);
		        ps.setString(4, s4);
		        ps.executeUpdate();
		        
		        
		        response.setContentType("text/html");
		        PrintWriter pw = response.getWriter();
		        //pw.println("<html><head></head><body bgcolor=black text=white>");
		        pw.println("<script>alert('You Have Successfully Registered 👌 click Ok to Login')</script>");

		      
		        RequestDispatcher rd = request.getRequestDispatcher("login.html");
		        rd.include(request, response);

				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

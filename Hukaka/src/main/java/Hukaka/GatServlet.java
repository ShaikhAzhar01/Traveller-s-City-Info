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
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class GatServlet
 */
public class GatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext sc = request.getServletContext();
        Connection con = (Connection)sc.getAttribute("oracle");

        try {
			String s1 = request.getParameter("uname");
			String s2 = request.getParameter("pword");
			PreparedStatement ps = con.prepareStatement("select * from info where uname=? and pword=?");
			ps.setString(1, s1);
	        ps.setString(2, s2);
	        
	        ResultSet rs=ps.executeQuery();
	        PrintWriter pw = response.getWriter();
	        
	        if(rs.next())
	        {
	        	pw.println("<html><body bgcolor=black text=white>");
	        	pw.println("<script>alert('WELCOME TO THE Portal')</script>");
	        	 RequestDispatcher rd=request.getRequestDispatcher("homer.html");
	 	        rd.forward(request, response);
	        	
	        }
	        else
	        	pw.println("<script>alert('Invalid UserName and Password')</script>");	
	        RequestDispatcher rf=request.getRequestDispatcher("login.html");
	        rf.include(request, response);
	        pw.println("</body><html>");
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

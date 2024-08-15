

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.io.*;

/**
 * Servlet implementation class reg
 */
@WebServlet("/reg")
public class Reg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String a=request.getParameter("username");
		String b=request.getParameter("email");
		String c=request.getParameter("password");
		PrintWriter pw=response.getWriter();
		
		if(a!=null && b!=null && c!=null) {
			try {
           	Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/ecom","root","karan123");	
			Statement st=con.createStatement();
			st.executeUpdate("insert into user values('"+a+"','"+b+"','"+c+"')");
		   response.sendRedirect("login.jsp");		
			}
			catch (Exception e) {
				pw.print(e);
			}
		}
	}

}

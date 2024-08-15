

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.io.*;

/**
 * Servlet implementation class productupdate
 */
@WebServlet("/productupdate")
public class productupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a=request.getParameter("pid");
		String b=request.getParameter("pname");
		String c=request.getParameter("pprice");
		String d=request.getParameter("pquantity");
		String f=request.getParameter("pimage");
		PrintWriter pw=response.getWriter();
		
		try {
           	Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/ecom","root","karan123");	
			Statement st=con.createStatement();
			st.executeUpdate("update product set pname='"+b+"',pprice='"+c+"',pquantity='"+d+"',pimage='"+f+"' where pid='"+a+"'");
		   response.sendRedirect("viewproduct.jsp");		
			}
			catch (Exception e) {
				pw.print(e);
			}
	}

}

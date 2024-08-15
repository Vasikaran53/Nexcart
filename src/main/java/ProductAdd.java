

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.io.*;

/**
 * Servlet implementation class ProductAdd
 */
@WebServlet("/ProductAdd")
public class ProductAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String a=request.getParameter("productName");
		String b=request.getParameter("productPrice");
		String c=request.getParameter("productQuantity");
		String d=request.getParameter("productImage");
		PrintWriter pw=response.getWriter();
		
		try {
           	Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/ecom","root","karan123");	
			Statement st=con.createStatement();
			st.executeUpdate("insert into product (pname, pprice, pquantity, pimage) values('" + a + "','" + b + "','" + c + "','" + d + "')"); // Corrected

		   response.sendRedirect("viewproduct.jsp");		
			}
			catch (Exception e) {
				pw.print(e);
			}
	}

}

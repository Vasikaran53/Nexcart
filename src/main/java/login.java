import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.io.*;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		PrintWriter pw = response.getWriter();

		if (username != null && password != null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecom", "root", "karan123");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from user where username='" + username + "' and password='" + password + "'");

				if (rs.next()) {
					HttpSession session = request.getSession();
					session.setAttribute("username",username); 
					response.sendRedirect("viewproduct.jsp");
				} else {
					pw.print("Invalid username or password.");
				}
			} catch (Exception e) {
				pw.print(e);
			}
		} else {
			pw.print("Username and password must not be null.");
		}
	}
}

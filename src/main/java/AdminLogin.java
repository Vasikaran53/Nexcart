

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		String a=request.getParameter("username");
		String b=request.getParameter("password");
		if(a.equals("admin") && b.equals("karan")) {
		
		response.sendRedirect("adminhome.jsp");
		
	}
		else {
			response.sendRedirect("adminlogin.jsp");
		}

}
}
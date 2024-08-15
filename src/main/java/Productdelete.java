import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.io.*;

/**
 * Servlet implementation class ProductDelete
 */
@WebServlet("/Productdelete")
public class Productdelete extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String productName = request.getParameter("productName");
        PrintWriter pw = response.getWriter();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecom", "root", "karan123");
            Statement st = con.createStatement();
            
            // Delete query
            int result = st.executeUpdate("DELETE FROM product WHERE pname = '" + productName + "'");

            if (result > 0) {
                response.sendRedirect("viewproduct.jsp"); // Redirect if successful
            } else {
                pw.print("No product found with the specified name.");
            }
        } catch (Exception e) {
            pw.print(e);
        }
    }
}

package question2_servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SearchServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");

        // Show the form
        out.println("<p>Enter the hotel Id </p>");
        out.println("<form >"); // Add attributes to the form
        out.println("<input type = \"text\" >"); // modify as needed
        // Add a button

        out.println("</form>");
        out.println("</body>");
        out.println("</html>");

        response.setStatus(HttpServletResponse.SC_OK);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
       // FILL IN CODE: get the HotelData using getAttribute
        // Then process the form - show information about the hotel id the user submitted

        // Show the previous searches too (from the cookie)

        // Update the cookie

    } // doPost
} // SearchServlet class

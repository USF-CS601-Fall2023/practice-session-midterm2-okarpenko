package question3_jdbc_solution;

import org.apache.commons.text.StringEscapeUtils;

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
        out.println("<form action=\"search\" method=\"post\" >"); // Add attributes to the form
        out.println("<input type = \"text\" name=\"hotelId\" >"); // modify as needed
        out.println("<input type = \"submit\" value = \"Search\">");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");

        response.setStatus(HttpServletResponse.SC_OK);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
        HotelData hdata = (HotelData)getServletContext().getAttribute("hotelData");
        String hotelId = request.getParameter("hotelId");
        hotelId = StringEscapeUtils.escapeHtml4(hotelId);
        String hotelInfo = hdata.getHotel(hotelId).toString();
        response.setStatus(HttpServletResponse.SC_OK);
        PrintWriter out = response.getWriter();
        out.println(hotelInfo);

        // Show the previous searches (from the database)
       // NOT done -  was not a part of the question (but could be)

        // Add searched hotelId the database
        SimpleDatabaseHandler.getInstance().storeHotelIdInDatabase(hotelId);
    } // doPost
} // SearchServlet class

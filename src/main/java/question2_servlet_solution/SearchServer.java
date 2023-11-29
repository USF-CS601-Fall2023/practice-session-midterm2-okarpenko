package question2_servlet_solution;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class SearchServer {
    public static final int PORT = 8080;

    public static void main(String[] args)  {
        HotelData hdata = new HotelData();
        hdata.addHotel("1003", new Hotel("1003", "Hotel Kabuki", "1625 Post St"));
        hdata.addHotel("10323", new Hotel("10323", "Hotel Hilton Garden Inn", "1800 Powell St"));
        hdata.addHotel("12625", new Hotel("12625", "Le Meridian", "123 Golden Gate Ave"));
        // feel free to add more hotels for testing

        Server server = new Server(PORT);
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.setAttribute("hotelData", hdata);
        handler.addServlet(SearchServlet.class, "/search");
        server.setHandler(handler);
        try {
            server.start();
            server.join();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

}

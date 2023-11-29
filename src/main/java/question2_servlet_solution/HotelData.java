package question2_servlet_solution;

import java.util.HashMap;
import java.util.Map;

/** A class that stores the hotel info in a map */
public class HotelData {
    private Map<String, Hotel> hotelMap = new HashMap<>(); // maps id to hotel

    public void addHotel(String id, Hotel hotel) {
        hotelMap.put(id, hotel);
    }

    public Hotel getHotel(String id) {
        return hotelMap.get(id);
    }

}

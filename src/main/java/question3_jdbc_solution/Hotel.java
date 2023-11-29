package question3_jdbc_solution;

/** A class that represents a hotel. */
public final class Hotel {
    private final String name;
    private final String id;
    private final String address;

    public Hotel(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return  id + System.lineSeparator() +
                name + System.lineSeparator() +
                address + System.lineSeparator();
    }
}
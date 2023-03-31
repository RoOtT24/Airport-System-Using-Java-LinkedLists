package application;

public class Flight implements Comparable<Flight> {

	private String FlightNum;
	private String airlineName;
	private String source;
	private String destination;
	private int capacity;
	private LinkedList<Passenger> passengers = new LinkedList<>();
	private int numPassengers = 0;
	
	

	public int getNumPassengers() {
		return numPassengers;
	}

	public void setNumPassengers(int numPassengers) {
		this.numPassengers = numPassengers;
	}

	public Flight() {
		super();
	}

	public Flight(String flightNum, String airlineName, String source, String destination, int capacity) {
		super();
		FlightNum = flightNum;
		this.airlineName = airlineName;
		this.source = source;
		this.destination = destination;
		this.capacity = capacity;
	}

	public String getFlightNum() {
		return FlightNum;
	}

	public void setFlightNum(String flightNum) {
		FlightNum = flightNum;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public LinkedList<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(LinkedList<Passenger> passengers) {
		this.passengers = passengers;
	}

	@Override
	public String toString() {
		return "Flight [FlightNum=" + FlightNum + ", airlineName=" + airlineName + ", source=" + source
				+ ", destination=" + destination + ", capacity=" + capacity + ", passengers=" + passengers + "]";
	}

	@Override
	public int compareTo(Flight o) {
		// TODO Auto-generated method stub
		if (o.getFlightNum().compareTo(this.getFlightNum()) < 0) {
			return 1;
		} else if (o.getFlightNum().compareTo(this.getFlightNum()) > 0) {
			return -1;
		}
		return 0;
	}

}
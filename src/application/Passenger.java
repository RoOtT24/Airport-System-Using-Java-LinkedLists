package application;

import java.util.Date;

public class Passenger implements Comparable<Passenger> {

	private String FlightNum;
	private String TicketNum;
	private String FullName;
	private String PassportNum;
	private String Nationality;
	private Date Bdate;

	public Passenger() {
		super();
	}

	public Passenger(String flightNum, String ticketNum, String fullName, String passportNum, String nationality,
			Date bdate) {
		super();
		FlightNum = flightNum;
		TicketNum = ticketNum;
		FullName = fullName;
		PassportNum = passportNum;
		Nationality = nationality;
		Bdate = bdate;
	}

	public String getFlightNum() {
		return FlightNum;
	}

	public void setFlightNum(String flightNum) {
		FlightNum = flightNum;
	}

	public String getTicketNum() {
		return TicketNum;
	}

	public void setTicketNum(String ticketNum) {
		TicketNum = ticketNum;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public String getPassportNum() {
		return PassportNum;
	}

	public void setPassportNum(String passportNum) {
		PassportNum = passportNum;
	}

	public String getNationality() {
		return Nationality;
	}

	public void setNationality(String nationality) {
		Nationality = nationality;
	}

	public Date getBdate() {
		return Bdate;
	}

	public void setBdate(Date bdate) {
		Bdate = bdate;
	}

	@Override
	public String toString() {
		return "Passenger [FlightNum=" + FlightNum + ", TicketNum=" + TicketNum + ", FullName=" + FullName
				+ ", PassportNum=" + PassportNum + ", Nationality=" + Nationality + ", Bdate=" + Bdate + "]";
	}

	@Override
	public int compareTo(Passenger o) {
		// TODO Auto-generated method stub
		if (o.getFullName().compareTo(this.getFullName()) < 0)
			return 1;
		else if (o.getFullName().compareTo(this.getFullName()) > 0)
			return -1;
		return 0;
	}

}
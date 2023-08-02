

public class Ticket {
		
	private int ticketId;
	private String customerName;
	private String customerContact;
	private String date;
	private String from;
	private String to;
	private String boardingTime; 
	private int noOfSeats;
	private int seatNumber; 
	private String email;
	private float amount;
	
	public Ticket(String customerName, String customerContact, int ticketNUmber, String date, String from, String to,
			String boardingTime, int noOfSeats, int seatNumber, String email, float amount) {
		super();
		this.customerName = customerName;
		this.customerContact = customerContact;
		this.ticketId = ticketNUmber;
		this.date = date;
		this.from = from;
		this.to = to;
		this.boardingTime = boardingTime;
		this.noOfSeats = noOfSeats;
		this.seatNumber = seatNumber;
		this.email = email;
		this.amount = amount;
	}
	
	public Ticket(){
		
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getBoardingTime() {
		return boardingTime;
	}

	public void setBoardingTime(String boardingTime) {
		this.boardingTime = boardingTime;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	
	
	
}

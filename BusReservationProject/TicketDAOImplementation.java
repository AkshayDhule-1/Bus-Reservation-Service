package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TicketDAOImplementation implements TicketDAO {

	Connection conn ; //GLOBAL

	public TicketDAOImplementation() {
		try {
			//1. Load the Driver
			System.out.println("Trying to load the driver...");
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			System.out.println("Driver loaded....");

			//2. Acquire the connection
			System.out.println("Trying to connect....");
			conn = 	DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");
			System.out.println("Connected : " + conn);


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void insertTicket(Ticket ticket) {
		//3. make a desired statement (insert/update/delete/select)

		try {
			PreparedStatement pst =
			    conn.prepareStatement("INSERT INTO TICKET VALUES (?,?,?,?,?,?,?,?,?,?,?)");

			pst.setInt(1, ticket.getTicketId());
			pst.setString(2, ticket.getCustomerName());
			pst.setString(3, ticket.getCustomerContact());
			pst.setString(4, ticket.getDate());
			pst.setString(5, ticket.getFrom());
			pst.setString(6, ticket.getTo());
			pst.setString(7, ticket.getBoardingTime());
			pst.setInt(8, ticket.getNoOfSeats());
			pst.setInt(9, ticket.getSeatNumber());
			pst.setString(10, ticket.getEmail());
			pst.setFloat(11, ticket.getAmount());


			System.out.println("PreparedStatement is created : " + pst);

			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			int rows = pst.executeUpdate();

			System.out.println("Rows created : " + rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Ticket selectTicket(int ticketId) {

		Ticket ticket = null;
		try {

			Statement statement = conn.createStatement();
			System.out.println("Statement is created : " + statement);

			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			ResultSet result = statement.executeQuery("SELECT * FROM TICKET WHERE TID=" + ticketId);

			//5. process the result if any
			if (result.next()) {
				
				
				ticket = new Ticket(); //blank object

				ticket.setTicketId(result.getInt(1));
				ticket.setCustomerName(result.getString(2));
				ticket.setCustomerContact(result.getString(3));
				ticket.setDate(result.getString(4));
				ticket.setFrom(result.getString(5));
				ticket.setTo(result.getString(6));
				ticket.setBoardingTime(result.getString(7));
				ticket.setNoOfSeats(result.getInt(8)); 
				ticket.setSeatNumber(result.getInt(9));
				ticket.setEmail(result.getString(10));
				ticket.setAmount(result.getFloat(11));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ticket;
	}

	@Override
	public List<Ticket> selectTickets() {

		List<Ticket> ticketList = new ArrayList<Ticket>();
		try {


			Statement statement = conn.createStatement();
			System.out.println("Statement is created : " + statement);

			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			ResultSet result = statement.executeQuery("SELECT * FROM TICKET");

			//5. process the result if any
			while (result.next()) {
				Ticket ticket = new Ticket(); //blank object


				ticket.setTicketId(result.getInt(1));
				ticket.setCustomerName(result.getString(2));
				ticket.setCustomerContact(result.getString(3));
				ticket.setDate(result.getString(4));
				ticket.setFrom(result.getString(5));
				ticket.setTo(result.getString(6));
				ticket.setBoardingTime(result.getString(7));
				ticket.setNoOfSeats(result.getInt(8)); 
				ticket.setSeatNumber(result.getInt(9));
				ticket.setEmail(result.getString(10));
				ticket.setAmount(result.getFloat(11));
				ticketList.add(ticket); // add this object to the LIST
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ticketList;
	}

	@Override
	public void updateTicket(Ticket ticket) {
		//3. make a desired statement (insert/update/delete/select)

		try {
			PreparedStatement pst =
			    conn.prepareStatement("UPDATE TICKET set custname=?, source=?, dest where tid=?");


			pst.setInt(1, ticket.getTicketId());
			pst.setString(2, ticket.getCustomerName());
			pst.setString(3, ticket.getCustomerContact());
			pst.setString(4, ticket.getDate());
			pst.setString(5, ticket.getFrom());
			pst.setString(6, ticket.getTo());
			pst.setString(7, ticket.getBoardingTime());
			pst.setInt(8, ticket.getNoOfSeats());
			pst.setInt(9, ticket.getSeatNumber());
			pst.setString(10, ticket.getEmail());
			pst.setFloat(11, ticket.getAmount());


			System.out.println("PreparedStatement is created : " + pst);

			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			int rows = pst.executeUpdate();

			System.out.println("Row MODIFIED : " + rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteTicket(int ticketId) {
		//3. make a desired statement (insert/update/delete/select)

		try {
			PreparedStatement pst =
			    conn.prepareStatement("DELETE FROM TICKET where tid=?");

			pst.setInt(1, ticketId); //WHERE t id =? 

			System.out.println("PreparedStatement is created : " + pst);

			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			int rows = pst.executeUpdate();

			System.out.println("Row DELETED : " + rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
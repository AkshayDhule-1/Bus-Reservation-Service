
import java.util.List;

//II. POJI
public interface TicketDAO { //POJI as per the POJO

	public void insertTicket(Ticket ticket); //C
	public Ticket selectTicket(int ticketId);//R
	public List<Ticket> selectTickets(); //RA
	public void updateTicket(Ticket ticket); //U
	public void deleteTicket(int ticketId);  //D
	
}
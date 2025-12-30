package genric_utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class javautils 
{
	/**
	 * It will add the random number to the value.so avoid duplication.
	 * @author PRATHEEP RAJ S
	 * @return
	 */
	public int RandumNumber()
	{
		Random ran = new Random();
		int ranNumber = ran.nextInt(1000);
		return ranNumber;
	}
	
	/**
	 * to get the current date
	 * @author PRATHEEP RAJ S
	 * @return
	 */
	public String systemdate()
	{
		LocalDate date = LocalDate.now();
		DateTimeFormatter d = DateTimeFormatter.ofPattern("dd-MM-yyy");
		String systemDate = d.format(date);
		return systemDate;
	}
	
	/**
	 * it is used to get both date and time.
	 * @author PRATHEEP RAJ S
	 * @return
	 */
	public String simpleDate()
	{
		Date dete = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");//we can use both date and time.
		String systemdateformate = sim.format(dete);
		return systemdateformate;
	}
	/**
	 * it is used to get future date
	 * @author PRATHEEP RAJ S
	 * @return
	 */
	public String futureDateIntermsOfMonth(int a)
	{
		LocalDate date = LocalDate.now();
		LocalDate future_month = date.plusMonths(a);
		DateTimeFormatter d = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String futureMonth = d.format(future_month);
		return futureMonth;
	}
	
}

package datautil;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ConversaoData {

	public Date converterStringDate (String data) {
		String dt[] = data.split("/");
		
		Calendar calendar = new GregorianCalendar();
		
		calendar.set(Integer.parseInt(dt[2]),
					 Integer.parseInt(dt[1])-1,
					 Integer.parseInt(dt[0]));
		return calendar.getTime();
	}
	
	public Date converterConsulta (String data) {
		String dt[] = data.split("-");
		
		Calendar calendar = new GregorianCalendar();
		
		calendar.set(Integer.parseInt(dt[0]),
					 Integer.parseInt(dt[1])-1,
					 Integer.parseInt(dt[2]));
		return calendar.getTime();
	}
	
}

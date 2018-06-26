import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateUtil {

    static SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
    
	static void changeDateFormat() {
		format = new  SimpleDateFormat("dd/MM/yyyy");
		
	}
	
	static void changeDateFormat(String date) {
		
		format = new  SimpleDateFormat(date);
		
	}
	
	public static Calendar stringToCalendar(String date) throws ParseException {
		
		// create date object
		Date newDate =  (Date)format.parse(date);		
		
		//convert to a calendar object
		Calendar cal=Calendar.getInstance();
		cal.setTime(newDate);
		return cal;
	}
	
    public static boolean isDateValid(String dateToValidate){
		
		if(dateToValidate == null){
			return false;
		}
		
		format.setLenient(false);
		
		try {
			
			Date date = format.parse(dateToValidate);
		
		} catch (ParseException e) {
			
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
    public static int getDay(Calendar date) throws ParseException {
		int dayOfMonth = date.get(Calendar.DAY_OF_MONTH);	
		return dayOfMonth;
		
	}
	
	public  static int getMonth(Calendar date) throws ParseException {
		
		int month = date.get(Calendar.MONTH);
		return month;
		
	}
	
	public static int getDayOfWeek(Calendar date) throws ParseException {
		int dayOfWeek = date.get(Calendar.DAY_OF_WEEK);
		return dayOfWeek;
		
	}
		
	public static boolean isWeekend(Calendar date) throws ParseException {
		
		//Check if the date is on Sunday or Saturday
	    if(getDayOfWeek(date) == 1 || getDayOfWeek(date) == 7) {
	    	return true;
	    }	
	     return false;
	     
	}
	
	public static boolean isHoliday(Calendar cal) throws ParseException {
		
		int month = getMonth(cal);
		int day = getDay(cal);
		int[] months = new int[] {01,01,03,04,04,04,05,06,8,10,10,12, 12, 12};
		int monthsArrayLenght =  months.length;
		int[] days = new int[] {01,02,21,14,17,27,01,16,9,24,25,16,25,26};
		
		//loop through day and month to see if date is public holiday
		for(int i = 0;  i < monthsArrayLenght; i++) {
			if(months[i] ==month+1  &&  days[i] ==  day)
				return true;
		}
		return false;
		
	}
	
	public static String printHolidayName(Calendar cal) throws ParseException {
		
		int month = getMonth(cal);
		int day = getDay(cal);
		
		String[] holidayNames = new String[] {"New Years", "New Years",	"Human Wrights Day", "Good Friday", "Family Day","Freedom Day", 
				"WorkersDay", "Youth Day", "National womens day", "Heritage day", "Public Holiday", "Day of reconciliation", "Chistmas",
				"Day Of Goodwill"};
		
		int[] months = new int[] {01,01,03,04,04,04,05,06,8,9,9,12, 12, 12};		
		int[] days = new int[] {01,02,21,14,17,27,01,16,9,24,25,16,25,26};
		int monthsArrayLenght =  months.length;
		
		for(int i = 0;  i < monthsArrayLenght; i++) {
			if(months[i] ==month+1  &&  days[i] ==  day)
			{
				if(isWeekend(cal)) {
				return  holidayNames[i]+ " - Weekend";
			} else {
				return  holidayNames[i];
			}
		}	
		}
		
		if(isWeekend(cal)) {
			return "Weekend";
		}
		
		return "Business Day";
		}

	public static Date futureBusinessDay(Calendar startDate, int n) throws ParseException {
		Calendar laterDate = startDate;
		
		for(int i = 0;i<n;) {
			
			//Add one day
			laterDate.add(Calendar.DATE, 1);
			
			//if the day is a public holiday do not increment loop so that an extra day will be added 
			if(!isWeekend(laterDate) && !isHoliday(laterDate)) 
				i++;
			
		}
		
		return laterDate.getTime();
	}
	
	public static Date previousBusinessDay(Calendar startDate, int n) throws ParseException {
		
		Calendar laterDate = startDate;
		
		for(int i = 0;i<n;) {
		laterDate.add(Calendar.DATE, -1);
		
		if(!isWeekend(laterDate) && !isHoliday(laterDate)) 
				i++;				
		}
		
		return laterDate.getTime();
	}
		
	
}

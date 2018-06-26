import java.text.ParseException;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		DateUtil.changeDateFormat();
		String dateTest = "16/12/2018";
		System.out.println(DateUtil.printHolidayName(DateUtil.stringToCalendar(dateTest)));
		System.out.println("Valid date? " + DateUtil.isDateValid(dateTest));
		System.out.println("Is weekened? " + DateUtil.isWeekend(DateUtil.stringToCalendar(dateTest)));
		System.out.println("Is public holiday? " + DateUtil.isHoliday(DateUtil.stringToCalendar(dateTest)));
		System.out.println("In five business days, the day will be: " + DateUtil.futureBusinessDay(DateUtil.stringToCalendar(dateTest), 5));
			

	}

}

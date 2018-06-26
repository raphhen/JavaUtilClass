import java.util.Calendar;
import java.util.Date;
import org.testng.Assert;
import org.testng.annotations.Test;

import bsh.ParseException;

public class NewTest1 {
  
  @Test
  public void testFutureDays() throws  java.text.ParseException {
		        
	     int expectedDay =  Calendar.MONDAY ;
	     
	     Calendar cal = DateUtil.stringToCalendar("04/14/2018");
	     Date futureDay = DateUtil.futureBusinessDay(cal,1);		 
		 cal.setTime(futureDay);
		 int futerDayInt = DateUtil.getDayOfWeek(cal);	 

		 Assert.assertEquals(expectedDay, futerDayInt);
  }
  
  @Test
  public void testPrintHolidayName() throws java.text.ParseException {
	 
	 String testDate = "04/14/2018";
	 String expectedName = "Good Friday - Weekend";
	 
	 Assert.assertEquals(DateUtil.printHolidayName(DateUtil.stringToCalendar(testDate)), expectedName);
 }
  
  @Test
  public void testCorrectDate() throws ParseException {
	
	 DateUtil.changeDateFormat("MM/dd/yyyy");
     String testDate = "04/14/2018";
     Assert.assertTrue( DateUtil.isDateValid(testDate));
	
}
  
}

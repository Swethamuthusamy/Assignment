package maven_demos.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DatePicker {

	public static void setCalendarDate(WebDriver driver, String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date currentDate = new Date();

		try {
			Date expectedDate = dateFormat.parse(date);
			
			String Day = new SimpleDateFormat("dd").format(expectedDate);
			String Month = new SimpleDateFormat("MMM").format(expectedDate);
			String Year = new SimpleDateFormat("yyyy").format(expectedDate);
			
			String expectedmonthyr = Month +" "+ Year;
			
			while(true) {
				String displaydate = driver.findElement(By.className("monthTitle")).getText();
				
				if(expectedmonthyr.equals(displaydate)) {
					driver.findElement(By.xpath("//tr//td[text()='"+Day+"']")).click();
					break;
				}else if(expectedDate.compareTo(currentDate)>0) {
					driver.findElement(By.xpath("//*[@class='rb-calendar']//tbody//tr[1]//td[3]//button")).click();
				}else {
					driver.findElement(By.xpath("//*[@class='rb-calendar']//tbody//tr[1]//td[1]//button")).click();
				}
				
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * public static void main(String[] args) { Date d = new Date();
	 * System.out.println(d);
	 * 
	 * SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	 * String expectedDateFormat = dateFormat.format(d);
	 * System.out.println(expectedDateFormat); }
	 */

}

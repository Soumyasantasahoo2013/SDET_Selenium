package Selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Calender_Popup_Test {
	
	@Test
	public void calenderHandle() throws InterruptedException
	{
		String dmonth="November 2023";
		int ddate=7;
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
		driver.get("https://www.makemytrip.com/flights/?gclid=Cj0KCQjw9fqnBhDSARIsAHlcQYTwyk8N_LoyN-2sHf9TZ2oKQboC4en5GGa0JGxNcrzSh6-wJCOaNAoaAsAZEALw_wcB&cmp=SEM|D|DF|G|Brand|Brand-BrandExact_DT|B_M_Makemytrip_Search_Exact|RSA|673383350836&s_kwcid=AL!1631!3!673383350836!e!!g!!mmt&ef_id=Cj0KCQjw9fqnBhDSARIsAHlcQYTwyk8N_LoyN-2sHf9TZ2oKQboC4en5GGa0JGxNcrzSh6-wJCOaNAoaAsAZEALw_wcB:G:s");	
		Actions a=new Actions(driver);
	    a.moveByOffset(10,10).click().perform();
		driver.findElement(By.id("fromCity")).sendKeys("DEL");
		driver.findElement(By.xpath("(//*[name()='p' and text()='SUGGESTIONS ']/parent::div/following-sibling::ul//div[@class='makeFlex hrtlCenter'])[1]")).click();
	    driver.findElement(By.id("toCity")).sendKeys("PNQ");
	    driver.findElement(By.xpath("(//*[name()='p' and text()='SUGGESTIONS ']/parent::div/following-sibling::ul//div[@class='makeFlex hrtlCenter'])[1]")).click();
	    List<WebElement> ele = driver.findElements(By.className("DayPicker-Caption"));
	    for(int i=0;i<ele.size();i++)
	    {
	    	String text=ele.get(i).getText();
	    	if(text.equals(dmonth))
	    	{
	    		driver.findElement(By.xpath("//div[text()='"+dmonth+"']/parent::div/following-sibling::div[@class='DayPicker-Body']//*[name()='p' and text()='"+ddate+"']")).click();
	    	    break;
	    	}
	    	else
	    	{
	    		driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
	    	}
	    }
	    
	    driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']")).click();
	}

}

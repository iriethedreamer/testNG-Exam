package testngConcept;




import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LearningTestNG {


	String browser="chrome";
	 WebDriver driver;
	

         @BeforeMethod    
       public void init() {
       	 
       	 
       	 if(browser.equalsIgnoreCase("chrome")) {
            	System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
           	driver=new ChromeDriver();
       		 
       		 
       	 }else if(browser.equalsIgnoreCase("edge")) {
            	System.setProperty("webdriver.edge.driver","drivers\\msedgedriver.exe");
           	driver= new EdgeDriver();
       	 } 
       		
       	 driver.manage().deleteAllCookies();
        	driver.get("https://techfios.com/test/107/");
        	driver.manage().window().maximize();
        	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
           }
       
       @Test
       public void UserAddCategory(){
    	driver.findElement(By.name("categorydata")).sendKeys("IRIETHEDREAMER");
    	driver.findElement(By.cssSelector("input[value='Add category']")).click();
       
       
       }
    	@Test
       public void UserCantAdd() throws InterruptedException {
        driver.findElement(By.name("categorydata")).sendKeys("IRIETHEDREAMER");
    	driver.findElement(By.cssSelector("input[value='Add category']")).click();
    	
    	Thread.sleep(3000);
       }
       
       @Test
       public void SelectDropDown() {
    	
    	 Select select = new Select(driver.findElement(By.name("due_month")));
    	 List actualDropdownValues = new ArrayList();
    	 for (WebElement element : select.getOptions()) {
    		 actualDropdownValues.add(element.getText());
    		 
    	 
    	 }
    	 
    	 List expectedDropdownValues = new ArrayList();
    	 expectedDropdownValues.add("None");
    	 expectedDropdownValues.add("Jan");
    	 expectedDropdownValues.add("Feb");
    	 expectedDropdownValues.add("Mar");
    	 expectedDropdownValues.add("Apr");
    	 expectedDropdownValues.add("May");
    	 expectedDropdownValues.add("Jun");
    	 expectedDropdownValues.add("Jul");
    	 expectedDropdownValues.add("Aug");
    	 expectedDropdownValues.add("Sep");
    	 expectedDropdownValues.add("Oct");
    	 expectedDropdownValues.add("Nov");
    	 expectedDropdownValues.add("Dec");
       
       for (int i = 0; i < actualDropdownValues.size(); i++) {
    	 System.out.println("Actual : "+ actualDropdownValues.get(i)+"& Expected :"+expectedDropdownValues.get(i)); 
    	 Assert.assertTrue(actualDropdownValues.get(i).equals(expectedDropdownValues.get(i)));
       }
       
      
       
       }
       
    	
    	@AfterMethod
       public void TearDown() {
    	   
    	   driver.close();
    	   driver.quit();
       }
       
    	
    	
    	
    	
    	
    	
    	}
       

       	
      
       	





































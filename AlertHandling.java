package AlertHandling;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class AlertHandling extends RediffTest{
	
	  
	WebDriver driver=null;
	static String alertText;
	static String alertText2;
	
	
	//Launching the browser
	
	
	//Implementing the test from description
	@Test
	public void handlealert()
	{
		
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\2266790\\Downloads\\chromedriver_win32\\chromedriver.exe");	
		
		//////////////// Launching the Website//////////////////////////
		
		
		//Launching the Website("Rediff")
		
		String URL="https://mail.rediff.com/cgi-bin/login.cgi";
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		
		
		
		//Initializing the WebElement to find element using name("proceed")
		WebElement signin=driver.findElement(By.name("proceed"));
		signin.click();
		
		
		
		//////////////ALert box handling and Verifying/////////////////
		
		//Creating an instance for alert handling
		Alert alert = driver.switchTo().alert();
		//Retrieving the text from AlertBox
        alertText = alert.getText();
           
        
        String expectedAlertText = "Please enter a valid user name";
        
        
        
        //Verifying the Alert text with expected alert text
        assert alertText.equals(expectedAlertText) : "Incorrect alert text";
        alert.accept();
        System.out.println(alertText);
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        
        
        
        //////////////////// Forgot password ////////////////////////////////
        
        //Creating an instance of forgot password element on webpage
        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password?"));
        //Auto-clicking the button
        forgotPasswordLink.click();
        
        
        //Clicking the next button without filling any details 
        WebElement nextButton = driver.findElement(By.name("next"));
        nextButton.click();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        
        

        /////////////////// Alert box handling and Verifying////////////////////////
        
        
        // Fetch the text of Alert and verify whether correct alert is displayed
        Alert alert2 = driver.switchTo().alert();
         alertText2 = alert2.getText();
        String expectedAlertText2 = "Please enter your email ID";
        assert alertText2.equals(expectedAlertText2) : "Incorrect alert text";
        alert2.accept();
        
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        
        
        
        ////////////////////// Navigating back to webpage content////////////
        
        
        driver.navigate().back();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        
        
        
        //////////////////// Privacy policy /////////////////////////////////
        
        
        //Clicking the verify button
        WebElement privacyPolicyLink = driver.findElement(By.linkText("Privacy Policy"));
        privacyPolicyLink.click();
        

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        
        //Verifying whether the link opened in new window 
        String currentWindowHandle = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        
        String expectedPrivacyPolicyURL = "http://www.rediff.com/w3c/policy.html";
        assert driver.getCurrentUrl().equals(expectedPrivacyPolicyURL) : "Privacy Policy page not displayed in new tab";
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            

       //Closing the browser
       driver.close();
       driver.quit();
       
       
      }
	
	public static void main(String args[])
	{
		AlertHandling alerthandling=new AlertHandling();
		RediffTest reddtest=new RediffTest();
		reddtest.alertbox_data_data(alertText,alertText2);
		alerthandling.handlealert();
		
		
	}
		
}

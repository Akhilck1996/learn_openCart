package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;
	
	@BeforeClass(groups= {"sanity"})
	@Parameters("browser")
	public void setup(String br)
	{
		logger=LogManager.getLogger(this.getClass()); //this.getclass will get u name of current class being executed
		rb=ResourceBundle.getBundle("config");
		
		if(br.equals("chrome1"))
		{
		driver=new ChromeDriver();
		}
		else if(br.equals("firefox1"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
			
	}
	
	public String generateRandomString()
	{
		String randomString=RandomStringUtils.randomAlphabetic(8);
		return randomString;
		
	}
	
	public String generateRandomNumber()
	{
		String randomNumber=RandomStringUtils.randomNumeric(10);
		return randomNumber;
	}
	
	public String generateRandomAlphaNumeric()
	{
		String randomAlphaNumeric=RandomStringUtils.randomAlphanumeric(10);
		
		return randomAlphaNumeric;
	}
	
	public String generateRandomEmail()
	{
		String generateRandomEmail=generateRandomString()+"@gmail.com";
		return generateRandomEmail;
	}
	
	public String captureScreen(String tname) throws IOException
	{
		/*
		SimpleDateFormat df= new SimpleDateFormat("yyyyMMddhhmmss");
		Date dt= new Date();
		String timeStamp=df.format(dt);
		*/
		//OR writing 3 lines of code in one line
		String timeStamp= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takeScreenshot= (TakesScreenshot) driver;
		File source=takeScreenshot.getScreenshotAs(OutputType.FILE);
		//File destination = new File(System.getProperty("user.dir")+"\\screenshots\\"+timeStamp+".png");
		String destination = System.getProperty("user.dir")+"\\screenshots\\"+timeStamp+".png";
		//FileUtils.copyFile(source, destination);  //sir method not working
		//Files.copy(source, destination);
		
		try
		{
		FileUtils.copyFile(source, new File(destination));  
		}catch(Exception e)
		{
			e.getMessage();
		}
		return destination;
	}
	
	@AfterClass(groups="sanity")
	public void tearDown()
	{
		//driver.quit();
	}
	
	
}

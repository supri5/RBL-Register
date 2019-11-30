package RBL;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

@Test
public class Registration {

	public static void Register() throws Exception {


		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Desktop\\supriya\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.rblbank.com/");

		driver.manage().window().maximize();
		
		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[@class='close']")).click();
		driver.findElement(By.xpath("(//span[@class='icon-menu'])[1]")).click();
		// driver.findElement(By.xpath("(//a[text()='Personal Banking'])[2]")).click();

		Thread.sleep(5000);

		driver.findElement(By.xpath("(//a[text()=\"Credit Cards\"])[2]")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//img[@alt='Credit Cards']")).click();

		Thread.sleep(5000);

		String parent = driver.getWindowHandle();
		Set allHandles = driver.getWindowHandles();
		Iterator itr = allHandles.iterator();
		
		while (itr.hasNext()) {
			String currwindow = (String) itr.next();
			if (!currwindow.contentEquals(parent)) {
				driver.switchTo().window(currwindow);
			}

		}

		Thread.sleep(5000);

		driver.findElement(By.xpath("(//button[text()='Apply Now'])")).click();
		
		Thread.sleep(2000);
		
		//entering data
		
		driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("Supriya");
		driver.findElement(By.xpath("//input[@id='lname']")).sendKeys("Sharma");
		driver.findElement(By.xpath("//input[@value='2']")).click();

		//Select dob= new Select(driver.findElement(By.xpath("//input[@name='dateOfBirth']")));
	//dob.selectByValue("24-09-1990");
		
		driver.findElement(By.xpath("//input[@name='dateOfBirth']")).sendKeys("24-09-1990");
		driver.findElement(By.xpath("//input[@id='mobile']")).click();
		driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys("9124567890");
		driver.findElement(By.xpath("//input[@id='emailid']")).sendKeys("Supriya.12@gmail.com");
		driver.findElement(By.xpath("//input[@id='addressL1']")).sendKeys("XYZ");
		driver.findElement(By.xpath("//input[@id='addressL2']")).sendKeys("XYZ2");
		// = new Select(null);
		 Select listValue =	new Select(driver.findElement(By.xpath("//Select[@name='cities']")));
		 listValue.selectByVisibleText("Pune");
		 
	
		 
		 Select income =	new Select(driver.findElement(By.xpath("//Select[@ id='employmentType']")));
		 income.selectByIndex(2);
		 
		 Thread.sleep(1000);
		 
		 Select pin =	new Select(driver.findElement(By.xpath("//Select[@id='pincode']")));
			pin.selectByIndex(2);
		 
			driver.findElement(By.xpath("//input[@id='employer']")).sendKeys("IRIS");
	driver.findElement(By.xpath("//input[@id='grossincome']")).sendKeys("35000");
	driver.findElement(By.xpath("//input[@id='panCard']")).sendKeys("DLIPS7975G");
	
driver.findElement(By.xpath("//button[@id=\"first_page_submit\"]")).click();

//reporting

ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("C:\\Users\\Lenovo\\Desktop\\supriya\\Report\\Results.html");
ExtentReports report=new ExtentReports();
report.attachReporter(htmlReporter);
ExtentTest logger= report.createTest("Aut_01_Bank Registeration", "All the required fields submitted successfully");
logger.log(Status.PASS, "Registeration Details entered successfully");


report.flush();

driver.quit();	
	}

	private static Select Select(WebElement findElement) {
		// TODO Auto-generated method stub
		return null;
	}


}

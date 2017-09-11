package seleniumTests;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import AutomantionSupport.scrollToElement;
import javaMail.CheckingMails;
import org.testng.Assert;
import org.testng.annotations.Test;

public class runActivationURL {
	//Email Credentials for GMail
	 String host = "imap.googlemail.com";// change accordingly
     String username = "sabbirswitchmediatest@gmail.com";// change accordingly
     String password = "SwitchMedia";// change accordingly
	
	//Creating Webdriver object
		private WebDriver driver;
	//Create an object of CheckingMails
		CheckingMails mailCheck=new CheckingMails();
    //Create a Global variable for ActivationLink URL
		String LinkURL=null;
	//Create a Global variable for ActivationLink URL
		String signUpEmailAddress=null;
		
		
		
		 @BeforeClass
		 public void setup(){
			 // Optional, if not specified, WebDriver will search your path for chromedriver.
			  System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			  driver = new ChromeDriver();
			//
			  //Add 60 secs for all page load
			  driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			  //Maximize browser window
			  driver.manage().window().maximize();
			  
			  
		 }
		 @Test
		 public void signupToRequestor() throws Exception{
			 //getting Noggin Requestor pricing page
			 driver.get("http://www.nogginrequestor.io/pricing-aud");
			 //Creating Wait of 60 secs
			 WebDriverWait waitForElement=new WebDriverWait(driver, 60);
			 
			 try{
			 //wait for Start Trial button
			 waitForElement.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Start Trial']")));
			 
			 //Click on Start Trial Button
			 WebElement StartTrialButton=driver.findElement(By.xpath("//a[@title='Start Trial']"));
			 StartTrialButton.click();
			 }
			 catch(NoSuchElementException ex){
				 ex.printStackTrace();
			 }
			 catch(TimeoutException ex){
				 ex.printStackTrace();
			 }
			 
			 //Configure your enviroment page should load
			 
			 try{
				 
				 DateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmm"); 
				 Date date = new Date(); 
						
				//wait for Elements in Sign up page
				 waitForElement.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@en-of='prov/element/container-main/container-form/input-email-address']/input")));
				 waitForElement.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@en-of='prov/element/container-main/container-form/input-first-name']/input")));
				 waitForElement.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@en-of='prov/element/container-main/container-form/input-last-name']/input")));
				 waitForElement.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@en-of='prov/element/container-main/container-form/input-country']/input")));
				 waitForElement.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@en-of='prov/element/container-main/container-form/input-organization']/input")));
				 waitForElement.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@en-of='prov/element/container-main/container-form/input-phone']/input")));
				 waitForElement.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@en-of='prov/element/container-main/container-form/input-sub-domain']/input")));
				 
				 WebElement emailAddressTextBox=driver.findElement(By.xpath("//div[@en-of='prov/element/container-main/container-form/input-email-address']/input"));
				 emailAddressTextBox.sendKeys("sabbirswitchmediatest+"+dateFormat.format(date)+"@gmail.com");//change accordingly
				 signUpEmailAddress="sabbirswitchmediatest+"+dateFormat.format(date)+"@gmail.com";//Assign value to global variable to pass in  checkEmailAndFindActivationLink
				 
				 WebElement firstNameTextBox=driver.findElement(By.xpath("//div[@en-of='prov/element/container-main/container-form/input-first-name']/input"));
				 firstNameTextBox.sendKeys("Sabbir");//change accordingly
				 
				 WebElement lastNameTextBox=driver.findElement(By.xpath("//div[@en-of='prov/element/container-main/container-form/input-last-name']/input"));
				 lastNameTextBox.sendKeys("Subhan");//change accordingly
				 
				 WebElement countryDropdownBox=driver.findElement(By.xpath("//div[@en-of='prov/element/container-main/container-form/input-country']/input"));
				 countryDropdownBox.click();;//change accordingly
				 
				 //Wait for list of countires
				 waitForElement.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Australia']")));//find country Australia from country list
				 WebElement countryListAustralia=driver.findElement(By.xpath("//div[text()='Australia']"));
				 countryListAustralia.click();
				 
				 WebElement organisationTextBox=driver.findElement(By.xpath("//div[@en-of='prov/element/container-main/container-form/input-organization']/input"));
				 organisationTextBox.sendKeys("NogginIT Automation");//change accordingly
				 
				 WebElement phoneTextBox=driver.findElement(By.xpath("//div[@en-of='prov/element/container-main/container-form/input-phone']/input"));
				 phoneTextBox.sendKeys("0430218963");//change accordingly
				 
				 //Need to scroll for sub domail text box
				 //Creating an object of scrollToElement class
				 scrollToElement scrollToSubdomainTextBox=new scrollToElement();
				 
				 WebElement subDomainTextBox=driver.findElement(By.xpath("//div[@en-of='prov/element/container-main/container-form/input-sub-domain']/input"));
				 
				 //scroll to sub domain text box
				 scrollToSubdomainTextBox.ScrollElementIntoView(driver, subDomainTextBox);
				 
				 subDomainTextBox.sendKeys("sabbirAutomation"+dateFormat.format(date));
				 
				 //Wait for Next button
				 waitForElement.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Next']")));
				//click on  Next
				 WebElement nextButton=driver.findElement(By.xpath("//span[text()='Next']"));
				 nextButton.click();
				 
				 	 
				 
				 
			 }
			 catch(NoSuchElementException ex){
				 ex.printStackTrace();
			 }
			 catch(TimeoutException ex){
				 ex.printStackTrace();
			 }
			 
			 //All most done... page should load
			 try{
				//click on  Next
				//Wait for Next button
				 waitForElement.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
				 WebElement nextButtonAllmostdone=driver.findElement(By.xpath("//span[text()='Next']"));
				 nextButtonAllmostdone.click();
				 //Thread.sleep(5000);
			 }
			 catch(NoSuchElementException ex){
				 ex.printStackTrace();
			 }
			
			 
		 }
		 @Test(dependsOnMethods = { "signupToRequestor" })
		 public void checkEmailAndFindActivationLink(){
			//using checkAndFindActivationURL to find Activation URL
			 LinkURL=mailCheck.checkAndFindActivationURL(host, username, password,signUpEmailAddress);
			 Assert.assertTrue(LinkURL.contains("user-activate?email"));//Asserting if Link URL is valid 
			 System.out.println("Activation URL from the test: "+ LinkURL);
		 }
		 
		 @Test(dependsOnMethods = { "checkEmailAndFindActivationLink" })
		  public void clickActivationURL() throws Exception {
			 
			 //open the link
			 driver.get(LinkURL);
			 String PageTitleSignUp=driver.getTitle();
			 Assert.assertTrue(PageTitleSignUp.contains("Noggin"));//Asserting if Page title is valid for Sign up landing page 
			 Thread.sleep(10000);
		 }
		 
		 @AfterClass
		  public void close(){
			driver.quit();
		  }
}

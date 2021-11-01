package SpiceJetProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import spiceJetConstants.Constants;
public class App 
{
	static WebDriver driver;
	@Test
	public void SearchFlight() throws Exception {
		System.out.println("Disabling location pop up");
		FirefoxProfile geoDisabled = new FirefoxProfile();
		geoDisabled.setPreference("geo.enabled", false);
		geoDisabled.setPreference("geo.provider.use_corelocation", false);
		geoDisabled.setPreference("geo.prompt.testing", false);
		geoDisabled.setPreference("geo.prompt.testing.allow", false);
		System.out.println("Disabling Notifications pop up");
		geoDisabled.setPreference("dom.webnotifications.enabled", false);
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability(FirefoxDriver.PROFILE, geoDisabled);

		System.out.println("Open Browser");
		System.setProperty("webdriver.gecko.driver","C:\\Users\\002EB4744\\Downloads\\geckodriver-v0.29.1-win64\\geckodriver.exe");

		driver = new FirefoxDriver(capabilities);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Go to the given website");
		driver.get("http://www.spicejet.com/");
		System.out.println("Select Round trip radio button");
		explicitWait(Constants.RoundTripButton);
		Thread.sleep(2000);//for observing the action
		System.out.println("Select a from location");
		driver.findElement(By.xpath("//div[contains(text(),'From')]")).click();	
		driver.findElement(By.xpath("//div[starts-with(text(),'Delhi')]")).click();
		Thread.sleep(2000);//for observing the action
		System.out.println("Select a To destination location");
		driver.findElement(By.xpath("//body/div[@id='react-root']/div[@id='main-container']/div[@class='css-1dbjc4n r-1niwhzg r-13awgt0 r-1jgb5lz r-r0h9e2 r-13qz1uu']/div[@class='css-1dbjc4n r-14lw9ot']/div[@class='css-1dbjc4n r-14lw9ot r-z2wwpe r-vgw6uq r-156q2ks r-urutk0 r-8uuktl r-136ojw6']/div[@class='css-1dbjc4n r-1pcd2l5 r-1uwte3a r-m611by r-bnwqim']/div[@class='css-1dbjc4n r-18u37iz r-1g40b8q']/div[@class='css-1dbjc4n r-13awgt0 r-18u37iz']/div[3]/div[1]/div[2]/input[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='css-76zvg2 r-cqee49 r-ubezar r-1kfrs79'][contains(text(),'Agartala')]")).click();
		Thread.sleep(2000);//for observing the action
		System.out.println("Select a To departure date");
		explicitWait(Constants.DepartureDate);
		System.out.println("Select a To Return date");
		explicitWait(Constants.ReturnDate);
		Thread.sleep(2000);//for observing the action

		System.out.println("Select GBP currency from the drop down");
		driver.findElement(By.xpath("//*[contains(text(),'Currency')]")).click();
		Thread.sleep(2000);//for observing the action
		driver.findElement(By.xpath("//*[starts-with(text(),'GBP')]")).click();
		Thread.sleep(2000);//for observing the action
		System.out.println("Select a radio button option - Students");
		driver.findElement(By.xpath("//*[contains(text(),'Students')]")).click();

		System.out.println("Click on Search flight");
		driver.findElement(By.cssSelector(".css-1dbjc4n.r-1awozwy.r-z2wwpe.r-1loqt21.r-18u37iz.r-1777fci.r-1g94qm0.r-1w50u8q.r-ah5dr5.r-1otgn73")).click();


	}

	public static void explicitWait(String element) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element))).click();

	}

}

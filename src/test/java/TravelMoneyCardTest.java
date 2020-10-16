
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TravelMoneyCardTest {
	public String BaseUrl= "https://www.commbank.com.au/";
	public String TravelMoneyCardApply = "https://www.commbank.com.au/digital/TravelMoneyCardApply/";
	
	@Test
	public void TravelMoneyCard()
	
	{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shalini\\chromedriver\\chromedriver.exe");
		
			WebDriver driver = new ChromeDriver();
			driver.get(BaseUrl);
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//div[contains(text(),'Travel products')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Discover more')]")).click();
			
			WebElement FeaturesAndBenefits = driver.findElement(By.xpath("//a[contains(text(),'Features & benefits')]"));
			Boolean CheckFeaturesAndBenefitsPresent= FeaturesAndBenefits.isDisplayed();		       
			Assert.assertTrue(CheckFeaturesAndBenefitsPresent);
			
			WebElement CurrentConverter = driver.findElement(By.xpath("(//a[contains(text(),'Currency converter')])[1]"));
			Boolean CurrentConverterPresent = CurrentConverter.isDisplayed();		       
			Assert.assertTrue(CurrentConverterPresent);
			
			WebElement ReloadNow = driver.findElement(By.xpath("(//a[contains(text(), 'Reload now')])[1]"));
			Boolean ReloadNowPresent = ReloadNow.isDisplayed();     
			Assert.assertTrue(ReloadNowPresent);
			
			WebElement RatesAndFees = driver.findElement(By.xpath("//a[contains(text(),'Rates & fees')]"));
			Boolean RatesAndFeesPresent = RatesAndFees.isDisplayed();		       
			Assert.assertTrue(RatesAndFeesPresent);
			
			WebElement HowItWorks = driver.findElement(By.xpath("//a[contains(text(),'How it works')]"));
			Boolean HowItWorksPresent = HowItWorks.isDisplayed();		       
			Assert.assertTrue(HowItWorksPresent);
			
			WebElement ManageYourCard = driver.findElement(By.xpath("//a[contains(text(),'Manage your card')]"));
			Boolean ManageYourCardPresent = ManageYourCard.isDisplayed();		       
			Assert.assertTrue(ManageYourCardPresent);				
			
			driver.findElement(By.xpath("//div[@class='anchor-nav-cta']//a[contains(text(),'Order online')]")).click();
					
			ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(newTab.get(1));
			String URL = driver.getCurrentUrl();
			Assert.assertEquals(URL, TravelMoneyCardApply);
			
			WebElement Online = driver.findElement(By.xpath("//span[contains(text(),'In branch')]"));
			Boolean OnlineCardPresent = Online.isDisplayed();		       
			Assert.assertTrue(OnlineCardPresent);			
			driver.findElement(By.xpath("//span[contains(text(),'Online')]")).click();
			driver.quit();		
				
	
	}

}

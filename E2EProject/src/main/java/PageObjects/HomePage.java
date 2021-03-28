package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	By signin=By.cssSelector("a[href*='sign_in']");
	By tagLine=By.xpath("//div[@id='myCarousel']//h3");
	By floatingMsgBar=By.xpath("//*[@id='homepage']/div[3]");
	By newsLetterPopup=By.cssSelector("[class='listbuilder-popup-scale']");
	By noThanksBtn=By.xpath("//button[contains(text(),'NO THANKS')]");
	
	public WebElement Loginbutton()
	{
		return driver.findElement(signin);
	}
	
	public WebElement tagLine()
	{
		return driver.findElement(tagLine);
	}

	public WebElement floatingMsgBar()
	{
		return driver.findElement(floatingMsgBar);
	}
	public WebElement newsLetterPopup()
	{
		return driver.findElement(newsLetterPopup);
	}
	public WebElement noThanksBtn()
	{
		return driver.findElement(noThanksBtn);
	}
}

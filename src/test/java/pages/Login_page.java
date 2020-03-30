package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import libary.Utility;


public class Login_page {
	WebDriver d;
	public Login_page(WebDriver d)
	{
		this.d=d;
	}
	Utility u=new Utility();
	By admin=By.xpath("//a[@href='Administration.php']");
	By user=By.xpath("//input[@name='login']");
	By pass=By.xpath("//input[@name='password']");
	By login=By.xpath("//input[@name='DoLogin']");
	By logout=By.xpath("//a[@href='Login.php?Logout=True']");
	By error=By.xpath("//tr[@class='Error']");
	public void ck_ad() {
		WebElement we=u.elementclick(d,admin, 20);
		we.click();
	}
	public void se_lo(String a) {
		WebElement we=u.waitForElement(d,user, 20);
		if(a.contains("blank"))
		{
			a="";
			we.sendKeys(a);
			
		}
		else
		   we.sendKeys(a);
	}
	public void se_ps(String a) {
		WebElement we=u.waitForElement(d,pass, 20);
		if(a.contains("blank"))
		{
			a="";
			we.sendKeys(a);
			
		}
		else
		   we.sendKeys(a);
	}
	public void ck_bt() {
		WebElement we=u.elementclick(d,login, 20);
		we.click();
	}
	public String log()
	{
		WebElement we=u.waitForElement(d,logout, 20);
		return we.getText();
		
	}
	public String error()
	{
		WebElement we=u.waitForElement(d,error, 20);
		return we.getText();
		
	}
	public void do_login()
	{
		this.ck_ad();
		this.se_lo("admin");
		this.se_ps("admin");
		this.ck_bt();
	}
	
	
		  
	
	

}

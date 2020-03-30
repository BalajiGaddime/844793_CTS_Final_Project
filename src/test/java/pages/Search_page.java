package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import libary.Utility;


public class Search_page {
	WebDriver d;
	public Search_page(WebDriver d)
	{
		this.d=d;
	}
	Utility u=new Utility();
	int m=2;
	By assign_to_xpath=By.xpath("//select[@name='assign_to']");
	By project_xpath=By.xpath("//select[@name='project_id']");
	By priority_xpath=By.xpath("//select[@name='priority_id']");
	By status_xpath=By.xpath("//select[@name='status_id']");
	By type_xpath=By.xpath("//select[@name='type_id']");
	By search_btn_xpath=By.xpath("//input[@name='DoSearch']");
	By result_parameter=By.xpath("//table[@class='Grid']/tbody/tr[2]/td["+m+"]");
	By result_project=By.xpath("//table[@class='Grid']/tbody/tr[2]/td[1]/a");

	
	public void sec_pro(String a) {
		WebElement we=u.waitForElement(d,project_xpath, 20);
		Select s=new Select(we);
		s.selectByVisibleText(a);
		
	}
	public void sec_pri(String a) {
		WebElement we=u.waitForElement(d,priority_xpath, 20);
		Select s=new Select(we);
		s.selectByVisibleText(a);
		
	}
	public void sec_stu(String a) {
		WebElement we=u.waitForElement(d,status_xpath, 20);
		Select s=new Select(we);
		s.selectByVisibleText(a);
		
	}
	public void sec_typ(String a) {
		WebElement we=u.waitForElement(d,type_xpath, 20);
		Select s=new Select(we);
		s.selectByVisibleText(a);
		
	}
	public void sec_ass(String a) {
		WebElement we=u.waitForElement(d,assign_to_xpath, 20);
		Select s=new Select(we);
		s.selectByVisibleText(a);
		
	}
	public void ck_ser_b() {
		WebElement we=u.elementclick(d,search_btn_xpath, 20);
		we.click();
	}
	public String table_result(int s)
	{    
		return d.findElement(By.xpath("//table[@class='Grid']/tbody/tr[2]/td["+s+"]")).getText();
		
	}
	public String project_result()
	{   
		return u.waitForElement(d, result_project, 20).getText();
		
	}
	public void ck_project()
	{   
		 u.waitForElement(d, result_project, 20).click();
		
	}
	public void do_serch(String project,String priority,String status,String type,String assign_to)
	{
		this.sec_pro(project);
		this.sec_pri(priority);
		this.sec_stu(status);
		this.sec_typ(type);
		this.sec_ass(assign_to);
		this.ck_ser_b();
		
	}
}

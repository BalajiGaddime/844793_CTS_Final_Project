package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import libary.Utility;

public class Add_Task_Page {
	WebDriver d;
	

	public Add_Task_Page(WebDriver d)
	{
		this.d=d;
	}
	Utility u=new Utility();
	By add_task=By.xpath("//a[@href='TaskRecord.php']");
	By task_name=By.xpath("//input[@name='task_name']");
	By desc=By.xpath("//textarea[@name='task_desc']");
	By project=By.xpath("//select[@name='project_id']");
	By priority =By.xpath("//select[@name='priority_id']");
	By status =By.xpath("//select[@name='status_id']");
	By type =By.xpath("//select[@name='type_id']");
	By assigned_to=By.xpath("//select[@name='user_id_assign_to']");
	By start_date=By.xpath("//input[@name='task_start_date']");
	By finish_date=By.xpath("//input[@name='task_finish_date']");
	By add_btn=By.xpath("//input[@name='Insert']");
	By err=By.xpath("//tr[@class='Error']/td");
	By del=By.xpath("//input[@name='Delete']");
	public void ck_delete()
	{
		WebElement we=u.elementclick(d,del, 20);
		we.click();
	}
	public String get_err()
	{
		WebElement we=u.elementclick(d,err, 20);
		return we.getText();
	}
	public void ck_add() {
		WebElement we=u.elementclick(d,add_task, 20);
		we.click();
	}
	
	public void se_tas(String a) {
		WebElement we=u.waitForElement(d,task_name, 20);
		if(a.contains("blank"))
		{
			a="";
			we.sendKeys(a);
			
		}
		else
		we.sendKeys(a);
	}
	public void se_de(String a) {
		WebElement we=u.waitForElement(d,desc, 20);
		we.sendKeys(a);
	}
	public void sec_pro(String a) {
		WebElement we=u.waitForElement(d,project, 20);
		Select s=new Select(we);
		s.selectByVisibleText(a);
		
	}
	public void sec_pri(String a) {
		WebElement we=u.waitForElement(d,priority, 20);
		Select s=new Select(we);
		s.selectByVisibleText(a);
		
	}
	public void sec_stu(String a) {
		WebElement we=u.waitForElement(d,status, 20);
		Select s=new Select(we);
		s.selectByVisibleText(a);
		
	}
	public void sec_typ(String a) {
		WebElement we=u.waitForElement(d,type, 20);
		Select s=new Select(we);
		s.selectByVisibleText(a);
		
	}
	public void sec_ass(String a) {
		WebElement we=u.waitForElement(d,assigned_to, 20);
		Select s=new Select(we);
		s.selectByVisibleText(a);
		
	}
	public void se_start(String a) {
		WebElement we=u.waitForElement(d,start_date, 20);
		we.sendKeys(a);
	}
	public void se_finish(String a) {
		WebElement we=u.waitForElement(d,finish_date, 20);
		we.sendKeys(a);
	}
	
	
	public void ck_add_b() {
		WebElement we=u.elementclick(d,add_btn, 20);
		we.click();
	}
	public void do_task(String t,String pro,String pri,String stu,String typ,String assi) {
		this.ck_add();
		this.se_tas(t);
//		this.se_de(d);
		this.sec_pro(pro);
		this.sec_pri(pri);
		this.sec_stu(stu);
		this.sec_typ(typ);
		this.sec_ass(assi);
//		this.se_start(start);
//		this.se_finish(from);
		this.ck_add_b();
	}
	
}

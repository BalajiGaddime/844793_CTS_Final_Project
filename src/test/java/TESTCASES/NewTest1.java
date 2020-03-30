package TESTCASES;

import org.testng.annotations.Test;

import libary.Utility;

import pages.Add_Task_Page;
import pages.Login_page;
import pages.Search_page;


import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class NewTest1 extends Utility {
	Add_Task_Page ad;
	Login_page l;
	Search_page s;
	int num=2;
	 @BeforeMethod
	  public void lanuchBrowser() {
		  d=launchBroser("CHROME", "http://examples.codecharge.com/TaskManager/Default.php");//Launch of Browser with Chrome
	  }
	
	@Test(dataProvider="valid_add_task_data",priority=0)
	public void add_task_valid(String task_name,String project,String priority,String status,String type,String assign_to,String expected_result)
	{
		l=new Login_page(d);
		  l.do_login();//Login with Valid data
		  ad=new Add_Task_Page(d);
		  ad.do_task(task_name, project, priority, status, type, assign_to);//Add Task in the system 
		  s=new Search_page(d);
		  s.do_serch(project, priority, status, type, assign_to);//search for task
		  
		  String actual_result=s.project_result();//Get result of search
		  ScreenShot();//take screenshot
		  Assert.assertTrue(actual_result.contains(expected_result));//compare result
		  

	}
	@DataProvider
	  public String[][] valid_add_task_data() {
		  get_data("Sheet1",2,7);//Get data from sheet1 excel
		 return data;
	   
	  }
	@Test(dataProvider="delete_add_task_data",priority=1)
	public void add_task_delete(String task_name,String project,String priority,String status,String type,String assign_to,String expected_result)
	{
		l=new Login_page(d);
		  l.do_login();//Login with Valid data
		  ad=new Add_Task_Page(d);
		  ad.do_task(task_name, project, priority, status, type, assign_to);//add task in system
		  
		  s=new Search_page(d);
		  s.do_serch(project, priority, status, type, assign_to);//search for task
		   String actual_result=s.project_result();//get result of task
		   s.ck_project();//click on project task
		   ad.ck_delete();//delete task
		  ScreenShot();//take screenshot
		  Assert.assertTrue(actual_result.contains(expected_result));//compare result
		  

	}
	@DataProvider
	  public String[][] delete_add_task_data() {
		  get_data("Sheet2",1,7);//Get data from sheet2 excel
		 return data;
	   
	  }
	@Test(dataProvider="blank_add_task_data",priority=2)
	public void add_task_blank(String task_name,String project,String priority,String status,String type,String assign_to,String expected_result)
	{
		l=new Login_page(d);
		  l.do_login();//Login with Valid data
		  ad=new Add_Task_Page(d);
		  ad.do_task(task_name, project, priority, status, type, assign_to);//try add task with blank detail
		  String actual_result=ad.get_err();//Get result of error message
		  ScreenShot();//take screenshot
		  Assert.assertTrue(actual_result.contains(expected_result));//compare result
		  

	}
	@DataProvider
	  public String[][] blank_add_task_data() {
		  get_data("Sheet3",3,7);//Get data from sheet3 excel
		 return data;
	   
	  }
	
  @AfterMethod
  public void closeBrowser() {
	  d.close();//close Browser
	  
	  
	  
  }

}

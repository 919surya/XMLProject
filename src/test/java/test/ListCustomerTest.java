package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.ListCustomersPage;
import page.LoginPage;
import util.BrowserFactory;

public class ListCustomerTest {
	
	WebDriver driver;		
	String userName;
	String password;
	
	String dashBoardPage;
	
	String newCustomerPage;
	
	String fullName;
	String companyName;
	String email;
	String phone;
	String address;
	String city;
	String zipcode;
	String country;
	String group;
	
    @Test
	public void userShouldBeAbleToOpenListCustomerPage()  {
    	

		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickSigninButton();
		
		DashboardPage dashboardPage=PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage(dashBoardPage);
		dashboardPage.clickCustomersPage();
		dashboardPage.clickAddCustomerPage();
		
		AddCustomerPage addCustomerPage=PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.validateNewCustomer(newCustomerPage);
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.selectCompany(companyName);
		addCustomerPage.insertEmail(email);		
		addCustomerPage.insertPhone(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertZipCode(zipcode);		
		addCustomerPage.selectCountry(country);		
		addCustomerPage.selectGroup(group);
		addCustomerPage.clickSaveButton();
		
		dashboardPage.clickListCustomersPage();
		
		
		ListCustomersPage listCustomer=PageFactory.initElements(driver, ListCustomersPage.class);
		listCustomer.validationOfCustomerListPage("Customer List");
		
//		listCustomer.validateInsrtedCustomer();

		listCustomer.validateInsrtedCustomerAndDelete();
		
    }
}

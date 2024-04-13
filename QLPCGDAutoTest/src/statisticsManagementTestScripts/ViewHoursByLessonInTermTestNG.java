package statisticsManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;
import pageFactory.MenuTab;
import pageFactory.StatisticsLectureHoursPage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class ViewHoursByLessonInTermTestNG {
	private WebDriver webDriver;
	private LoginPage loginPage;
	private MenuTab menuTab;
	private StatisticsLectureHoursPage statisticsLectureHoursPage;
	private Actions actions;
	
	@BeforeTest
	public void beforeTest() throws InterruptedException {
		System.setProperty(DataContainer.WEBDRIVER_CHROME_DRIVER, DataContainer.WEBDRIVER_CHROME_DRIVER_PATH);
		
		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);
		statisticsLectureHoursPage = new StatisticsLectureHoursPage(webDriver);
		menuTab = new MenuTab(webDriver);
		actions = new Actions(webDriver);
		
		loginPage.loginToWebsite();
		menuTab.moveToViewLessonTab();
		statisticsLectureHoursPage.setViewHoursInTerm();
		statisticsLectureHoursPage.checkViewHoursByLessonButtonClicked();
	}
	
	@Test
	public void fullAndMinimizeScreen() throws InterruptedException {
		statisticsLectureHoursPage.fullAndMinimizeScreenButtonClicked();
	}
	
	@Test
	public void scrollUpAndDownPage() throws InterruptedException {
		actions.sendKeys(Keys.ARROW_DOWN).perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.UP).perform();
		Thread.sleep(2000);
	}
	
	@Test
	public void compareTitle() throws InterruptedException {
		String expectedTitle = "Thống kê số giờ giảng viên";
		String actualTitle = webDriver.getTitle();
		
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("PASS");
		}else {
			System.out.println("Fail");
			System.out.println("Expected Title: " + expectedTitle);
			System.out.println("Actual Title: " + actualTitle);
		}
	}

	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
package termManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;
import pageFactory.TermPage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class UpdateTermTestNG {

	private WebDriver webDriver;
	private LoginPage loginPage;
	private TermPage termPage;

	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty(DataContainer.WEBDRIVER_CHROME_DRIVER, DataContainer.WEBDRIVER_CHROME_DRIVER_PATH);

		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);
		termPage = new TermPage(webDriver);

		loginPage.loginToWebsite();
		termPage.chonMucHocKy();
	}

	@Test(priority = 1)
	public void TC1_updateTermSuccess() throws InterruptedException {
		termPage.suaHocKy("26", "2025", "7", "15");
		String thongBaoThanhCongExpect = "Cập nhật thành công!";
		String thongBaoThanhCongActual = webDriver.findElement(By.className("toast-message")).getText();
		if (thongBaoThanhCongActual.contentEquals(thongBaoThanhCongExpect)) {
			System.out.println("Pass");
			System.out.println("Thông báo cập nhật học kỳ thành công theo mong đợi là: " + thongBaoThanhCongExpect);
			System.out.println("Thông báo cập nhật học kỳ thành công theo thực tế là: " + thongBaoThanhCongActual);
		} else {
			System.out.println("Fail");
			System.out.println("Thông báo cập nhật học kỳ thành công theo mong đợi là: " + thongBaoThanhCongExpect);
			System.out.println("Thông báo cập nhật học kỳ thành công theo thực tế là: " + thongBaoThanhCongActual);
		}
	}

	@Test(priority = 2)
	public void TC2_updateTermWithoutData() throws InterruptedException {
		termPage.suaHocKy(null, null, null, null);
		String tuanBDErrorExpect = "Bạn chưa nhập tuần bắt đầu";
		String tietTDErrorExpect = "Bạn chưa nhập số tiết tối đa";
		String lopTDErrorExpect = "Bạn chưa nhập số lớp tối đa";
		String tuanBDErrorActual = webDriver.findElement(By.xpath("//*[@id=\"start_week-error\"]")).getText();
		String tietTDErrorActual = webDriver.findElement(By.xpath("//*[@id=\"max_lesson-error\"]")).getText();
		String lopTDErrorActual = webDriver.findElement(By.xpath("//*[@id=\"max_class-error\"]")).getText();
		if (tuanBDErrorActual.contentEquals(tuanBDErrorActual) && tietTDErrorActual.contentEquals(tietTDErrorExpect)
				&& lopTDErrorActual.contentEquals(lopTDErrorExpect)) {
			System.out.println("Pass");
			System.out.println("Thông báo lỗi của trường nhập tuần bắt đầu mong đợi là: " + tuanBDErrorExpect);
			System.out.println("Thông báo lỗi của trường nhập tuần bắt đầu thực tế là: " + tuanBDErrorActual);
			System.out.println("---------------------------------------");
			System.out.println("Thông báo lỗi của trường nhập tiết tối đa mong đợi là: " + tietTDErrorExpect);
			System.out.println("Thông báo lỗi của trường nhập tiết tối đa thực tế là: " + tietTDErrorActual);
			System.out.println("---------------------------------------");
			System.out.println("Thông báo lỗi của trường nhập lớp tối đa mong đợi là: " + lopTDErrorExpect);
			System.out.println("Thông báo lỗi của trường nhập lớp tối đa thực tế là: " + lopTDErrorActual);
		} else {
			System.out.println("Fail");
			System.out.println("Thông báo lỗi của trường nhập tuần bắt đầu mong đợi là: " + tuanBDErrorExpect);
			System.out.println("Thông báo lỗi của trường nhập tuần bắt đầu thực tế là: " + tuanBDErrorActual);
			System.out.println("---------------------------------------");
			System.out.println("Thông báo lỗi của trường nhập tiết tối đa mong đợi là: " + tietTDErrorExpect);
			System.out.println("Thông báo lỗi của trường nhập tiết tối đa thực tế là: " + tietTDErrorActual);
			System.out.println("---------------------------------------");
			System.out.println("Thông báo lỗi của trường nhập lớp tối đa mong đợi là: " + lopTDErrorExpect);
			System.out.println("Thông báo lỗi của trường nhập lớp tối đa thực tế là: " + lopTDErrorActual);
		}
	}

	@AfterTest
	public void afterTest() {
		webDriver.close();
	}
}

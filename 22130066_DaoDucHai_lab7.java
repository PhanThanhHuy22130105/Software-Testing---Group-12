//Checkout
package com.example.Checkout;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class UntitledTestCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private JavascriptExecutor js;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testUntitledTestCase() throws Exception {
    driver.get("https://shopvnb.com/");
    driver.findElement(By.linkText("Vợt cầu lông VNB V200 Xanh chính hãng")).click();
    driver.findElement(By.xpath("//form[@id='add-to-cart-form']/div[2]/div[3]/div/div/div/button[2]/b")).click();
    driver.findElement(By.linkText("Xem giỏ hàng")).click();
    driver.findElement(By.xpath("//body[@id='page_gio_hang']/div[2]/section[2]/div/div/div[2]/div/div[2]/div/div/form/div[3]/div[2]/button")).click();
    driver.findElement(By.id("dia_chi")).click();
    driver.findElement(By.id("dia_chi")).clear();
    driver.findElement(By.id("dia_chi")).sendKeys("Nông lâm tphcm");
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

//forgotPass
package com.example.ForgotPass;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class UntitledTestCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private JavascriptExecutor js;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testUntitledTestCase() throws Exception {
    driver.get("https://shopvnb.com/");
    driver.findElement(By.linkText("Đăng nhập")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("22130066@st.hcmuaf.edu.vn");
    driver.findElement(By.id("customer_password")).clear();
    driver.findElement(By.id("customer_password")).sendKeys("CK88MZNGAJ");
    driver.findElement(By.linkText("Quên mật khẩu")).click();
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("22130066@st.hcmuaf.edu.vn");
    driver.findElement(By.name("captcha")).click();
    driver.findElement(By.name("captcha")).clear();
    driver.findElement(By.name("captcha")).sendKeys("8818");
    driver.findElement(By.xpath("//input[@value='Lấy lại mật khẩu']")).click();
    driver.findElement(By.linkText("Xác nhận")).click();
    driver.get("https://mail.google.com/mail/u/0/#inbox/FMfcgzQdzcnFjNtbmbDGqJFFBjrKcnnF");
    driver.findElement(By.linkText("Hộp thư đến")).click();
    driver.get("https://mail.google.com/mail/u/0/#inbox");
    driver.findElement(By.id(":1q")).click();
    driver.findElement(By.linkText("Khôi phục mật khẩu")).click();
    driver.get("https://shopvnb.com/thanh-vien/quen-mat-khau?email=22130066@st.hcmuaf.edu.vn&xac_nhan=1&ma_xac_nhan=DSMIFACKWL");
    driver.findElement(By.xpath("//input[@value='Lấy lại mật khẩu']")).click();
    driver.get("https://shopvnb.com/thanh-vien");
    driver.findElement(By.linkText("Đăng nhập ngay")).click();
    //ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_local | ]]
    driver.get("https://mail.google.com/mail/u/0/#inbox/FMfcgzQdzcnFjNtJVVmKMVRRZhGDjlrQ");
    driver.findElement(By.linkText("Hộp thư đến")).click();
    driver.get("https://mail.google.com/mail/u/0/#inbox");
    driver.findElement(By.id(":mx")).click();
    driver.findElement(By.xpath("//div[@id='avWBGd-122']/div/table/tbody/tr[2]/td")).click();
    //ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_1 | ]]
    driver.get("https://shopvnb.com/thanh-vien/dang-nhap");
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("22130066@st.hcmuaf.edu.vn");
    driver.findElement(By.id("customer_password")).clear();
    driver.findElement(By.id("customer_password")).sendKeys("CK88MZNGAJ");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Liên hệ'])[1]/following::div[5]")).click();
    driver.findElement(By.id("customer_password")).clear();
    driver.findElement(By.id("customer_password")).sendKeys("12ZZ6QEF0P");
    driver.findElement(By.xpath("//input[@value='Đăng nhập']")).click();
    driver.get("https://shopvnb.com/thanh-vien");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Liên hệ'])[1]/following::div[2]")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

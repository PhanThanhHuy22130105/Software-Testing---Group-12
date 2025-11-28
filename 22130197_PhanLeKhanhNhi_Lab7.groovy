import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium
import org.testng.asserts.SoftAssert
import org.openqa.selenium.Keys as Keys

//CART_MGT_AddToCart_1
WebUI.openBrowser('https://www.google.com/')
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.google.com/"
selenium = new WebDriverBackedSelenium(driver, baseUrl)
selenium.open("https://shopvnb.com/")
selenium.click("xpath=//div[@id='tab-dm-0div']/div/div/div/div")
selenium.click("xpath=//img[@alt='Giày cầu lông Taro TR024-2']")
selenium.click("xpath=//form[@id='add-to-cart-form']/div[3]/div/div[6]/label/span")
selenium.click("xpath=//form[@id='add-to-cart-form']/div[4]/div[2]/div/div/div/button[2]")
selenium.click("link=Xem giỏ hàng")
WebUI.closeBrowser()

//CART_MGT_AddToCart_2
WebUI.openBrowser('https://www.google.com/')
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.google.com/"
selenium = new WebDriverBackedSelenium(driver, baseUrl)
selenium.open("https://shopvnb.com/")
selenium.click("link=Vợt cầu lông VNB Carbon Training 150g chính hãng")
selenium.click("xpath=//form[@id='add-to-cart-form']/div[2]/div[2]/div/div/div/div/button[2]/span")
selenium.click("xpath=//form[@id='add-to-cart-form']/div[2]/div[2]/div/div/div/div/button[2]/span")
selenium.click("xpath=//form[@id='add-to-cart-form']/div[2]/div[2]/div/div/div/div/button[2]/span")
selenium.click("xpath=//form[@id='add-to-cart-form']/div[2]/div[2]/div/div/div/div/button[2]/span")
selenium.click("xpath=//form[@id='add-to-cart-form']/div[2]/div[3]/div/div/div/button[2]")
selenium.click("link=Xem giỏ hàng")
WebUI.closeBrowser()

//CART_MGT_AddToCart_3
WebUI.openBrowser('https://www.google.com/')
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.google.com/"
selenium = new WebDriverBackedSelenium(driver, baseUrl)
selenium.open("https://shopvnb.com/")
selenium.click("link=Vợt cầu lông VNB V200i Hồng chính hãng")
selenium.click("xpath=//form[@id='add-to-cart-form']/div[2]/div[3]/div/div/div/button[2]/b")
selenium.click("link=Xem giỏ hàng")

WebUI.closeBrowser()

//CART_MGT_AddToCart_4
WebUI.openBrowser('https://www.google.com/')
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.google.com/"
selenium = new WebDriverBackedSelenium(driver, baseUrl)
selenium.open("https://shopvnb.com/")
selenium.click("xpath=//section[3]/div/div[2]/div[2]/div/a")
selenium.click("xpath=//img[@alt='Giày cầu lông Taro TR024-2']")
selenium.click("xpath=//form[@id='add-to-cart-form']/div[4]/div[2]/div/div/div/button[2]")

WebUI.closeBrowser()

//CART_MGT_AddToCart_5
WebUI.openBrowser('https://www.google.com/')
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.google.com/"
selenium = new WebDriverBackedSelenium(driver, baseUrl)
selenium.open("https://shopvnb.com/")
selenium.click("xpath=//section[3]/div/div[2]/div[2]/div/a")
selenium.click("xpath=//img[@alt='Giày cầu lông Taro TR024-2']")
selenium.click("xpath=//form[@id='add-to-cart-form']/div[3]/div/div[6]/label/span")
selenium.click("xpath=//form[@id='add-to-cart-form']/div[4]/div/div/div/div/div/button[2]/span")
selenium.click("xpath=//form[@id='add-to-cart-form']/div[4]/div/div/div/div/div/button[2]/span")
selenium.click("xpath=//form[@id='add-to-cart-form']/div[4]/div[2]/div/div/div/button[2]/b")
WebUI.closeBrowser()

// CART_MGT_ViewCart_3
WebUI.openBrowser('https://www.google.com/')
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.google.com/"
selenium = new WebDriverBackedSelenium(driver, baseUrl)
selenium.open("https://shopvnb.com/")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Giỏ hàng'])[2]/preceding::a[1]")
selenium.click("xpath=//body[@id='page_gio_hang']/div[2]/section[2]/div/div/div[2]/div/div[2]/div/div/form/div[2]/div[2]/div/div/div[2]/div/div/button[2]")
WebUI.closeBrowser()

//CART_MGT_ViewCart_4
WebUI.openBrowser('https://www.google.com/')
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.google.com/"
selenium = new WebDriverBackedSelenium(driver, baseUrl)
selenium.open("https://shopvnb.com/")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Giỏ hàng'])[1]/preceding::*[name()='svg'][1]")
selenium.click("xpath=//body[@id='page_gio_hang']/div[2]/section[2]/div/div/div[2]/div/div[2]/div/div/form/div[2]/div/div/div/div[2]/div/div/button[2]")


//CART_MGT_ViewCart_5
WebUI.openBrowser('https://www.google.com/')
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.google.com/"
selenium = new WebDriverBackedSelenium(driver, baseUrl)
selenium.open("https://shopvnb.com/")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Giỏ hàng'])[1]/preceding::*[name()='svg'][1]")
selenium.open("https://shopvnb.com/gio-hang")
selenium.click("xpath=//body[@id='page_gio_hang']/div[2]/section[2]/div/div/div[2]/div/div[2]/div/div/form/div[2]/div/div/div/div[2]/div/div/button")
WebUI.closeBrowser()

// CART_MGT_ViewCart_6
WebUI.openBrowser('https://www.google.com/')
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.google.com/"
selenium = new WebDriverBackedSelenium(driver, baseUrl)
selenium.open("https://shopvnb.com/")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Giỏ hàng'])[1]/preceding::*[name()='svg'][1]")
selenium.open("https://shopvnb.com/gio-hang")
selenium.click("xpath=//body[@id='page_gio_hang']/div[2]/section[2]/div/div/div[2]/div/div[2]/div/div/form/div[2]/div/div/div/div/a[2]")
WebUI.closeBrowser()

// CART_MGT_ViewCart_9
WebUI.openBrowser('https://www.google.com/')
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.google.com/"
selenium = new WebDriverBackedSelenium(driver, baseUrl)
selenium.open("https://shopvnb.com/")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Giỏ hàng'])[2]/preceding::a[1]")
selenium.open("https://shopvnb.com/gio-hang")
selenium.click("xpath=//body[@id='page_gio_hang']/div[2]/section[2]/div/div/div[2]/div/div[2]/div/div/form/div[3]/div[2]/button")
WebUI.closeBrowser()


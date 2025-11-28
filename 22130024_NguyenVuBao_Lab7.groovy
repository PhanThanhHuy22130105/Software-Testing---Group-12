import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.Keys as Keys

class Script_news{
	def view_news() {
		//view_news_TC1
		
		// BƯỚC 1: Truy cập trang chủ ShopVNB
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl('https://shopvnb.com')
		
		// Đợi trang chủ load xong và logo hiện ra
		WebUI.waitForPageLoad(15)
		WebUI.waitForElementVisible(findTestObject('ShopVNB/TinTuc/a_Tin tc'), 10)
		
		// BƯỚC 2: Click vào menu "Tin tức"
		WebUI.click(findTestObject('ShopVNB/TinTuc/a_Tin tc'))
		
		// Đợi trang Tin tức load xong
		WebUI.waitForPageLoad(15)
		
		// BƯỚC 3: Click vào bài viết có ảnh Review (đúng object bạn đã spy)
		WebUI.scrollToElement(findTestObject('ShopVNB/TinTuc/news'), 10)
		WebUI.click(findTestObject('ShopVNB/TinTuc/news'))
		
		// Đợi trang chi tiết bài viết load xong
		WebUI.waitForPageLoad(15)
		
		// Verify đã vào đúng bài viết (kiểm tra tiêu đề hoặc URL)
		WebUI.verifyElementPresent(findTestObject('ShopVNB/TinTuc/news'), 10)
		// Đóng trình duyệt
		WebUI.delay(10)
		//WebUI.closeBrowser()
	}
	def view_news_and_return() {
		//view_news_TC2
		
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl('https://shopvnb.com')
		
		// Đợi trang chủ load xong và logo hiện ra
		WebUI.waitForPageLoad(15)
		WebUI.waitForElementVisible(findTestObject('ShopVNB/TinTuc/a_Tin tc'), 10)
		
		// BƯỚC 2: Click vào menu "Tin tức"
		WebUI.click(findTestObject('ShopVNB/TinTuc/a_Tin tc'))
		
		// Đợi trang Tin tức load xong
		WebUI.waitForPageLoad(15)
		
		// BƯỚC 3: Click vào bài viết có ảnh Review (đúng object bạn đã spy)
		WebUI.scrollToElement(findTestObject('ShopVNB/TinTuc/news'), 10)
		WebUI.click(findTestObject('ShopVNB/TinTuc/news'))
		
		// Đợi trang chi tiết bài viết load xong
		WebUI.waitForPageLoad(15)
		
		// Đóng trình duyệt
		WebUI.delay(2)
		WebUI.click(findTestObject('ShopVNB/TinTuc/a_Tin tc'))
		
		// Đợi trang Tin tức load xong
		WebUI.waitForPageLoad(15)
		WebUI.delay(5)
		//WebUI.closeBrowser()
	}
	def search_news_withaccents() {
		//search_news_TC1
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl('https://shopvnb.com')
		
		// 2. Click vào menu "Tin tức" (dùng object bạn đã có trước đó)
		WebUI.waitForPageLoad(15)
		WebUI.click(findTestObject('ShopVNB/TinTuc/a_Tin tc'))
		
		// 3. Đợi trang Tin tức load xong + thanh tìm kiếm hiện ra
		WebUI.waitForPageLoad(15)
		WebUI.waitForElementVisible(findTestObject('ShopVNB/TinTuc/search_bar'), 10)
		
		// 4. Nhập từ khóa "cầu lông" vào thanh tìm kiếm
		WebUI.setText(findTestObject('ShopVNB/TinTuc/search_bar'), 'cầu lông')
		
		// 5. Nhấn Enter để tìm kiếm (nhanh và ổn định hơn click nút kính lúp)
		WebUI.sendKeys(findTestObject('ShopVNB/TinTuc/search_bar'), Keys.chord(Keys.ENTER))
		
		// Nếu bạn thích click nút tìm kiếm thay vì Enter thì dùng dòng dưới:
		// WebUI.click(findTestObject('ShopVNB/TinTuc/button_Search')) // nếu bạn có spy sẵn nút kính lúp
		
		// 6. Đợi kết quả tìm kiếm hiện ra
		WebUI.waitForPageLoad(15)
		WebUI.delay(1) // đợi 1 giây cho kết quả render xong
		
		// 7. Scroll tới + Click vào bài viết đầu tiên (object news1st bạn đã spy)
		WebUI.scrollToElement(findTestObject('ShopVNB/TinTuc/div'), 10)
		WebUI.click(findTestObject('ShopVNB/TinTuc/div'))
		
		
		WebUI.delay(2)
		//WebUI.closeBrowser()
	}
	def search_news_unaccents() {
		//search_news_TC2
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl('https://shopvnb.com')
		
		// 2. Click vào menu "Tin tức" (dùng object bạn đã có trước đó)
		WebUI.waitForPageLoad(15)
		WebUI.click(findTestObject('ShopVNB/TinTuc/a_Tin tc'))
		
		// 3. Đợi trang Tin tức load xong + thanh tìm kiếm hiện ra
		WebUI.waitForPageLoad(15)
		WebUI.waitForElementVisible(findTestObject('ShopVNB/TinTuc/search_bar'), 10)
		
		// 4. Nhập từ khóa "cầu lông" vào thanh tìm kiếm
		WebUI.setText(findTestObject('ShopVNB/TinTuc/search_bar'), 'vot cau long')
		
		// 5. Nhấn Enter để tìm kiếm (nhanh và ổn định hơn click nút kính lúp)
		WebUI.sendKeys(findTestObject('ShopVNB/TinTuc/search_bar'), Keys.chord(Keys.ENTER))
		
		// Nếu bạn thích click nút tìm kiếm thay vì Enter thì dùng dòng dưới:
		// WebUI.click(findTestObject('ShopVNB/TinTuc/button_Search')) // nếu bạn có spy sẵn nút kính lúp
		
		// 6. Đợi kết quả tìm kiếm hiện ra
		WebUI.waitForPageLoad(15)
		WebUI.delay(1) // đợi 1 giây cho kết quả render xong
		
		// 7. Scroll tới + Click vào bài viết đầu tiên (object news1st bạn đã spy)
		WebUI.scrollToElement(findTestObject('ShopVNB/TinTuc/div'), 10)
		WebUI.click(findTestObject('ShopVNB/TinTuc/div'))
		
		
		WebUI.delay(2)
		//WebUI.closeBrowser()
	}
	def search_news_single_word() {
		//search_news_TC3
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl('https://shopvnb.com')
		
		// 2. Click vào menu "Tin tức" (dùng object bạn đã có trước đó)
		WebUI.waitForPageLoad(15)
		WebUI.click(findTestObject('ShopVNB/TinTuc/a_Tin tc'))
		
		// 3. Đợi trang Tin tức load xong + thanh tìm kiếm hiện ra
		WebUI.waitForPageLoad(15)
		WebUI.waitForElementVisible(findTestObject('ShopVNB/TinTuc/search_bar'), 10)
		
		// 4. Nhập từ khóa "cầu lông" vào thanh tìm kiếm
		WebUI.setText(findTestObject('ShopVNB/TinTuc/search_bar'), 'giày')
		
		// 5. Nhấn Enter để tìm kiếm (nhanh và ổn định hơn click nút kính lúp)
		WebUI.sendKeys(findTestObject('ShopVNB/TinTuc/search_bar'), Keys.chord(Keys.ENTER))
		
		// Nếu bạn thích click nút tìm kiếm thay vì Enter thì dùng dòng dưới:
		// WebUI.click(findTestObject('ShopVNB/TinTuc/button_Search')) // nếu bạn có spy sẵn nút kính lúp
		
		// 6. Đợi kết quả tìm kiếm hiện ra
		WebUI.waitForPageLoad(15)
		WebUI.delay(1) // đợi 1 giây cho kết quả render xong
		
		// 7. Scroll tới + Click vào bài viết đầu tiên (object news1st bạn đã spy)
		WebUI.scrollToElement(findTestObject('ShopVNB/TinTuc/div'), 10)
		WebUI.click(findTestObject('ShopVNB/TinTuc/div'))
		
		
		WebUI.delay(2)
		//WebUI.closeBrowser()
	}
	def search_news_nonsense_word() {
		//search_news_TC4
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl('https://shopvnb.com')
		
		// 2. Click vào menu "Tin tức" (dùng object bạn đã có trước đó)
		WebUI.waitForPageLoad(15)
		WebUI.click(findTestObject('ShopVNB/TinTuc/a_Tin tc'))
		
		// 3. Đợi trang Tin tức load xong + thanh tìm kiếm hiện ra
		WebUI.waitForPageLoad(15)
		WebUI.waitForElementVisible(findTestObject('ShopVNB/TinTuc/search_bar'), 10)
		
		// 4. Nhập từ khóa "cầu lông" vào thanh tìm kiếm
		WebUI.setText(findTestObject('ShopVNB/TinTuc/search_bar'), 'abcxyz123')
		
		// 5. Nhấn Enter để tìm kiếm (nhanh và ổn định hơn click nút kính lúp)
		WebUI.sendKeys(findTestObject('ShopVNB/TinTuc/search_bar'), Keys.chord(Keys.ENTER))
		
		// Nếu bạn thích click nút tìm kiếm thay vì Enter thì dùng dòng dưới:
		// WebUI.click(findTestObject('ShopVNB/TinTuc/button_Search')) // nếu bạn có spy sẵn nút kính lúp
		
		// 6. Đợi kết quả tìm kiếm hiện ra
		WebUI.waitForPageLoad(15)
		WebUI.delay(1) // đợi 1 giây cho kết quả render xong
		
		// 7. Scroll tới + Click vào bài viết đầu tiên (object news1st bạn đã spy)
		WebUI.scrollToElement(findTestObject('ShopVNB/TinTuc/div'), 10)
		WebUI.click(findTestObject('ShopVNB/TinTuc/div'))
		
		
		WebUI.delay(2)
		//WebUI.closeBrowser()
	}
	def search_news_and_check_paging() {
		//search_news_TC5
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl('https://shopvnb.com')
		
		// 1. Vào Tin tức
		WebUI.click(findTestObject('ShopVNB/TinTuc/a_Tin tc'))
		WebUI.waitForPageLoad(15)
		
		// 2. Tìm kiếm "cầu lông"
		WebUI.setText(findTestObject('ShopVNB/TinTuc/search_bar'), 'cầu lông')
		WebUI.sendKeys(findTestObject('ShopVNB/TinTuc/search_bar'), Keys.chord(Keys.ENTER))
		WebUI.waitForPageLoad(20)
		
		// 3. Cuộn xuống cuối trang để load phân trang
		// Cuộn xuống 60% chiều cao trang web
		WebUI.executeJavaScript("window.scrollTo({ top: document.body.scrollHeight * 0.4, behavior: 'smooth' })", null)
		WebUI.delay(3)
		
		// Cuộn xuống 60% chiều cao trang web
		WebUI.executeJavaScript("window.scrollTo({ top: document.body.scrollHeight * 0.45, behavior: 'smooth' })", null)
		WebUI.delay(3)
		
		// Click trang 2, 3, 4 bằng text (chắc chắn đúng dù có tìm kiếm hay không)
		WebUI.executeJavaScript("window.scrollTo({ top: document.body.scrollHeight * 0.45, behavior: 'smooth' })", null)
		WebUI.delay(3)
		WebUI.click(findTestObject('ShopVNB/TinTuc/paging2'))
		WebUI.waitForPageLoad(15)
		
		WebUI.executeJavaScript("window.scrollTo({ top: document.body.scrollHeight * 0.45, behavior: 'smooth' })", null)
		WebUI.delay(3)
		WebUI.click(findTestObject('ShopVNB/TinTuc/paging3'))
		WebUI.waitForPageLoad(15)
		
		WebUI.executeJavaScript("window.scrollTo({ top: document.body.scrollHeight * 0.45, behavior: 'smooth' })", null)
		WebUI.delay(3)
		WebUI.click(findTestObject('ShopVNB/TinTuc/paging4'))
		WebUI.waitForPageLoad(15)
		WebUI.executeJavaScript("window.scrollTo({ top: document.body.scrollHeight * 0.45, behavior: 'smooth' })", null)
		WebUI.delay(3)
		
		WebUI.comment("ĐÃ CHUYỂN QUA 3 TRANG PHÂN TRANG THÀNH CÔNG VỚI TỪ KHÓA CẦU LÔNG!")
		WebUI.delay(3)
		//WebUI.closeBrowser()
	}
}







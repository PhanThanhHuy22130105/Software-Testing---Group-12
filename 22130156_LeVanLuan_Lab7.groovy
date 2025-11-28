import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

class SearchAndviewProductTest {
	
	// TC_SEARCH_01 Tìm kiếm sản phẩm hợp lệ
	def validSearchTest() {
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		
		WebUI.navigateToUrl('https://shopvnb.com')
		
		String keyword = "vợt cầu lông"
		WebUI.setText(findTestObject('Object Repository/Search/input_search'), keyword)
		
		WebUI.click(findTestObject('Object Repository/Search/btn_search'))
		
		WebUI.waitForPageLoad(10)
		
		boolean hasProduct = WebUI.verifyElementPresent(
			findTestObject('Object Repository/Search/list_product'),
			10,
			FailureHandling.OPTIONAL
		)
		
		if (hasProduct) {
			WebUI.comment("Kết quả OK: xuất hiện sản phẩm cho từ khóa '" + keyword + "'")
		} else {
			WebUI.comment("Không tìm thấy sản phẩm cho từ khóa '" + keyword + "'")
			WebUI.takeScreenshot()
			throw new Exception("Test Failed: Không tìm thấy sản phẩm")
		}
		
		WebUI.closeBrowser()
	}
	
	// TC_SEARCH_02 Tìm kiếm sản phẩm với từ khóa không chính xác
	def invalidSearchTest() {
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		
		WebUI.navigateToUrl('https://shopvnb.com')
		
		String keyword = "abcdt235126"
		WebUI.setText(findTestObject('Object Repository/Search/input_search'), keyword)
		
		WebUI.click(findTestObject('Object Repository/Search/btn_search'))
		
		WebUI.waitForPageLoad(10)
		
		boolean hasProduct = WebUI.verifyElementPresent(
			findTestObject('Object Repository/Search/no_product'),
			10,
			FailureHandling.OPTIONAL
		)
		
		if (hasProduct) {
			WebUI.comment("Kết quả OK: xuất hiện sản phẩm cho từ khóa '" + keyword + "'")
		} else {
			WebUI.comment("Không tìm thấy sản phẩm cho từ khóa '" + keyword + "'")
			WebUI.takeScreenshot()
			throw new Exception("Test Failed: Không tìm thấy sản phẩm")
		}
		
		WebUI.closeBrowser()
	}
	
	// TC_SEARCH_03: Tìm kiếm với từ khóa trống
	def emptySearchTest() {
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl('https://shopvnb.com')
		
		WebUI.setText(findTestObject('Object Repository/Search/input_search'), "") // từ khóa trống
		WebUI.click(findTestObject('Object Repository/Search/btn_search'))
	
		// Lấy thuộc tính validationMessage từ input
		String message = WebUI.getAttribute(findTestObject('Object Repository/Search/input_search'), 'validationMessage')
		WebUI.comment("Validation message: " + message)

		if (message.contains("Vui lòng") || message.contains("Please fill")) {
			WebUI.comment("Kết quả OK: hiển thị thông báo khi tìm kiếm từ khóa trống")
		} else {
			WebUI.comment("Test Failed: thông báo không đúng hoặc không xuất hiện")
			WebUI.takeScreenshot()
			throw new Exception("Test Failed: tìm kiếm từ khóa trống không xử lý đúng")
		}

		WebUI.closeBrowser()
	}
	
	// TC_SEARCH_04: Tìm kiếm với ký tự đặc biệt
	def specialCharacterSearchTest() {
		WebUI.openBrowser('')
		
		WebUI.navigateToUrl('https://shopvnb.com')
		
		String specialChars = '@#$^&*'
		
		WebUI.setText(findTestObject('Object Repository/Search/input_search'), specialChars)
		
		WebUI.click(findTestObject('Object Repository/Search/btn_search'))
		
		WebUI.waitForPageLoad(10)
		
		boolean hasProduct = WebUI.verifyElementPresent(
			findTestObject('Object Repository/Search/no_product'),
			10,
			FailureHandling.OPTIONAL
		)
		
		if (hasProduct) {
			WebUI.comment("Kết quả OK: xuất hiện sản phẩm cho từ khóa '" + specialChars + "'")
		} else {
			WebUI.comment("Không tìm thấy sản phẩm cho từ khóa '" + specialChars + "'")
			WebUI.takeScreenshot()
			throw new Exception("Test Failed: Không tìm thấy sản phẩm")
		}
		
		WebUI.closeBrowser()
	}
	
	
	def runAllTestsSearchProduct() {
		validSearchTest();
		invalidSearchTest();
		emptySearchTest();
		specialCharacterSearchTest();
	}
	
}


 class ProductDetailTest {
	 // TC_PDP_01 – Mở trang chi tiết sản phẩm từ danh sách
    def openProductDetailFromList() {

        WebUI.comment("=== TC_PDP_01: Mở trang chi tiết sản phẩm từ danh sách ===")

        WebUI.openBrowser('')
        WebUI.maximizeWindow()
        WebUI.navigateToUrl("https://shopvnb.com")

        WebUI.waitForPageLoad(10)

        // Click vào sản phẩm đầu tiên
        WebUI.click(findTestObject('Object Repository/Product Detail/click_product'))

        WebUI.waitForPageLoad(10)

        // Verify trang chi tiết sản phẩm mở ra
        boolean hasTitle = WebUI.verifyElementPresent(
            findTestObject('Object Repository/Product Detail/title_product_detail'),
            10,
            FailureHandling.OPTIONAL
        )

        if (!hasTitle) {
            WebUI.takeScreenshot()
            throw new Exception("FAILED: Không mở được trang chi tiết sản phẩm")
        }

        WebUI.comment("PASSED: Trang chi tiết sản phẩm đã mở thành công")

        WebUI.closeBrowser()
    }
	
	// TC_PDP_02 – Xem sản phẩm liên quan
	def viewRelatedProductTest() {

		WebUI.comment("=== TC_PDP_02: Xem sản phẩm liên quan trong trang chi tiết ===")

		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl("https://shopvnb.com")

		WebUI.waitForPageLoad(10)

		// Mở sản phẩm đầu tiên để vào trang chi tiết
		WebUI.click(findTestObject('Object Repository/Product Detail/click_product'))
		WebUI.waitForPageLoad(10)

		// Cuộn xuống mục "Sản phẩm liên quan"
		WebUI.scrollToElement(findTestObject('Object Repository/Product Detail/check_title_product_related'), 10)

		boolean hasRelatedSection = WebUI.verifyElementPresent(
			findTestObject('Object Repository/Product Detail/title_product_detail'),
			10,
			FailureHandling.OPTIONAL
		)

		if (!hasRelatedSection) {
			WebUI.takeScreenshot()
			throw new Exception("FAILED: Không tìm thấy mục 'Sản phẩm liên quan'")
		}

		WebUI.comment("Tìm thấy mục Sản phẩm liên quan")

		// Nhấn vào sản phẩm liên quan
		WebUI.click(findTestObject('Object Repository/Product Detail/click_product_related'))
		WebUI.waitForPageLoad(10)

		// Kiểm tra rằng trang chi tiết của sản phẩm liên quan được mở
		boolean hasProductTitle = WebUI.verifyElementPresent(
			findTestObject('Object Repository/Product Detail/title_product_detail'),
			10,
			FailureHandling.OPTIONAL
		)

		if (!hasProductTitle) {
			WebUI.takeScreenshot()
			throw new Exception("FAILED: Không mở được trang chi tiết của sản phẩm liên quan")
		}

		WebUI.comment("PASSED: Mở trang chi tiết của sản phẩm liên quan thành công")

		WebUI.closeBrowser()
	}
	
	// TC_PDP_03 – Thay đổi số lượng sản phẩm
	def increaseQuantityTest() {

		WebUI.comment("=== TC_PDP_03: Tăng số lượng sản phẩm ===")

		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl("https://shopvnb.com")

		WebUI.waitForPageLoad(10)

		// B1: Mở trang chi tiết từ sản phẩm
		WebUI.click(findTestObject('Object Repository/Product Detail/click_product'))
		WebUI.waitForPageLoad(10)

		// B2: Lấy số lượng hiện tại
		String qtyBefore = WebUI.getAttribute(findTestObject('Object Repository/Product Detail/input_quantity'), 'value')
		int beforeValue = Integer.parseInt(qtyBefore)

		WebUI.comment("Số lượng trước khi tăng: " + beforeValue)

		// B3: Nhấn nút tăng số lượng
		WebUI.click(findTestObject('Object Repository/Product Detail/btn_increase_qty'))
		WebUI.delay(1)

		// B4: Lấy số lượng sau khi tăng
		String qtyAfter = WebUI.getAttribute(findTestObject('Object Repository/Product Detail/input_quantity'), 'value')
		int afterValue = Integer.parseInt(qtyAfter)

		WebUI.comment("Số lượng sau khi tăng: " + afterValue)

		// B5: Kiểm tra kết quả
		if (afterValue == beforeValue + 1) {
			WebUI.comment("PASSED: Tăng số lượng thành công")
		} else {
			WebUI.takeScreenshot()
			throw new Exception("FAILED: Giá trị số lượng không tăng đúng (Expected: " + (beforeValue + 1) + ", Actual: " + afterValue + ")")
		}

		WebUI.closeBrowser()
	}

	//	TC_PDP_04: Hiển thị bảng Thông số kỹ thuật khi nhấn vào tab
	def showSpecificationsTest() {
		WebUI.comment("TC_PDP_04: Hiển thị bảng Thông số kỹ thuật khi nhấn vào tab")

		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl("https://shopvnb.com/vot-cau-long-vnb-v200-xanh.html")
		WebUI.waitForPageLoad(10)

		// Click vào tab "Thông số kỹ thuật"
		WebUI.click(findTestObject('Product Detail/tab_specifications'))
		WebUI.delay(1)  // đợi bảng load

		// Kiểm tra bảng thông số kỹ thuật xuất hiện
		boolean isVisible = WebUI.verifyElementPresent(findTestObject('Product Detail/table_specifications'), 5, FailureHandling.OPTIONAL)
		if (isVisible) {
			WebUI.comment("PASSED: Bảng Thông số kỹ thuật hiển thị đúng khi nhấn tab")
		} else {
			WebUI.takeScreenshot()
			throw new Exception("FAILED: Bảng Thông số kỹ thuật không hiển thị khi nhấn tab")
		}

		WebUI.closeBrowser()
	}

	
	def runAllTestsProductDetail() {
		openProductDetailFromList();
		viewRelatedProductTest();
		increaseQuantityTest();
		showSpecificationsTest();
	}
 }
 
new SearchAndviewProductTest().runAllTestsSearchProduct();

//new ProductDetailTest().runAllTestsProductDetail();



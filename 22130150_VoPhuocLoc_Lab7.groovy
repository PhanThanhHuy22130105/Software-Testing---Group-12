package keywords.shopvnb

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.annotation.Keyword
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import org.openqa.selenium.WebElement
import com.kms.katalon.core.model.FailureHandling

class Script_Filter_Rating {
	//FILTER:
	@Keyword
	//TC_Filter_01
	def filterByBrand() {
		WebUI.openBrowser('')
		WebUI.navigateToUrl('https://shopvnb.com')

		WebUI.mouseOver(findTestObject('Object Repository/Filter/TC_Filter//Menu_SanPham'))
		WebUI.click(findTestObject('Object Repository/Filter/TC_Filter_Branch/Menu_VotCauLong'))

		WebUI.verifyTextPresent('Vợt Cầu Lông', false)
		//		WebUI.closeBrowser()
	}

	//TC_Filter_02
	def filterByPrice(){
		WebUI.openBrowser('')
		WebUI.navigateToUrl('https://shopvnb.com')

		WebUI.mouseOver(findTestObject('Object Repository/Filter/TC_Filter/Menu_SanPham'))
		WebUI.click(findTestObject('Object Repository/Filter/TC_Filter_Price/Menu_GiayCauLong'))
		WebUI.verifyTextPresent('Giày Cầu Lông', false)

		// --- FILTER theo giá ---
		WebUI.waitForElementVisible(findTestObject('Object Repository/Filter/TC_Filter_Price/Price_2_3M'), 10)
		WebUI.scrollToElement(findTestObject('Object Repository/Filter/TC_Filter_Price/Price_2_3M'), 10)
		WebUI.click(findTestObject('Object Repository/Filter/TC_Filter_Price/Price_2_3M'))

		WebUI.delay(2)

		// --- Verify kết quả ---
		WebUI.verifyTextPresent('2 - 3 triệu', false)

		//		WebUI.closeBrowser()
	}

	//TC_Filter_03
	def filterNoResult() {
		WebUI.openBrowser('')
		WebUI.navigateToUrl('https://shopvnb.com')

		WebUI.mouseOver(findTestObject('Object Repository/Filter/TC_Filter/Menu_SanPham'))
		WebUI.click(findTestObject('Object Repository/Filter/TC_Filter_Price/Menu_GiayCauLong'))
		WebUI.verifyTextPresent('Giày Cầu Lông', false)

		// --- FILTER theo giá ---
		WebUI.waitForElementVisible(findTestObject('Object Repository/Filter/TC_Filter_NoResult/PriceDown_500'), 10)
		WebUI.scrollToElement(findTestObject('Object Repository/Filter/TC_Filter_NoResult/PriceDown_500'), 10)
		WebUI.click(findTestObject('Object Repository/Filter/TC_Filter_NoResult/PriceDown_500'))

		WebUI.delay(1)

		// --- FILTER theo thương hiệu Lining ---
		WebUI.waitForElementVisible(findTestObject('Object Repository/Filter/TC_Filter_NoResult/Brand_Lining'), 10)
		WebUI.scrollToElement(findTestObject('Object Repository/Filter/TC_Filter_NoResult/Brand_Lining'), 10)
		WebUI.click(findTestObject('Object Repository/Filter/TC_Filter_NoResult/Brand_Lining'))

		WebUI.delay(2)

		// --- Verify kết quả ---
		WebUI.verifyTextPresent('Lining', false)
		WebUI.verifyTextPresent('500', false)

		//		WebUI.closeBrowser()
	}

	//TC_Filter_04
	def filterByPriceAndGoToPage2(){
		WebUI.openBrowser('')
		WebUI.navigateToUrl('https://shopvnb.com')

		WebUI.mouseOver(findTestObject('Object Repository/Filter/TC_Filter/Menu_SanPham'))
		WebUI.click(findTestObject('Object Repository/Filter/TC_Filter_Price/Menu_GiayCauLong'))
		WebUI.verifyTextPresent('Giày Cầu Lông', false)

		// --- FILTER theo giá ---
		WebUI.waitForElementVisible(findTestObject('Object Repository/Filter/TC_Filter_Price/Price_2_3M'), 10)
		WebUI.scrollToElement(findTestObject('Object Repository/Filter/TC_Filter_Price/Price_2_3M'), 10)
		WebUI.click(findTestObject('Object Repository/Filter/TC_Filter_Price/Price_2_3M'))

		WebUI.delay(2)

		// --- Verify filter ---
		WebUI.verifyTextPresent('2 - 3 triệu', false)

		// --- SCROLL ---
		WebUI.scrollToElement(findTestObject('Object Repository/Filter/TC_Filter_PageNext/Page_2'), 10)
		WebUI.delay(1)

		// --- CLICK TRANG 2 ---
		WebUI.click(findTestObject('Object Repository/Filter/TC_Filter_PageNext/Page_2'))
		WebUI.delay(2)

		//		WebUI.closeBrowser()
	}

	//TC_Filter_05
	def filterByPriceAndSortby() {
		WebUI.openBrowser('')
		WebUI.navigateToUrl('https://shopvnb.com')

		WebUI.mouseOver(findTestObject('Object Repository/Filter/TC_Filter/Menu_SanPham'))
		WebUI.click(findTestObject('Object Repository/Filter/TC_Filter_Price/Menu_GiayCauLong'))
		WebUI.verifyTextPresent('Giày Cầu Lông', false)

		// --- FILTER 2 - 3 triệu ---
		WebUI.waitForElementVisible(findTestObject('Object Repository/Filter/TC_Filter_Price/Price_2_3M'), 10)
		WebUI.scrollToElement(findTestObject('Object Repository/Filter/TC_Filter_Price/Price_2_3M'), 10)
		WebUI.click(findTestObject('Object Repository/Filter/TC_Filter_Price/Price_2_3M'))
		WebUI.delay(2)

		// --- CUỘN XUỐNG KHU SẮP XẾP ---
		WebUI.scrollToElement(findTestObject('Object Repository/Filter/TC_Filter_Sort/Menu_Sort'), 10)

		// --- MỞ MENU SẮP XẾP ---
		WebUI.click(findTestObject('Object Repository/Filter/TC_Filter_Sort/Menu_Sort'))
		WebUI.delay(1)

		// --- CHỌN "GIÁ TĂNG DẦN" ---
		WebUI.click(findTestObject('Object Repository/Filter/TC_Filter_Sort/Sort_Up'))
		WebUI.delay(2)

		// --- VERIFY ---
		WebUI.verifyTextPresent("Giá tăng dần", false)
	}

	//------------------------------------------------------------------------------------------------
	//**
	//------------------------------------------------------------------------------------------------
	
	//RAITNG
	//TC_Rating_01:
	def ratingValid() {
		// --- Mở trang ---
		WebUI.openBrowser('')
		WebUI.navigateToUrl('https://shopvnb.com')
		WebUI.waitForPageLoad(10)

		// --- Click vào link sản phẩm ---
		def productLink = findTestObject('Object Repository/Rating/ProductDetail/Link_VNB_V200_Xanh')
		WebUI.scrollToElement(productLink, 10)
		WebUI.delay(1)
		WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(WebUI.findWebElement(productLink)))
		WebUI.delay(2)

		// --- Click vào nút "Đánh giá ngay" ---
		def rateButton = findTestObject('Object Repository/Rating/ProductDetail/Button_Danhgia')
		WebUI.scrollToElement(rateButton, 10)
		WebUI.delay(1)
		WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(WebUI.findWebElement(rateButton)))
		WebUI.delay(2)

		// --- Điền thông tin đánh giá ---
		WebUI.setText(findTestObject('Object Repository/Rating/Form_DanhGia/Input_HoTen'), 'Vo Phuoc Loc')
		WebUI.setText(findTestObject('Object Repository/Rating/Form_DanhGia/Input_SoDT'), '0987654321')
		WebUI.uploadFile(findTestObject('Object Repository/Rating/Form_DanhGia/Input_Img'),
				'C:\\Users\\Admin\\Pictures\\Screenshots\\Screenshot 2025-11-24 225129.png')
		WebUI.setText(findTestObject('Object Repository/Rating/Form_DanhGia/NoiDung'),
				'Sản phẩm rất tốt, chất lượng như mong đợi!')
		WebUI.click(findTestObject('Object Repository/Rating/Form_DanhGia/Input_Star5'))

		// --- CHỜ BẠN NHẬP CAPTCHA 5 GIÂY ---
		WebUI.comment("Vui lòng nhập Captcha trong 5 giây...")
		WebUI.delay(5)

		// --- TỰ ĐỘNG SUBMIT ---
		// Click submit bằng JS (quan trọng)
		def submitBtn = findTestObject('Object Repository/Rating/Form_DanhGia/Button_Submit')
		WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(WebUI.findWebElement(submitBtn)))

		// Chờ alert
		WebUI.waitForAlert(10)

		// Lấy text alert
		String msg = WebUI.getAlertText()
		println(msg)

		// Xác nhận alert
		WebUI.acceptAlert()

		// Kiểm tra nội dung alert
		WebUI.verifyMatch(msg, '.*kiểm duyệt.*|.*cám ơn.*', true)
	}

	//TC_Rating_02:
	def ratingMissing() {
		// Mở trang
		WebUI.openBrowser('')
		WebUI.navigateToUrl('https://shopvnb.com')
		WebUI.waitForPageLoad(10)

		// Scroll và click vào link sản phẩm
		def productLink = findTestObject('Object Repository/Rating/ProductDetail/Link_VNB_V200_Xanh')
		WebUI.scrollToElement(productLink, 10)
		WebUI.delay(1)
		WebUI.executeJavaScript(
				"arguments[0].click();",
				Arrays.asList(WebUI.findWebElement(productLink))
				)
		WebUI.delay(2)

		// Scroll và click "Đánh giá ngay"
		def rateButton = findTestObject('Object Repository/Rating/ProductDetail/Button_Danhgia')
		WebUI.scrollToElement(rateButton, 10)
		WebUI.delay(1)
		WebUI.executeJavaScript(
				"arguments[0].click();",
				Arrays.asList(WebUI.findWebElement(rateButton))
				)
		WebUI.delay(2)

		// Nhập thông tin đánh giá (không nhập CAPTCHA)
		WebUI.setText(findTestObject('Object Repository/Rating/Form_DanhGia/Input_HoTen'), 'Vo Phuoc Loc')
		WebUI.setText(findTestObject('Object Repository/Rating/Form_DanhGia/Input_SoDT'), '0987654321')
		WebUI.setText(findTestObject('Object Repository/Rating/Form_DanhGia/NoiDung'), 'Sản phẩm rất tốt, chất lượng như mong đợi!')
		WebUI.uploadFile(findTestObject('Object Repository/Rating/Form_DanhGia/Input_Img'),
				'C:\\Users\\Admin\\Pictures\\Screenshots\\Screenshot 2025-11-24 225129.png')

		// Chọn 5 sao
		def star5Div = findTestObject('Object Repository/Rating/Form_DanhGia/Input_Star5')
		WebUI.scrollToElement(star5Div, 10)
		WebUI.delay(1)
		WebUI.click(star5Div)

		// KHÔNG nhập Captcha

		// Submit form
		WebUI.click(findTestObject('Object Repository/Rating/Form_DanhGia/Button_Submit'))
		WebUI.delay(2)

		WebUI.closeBrowser()
	}

	//TC_Rating_03:
	def ratingSpam() {
		// --- Mở trình duyệt và load trang sản phẩm ---
		WebUI.openBrowser('')
		WebUI.navigateToUrl('https://shopvnb.com')
		WebUI.waitForPageLoad(10)

		def productLink = findTestObject('Object Repository/Rating/ProductDetail/Link_VNB_V200_Xanh')
		WebUI.scrollToElement(productLink, 10)
		WebUI.delay(1)
		WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(WebUI.findWebElement(productLink)))
		WebUI.delay(2)

		def rateButton = findTestObject('Object Repository/Rating/ProductDetail/Button_Danhgia')
		WebUI.scrollToElement(rateButton, 10)
		WebUI.delay(1)
		WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(WebUI.findWebElement(rateButton)))
		WebUI.delay(2)

		// --- Loop spam 3 lần ---
		for (int i = 1; i <= 3; i++) {
			println("===== SPAM LẦN ${i} =====")

			// --- Nếu form đang mở → đóng lại để tránh double layer ---
			try {
				WebUI.click(findTestObject('Object Repository/Rating/Form_DanhGia/Button_Close'), FailureHandling.OPTIONAL)
				WebUI.delay(1)
			} catch (Exception e) { }

			// --- Mở form đánh giá lại ---
			WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(WebUI.findWebElement(rateButton)))
			WebUI.delay(2)

			// --- Chờ input có thể tương tác ---
			WebUI.waitForElementClickable(findTestObject('Object Repository/Rating/Form_DanhGia/Input_HoTen'), 10)

			// --- Điền thông tin đánh giá ---
			WebUI.setText(findTestObject('Object Repository/Rating/Form_DanhGia/Input_HoTen'), 'Vo Phuoc Loc')
			WebUI.setText(findTestObject('Object Repository/Rating/Form_DanhGia/Input_SoDT'), '0987654321')
			WebUI.uploadFile(findTestObject('Object Repository/Rating/Form_DanhGia/Input_Img'),
					'C:\\Users\\Admin\\Pictures\\Screenshots\\Screenshot 2025-11-24 225129.png')
			WebUI.setText(findTestObject('Object Repository/Rating/Form_DanhGia/NoiDung'),
					'Nội dung đánh giá lần ' + i)
			WebUI.click(findTestObject('Object Repository/Rating/Form_DanhGia/Input_Star5'))

			// --- Chờ CAPTCHA nhập liệu ---
			WebUI.delay(5)  // chỉnh thời gian phù hợp

			// --- Submit đánh giá ---
			def submitBtn = findTestObject('Object Repository/Rating/Form_DanhGia/Button_Submit')
			WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(WebUI.findWebElement(submitBtn)))

			// --- Lấy và xử lý alert ---
			try {
				WebUI.waitForAlert(10)
				String msg = WebUI.getAlertText()
				println("Kết quả lần ${i}: " + msg)

				// Xác nhận alert
				WebUI.acceptAlert()

				// --- Kiểm tra nội dung alert nhưng không dừng script nếu fail ---
				try {
					WebUI.verifyMatch(msg, '.*kiểm duyệt.*|.*cám ơn.*', true, FailureHandling.CONTINUE_ON_FAILURE)
				} catch (Exception e) {
					println("Lỗi verifyMatch lần ${i}: " + e.getMessage())
				}
			} catch (Exception e) {
				println("Không tìm thấy alert lần ${i}, có thể do captcha hoặc lỗi web: " + e.getMessage())
			}

			WebUI.delay(2)
		}
	}

	//TC_Rating_04
	def ratingInvalidPhone() {
		// --- Mở trang ---
		WebUI.openBrowser('')
		WebUI.navigateToUrl('https://shopvnb.com')
		WebUI.waitForPageLoad(10)

		// --- Click vào link sản phẩm ---
		def productLink = findTestObject('Object Repository/Rating/ProductDetail/Link_VNB_V200_Xanh')
		WebUI.scrollToElement(productLink, 10)
		WebUI.delay(1)
		WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(WebUI.findWebElement(productLink)))
		WebUI.delay(2)

		// --- Click vào "Đánh giá ngay" ---
		def rateButton = findTestObject('Object Repository/Rating/ProductDetail/Button_Danhgia')
		WebUI.scrollToElement(rateButton, 10)
		WebUI.delay(1)
		WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(WebUI.findWebElement(rateButton)))
		WebUI.delay(2)

		// --- Điền form đánh giá ---
		WebUI.setText(findTestObject('Object Repository/Rating/Form_DanhGia/Input_HoTen'), 'Vo Phuoc Loc')

		// ❗ NHẬP SAI ĐỊNH DẠNG SĐT
		WebUI.setText(findTestObject('Object Repository/Rating/Form_DanhGia/Input_SoDT'), '09abc1234')

		// Không cần upload ảnh cho testcase này
		WebUI.setText(findTestObject('Object Repository/Rating/Form_DanhGia/NoiDung'),
				'Test nhập sai số điện thoại')

		WebUI.click(findTestObject('Object Repository/Rating/Form_DanhGia/Input_Star5'))

		// --- CHỜ NHẬP CAPTCHA ---
		WebUI.comment("Vui lòng nhập Captcha trong 5 giây...")
		WebUI.delay(5)

		// --- Submit ---
		def submitBtn = findTestObject('Object Repository/Rating/Form_DanhGia/Button_Submit')
		WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(WebUI.findWebElement(submitBtn)))

		// --- Chờ alert ---
		WebUI.waitForAlert(10)

		// --- Lấy nội dung alert ---
		String msg = WebUI.getAlertText()
		println("Alert: " + msg)

		WebUI.delay(2)
		WebUI.acceptAlert()

		// --- Verify alert đúng expected ---
		WebUI.verifyMatch(msg, '.*Số điện thoại không đúng.*', true)
	}

	//TC_Rating_05:
	def ratingMissingRate() {
		// --- Mở trang ---
		WebUI.openBrowser('')
		WebUI.navigateToUrl('https://shopvnb.com')
		WebUI.waitForPageLoad(10)

		// --- Click vào link sản phẩm ---
		def productLink = findTestObject('Object Repository/Rating/ProductDetail/Link_VNB_V200_Xanh')
		WebUI.scrollToElement(productLink, 10)
		WebUI.delay(1)
		WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(WebUI.findWebElement(productLink)))
		WebUI.delay(2)

		// --- Click vào nút "Đánh giá ngay" ---
		def rateButton = findTestObject('Object Repository/Rating/ProductDetail/Button_Danhgia')
		WebUI.scrollToElement(rateButton, 10)
		WebUI.delay(1)
		WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(WebUI.findWebElement(rateButton)))
		WebUI.delay(2)

		// --- Điền thông tin đánh giá ---
		WebUI.setText(findTestObject('Object Repository/Rating/Form_DanhGia/Input_HoTen'), 'Vo Phuoc Loc')
		WebUI.setText(findTestObject('Object Repository/Rating/Form_DanhGia/Input_SoDT'), '0987654321')
		WebUI.uploadFile(findTestObject('Object Repository/Rating/Form_DanhGia/Input_Img'),
				'C:\\Users\\Admin\\Pictures\\Screenshots\\Screenshot 2025-11-24 225129.png')
		WebUI.setText(findTestObject('Object Repository/Rating/Form_DanhGia/NoiDung'),
				'Sản phẩm rất tốt, chất lượng như mong đợi!')
		//Không chọn sao đánh giá

		// --- CHỜ BẠN NHẬP CAPTCHA 5 GIÂY ---
		WebUI.comment("Vui lòng nhập Captcha trong 5 giây...")
		WebUI.delay(5)

		// --- TỰ ĐỘNG SUBMIT ---
		// Click submit bằng JS (quan trọng)
		def submitBtn = findTestObject('Object Repository/Rating/Form_DanhGia/Button_Submit')
		WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(WebUI.findWebElement(submitBtn)))

		// Chờ alert
		WebUI.waitForAlert(10)

		// Lấy text alert
		String msg = WebUI.getAlertText()
		println(msg)

		WebUI.delay(2)
		// Xác nhận alert
		WebUI.acceptAlert()

		// Kiểm tra nội dung alert
		WebUI.verifyMatch(msg, '.*Bạn chưa đánh giá*.', true)
	}

	//TC_Rating_06:
	def ratingCheckEmoji() {
		// --- Mở trang ---
		WebUI.openBrowser('')
		WebUI.navigateToUrl('https://shopvnb.com')
		WebUI.waitForPageLoad(10)

		// --- Click vào link sản phẩm ---
		def productLink = findTestObject('Object Repository/Rating/ProductDetail/Link_VNB_V200_Xanh')
		WebUI.scrollToElement(productLink, 10)
		WebUI.delay(1)
		WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(WebUI.findWebElement(productLink)))
		WebUI.delay(2)

		// --- Click vào nút "Đánh giá ngay" ---
		def rateButton = findTestObject('Object Repository/Rating/ProductDetail/Button_Danhgia')
		WebUI.scrollToElement(rateButton, 10)
		WebUI.delay(1)
		WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(WebUI.findWebElement(rateButton)))
		WebUI.delay(2)

		// --- Điền thông tin đánh giá ---
		WebUI.setText(findTestObject('Object Repository/Rating/Form_DanhGia/Input_HoTen'), 'Vo Phuoc Loc')
		WebUI.setText(findTestObject('Object Repository/Rating/Form_DanhGia/Input_SoDT'), '0987654321')
		WebUI.uploadFile(findTestObject('Object Repository/Rating/Form_DanhGia/Input_Img'),
				'C:\\Users\\Admin\\Pictures\\Screenshots\\Screenshot 2025-11-24 225129.png')
		// Lấy WebElement từ TestObject
		WebElement noiDungEl = WebUI.findWebElement(findTestObject('Rating/Form_DanhGia/NoiDung'))

		// Set giá trị bằng JS
		WebUI.executeJavaScript("arguments[0].value='Sản phẩm tốt 😊🔥👍!!!';", Arrays.asList(noiDungEl))
		WebUI.click(findTestObject('Object Repository/Rating/Form_DanhGia/Input_Star5'))

		// --- CHỜ BẠN NHẬP CAPTCHA 5 GIÂY ---
		WebUI.comment("Vui lòng nhập Captcha trong 5 giây...")
		WebUI.delay(5)

		// --- TỰ ĐỘNG SUBMIT ---
		// Click submit bằng JS (quan trọng)
		def submitBtn = findTestObject('Object Repository/Rating/Form_DanhGia/Button_Submit')
		WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(WebUI.findWebElement(submitBtn)))

		// Chờ alert
		WebUI.waitForAlert(10)

		// Lấy text alert
		String msg = WebUI.getAlertText()
		println(msg)

		// Xác nhận alert
		WebUI.acceptAlert()

		// Kiểm tra nội dung alert
		WebUI.verifyMatch(msg, '.*kiểm duyệt.*|.*cám ơn.*', true)
	}
}

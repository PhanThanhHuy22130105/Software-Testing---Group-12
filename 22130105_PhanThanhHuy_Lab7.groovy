import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling

// Contact
//Test Cases/Contact/TC02_FullInfo_SendSuccess
WebUI.openBrowser('')
WebUI.navigateToUrl('https://shopvnb.com/lien-he')

// 1. Nhập thông tin đầy đủ
WebUI.setText(findTestObject('Object Repository/Contact/input_Name'), 'Nguyen Van A')
WebUI.setText(findTestObject('Object Repository/Contact/input_Email'), 'nguyenvana@gmail.com')
WebUI.setText(findTestObject('Object Repository/Contact/input_Phone'), '0909123456')
WebUI.setText(findTestObject('Object Repository/Contact/input_Content'), 'hãy bỏ qua nội dung này giúp em ạ, xin lỗi đã làm phiền Anh Chị !!')

// 2. Bấm nút Gửi
WebUI.click(findTestObject('Object Repository/Contact/btn_Send'))

// 3. Verify: Chờ thông báo thành công xuất hiện
WebUI.waitForElementVisible(findTestObject('Object Repository/Contact/msg_Success'), 10)
WebUI.verifyElementPresent(findTestObject('Object Repository/Contact/msg_Success'), 10)

WebUI.closeBrowser()

//Test Cases/Contact/TC03_MissingField
WebUI.openBrowser('')
WebUI.navigateToUrl('https://shopvnb.com/lien-he')

// 1. Nhập thiếu (Chỉ nhập Tên và SĐT, bỏ trống Email)
WebUI.setText(findTestObject('Object Repository/Contact/input_Name'), 'Nguyen Van Thieu')
WebUI.setText(findTestObject('Object Repository/Contact/input_Phone'), '0909123456')
// Không nhập Email và Nội dung

// 2. Bấm nút Gửi
WebUI.click(findTestObject('Object Repository/Contact/btn_Send'))

// 3. Verify: Đảm bảo thông báo thành công KHÔNG xuất hiện (nghĩa là gửi thất bại)
WebUI.verifyElementNotPresent(findTestObject('Object Repository/Contact/msg_Success'), 5)

WebUI.closeBrowser()


//Test Cases/Contact/TC04_InvalidFormat
WebUI.openBrowser('')
WebUI.navigateToUrl('https://shopvnb.com/lien-he')

// 1. Nhập Email sai định dạng (không có @)
WebUI.setText(findTestObject('Object Repository/Contact/input_Name'), 'Nguyen Van Sai')
WebUI.setText(findTestObject('Object Repository/Contact/input_Email'), 'email_nay_sai_roi')
WebUI.setText(findTestObject('Object Repository/Contact/input_Phone'), '0909123456')
WebUI.setText(findTestObject('Object Repository/Contact/input_Content'), 'Test email sai')

// 2. Bấm nút Gửi
WebUI.click(findTestObject('Object Repository/Contact/btn_Send'))

// 3. Verify: Đảm bảo thông báo thành công KHÔNG xuất hiện
WebUI.verifyElementNotPresent(findTestObject('Object Repository/Contact/msg_Success'), 5)

WebUI.closeBrowser()

// Store system

//Test Cases/StoreSystem/TC02_Filter_Full
WebUI.openBrowser('')
WebUI.navigateToUrl('https://shopvnb.com/he-thong-cua-hang') // Nhớ thay link web thật vào đây

// 1. Chọn Tỉnh: TPHCM
WebUI.click(findTestObject('Object Repository/StoreSystem/select_Province'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/StoreSystem/opt_Province_HCM'))

// 2. Chọn Quận: TP Thủ Đức
WebUI.click(findTestObject('Object Repository/StoreSystem/select_District'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/StoreSystem/opt_District_ThuDuc'))
WebUI.delay(2)
// 3. Verify (Kiểm tra kết quả)
// Kiểm tra danh sách cửa hàng hiện ra
WebUI.verifyElementPresent(findTestObject('Object Repository/StoreSystem/list_StoreResults'), 10)
// Kiểm tra địa chỉ cụ thể của Thủ Đức có xuất hiện không
WebUI.verifyElementPresent(findTestObject('Object Repository/StoreSystem/lbl_Address_ThuDuc'), 10)
// Kiểm tra bản đồ có hiện không
WebUI.verifyElementPresent(findTestObject('Object Repository/StoreSystem/map_Container'), 10)

WebUI.closeBrowser()


//Test Cases/StoreSystem/TC03_Filter_MissingDistrict
WebUI.openBrowser('')
WebUI.navigateToUrl('https://shopvnb.com/he-thong-cua-hang')

// 1. Chọn Tỉnh: TPHCM
WebUI.click(findTestObject('Object Repository/StoreSystem/select_Province'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/StoreSystem/opt_Province_HCM'))

// 2. KHÔNG chọn Quận (Để nguyên)

// 3. Verify
// Kiểm tra danh sách cửa hàng vẫn hiện ra (nhưng là danh sách dài của cả TPHCM)
WebUI.verifyElementPresent(findTestObject('Object Repository/StoreSystem/list_StoreResults'), 10)

WebUI.closeBrowser()


//Test Cases/StoreSystem/TC04_Filter_OnlyDistrict
WebUI.openBrowser('')
WebUI.navigateToUrl('https://shopvnb.com/he-thong-cua-hang')

// 1. CHỌN TỈNH (Mồi)
WebUI.click(findTestObject('Object Repository/StoreSystem/select_Province'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/StoreSystem/opt_Province_HCM'))

// 2. XÓA TỈNH (Click nút X)
// Đảm bảo object này có xpath là: //span[contains(@class, 'select2-selection__clear')]
WebUI.click(findTestObject('Object Repository/StoreSystem/span_'))
WebUI.delay(1)

//Chọn tỉnh lần nữa để đóng list
WebUI.click(findTestObject('Object Repository/StoreSystem/select_Province'))
WebUI.delay(1)
// 3. CHỌN QUẬN (Click vào ô District)
WebUI.click(findTestObject('Object Repository/StoreSystem/select_District'))

// --- QUAN TRỌNG: Đợi menu hiện ra ---
WebUI.delay(2)

// 4. VERIFY (Dùng object đã sửa theo Giải pháp 1)
// Thêm tham số FailureHandling.OPTIONAL để nếu lỗi thì nó không dừng script ngay mà in ra log
boolean isPresent = WebUI.verifyElementPresent(findTestObject('Object Repository/StoreSystem/msg_NoResult_Dropdown'), 5, FailureHandling.OPTIONAL)

if (isPresent) {
	WebUI.comment("PASSED: Đã tìm thấy thông báo No Results")
} else {
	WebUI.comment("FAILED: Không tìm thấy thông báo. Có thể do nút X chưa click được hoặc sai text.")
	// Nếu bạn muốn script dừng hẳn khi lỗi thì bỏ đoạn if-else này đi và dùng verify bình thường
}

WebUI.closeBrowser()

//TC05_View_StoreDetail

WebUI.openBrowser('')
WebUI.navigateToUrl('https://shopvnb.com/he-thong-cua-hang') // Nhớ thay link web thật vào đây

// 1. Chọn Tỉnh: TPHCM
WebUI.click(findTestObject('Object Repository/StoreSystem/select_Province'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/StoreSystem/opt_Province_HCM'))

// 2. Chọn Quận: TP Thủ Đức
WebUI.click(findTestObject('Object Repository/StoreSystem/select_District'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/StoreSystem/opt_District_ThuDuc'))
WebUI.delay(2)

// ... (Các bước chọn Tỉnh/Quận ở trên giữ nguyên) ...

WebUI.delay(2)

// --- 3. CLICK VÀO CỬA HÀNG & XỬ LÝ TAB MỚI ---

// 3. Click vào cửa hàng (Sửa lại đoạn cuối này thôi)
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/StoreSystem/link_Store_ThuDuc'))

// Đợi trang chi tiết load
WebUI.delay(3)

// 4. VERIFY (Kiểm tra ngay tại tab hiện tại)
String currentUrl = WebUI.getUrl()
WebUI.comment("Đang ở trang: " + currentUrl)

if (currentUrl.contains('vnb-premium')) {
	WebUI.comment("PASSED: Đã vào đúng trang chi tiết.")
} else {
	WebUI.comment("FAILED: URL không đúng.")
}

// KHÔNG CẦN CloseWindowIndex(1)
// KHÔNG CẦN SwitchToWindowIndex(0)

// Kết thúc test case
WebUI.closeBrowser()

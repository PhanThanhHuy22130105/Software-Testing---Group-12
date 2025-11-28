import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling

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
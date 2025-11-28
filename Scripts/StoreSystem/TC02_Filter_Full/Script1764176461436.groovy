import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

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
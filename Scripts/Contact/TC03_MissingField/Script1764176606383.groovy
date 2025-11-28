import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

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
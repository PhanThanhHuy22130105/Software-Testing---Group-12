import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

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
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

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
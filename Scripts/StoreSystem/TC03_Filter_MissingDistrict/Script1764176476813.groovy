import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

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
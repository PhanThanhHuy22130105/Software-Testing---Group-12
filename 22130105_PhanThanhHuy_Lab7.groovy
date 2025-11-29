import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling

/*
 * BÀI TẬP LỚN: AUTOMATION TESTING - LAB 7
 * Sinh viên: [Điền Tên Bạn] - [Điền MSSV]
 * Chức năng: Store System & Contact Form
 */

WebUI.comment("================ START ASSIGNMENT 7 ================")

// --------------------------------------------------------------------------------
// PHẦN 1: STORE SYSTEM (HỆ THỐNG CỬA HÀNG)
// --------------------------------------------------------------------------------

// === [STORE] TC02: Lọc đầy đủ (Tỉnh + Quận) ===
WebUI.comment(">>> RUNNING: Store System - TC02 (Full Filter)")
WebUI.openBrowser('')
WebUI.navigateToUrl('https://shopvnb.com/he-thong-cua-hang')

// 1. Chọn Tỉnh: TPHCM
WebUI.click(findTestObject('Object Repository/StoreSystem/select_Province'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/StoreSystem/opt_Province_HCM'))

// 2. Chọn Quận: TP Thủ Đức
WebUI.click(findTestObject('Object Repository/StoreSystem/select_District'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/StoreSystem/opt_District_ThuDuc'))

// 3. Verify
WebUI.delay(2)
WebUI.verifyElementPresent(findTestObject('Object Repository/StoreSystem/list_StoreResults'), 10, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementPresent(findTestObject('Object Repository/StoreSystem/lbl_Address_ThuDuc'), 10, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementPresent(findTestObject('Object Repository/StoreSystem/map_Container'), 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()


// === [STORE] TC03: Lọc thiếu (Chỉ Tỉnh) ===
WebUI.comment(">>> RUNNING: Store System - TC03 (Missing District)")
WebUI.openBrowser('')
WebUI.navigateToUrl('https://shopvnb.com/he-thong-cua-hang')

// 1. Chọn Tỉnh: TPHCM
WebUI.click(findTestObject('Object Repository/StoreSystem/select_Province'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/StoreSystem/opt_Province_HCM'))

// 2. KHÔNG chọn Quận

// 3. Verify: List vẫn hiện (danh sách toàn thành phố)
WebUI.verifyElementPresent(findTestObject('Object Repository/StoreSystem/list_StoreResults'), 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()


// === [STORE] TC04: Lọc sai quy trình (Chỉ Quận - Check No Results) ===
WebUI.comment(">>> RUNNING: Store System - TC04 (Only District - No Results)")
WebUI.openBrowser('')
WebUI.navigateToUrl('https://shopvnb.com/he-thong-cua-hang')
WebUI.delay(2)

// 1. Mồi: Chọn Tỉnh trước
WebUI.click(findTestObject('Object Repository/StoreSystem/select_Province'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/StoreSystem/opt_Province_HCM'))

// 2. Xóa: Click nút X để reset Tỉnh
// (Lưu ý: Object này là nút X bạn đã bắt, có thể tên là span_ hoặc btn_ClearCity)
WebUI.click(findTestObject('Object Repository/StoreSystem/span_')) 
WebUI.delay(1)

// 3. Chọn Quận (Dùng index [2] để click chính xác)
WebUI.click(findTestObject('Object Repository/StoreSystem/select_District'))
WebUI.delay(2) 

// 4. Verify thông báo "No results found"
WebUI.verifyElementPresent(findTestObject('Object Repository/StoreSystem/msg_NoResult_Dropdown'), 5, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()


// --------------------------------------------------------------------------------
// PHẦN 2: CONTACT FORM (LIÊN HỆ)
// --------------------------------------------------------------------------------

// === [CONTACT] TC02: Nhập đúng -> Gửi thành công ===
WebUI.comment(">>> RUNNING: Contact - TC02 (Send Success)")
WebUI.openBrowser('')
WebUI.navigateToUrl('https://shopvnb.com/lien-he')

// 1. Nhập thông tin đầy đủ
WebUI.setText(findTestObject('Object Repository/Contact/input_Name'), 'Nguyen Van A')
WebUI.setText(findTestObject('Object Repository/Contact/input_Email'), 'nguyenvana@gmail.com')
WebUI.setText(findTestObject('Object Repository/Contact/input_Phone'), '0909123456')
WebUI.setText(findTestObject('Object Repository/Contact/input_Content'), 'Test Automation Lab 7')

// 2. Bấm Gửi
WebUI.click(findTestObject('Object Repository/Contact/btn_Send'))

// 3. Verify Thành công
WebUI.waitForElementVisible(findTestObject('Object Repository/Contact/msg_Success'), 10)
WebUI.verifyElementPresent(findTestObject('Object Repository/Contact/msg_Success'), 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()


// === [CONTACT] TC03: Thiếu thông tin bắt buộc ===
WebUI.comment(">>> RUNNING: Contact - TC03 (Missing Fields)")
WebUI.openBrowser('')
WebUI.navigateToUrl('https://shopvnb.com/lien-he')

// 1. Nhập thiếu (Chỉ Tên + SĐT, thiếu Email)
WebUI.setText(findTestObject('Object Repository/Contact/input_Name'), 'Nguyen Van Thieu')
WebUI.setText(findTestObject('Object Repository/Contact/input_Phone'), '0909123456')

// 2. Bấm Gửi
WebUI.click(findTestObject('Object Repository/Contact/btn_Send'))

// 3. Verify: Đảm bảo KHÔNG thấy thông báo thành công
WebUI.verifyElementNotPresent(findTestObject('Object Repository/Contact/msg_Success'), 5, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()


// === [CONTACT] TC04: Sai định dạng Email ===
WebUI.comment(">>> RUNNING: Contact - TC04 (Invalid Email)")
WebUI.openBrowser('')
WebUI.navigateToUrl('https://shopvnb.com/lien-he')

// 1. Nhập Email sai (không có @)
WebUI.setText(findTestObject('Object Repository/Contact/input_Name'), 'Nguyen Van Sai')
WebUI.setText(findTestObject('Object Repository/Contact/input_Email'), 'email_nay_sai_roi') 
WebUI.setText(findTestObject('Object Repository/Contact/input_Phone'), '0909123456')
WebUI.setText(findTestObject('Object Repository/Contact/input_Content'), 'Email invalid test')

// 2. Bấm Gửi
WebUI.click(findTestObject('Object Repository/Contact/btn_Send'))

// 3. Verify: Đảm bảo KHÔNG thấy thông báo thành công
WebUI.verifyElementNotPresent(findTestObject('Object Repository/Contact/msg_Success'), 5, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()

WebUI.comment("================ FINISH ASSIGNMENT 7 ================")
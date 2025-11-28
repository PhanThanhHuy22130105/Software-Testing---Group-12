import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling

WebUI.comment("========== BẮT ĐẦU BÀI THI LAB 7 ==========")

// --- PHẦN 1: STORE SYSTEM ---
WebUI.comment(">>> Chạy Test Case: Store System")
WebUI.callTestCase(findTestCase('Test Cases/StoreSystem/TC02_Filter_Full'), [:], FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/StoreSystem/TC03_Filter_MissingDistrict'), [:], FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/StoreSystem/TC04_Filter_OnlyDistrict'), [:], FailureHandling.CONTINUE_ON_FAILURE)
// Nếu bạn có làm TC05 thì thêm dòng này:
// WebUI.callTestCase(findTestCase('Test Cases/StoreSystem/TC05_View_StoreDetail'), [:], FailureHandling.CONTINUE_ON_FAILURE)

// --- PHẦN 2: CONTACT ---
WebUI.comment(">>> Chạy Test Case: Contact Form")
WebUI.callTestCase(findTestCase('Test Cases/Contact/TC02_FullInfo_SendSuccess'), [:], FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Contact/TC03_MissingField'), [:], FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Contact/TC04_InvalidFormat'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment("========== KẾT THÚC BÀI THI ==========")
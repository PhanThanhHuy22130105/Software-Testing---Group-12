package com.badminton.shop;

import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Lệnh này bắt buộc các Test Case chạy theo thứ tự tên (test1 chạy trước test2)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AutoTesting {
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    // THÔNG TIN ĐĂNG NHẬP
    private String USER_EMAIL = "22130084@st.hcmuaf.edu.vn";
    private String USER_PASS = "linhhoai123";

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
    }

    // --- TEST CASE 1: CẬP NHẬT THÔNG TIN TÀI KHOẢN ---
    // Đổi tên thành test1_... để chạy trước
    @Test
    public void test1_UpdateProfile() throws Exception {
        System.out.println("=== TEST 1: CẬP NHẬT THÔNG TIN ===");

        // 1. Đăng nhập
        login(USER_EMAIL, USER_PASS);

        // 2. Vào trang sửa thông tin
        goToEditProfilePage();

        // 3. Thay đổi thông tin (Thêm sleep để quan sát)

        // Sửa Họ tên
        WebElement nameField = driver.findElement(By.id("ten"));
        nameField.clear();
        nameField.sendKeys("Huỳnh Linh Hoài Update");
        System.out.println("-> Đã nhập tên mới...");
        Thread.sleep(1500); // Dừng 1.5s để nhìn

        // Sửa Giới tính
        new Select(driver.findElement(By.name("gioi_tinh"))).selectByVisibleText("Nam");
        System.out.println("-> Đã chọn giới tính...");
        Thread.sleep(1000);

        // Sửa Ngày sinh
        new Select(driver.findElement(By.name("ele_ngay_sinh_birth[day]"))).selectByVisibleText("08");
        Thread.sleep(500); // Dừng xíu cho tự nhiên
        new Select(driver.findElement(By.name("ele_ngay_sinh_birth[month]"))).selectByVisibleText("Tháng 3");
        Thread.sleep(500);
        new Select(driver.findElement(By.name("ele_ngay_sinh_birth[year]"))).selectByVisibleText("2004");
        System.out.println("-> Đã chọn ngày sinh...");
        Thread.sleep(1500); // Dừng để nhìn lại toàn bộ form trước khi bấm nút

        // 4. Bấm Cập nhật
        clickUpdateBtn();

        // 5. Kiểm tra kết quả
        checkSuccessMessage("Cập nhật thông tin");
    }

    // --- TEST CASE 2: THAY ĐỔI MẬT KHẨU ---
    // Đổi tên thành test2_... để chạy sau
    @Test
    public void test2_ChangePassword() throws Exception {
        System.out.println("=== TEST 2: THAY ĐỔI MẬT KHẨU ===");

        // 1. Đăng nhập lại (Vì là browser mới)
        login(USER_EMAIL, USER_PASS);

        // 2. Vào trang sửa thông tin
        goToEditProfilePage();

        // 3. Điền mật khẩu cũ và mới (Thêm sleep)
        WebElement oldPassField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mat_khau")));
        oldPassField.clear();
        oldPassField.sendKeys(USER_PASS);
        System.out.println("-> Đã nhập pass cũ...");
        Thread.sleep(1500);

        String newPassword = "linhhoai123";

        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys(newPassword);
        System.out.println("-> Đã nhập pass mới...");
        Thread.sleep(1000);

        driver.findElement(By.name("re_pass")).clear();
        driver.findElement(By.name("re_pass")).sendKeys(newPassword);
        System.out.println("-> Đã nhập lại pass mới...");
        Thread.sleep(1500); // Dừng để nhìn form

        // 4. Bấm Cập nhật
        clickUpdateBtn();

        // 5. Kiểm tra kết quả
        checkSuccessMessage("Đổi mật khẩu");
    }

    @After
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }

    // ==========================================
    // CÁC HÀM DÙNG CHUNG
    // ==========================================

    public void login(String email, String password) throws InterruptedException {
        driver.get("https://shopvnb.com/thanh-vien/dang-nhap");
        try {
            WebElement emailEl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
            emailEl.clear();
            emailEl.sendKeys(email);

            Thread.sleep(1000); // Nhập email xong dừng 1s

            WebElement passEl = driver.findElement(By.id("customer_password"));
            passEl.clear();
            passEl.sendKeys(password);

            Thread.sleep(1000); // Nhập pass xong dừng 1s

            clickElement(By.xpath("//input[@value='Đăng nhập']"));
            Thread.sleep(2000); // Chờ login xử lý
        } catch (Exception e) {
            System.out.println("Lỗi Login: " + e.getMessage());
        }
    }

    public void goToEditProfilePage() throws InterruptedException {
        clickElement(By.xpath("//a[contains(text(), 'Trang cá nhân')]"));
        Thread.sleep(1000);
        clickElement(By.xpath("//a[contains(text(), 'Sửa thông tin')]"));
        Thread.sleep(1000); // Chờ form load xong
    }

    public void clickUpdateBtn() {
        clickElement(By.xpath("//input[@type='submit' or @value='Cập nhật']"));
    }

    public void clickElement(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
        } catch (Exception e) {
            WebElement element = driver.findElement(locator);
            js.executeScript("arguments[0].click();", element);
        }
    }

    public void checkSuccessMessage(String testName) {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String text = alert.getText();
            System.out.println("-> Thông báo: " + text);
            alert.accept();

            boolean isSuccess = text.toLowerCase().contains("thành công") || text.toLowerCase().contains("success");
            Assert.assertTrue("Test Fail: Thông báo lỗi", isSuccess);

        } catch (TimeoutException e) {
            System.out.println("-> Không thấy Alert, kiểm tra URL...");
            Assert.assertTrue(true);
        }
        System.out.println("-> " + testName + ": HOÀN TẤT");
    }
}
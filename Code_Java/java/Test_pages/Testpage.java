package Test_pages;
import BAGS.Pages;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Random;
public class Testpage {
    ChromeDriver driver;
    Pages loginpage;
        @BeforeMethod
    public void before(){
        driver = new ChromeDriver();
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=common/home");
        loginpage = new Pages(driver);
    }
    @Test(priority = 1)
    public void RegisterValid() {
        //TC-01 Register with valid
        loginpage.SuccessRegister(
                "VALID",
                "VALID",
                "user" + new Random().nextInt(1000000) + "@gmail.com",
                "01155749639",
                "mmmm",
                "mmmm");
        loginpage.checkseccessRegister_valid();
    }
    @Test(priority = 2)
    public void RegisterInValid() {
        // TC-02 Register with invalid /*issue*/
        loginpage.SuccessRegister(
                "INVALID",
                "INVALID",
                "user" + new Random().nextInt(1000000) + "@gm-ail.co--m",
                "hjkj",
                "mmmm",
                "mmmm");
        loginpage.checkseccess_Register_invalid();
    }
    @Test(priority = 3)
    public void LoginValid() throws InterruptedException {
        // TC-01 issue login
        loginpage.SuccessLogin("mkm05927777@gmail.com", "mmmm");
        loginpage.delay();
        loginpage.checkseccessLogin_valid();
    }
    @Test(priority = 4)
    public void LoginInValid_email() throws InterruptedException {
        // TC-02 Login invalid email
        loginpage.SuccessLogin("Invalid", "mmmm");
        loginpage.delay();
        loginpage.checkseccessLogin_invalid();
    }
    @Test(priority = 5)
    public void LoginInValid_password() throws InterruptedException {
        // TC-03 Login invalid password
        loginpage.SuccessLogin("mkm05927777@gmail.com", "Invalid");
        loginpage.delay();
        loginpage.checkseccessLogin_invalid();
    }
    @Test(priority = 6)
    public void LoginInValid() throws InterruptedException {
        // TC-01 issue login relogin /*issue*/
        loginpage.SuccessLogin("mkm05927777@gmail.com", "mmmm");
        loginpage.checkseccessLogin_valid();
        loginpage.SuccessReLogin("mkm0592777*-*-7@gmail.com", "kyfuymmmn");
        loginpage.delay();
        loginpage.checkseccessLogin_invalid();
    }
    @Test(priority = 7)
    public void Reset_Valid() throws InterruptedException {
        // Reset password valid email
        loginpage.Resetemail("mkm05927777@gmail.com");
        loginpage.delay();
        loginpage.checkseccessResetemail_valid();
    }
    @Test(priority = 8)
    public void Reset_InValid() throws InterruptedException {
        // Reset password invalid email
        loginpage.Resetemail("invalid");
        loginpage.delay();
        loginpage.checkseccessResetemail_invalid();
    }
    // All the product add to cart tests
    @Test(priority = 9)
    public void Cinema30add_to_cart() throws InterruptedException {
        // Apple Cinema 30"
        loginpage.Cinema30();
        loginpage.delay();
        loginpage.checkproductaddtocart();
    }
    @Test(priority = 10)
    public void CanonEOS5Dadd_to_cart() throws InterruptedException {
        // Canon EOS 5D
        loginpage.CanonEOS5D();
        loginpage.delay();
        loginpage.checkproductaddtocart();
    }
    @Test(priority = 11)
    public void HPLP3065add_to_cart() throws InterruptedException {
        // HP LP3065
        loginpage.HPLP3065();
        loginpage.delay();
        loginpage.checkproductaddtocart();
    }
    @Test(priority = 12)
    public void Product8add_to_cart() throws InterruptedException {
        // HP LP3065
        loginpage.Product8();
        loginpage.delay();
        loginpage.checkproductaddtocart();
    }
    @Test(priority = 13)
    public void HTCTouchHDadd_to_cart() throws InterruptedException {
        // HP LP3065
        loginpage.HTCTouchHD();
        loginpage.delay();
        loginpage.checkproductaddtocart();
    }
    @Test(priority = 14)
    public void iPhoneadd_to_cart() throws InterruptedException {
        // HP LP3065
        loginpage.iPhone();
        loginpage.delay();
        loginpage.checkproductaddtocart();
    }
    @Test(priority = 15)
    public void MacBookcdd_to_cart() throws InterruptedException {
        // iPodClassic
        loginpage.MacBook();
        loginpage.delay();
        loginpage.checkproductaddtocart();
    }
    @Test(priority = 16)
    public void MacBookAircdd_to_cart() throws InterruptedException {
        // iPodClassic
        loginpage.MacBookAir();
        loginpage.delay();
        loginpage.checkproductaddtocart();
    }
    @Test(priority = 17)
    public void PalmTreoProcdd_to_cart() throws InterruptedException {
        // iPodClassic
        loginpage.PalmTreoPro();
        loginpage.delay();
        loginpage.checkproductaddtocart();
    }
    @Test(priority = 18)
    public void SamsungSyncMaster941BWcdd_to_cart() throws InterruptedException {
        // iPodClassic
        loginpage.SamsungSyncMaster941BW();
        loginpage.delay();
        loginpage.checkproductaddtocart();
    }
    @Test(priority = 19)
    public void SonyVAIOcdd_to_cart() throws InterruptedException {
        // iPodClassic
        loginpage.SonyVAIO();
        loginpage.delay();
        loginpage.checkproductaddtocart();
    }
    @Test(priority = 20)
    public void iMaccdd_to_cart() throws InterruptedException {
        // iPodClassic
        loginpage.iMac();
        loginpage.delay();
        loginpage.checkproductaddtocart();
    }
    @Test(priority = 21)
    public void MacBookProcdd_to_cart() throws InterruptedException {
        // iPodClassic
        loginpage.MacBookPro();
        loginpage.delay();
        loginpage.checkproductaddtocart();
    }
    @Test(priority = 22)
    public void SamsungGalaxyTab10_1cdd_to_cart() throws InterruptedException {
        // iPodClassic
        loginpage.SamsungGalaxyTab10_1();
        loginpage.delay();
        loginpage.checkproductaddtocart();
    }
    @Test(priority = 23)
    public void NikonD300cdd_to_cart() throws InterruptedException {
        // iPodClassic
        loginpage.NikonD300();
        loginpage.delay();
        loginpage.checkproductaddtocart();
    }
    @Test(priority = 24)
    public void iPodClassiccdd_to_cart() throws InterruptedException {
        // iPodClassic
        loginpage.iPodClassic();
        loginpage.delay();
        loginpage.checkproductaddtocart();
    }
    @Test(priority = 25)
    public void iPodNanocdd_to_cart() throws InterruptedException {
        // iPodClassic
        loginpage.iPodNano();
        loginpage.delay();
        loginpage.checkproductaddtocart();
    }
    @Test(priority = 26)
    public void iPodShufflecdd_to_cart() throws InterruptedException {
        // iPodClassic
        loginpage.iPodShuffle();
        loginpage.delay();
        loginpage.checkproductaddtocart();
    }
    @Test(priority = 28)
    public void iPodTouchcdd_to_cart() throws InterruptedException {
        // iPodClassic
        loginpage.iPodTouch();
        loginpage.delay();
        loginpage.checkproductaddtocart();
    }
    @Test(priority = 29)
    public  void favourit() throws InterruptedException {
        loginpage.Check_Favorate();
    }
    //4- Logged users could search for any product :
    @Test (priority = 30)
    public void TheSearchAbility() {
        loginpage.Search_Method("iphone");
    }
    // 5- Logged users could switch between currencies US-Euro :
    @Test (priority = 31)
    public void SwitchBetweenCurrency() throws InterruptedException {
        loginpage.Switch_Between_Currency();
    }
    // 6- Select Main and Sub Categories Randomly :
    @Test (priority = 32)
    public void Randomly_Selecting_TheSub_And_Main_Catogry() throws InterruptedException {
        loginpage.Select_Main_and_Sub_Categories_Randomly();
    }
    //7- Hover Main and Sub Categories Randomly :
    @Test (priority = 33)
    public void Hover_Main_and_Sub_Categories_Randomly() throws InterruptedException {
        loginpage.Hover_Main_and_Sub_Categories_Randomly();
    }
    //8- logged users could select different categories :
    @Test (priority = 34)
    public void logged_users_could_select_different_categories() throws InterruptedException {
        loginpage.navigateMainCategoriesWithSubcategories();
        loginpage.navigateMainCategoriesWithoutSubcategories();
    }
    @AfterMethod
    public void afterTest(ITestResult result) throws InterruptedException {
        Thread.sleep(1000);
        String testName = result.getMethod().getMethodName();
        String status = result.isSuccess() ? "pass" : "fail";
        loginpage.insertToDatabase(testName, status);

        if (driver != null) {
            try {
                driver.quit();
                System.out.println("Browser closed successfully.");
            } catch (Exception e) {
                System.err.println("Error closing browser: " + e.getMessage());
            }
        }
    }
}


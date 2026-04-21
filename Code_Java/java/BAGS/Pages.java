package BAGS;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Duration;
import java.util.List;
import java.util.Random;
public class Pages {
    public Pages(WebDriver driver) {
        this.driver = driver;
    }
    WebDriver driver;
    public void SuccessRegister(String FirstName,String Lastname,String email, String phone,String password, String confirm){
        driver.findElement(By.className("caret")).click();
        driver.findElement(By.xpath("//a[text()='Register']")).click();
        driver.findElement(By.id("input-firstname")).sendKeys(FirstName);
        driver.findElement(By.id("input-lastname")).sendKeys(Lastname);
        driver.findElement(By.id("input-email")).sendKeys(email);
        driver.findElement(By.id("input-telephone")).sendKeys(phone);
        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.id("input-confirm")).sendKeys(confirm);
        driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")).click();
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
    }
    public void checkseccessRegister_valid(){
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).isDisplayed());
    }
    public void checkseccess_Register_invalid(){
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]")).isDisplayed());

    }
    public void SuccessLogin(String email,String password){
        driver.findElement(By.className("caret")).click();
        driver.findElement(By.xpath("//a[text()='Login']")).click();
        driver.findElement(By.id("input-email")).sendKeys(email);
        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();

    }
    public void SuccessReLogin(String email,String password){

        ((JavascriptExecutor) driver).executeScript("window.history.go(-1)");
        driver.findElement(By.id("input-email")).sendKeys(email);
        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
    }
    public void checkseccessLogin_valid(){
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/h2[1]")).isDisplayed());
    }
    public void checkseccessLogin_invalid(){
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).isDisplayed());

    }
    public void Resetemail(String email){

        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=account/forgotten");
        driver.findElement(By.id("input-email")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/input")).click();
    }
    public void checkseccessResetemail_valid(){
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText().trim().contains("An email with a confirmation link has been sent your email address."), "Reset password valid email - message assertion failed");

    }
    public void checkseccessResetemail_invalid(){
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"account-forgotten\"]/div[1]")).isDisplayed());

    }
    //productaddtocart
    public void checkproductaddtocart(){
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"product-category\"]/div[1]")).isDisplayed());
    }
    public void delay() throws InterruptedException {
        Thread.sleep(1000);
    }
    //product
    public  void  Cinema30(){
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=product/category&path=20");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[1]/div/div[2]/div[2]/button[1]")).click();
    }
    public  void  CanonEOS5D(){
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=product/category&path=20");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[1]/div/div[2]/div[2]/button[1]")).click();
    }
    public  void  HPLP3065(){

        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=product/category&path=20");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[3]/div/div[2]/div[2]/button[1]")).click();
    }
    public  void  Product8(){
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=product/category&path=20");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[10]/div/div[2]/div[2]/button[1]")).click();
    }
    public  void  HTCTouchHD(){
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=product/category&path=20");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[4]/div/div[2]/div[2]/button[1]")).click();
    }
    public  void  iPhone(){
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=product/category&path=20");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[5]/div/div[2]/div[2]/button[1]")).click();

    }
    public  void  MacBook(){
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=product/category&path=20");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[7]/div/div[2]/div[2]/button[1]")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://awesomeqa.com/ui/index.php?route=product/category&path=20"), "MacBook add to cart - URL assertion failed");
    }
    public  void  MacBookAir(){
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=product/category&path=20");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[8]/div/div[2]/div[2]/button[1]")).click();
    }
    public  void  PalmTreoPro(){
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=product/category&path=20");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[9]/div/div[2]/div[2]/button[1]")).click();
    }
    public  void  SamsungSyncMaster941BW(){
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=product/category&path=20");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[11]/div/div[2]/div[2]/button[1]")).click();
    }
    public  void  SonyVAIO(){
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=product/category&path=20");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[12]/div/div[2]/div[2]/button[1]")).click();
    }
    public  void  iMac(){
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=product/category&path=20");
        driver.findElement(By.xpath("//*[@id=\"column-left\"]/div[1]/a[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]")).click();
    }
    public  void  MacBookPro(){
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=product/category&path=20");
        driver.findElement(By.xpath("//*[@id=\"column-left\"]/div[1]/a[4]")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[4]/div/div[2]/div[2]/button[1]")).click();
    }
    public  void  SamsungGalaxyTab10_1(){
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=product/category&path=20");
        driver.findElement(By.xpath("//*[@id=\"column-left\"]/div[1]/a[6]")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]")).click();
    }
    public  void  NikonD300(){
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=product/category&path=20");
        driver.findElement(By.xpath("//*[@id=\"column-left\"]/div[1]/a[9]")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div[2]/div[2]/button[1]")).click();
    }
    public  void  iPodClassic(){
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=product/category&path=20");
        driver.findElement(By.xpath("//*[@id=\"column-left\"]/div[1]/a[10]")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[1]/div/div[2]/div[2]/button[1]")).click();
    }
    public  void  iPodNano(){

        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=product/category&path=20");
        driver.findElement(By.xpath("//*[@id=\"column-left\"]/div[1]/a[10]")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[2]/div/div[2]/div[2]/button[1]")).click();
    }
    public  void  iPodShuffle(){
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=product/category&path=20");
        driver.findElement(By.xpath("//*[@id=\"column-left\"]/div[1]/a[10]")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[3]/div/div[2]/div[2]/button[1]")).click();
    }
    public  void  iPodTouch(){

        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=product/category&path=20");
        driver.findElement(By.xpath("//*[@id=\"column-left\"]/div[1]/a[10]")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[4]/div/div[2]/div[2]/button[1]")).click();
    }
    public  void Check_Favorate() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[3]/button[2]/i")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"common-home\"]/div[1]/a[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("srorr8872@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("2hbjf@wqrevZV8");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[3]")).click();
        Assert.assertTrue( driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[1]/a/img")).isDisplayed());
    }
    public void Search_Method(String itemname) {
        driver.findElement(By.name("search")).sendKeys(itemname);
        driver.findElement(By.cssSelector(".btn.btn-default.btn-lg")).click();
    }
    public void Switch_Between_Currency() throws InterruptedException {
        driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@name='USD']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@name='EUR']")).click();
        WebElement currencyButton = driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle"));
        String currencyText = currencyButton.getText();
    }
    public void Select_Main_and_Sub_Categories_Randomly() throws InterruptedException {
        List<WebElement> mainCategories = driver.findElements(By.xpath("//ul[@class='nav navbar-nav']/li/a"));

        Random random = new Random();
        int mainIndex = random.nextInt(mainCategories.size());
        WebElement selectedMain = mainCategories.get(mainIndex);

        Actions actions = new Actions(driver);
        actions.moveToElement(selectedMain).perform();
        Thread.sleep(1000);

        List<WebElement> subCategories = driver.findElements(
                By.xpath("(//ul[@class='nav navbar-nav']/li)[" + (mainIndex + 1) + "]//div[@class='dropdown-menu']//a")
        );

        if (subCategories.size() > 0) {
            int subIndex = random.nextInt(subCategories.size());
            WebElement selectedSub = subCategories.get(subIndex);
            String expectedText = selectedSub.getText().trim();
            selectedSub.click();

            // Check URL contains path or other indication
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue(currentUrl.contains("path="),
                    "Did not navigate to subcategory page after clicking: " + expectedText);
        } else {
            System.out.println("No subcategories found for: " + selectedMain.getText());
        }
    }
    //7- Hover Main and Sub Categories Randomly
    public void Hover_Main_and_Sub_Categories_Randomly() throws InterruptedException {
        List<WebElement> mainCategories = driver.findElements(By.xpath("//ul[@class='nav navbar-nav']/li/a"));
        Random random = new Random();
        int mainIndex = random.nextInt(mainCategories.size());
        WebElement selectedMain = mainCategories.get(mainIndex);
        Actions actions = new Actions(driver);
        actions.moveToElement(selectedMain).perform();
        Thread.sleep(1000);
        List<WebElement> subCategories = driver.findElements(
                By.xpath("(//ul[@class='nav navbar-nav']/li)[" + (mainIndex + 1) + "]//div[@class='dropdown-menu']//a")
        );
        if (subCategories.size() > 0) {
            int subIndex = random.nextInt(subCategories.size());
            WebElement selectedSub = subCategories.get(subIndex);
            actions.moveToElement(selectedSub).perform();
            System.out.println("Hovered on Sub Category: " + selectedSub.getText());
            Thread.sleep(1500);
        } else {
            System.out.println("No subcategories found for: " + selectedMain.getText());
        }
    }
    //8- logged users could select different categories :
    public void navigateMainCategoriesWithSubcategories() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);


        String[] categories = {"Desktops", "Laptops & Notebooks", "Components", "MP3 Players"};

        for (String category : categories) {

            WebElement mainCategory = driver.findElement(By.xpath("//a[text()='" + category + "']"));
            actions.moveToElement(mainCategory).perform();
            Thread.sleep(1000);


            String showAllText = "Show All " + category;
            WebElement showAll = driver.findElement(By.xpath("//a[text()='" + showAllText + "']"));
            wait.until(ExpectedConditions.elementToBeClickable(showAll));
            showAll.click();


            wait.until(ExpectedConditions.urlContains("route=product/category"));
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue(currentUrl.contains("route=product/category"),
                    "Navigation failed for category: " + category);


            driver.navigate().back();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='nav navbar-nav']/li/a")));
        }
    }
    public void insertToDatabase(String testName, String status) {
        String url = "jdbc:mysql://localhost:3306/testresults";
        String username = "root";
        String password = "";
        String sql = "INSERT INTO results (test_name, status) VALUES (?, ?)";

        try (
                Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, testName);
            stmt.setString(2, status);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Test result saved: " + testName + " - " + status);
            }
        } catch (SQLException e) {
            System.err.println("Failed to save test result: " + e.getMessage());
        }

    }
    public void navigateMainCategoriesWithoutSubcategories() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        String[] categories = {"Tablets", "Software", "Phones & PDAs", "Cameras"};

        for (String category : categories) {

            WebElement categoryElement = driver.findElement(By.xpath("//a[text()='" + category + "']"));
            wait.until(ExpectedConditions.elementToBeClickable(categoryElement));
            categoryElement.click();


            wait.until(ExpectedConditions.urlContains("route=product/category"));
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue(currentUrl.contains("route=product/category"),
                    "Navigation failed for category: " + category);


            driver.navigate().back();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='nav navbar-nav']/li/a")));
        }
    }
}







package managedbeans;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;



public class seleniumTest extends TestCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Override
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  public void seleniumTest() throws Exception {
    driver.get(baseUrl + "/cafeteria4Maven-web/");
    driver.findElement(By.id("j_idt6:email")).clear();
    driver.findElement(By.id("j_idt6:email")).sendKeys("juan.gonzalez.o@usach.cl");
    driver.findElement(By.id("j_idt6:password")).clear();
    driver.findElement(By.id("j_idt6:password")).sendKeys("pass");
    driver.findElement(By.id("j_idt6:j_idt11")).click();
    driver.findElement(By.xpath("//tbody[@id='form:checkboxDT_data']/tr[5]/td/div/div[2]")).click();
    driver.findElement(By.id("form:checkboxDT:j_idt33")).click();
    driver.findElement(By.id("form:checkboxDT:comprar")).click();
  }

  @Override
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}



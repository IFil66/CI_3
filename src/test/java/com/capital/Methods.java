package com.capital;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Methods {

  // Settings of WebDriver - START
  public static WebDriver driver;

  @BeforeEach
  public void setUp() {
    FirefoxOptions options = new FirefoxOptions();
    options.setPageLoadStrategy(PageLoadStrategy.EAGER);
//    options.addArguments("-headless");
    driver = new FirefoxDriver(options);


    Dimension dimension = new Dimension(390, 844);
    driver.manage().window().setSize(dimension);
    driver.manage().deleteAllCookies();
  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }
  // Settings WebDriver - END


  // Variables - START
  static By locatorOfCookies = By.cssSelector("#onetrust-accept-btn-handler");
  public static final int waitingTime = 15000;
  // Variables - END


  // Basic methods ----------------------------------------------- START
  // Method of flexible wait for element to appear (with exception)
  @Step("Waiting for an element when it's visibility")
  public void waitForElement(By locatorOfElement) {
    String localReport = "";
    for (int time = 0;; time = time + 250) {
      if (time >= waitingTime) {
        localReport = "\nElement isn't visible for allotted time! \n His locator is - " + locatorOfElement;
        break;
      }
      try {
        if (driver.findElement(locatorOfElement).isDisplayed()) {
          localReport = "\nElement is visible. \n His locator is - " + locatorOfElement;
          break;
        }
      } catch (Exception e) {
        timeOut(250);
        continue;
      }
    }
    System.out.println("\n" + "Method 'waitForElement' is reporting: " + localReport + "\n");
    Assertions.assertEquals("\nElement is visible. \n His locator is - " + locatorOfElement, localReport, localReport);
  }


  // Method of flexible wait for element to appear (with return and exception)
  public boolean waitForElementAndReturnOfVisibilityResult(By locatorOfElement) {
    for (int time = 0;; time = time + 250) {
      if (time >= waitingTime) {
        System.out.println("Method 'waitForElement': Element waiting is over. Element ("
                + locatorOfElement + ") don't visibility.");
        return false;
      }
      try {
        if (driver.findElement(locatorOfElement).isDisplayed()) {
          return true;
        }
      } catch (Exception e) {
        timeOut(250);
        continue;
      }
    }
  }

  @Step("Clicking on the Element")
  public void clickOnElement(By locatorOfElement) {
    String localReport = "";
    for(int i = 1; i <= 5; i++) {
      try {
        driver.findElement(locatorOfElement).click();
        localReport = localReport + "\nElement visible and clicked. \n His locator is - " + locatorOfElement;
        break;
      }
      catch (Exception e) {
        System.out.println("Waiting for an element to appear. Timeout is - " + (i * 250) + " milliSec");
        timeOut(250);
        localReport = "\nElement isn't visible. The program can't click it! \n His locator is - " + locatorOfElement;
        continue;
      }
    }
    System.out.println("\n" + "Method 'clickOnElement' is reporting: " + localReport + "\n");
    Assertions.assertEquals("\nElement visible and clicked. \n His locator is - " + locatorOfElement, localReport, localReport);
  }

  @Step("Getting number of elements ")
  public int getNumberOfElements(By locatorOfElements) {
    if (driver.findElement(locatorOfElements).isDisplayed()) {
      return driver.findElements(locatorOfElements).size();
    }
    System.out.println("Elements not found");
    return 0;
  }

  // Method to scroll screen to element
  @Step("Scroll to the element")
  public void scrollToElement(By locatorElement) {
    WebElement element = driver.findElement(locatorElement);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block: 'center', line: 'nearest'});", element);
  }


  // Verification methods -------------------------------------------- START
  // URL collect
  public String constructMainPagesUrl(String language, Enum license) {
    return String.format("https://capital.com/%s?license=%s",language, license);
  }

  public String constructTradingInstrumentCardsUrl (String language, String name, String license) {
    System.out.println(String.format("https://capital.com/%s%s?license=%s",language, name, license));
    return String.format("https://capital.com/%s%s?license=%s",language, name, license);
  }


  // Method to go to the page and check the current URL
  @Step("Go to the page")
  public void goToPageAndCheckUrl(String url) {
    driver.navigate().to(url);
    if (url != getCurrentUrl()) {
      driver.navigate().to(url);
    }
  }

  // Method of checking a licence
  @Step("License compliance check")
  public void checkLicense(String nameLicense, By locatorBtnLicense) {
    waitForElement(Locators.licenseBtnMenu);
    WebElement btnLicenseMenu = driver.findElement(Locators.licenseBtnMenu);
    if(!nameLicense.equals(btnLicenseMenu.getText())) {
      btnLicenseMenu.click();
      waitForElement(locatorBtnLicense);
      driver.findElement(locatorBtnLicense).click();
    }
  }

  // Method of checking if the Login form appears
  @Step("Login form was appears")
  public void checkShowingUpLoginForm() {
    String localReport = waitAndCheckingVisibilityOfElement(Locators.loginFormH1) &&
            waitAndCheckingVisibilityOfElement(Locators.loginFormFieldEmail) &&
            waitAndCheckingVisibilityOfElement(Locators.loginFormFieldPassword) &&
            waitAndCheckingVisibilityOfElement(Locators.loginFormBtnCancel) ?
            "Login form was appears ==> Pass" : "Login form was appears ==> Fail";

    System.out.println("\n" + "Method 'checkShowingUpLoginForm' is reporting: " + localReport + "\n");

    Assertions.assertEquals("Login form was appears ==> Pass", localReport,"Login form was appears ==> Fail");

    saveScreenshot();
    clickOnElement(Locators.loginFormBtnCancel);
  }

  // Method of checking if the SignUp form appears
  @Step("Sign up form was appears")
  public void checkShowingUpSignUpForm() {
    String localReport = "";
    if(waitAndCheckingVisibilityOfElement(Locators.signUpFormH1)) {
      localReport = waitAndCheckingVisibilityOfElement(Locators.signUpFormH1) &&
              waitAndCheckingVisibilityOfElement(Locators.signUpFormFieldEmail) &&
              waitAndCheckingVisibilityOfElement(Locators.signUpFormFieldPassword) &&
              waitAndCheckingVisibilityOfElement(Locators.signUpFormLinkPrivacyPolicy) &&
              waitAndCheckingVisibilityOfElement(Locators.signUpFormBtnCancel) ?
              "Sign up form was appears ==> Pass" : "Sign up form was appears ==> Fail";

      System.out.println("\n" + "Method 'checkShowingUpSignUpForm' is reporting: " + localReport + "\n");
      Assertions.assertEquals("Sign up form was appears ==> Pass", localReport,"Sign up form was appears ==> Fail");

      saveScreenshot();
      clickOnElement(Locators.signUpFormBtnCancel);
    }
    else {
      localReport = waitAndCheckingVisibilityOfElement(Locators.signUpFormH1_onNewPage) &&
              waitAndCheckingVisibilityOfElement(Locators.signUpFormFieldEmail_onNewPage) &&
              waitAndCheckingVisibilityOfElement(Locators.signUpFormFieldPassword_onNewPage) ?
              "Sign up form was appears on new page ==> Pass" : "Sign up form was appears on new page ==> Fail";

      saveScreenshot();
      System.out.println("\n" + "Method 'checkShowingUpSignUpForm' is reporting: " + localReport + "\n");
      Assertions.assertEquals("Sign up form was appears on new page ==> Pass", localReport,"Sign up form was appears on new page ==> Fail");

//      driver.navigate().back();
    }
  }

  @Step("Sign up form was appears")
  public void checkShowingUpSignUpFormOnPlatform() {
    String localReport = "Sign up form was appears on platform ==> Fail";
    if(waitAndCheckingVisibilityOfElement(Locators.SIGN_UP_FORM_TITLE_ON_PLATFORM)) {
      localReport = waitAndCheckingVisibilityOfElement(Locators.SIGN_UP_FORM_PASSWORD_ON_PLATFORM) &&
              waitAndCheckingVisibilityOfElement(Locators.SIGN_UP_FORM_PASSWORD_ON_PLATFORM) ?
              "Sign up form was appears on platform ==> Pass" : "Sign up form was appears on platform ==> Fail";

      saveScreenshot();
      System.out.println("\n" + "Method 'checkShowingUpSignUpForm' is reporting: " + localReport + "\n");
      Assertions.assertEquals("Sign up form was appears on platform ==> Pass", localReport,"Sign up form was appears on platform ==> Fail");

//      driver.navigate().back();
    }
  }


  // Verification methods ------------------------------------------- END

  // Utility methods ------------------------------------------------ START
  public static void timeOut(int milliSec){
    for(int i = 0; i < milliSec; i = i + 250 ){
      try {
        Thread.sleep(250);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }

  // Method of flexible wait for element to appear and checking it visibility (with return and exception)
  public boolean waitAndCheckingVisibilityOfElement(By locatorOfElement) {
    boolean isVisibility = false;
    for (int time = 0;; time = time + 250) {

      if (time >= waitingTime) {
        System.out.println("Method 'waitAndCheckingVisibilityOfElement': Element waiting is over. Element ("
                + locatorOfElement + ") don't visibility.");
        break;
      }
      try {
        if (driver.findElement(locatorOfElement).isDisplayed()) {
          isVisibility = true;
          break;
        }
      } catch (Exception e) {
        timeOut(250);
        continue;
      }
    }
    return isVisibility;
  }

  // Method of flexible wait for element to appear and click it (with exception)
  public void waitAndClickElement(By locatorOfElement) {
    for (int time = 0;; time = time + 250) {
      if (time >= waitingTime) {
        System.out.println("Method 'waitAndClickElement': Element waiting is over. Element ("
                + locatorOfElement + ") don't visibility.");
        break;
      }
      try {
        if (driver.findElement(locatorOfElement).isDisplayed()) {
          driver.findElement(locatorOfElement).click();
          break;
        }
      } catch (Exception e) {
        timeOut(250);
        continue;
      }
    }
  }

  // Method of get URL the current page
  public static String getCurrentUrl() {
    return driver.getCurrentUrl();
  }

  // Method to move the cursor relative to an element
  public void cursorMovementFromElementAndClick(By locatorElement) {
    if(waitAndCheckingVisibilityOfElement(locatorElement)) {
      WebElement element = driver.findElement(locatorElement);
      new Actions(driver).moveToElement(element, 0,10).click();
    }
    else {
      System.out.println("Method 'cursorMovementFromElementAndClick' failed because element is not visible");
    }
  }

  // Method to get the link URL
  public String getUrlOfLink(By locator) {
    return driver.findElement(locator).getAttribute("href");
  }

  // Method to take a screenshot
  @Attachment(value = "Page screenshot", type = "image/png")
  public byte[] getScreenshot(String fileAddress) throws IOException {
    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(scrFile, new File(fileAddress));
    return Files.readAllBytes(Paths.get(fileAddress));
  }

  @Attachment(value = "Screenshot", type = "image/png")
  public byte[] saveScreenshot() {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }

  // Utility methods ---------------------------------------------------------- END


  // Module Widget "Trading instrument" --------------------------------------- START
  @Step("Checking all buttons on a tab (option A)")
  public void checkingAllItemOnTabOption_A (String codeName) {
    By locatorOfBtns = By.cssSelector(Locators.locatorAllButtonsOnWidgetTradingInstrument_A_1
            + codeName + Locators.locatorAllButtonsOnWidgetTradingInstrument_A_2);
    int numberOfBtn = getNumberOfElements(locatorOfBtns);
    scrollToElement(locatorOfBtns);
    for (int number = 1; number <= numberOfBtn; number++) {
      By locatorOfCurrentBtn = By.cssSelector(Locators.locatorCssWidgetMarketBtnTrade_A_1 + codeName
              + Locators.locatorCssWidgetMarketBtnTrade_A_2 + number
              + Locators.locatorCssWidgetMarketBtnTrade_A_3);
      scrollToElement(locatorOfCurrentBtn);
      waitForElement(locatorOfCurrentBtn);
      clickOnElement(locatorOfCurrentBtn);
      checkShowingUpSignUpForm();
    }
  }

  @Step("Checking all buttons on a tab (option B)")
  public void checkingAllItemOnTabOption_B (String codeName) {
    By locatorOfBtns = By.cssSelector(Locators.locatorAllButtonsOnWidgetTradingInstrument_B_1
            + codeName + Locators.locatorAllButtonsOnWidgetTradingInstrument_B_2);
    int numberOfBtn = getNumberOfElements(locatorOfBtns);
    for (int number = 1; number <= numberOfBtn; number++) {
      System.out.println("Цикл начался - " + number);

      By locatorOfCurrentBtn = By.cssSelector(Locators.locatorTradingInstrumentWidgetBtnTrade_B_1
              + codeName + Locators.locatorTradingInstrumentWidgetBtnTrade_B_2
              + number + Locators.locatorTradingInstrumentWidgetBtnTrade_B_3);
      scrollToElement(locatorOfCurrentBtn);
      waitForElement(locatorOfCurrentBtn);
      clickOnElement(locatorOfCurrentBtn);

      checkShowingUpSignUpForm();
    }
  }

  // Checking condition to run test group A or B (for annotation JUnit)
  @Step("Checking the visibility of option A or B the Trading instruments widget module")
  static boolean checkingConditionToRunTestGroup_AorB() {
    return driver.findElement(Locators.locatorTradingInstrumentWidgetTabMostTraded1).isDisplayed();
  }
  @Step("checking element visibility to run tests options A or B")
  public boolean checkingVisibleElementForOptionsAorB(By locatorOfElement) {
    try {
      return driver.findElement(locatorOfElement).isDisplayed();
    }
    catch(Exception e) {
      return false;
    }
  }


  // Module Widget "Trading instrument" ------------------------------------ END

  // Module Widget “Promo Market” ------------------------------------------ START
  @Step("Checking all buttons on tabs (4 items)")
  public void checkingModuleWidgetPromoMarketForMainPage() {
    String localReport = "";

    scrollToElement(Locators.moduleWidgetPromoMarketTabName);
    localReport = waitAndCheckingVisibilityOfElement(Locators.moduleWidgetPromoMarketTabName)
            ? localReport : "Fail (Button isn't visible)";
    if(localReport == "") {
      HashSet tabNamesHashSet = new HashSet<>();
      int totalTabs = driver.findElements(Locators.moduleWidgetPromoMarketTab).size();
      System.out.println("Starts - Total elements - " + totalTabs + "\n");
      while(tabNamesHashSet.size() < totalTabs) {
        System.out.println("Element - " + driver.findElement(Locators.moduleWidgetPromoMarketTabName).getText()
                + " " + tabNamesHashSet.size() + " out of " + totalTabs);
        String tabName = driver.findElement(Locators.moduleWidgetPromoMarketTabName).getText();
        if(!tabNamesHashSet.contains(tabName)) {
          tabNamesHashSet.add(tabName);
          waitAndClickElement(Locators.moduleWidgetPromoMarketBtnTradeNow);
          // assert
          checkShowingUpSignUpForm();
        }
        // This cursor movement is necessary to remove the tooltip of module Widget “Promo Market”
        cursorMovementFromElementAndClick(Locators.moduleWidgetPromoMarketBtnTradeNow);
        timeOut(250);
        continue;
      }
    }
    System.out.println("Finished checking the block" + "\n" + "Result - " + localReport);
  }
  // Module Widget “Promo Market” - END

  @Step("Checking all buttons on tabs (5 items)")
  public void checkingAllBtnOnTradersDashboard() {
    int numberOfElements = driver.findElements(Locators.locatorTradersDashboard).size();
    for (int i = 1; i <= numberOfElements; i++) {
      By locator = By.cssSelector(Locators.locatorTradersDashboardBtnTrad1 + i
              + Locators.locatorTradersDashboardBtnTrad2);
      waitForElement(locator);
      System.out.println("Circle is running. Step - " + i + " out of " + numberOfElements);
      timeOut(250);
      clickOnElement(locator);
      checkShowingUpSignUpForm();
    }
  }

  // Special methods ------------------------------------------------------------- START
  // Method of accepting the terms of use of cookies
  public void cookiesAcceptConsent() {
    for (int time = 0;; time = time + 250) {
      if (time >= 15000) {
        System.out.println("notification with cookies don't showed up");
        break;
      }
      try {
        if (driver.findElement(locatorOfCookies).isDisplayed()) {
          System.out.println("notification with cookies appeared");
          driver.findElement(locatorOfCookies).click();
          break;
        }
      } catch (Exception e) {
        timeOut(250);
        continue;
      }
    }
  }


  // Writing and reading files methods --------------------------------------------START
  // Method of write to file
  public void writeStringToFile(String addressOfFileWhereToWrite, String whatToWrite) {
    PrintWriter writer = null;
    try {
      writer = new PrintWriter(addressOfFileWhereToWrite);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    writer.write(whatToWrite);
    writer.flush();
    writer.close();
  }

  public void writeListToFile (String addressOfFileWhereToWrite, ArrayList whatToWrite) throws FileNotFoundException {
    try(PrintWriter writer = new PrintWriter(addressOfFileWhereToWrite)) {
      Iterator<String> itr = whatToWrite.iterator();
      while (itr.hasNext()) {
        writer.write(itr.next() + "\n");
      }
      writer.flush();
    }
  }

  // Reading the file having the list of URL and adding the URL to ArrayList to check the pages
  public ArrayList transferDataFromFileToList(ArrayList listUrl, String fileAddress) {
    try {
      BufferedReader urlFile = new BufferedReader(new FileReader(fileAddress));
      for(;;) {
        String internalLine = urlFile.readLine();
        if(internalLine == null) {
          break;
        }
        listUrl.add(internalLine);
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return listUrl;
  }

  public void writeTextToFile(String fileAddress, String lineText) throws FileNotFoundException {
    PrintWriter writer = new PrintWriter(fileAddress);
    writer.write(lineText + "\n");
    writer.flush();
    writer.close();
  }

  public void parsingUrlAndWriteToFile(String sectionUrl, String fileWriteAddress) {
    ArrayList<String> tradingInstrumentCardName = new ArrayList<>();

    goToPageAndCheckUrl(sectionUrl);

    waitForElement(Locators.LAST_NUMBER_IN_LIST_PAGES);
    String numberOFLastPages = driver.findElement(Locators.LAST_NUMBER_IN_LIST_PAGES).getText();
    int cycleNumber = Integer.parseInt (numberOFLastPages);

    for(int i = 1; i <= cycleNumber; i++) {
      if(i > 1) {
        goToPageAndCheckUrl(sectionUrl + "/" + i);
      }
      List<WebElement> elements = driver.findElements(Locators.TRADING_INSTRUMENT_CARD_LINK);
      // Getting trading instrument card names and write it to list
      for(int n = 0; n < elements.size(); n++) {
        String url = elements.get(n).getAttribute("href");
        int lettersNumber = url.length();
        String name = "";
        for(int l = 20; l < lettersNumber; l++) {
          name = name + Character.toString(url.charAt(l));
        }
        tradingInstrumentCardName.add(name);
      }
    }
    // Writing to file
    PrintWriter writer = null;
    try {
      writer = new PrintWriter(fileWriteAddress);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    int number = 0;
    for (String s: tradingInstrumentCardName) {
      number = number + 1;
      writer.write(s + "\n");
      System.out.println(number + " - " + s);
    }
    writer.flush();
    writer.close();
  }

  // Writing and reading files methods --------------------------------------------END
  // Special methods ------------------------------------------------------------- END
}
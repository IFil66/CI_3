package com.capital.ticTests.EN.cryptocurrencies;

import com.capital.Locators;
import com.capital.Methods;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.IOException;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class CheckRegBtnTests extends Methods {

  @ParameterizedTest
  @CsvFileSource(files = "src/test/resources/data/csvFiles/toDoCSV/cryptocurrenciesToDo.csv", numLinesToSkip = 0)
  @DisplayName("Check 'Log In' button on page header")
  public void ticPageHeader_ClickOnBtnLogIn_LoginFormWasAppear(
          String language,  String licence, String nameTradingInstrument) {

    // arrange
    goToPageAndCheckUrl(constructTradingInstrumentCardsUrl(language, nameTradingInstrument, licence));
    saveScreenshot();

    // act
    scrollToElement(Locators.headerBtnLogIn);
    saveScreenshot();
    waitForElement(Locators.headerBtnLogIn);
    clickOnElement(Locators.headerBtnLogIn);

    // assert
    checkShowingUpLoginForm();

    saveScreenshot();
  }

  @ParameterizedTest
  @CsvFileSource(files = "src/test/resources/data/csvFiles/toDoCSV/cryptocurrenciesToDo.csv", numLinesToSkip = 0)
  @DisplayName("Check 'Trade Now' button on page header")
  public void ticPageHeader_ClickOnBtnTradeNow_SignUpFormWasAppear(
          String language, String licence, String nameTradingInstrument) {
    // arrange
    goToPageAndCheckUrl(constructTradingInstrumentCardsUrl(language, nameTradingInstrument, licence));
    saveScreenshot();

    // act
    scrollToElement(Locators.headerBtnTradeNow);
    saveScreenshot();
    waitForElement(Locators.headerBtnTradeNow);
    clickOnElement(Locators.headerBtnTradeNow);

    // assert
    checkShowingUpSignUpForm();

    saveScreenshot();
  }

  @ParameterizedTest
  @CsvFileSource(files = "src/test/resources/data/csvFiles/toDoCSV/cryptocurrenciesToDo.csv", numLinesToSkip = 0)
  @DisplayName("Check 'Add to favourite' button on title block")
  public void ticPage_ClickOnBtnAddToFavourite_SignUpFormWasAppear(
          String language, String licence, String nameTradingInstrument) {
    // arrange
    goToPageAndCheckUrl(constructTradingInstrumentCardsUrl(language, nameTradingInstrument, licence));
    saveScreenshot();

    // act
    scrollToElement(Locators.tradingInstrumentNamePanelBtnAddToFavourite);
    saveScreenshot();
    waitForElement(Locators.tradingInstrumentNamePanelBtnAddToFavourite);
    clickOnElement(Locators.tradingInstrumentNamePanelBtnAddToFavourite);

    // assert
    checkShowingUpSignUpForm();

    saveScreenshot();
  }

  @ParameterizedTest
  @CsvFileSource(files = "src/test/resources/data/csvFiles/toDoCSV/cryptocurrenciesToDo.csv", numLinesToSkip = 0)
  @DisplayName("Check Bell on trading instrument widget")
  public void ticWidget_ClickOnBtnBell_SignUpFormWasAppear(
          String language, String licence, String nameTradingInstrument) {

    // arrange
    goToPageAndCheckUrl(constructTradingInstrumentCardsUrl(language, nameTradingInstrument, licence));
    saveScreenshot();

    // act
    scrollToElement(Locators.widgetBtnBell);
    saveScreenshot();
    waitForElement(Locators.widgetBtnBell);
    clickOnElement(Locators.widgetBtnBell);

    // assert
    checkShowingUpSignUpForm();

    saveScreenshot();
  }

  @ParameterizedTest
  @CsvFileSource(files = "src/test/resources/data/csvFiles/toDoCSV/cryptocurrenciesToDo.csv", numLinesToSkip = 0)
  @DisplayName("Check 'View detailed chart' button on trading instrument widget")
  public void ticWidget_ClickOnViewDetailedChart_SignUpFormWasAppear(
          String language, String licence, String nameTradingInstrument) {

    // arrange
    goToPageAndCheckUrl(constructTradingInstrumentCardsUrl(language, nameTradingInstrument, licence));
    saveScreenshot();

    // act
    scrollToElement(Locators.widgetBtnViewDetailedChart);
    saveScreenshot();
    waitForElement(Locators.widgetBtnViewDetailedChart);
    clickOnElement(Locators.widgetBtnViewDetailedChart);

    // assert
    checkShowingUpSignUpForm();

    saveScreenshot();
  }

  @ParameterizedTest
  @CsvFileSource(files = "src/test/resources/data/csvFiles/toDoCSV/cryptocurrenciesToDo.csv", numLinesToSkip = 0)
  @DisplayName("Check 'Sell' button on trading instrument widget")
  public void ticWidget_ClickOnBtnSell_SignUpFormWasAppear(
          String language, String licence, String nameTradingInstrument) {

    // arrange
    goToPageAndCheckUrl(constructTradingInstrumentCardsUrl(language, nameTradingInstrument, licence));
    saveScreenshot();

    // act
    if (waitForElementAndReturnOfVisibilityResult(Locators.widgetBtnSell)) {
      scrollToElement(Locators.widgetBtnSell);
      saveScreenshot();
      clickOnElement(Locators.widgetBtnSell);
    } else {
      scrollToElement(Locators.widgetBtnCreateAccount);
      saveScreenshot();
      clickOnElement(Locators.widgetBtnCreateAccount);
    }

    // assert
    checkShowingUpSignUpForm();

    saveScreenshot();
  }

  @ParameterizedTest
  @CsvFileSource(files = "src/test/resources/data/csvFiles/toDoCSV/cryptocurrenciesToDo.csv", numLinesToSkip = 0)
  @DisplayName("Check 'Buy' button on trading instrument widget")
  public void ticWidget_ClickOnBtnBuy_SignUpFormWasAppear(
          String language, String licence, String nameTradingInstrument) {

    // arrange
    goToPageAndCheckUrl(constructTradingInstrumentCardsUrl(language, nameTradingInstrument, licence));
    saveScreenshot();

    // act
    if (waitForElementAndReturnOfVisibilityResult(Locators.widgetBtnBuy)) {
      scrollToElement(Locators.widgetBtnBuy);
      saveScreenshot();
      clickOnElement(Locators.widgetBtnBuy);
    } else {
      scrollToElement(Locators.widgetBtnCreateAccount);
      saveScreenshot();
      clickOnElement(Locators.widgetBtnCreateAccount);
    }

    // assert
    checkShowingUpSignUpForm();

    saveScreenshot();
  }

  @ParameterizedTest
  @CsvFileSource(files = "src/test/resources/data/csvFiles/toDoCSV/cryptocurrenciesToDo.csv", numLinesToSkip = 0)
  @DisplayName("Check button on Long position overnight fee")
  public void ticLongPosition_ClickOnGoToPlatform_SignUpFormWasAppear(
          String language, String licence, String nameTradingInstrument) {

    // arrange
    goToPageAndCheckUrl(constructTradingInstrumentCardsUrl(language, nameTradingInstrument, licence));
    saveScreenshot();

    // act
    scrollToElement(Locators.LONG_POSITION);
    saveScreenshot();
    waitForElement(Locators.LONG_POSITION);
    clickOnElement(Locators.LONG_POSITION);
    elementToBeClickable(Locators.LONG_POSITION_BTN);
    clickOnElement(Locators.LONG_POSITION_BTN);

    // assert
    checkShowingUpSignUpFormOnPlatform();

    saveScreenshot();
  }

  @ParameterizedTest
  @CsvFileSource(files = "src/test/resources/data/csvFiles/toDoCSV/cryptocurrenciesToDo.csv", numLinesToSkip = 0)
  @DisplayName("Check button on Short position overnight fee")
  public void ticShotPosition_ClickOnGoToPlatform_SignUpFormWasAppear(
          String language, String licence, String nameTradingInstrument) {

    // arrange
    goToPageAndCheckUrl(constructTradingInstrumentCardsUrl(language, nameTradingInstrument, licence));
    saveScreenshot();

    // act
    scrollToElement(Locators.SHORT_POSITION);
    saveScreenshot();
    waitForElement(Locators.SHORT_POSITION);
    clickOnElement(Locators.SHORT_POSITION);
    elementToBeClickable(Locators.SHORT_POSITION_BTN);
    clickOnElement(Locators.SHORT_POSITION_BTN);

    // assert
    checkShowingUpSignUpFormOnPlatform();

    saveScreenshot();
  }

  @ParameterizedTest
  @CsvFileSource(files = "src/test/resources/data/csvFiles/toDoCSV/cryptocurrenciesToDo.csv", numLinesToSkip = 0)
  @DisplayName("Checking button 'Try Now' on module 'Why choose Capital.com? Our numbers speak for themselves.'")
  public void ticModuleWhyChooseCapitalCom_clickOnBtnTryNow_SignUpFormWasAppear(
          String language, String licence, String nameTradingInstrument) {

    // arrange
    goToPageAndCheckUrl(constructTradingInstrumentCardsUrl(language, nameTradingInstrument, licence));
    saveScreenshot();

    // act
    if (waitForElementAndReturnOfVisibilityResult(Locators.moduleWhyChooseCapitalComBtnTryNow)) {
      scrollToElement(Locators.moduleWhyChooseCapitalComBtnTryNow);
      saveScreenshot();
      waitForElement(Locators.moduleWhyChooseCapitalComBtnTryNow);
      clickOnElement(Locators.moduleWhyChooseCapitalComBtnTryNow);
    } else {
      scrollToElement(Locators.moduleWhyChooseCapitalComBtnTryNow2);
      saveScreenshot();
      waitForElement(Locators.moduleWhyChooseCapitalComBtnTryNow2);
      clickOnElement(Locators.moduleWhyChooseCapitalComBtnTryNow2);
    }


    // assert
    checkShowingUpSignUpForm();

    saveScreenshot();
  }

  @ParameterizedTest
  @CsvFileSource(files = "src/test/resources/data/csvFiles/toDoCSV/cryptocurrenciesToDo.csv", numLinesToSkip = 0)
  @DisplayName("Checking button 'Start trading' on module 'Trading calculator'")
  public void ticModuleTradingCalculator_clickOnBtnStartTrading_SignUpFormWasAppear(
          String language, String licence, String nameTradingInstrument) {

    // arrange
    goToPageAndCheckUrl(constructTradingInstrumentCardsUrl(language, nameTradingInstrument, licence));
    saveScreenshot();

    // act
    scrollToElement(Locators.moduleTradingCalculatorBtnStartTrading);
    saveScreenshot();
    waitForElement(Locators.moduleTradingCalculatorBtnStartTrading);
    clickOnElement(Locators.moduleTradingCalculatorBtnStartTrading);

    // assert
    checkShowingUpSignUpForm();

    saveScreenshot();
  }

  @ParameterizedTest
  @CsvFileSource(files = "src/test/resources/data/csvFiles/toDoCSV/cryptocurrenciesToDo.csv", numLinesToSkip = 0)
  @DisplayName("Checking buttons 'Trade Now' (4 items) on module widget promo market")
  public void ticModuleWidgetPromoMarket_clickOnBtnTradeNow_SignUpFormWasAppear(
          String language, String licence, String nameTradingInstrument) {

    // arrange
    goToPageAndCheckUrl(constructTradingInstrumentCardsUrl(language, nameTradingInstrument, licence));
    saveScreenshot();

    // act and assert
    checkingModuleWidgetPromoMarketForMainPage();

    saveScreenshot();
  }

  @ParameterizedTest
  @CsvFileSource(files = "src/test/resources/data/csvFiles/toDoCSV/cryptocurrenciesToDo.csv", numLinesToSkip = 0)
  @DisplayName("Checking user plus button on module 'Still looking for a broker you can trust?'")
  public void ticModuleStillLookingForBrokerYouCanTrust_clickOnBtnUserPlus_SignUpFormWasAppear(
          String language, String licence, String nameTradingInstrument) {

    // arrange
    goToPageAndCheckUrl(constructTradingInstrumentCardsUrl(language, nameTradingInstrument, licence));
    saveScreenshot();

    // act
    scrollToElement(Locators.moduleStillLookingForBrokerYouCanTrustIconUserPlus);
    saveScreenshot();
    waitForElement(Locators.moduleStillLookingForBrokerYouCanTrustIconUserPlus);
    clickOnElement(Locators.moduleStillLookingForBrokerYouCanTrustIconUserPlus);

    // assert
    checkShowingUpSignUpForm();

    saveScreenshot();
  }

}
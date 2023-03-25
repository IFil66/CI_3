package com.capital;

import org.openqa.selenium.By;

public class Locators {

  // License
  public static final By licenseBtnMenu = By.cssSelector("button.cc-toggleLicense__btn");
  public static final By licenseBtnASIC = By.xpath("//a[contains(@href, 'license')] [contains(., 'ASIC')]");
  public static final String licenseNameASIC = "Capital Com Australia Pty Ltd";
  public static final By licenseBtnFCA = By.xpath("//a[contains(@href, 'license')] [contains(., 'FCA')]");
  public static final String licenseNameFCA = "Capital Com UK Limited";
  public static final By licenseBtnCYSEC = By.xpath("//a[contains(@href, 'license')] [contains(., 'CYSEC')]");
  public static final String licenseNameCYSEC = "Capital Com SV Investments Limited";
  public static final By licenseBtnNBRB = By.xpath("//a[contains(@href, 'license')] [contains(., 'NBRB')]");
  public static final String licenseNameNBRB = "Сlosed Joint Stock Company «FinTech Solutions»";
  public static final By licenseBtnForex = By.xpath("//a[contains(@href, 'license')] [contains(., 'Forex')]");
  public static final String licenseNameForex = "Smart Forex Broker LLC";
  public static final By licenseBtnFSA = By.xpath("//a[contains(@href, 'license')] [contains(., 'FSA')]");
  public static final String licenseNameFSA = "Capital Com Stock and CFD Investing Ltd";


  // Login form
  public static final By loginFormH1 = By.cssSelector("#l_overlay div.h1");
  public static final By loginFormFieldEmail = By.cssSelector("#l_overlay input[type = 'email']");
  public static final By loginFormFieldPassword = By.cssSelector("#l_overlay input[type = 'password']");
  public static final By loginFormBtnCancel = By.cssSelector("#l_overlay button.button-cleared");


  // Sign up form
  public static final By signUpFormH1 = By.cssSelector("#s_overlay div.h1");
  public static final By signUpFormFieldEmail = By.cssSelector("#s_overlay input[type = 'email']");
  public static final By signUpFormFieldPassword = By.cssSelector("#s_overlay input[type = 'password']");
  public static final By signUpFormBtnCancel = By.cssSelector("#s_overlay button.button-cleared");

  public static final By signUpFormLinkPrivacyPolicy = By.cssSelector(
      "div.form-container-small-footer a[href*='http'], div.form-container-small-footer a[target='_blank'], a[href='/privacy-policy']");


  // Sign up form on new page
  public static final By signUpFormH1_onNewPage = By.cssSelector("#testwrap div.h1");
  public static final By signUpFormFieldEmail_onNewPage = By.cssSelector("#testwrap input[type = 'email']");
  public static final By signUpFormFieldPassword_onNewPage = By.cssSelector("#testwrap input[type = 'password']");

  // Sign up form on trading platform
  public static final By SIGN_UP_FORM_TITLE_ON_PLATFORM = By.cssSelector("div.modal__header-title");
  public static final By SIGN_UP_FORM_EMAIL_ON_PLATFORM = By.cssSelector("input[name = 'username']");
  public static final By SIGN_UP_FORM_PASSWORD_ON_PLATFORM = By.cssSelector("input[name = 'password']");
  public static final By SIGN_UP_FORM_CONTINUE_BTN_ON_PLATFORM = By.cssSelector("button.button-main");


  // Modules ------------------------------------------- START

  // Header of all pages
  public static final By headerBtnLogIn = By.cssSelector("#wg_loginBtn");
  public static final By headerBtnTradeNow = By.cssSelector("a[data-type = 'btn_header']");


  // Module Widget “Promo Market”
  public static final By moduleWidgetPromoMarketTab = By.cssSelector("div.cc-sliderFade__item");
  public static final By moduleWidgetPromoMarketTabName = By.cssSelector("div.cc-sliderFade__item.active strong");
  public static final By moduleWidgetPromoMarketBtnTradeNow = By.cssSelector("div.cc-sliderFade__item.active a[class^='promoMarket__col btn']");


  // Module "Trading calculator"
  public static final By moduleTradingCalculatorBtnStartTrading = By.cssSelector("*[data-type = 'btn_calculator']");


  // Module "Still looking for a broker you can trust?" - START
  public static final By moduleStillLookingForBrokerYouCanTrustIconUserPlus = By.cssSelector("i[data-type = 'banner_with_steps']");


  // Module "Why choose Capital.com? Our numbers speak for themselves."
  public static final By moduleWhyChooseCapitalComBtnTryNow = By.cssSelector("a[data-type *= 'banner_with_counter_hor_counter_hor']");
  public static final By moduleWhyChooseCapitalComBtnTryNow2 = By.cssSelector("a[data-type *= 'b_hor_new_style_876']");
  // Modules --------------------------------------------- END


// --------------------------------------------------------------------------------------------------------------------


  // Main page ------------------------------------------- START
  // Checking Registration / Authorization form
  // URL
  public static final  String url = "https://capital.com";


  // Header
  // here used locators of buttons "Log in" and "Trade now" from class "com.capital_tests.Locators"

  // Section Widget "Trading instrument" ----------------------------- START

  // Option A
  // Tab Most traded (codeName - mtr, number 7)
  // Tab Commodities (codeName - com, number 7)
  // Tab Indices (codeName - ind, number 7)
  // Tab Cryptocurrencies (codeName - cryp, number 7)
  // Tab Shares (codeName - shar, number 7)
  // Tab Forex (codeName - fx, number 7)
  // Tab ETFs (codeName - etf, number 7)

  public static final By locatorTradingInstrumentWidgetTabMostTraded1 = By.cssSelector("li[data-tab-control = 'mtr']");

  public static final String locatorAllButtonsOnWidgetTradingInstrument_A_1 = "tbody[data-tab-content = '";
  public static final String locatorAllButtonsOnWidgetTradingInstrument_A_2 = "'] tr";

  public static final String locatorCssWidgetMarketBtnTrade_A_1 = "tbody[data-tab-content = '";
  public static final String locatorCssWidgetMarketBtnTrade_A_2 = "'] tr:nth-child(";
  public static final String locatorCssWidgetMarketBtnTrade_A_3 = ") a[data-type='wdg_markets']";


  // Option B
  public static final String locatorAllButtonsOnWidgetTradingInstrument_B_1 = "div.ihome-";
  public static final String locatorAllButtonsOnWidgetTradingInstrument_B_2 = " div.tools__item";

  public static final String locatorTradingInstrumentWidgetBtnTrade_B_1 = "div.ihome-";
  public static final String locatorTradingInstrumentWidgetBtnTrade_B_2 = " div.tools__item:nth-child(";
  public static final String locatorTradingInstrumentWidgetBtnTrade_B_3 = ") a.tools__btn";


  // Section "Still looking for a broker you can trust?"
  // here used locator of button "user plus" from class "com.capital_tests.Locators"


  // Section Widget “Promo Market”
  // here used locator of button "Trade Now" from class "com.capital_tests.Locators"


  // Section "Trading calculator"
  // here used locator of button "Start trading" from class "com.capital_tests.Locators"


  // Section "Trader's Dashboard" -------------------------------- START
  public static final By locatorTradersDashboard = By.cssSelector("div.tradersDashboard__item");
  public static final String locatorTradersDashboardBtnTrad1 = "div.tradersDashboard__item:nth-child(";
  public static final String locatorTradersDashboardBtnTrad2 = ") button";
  // Section "Trader's Dashboard" -------------------------------- END


  // Section "Why choose Capital.com? Our numbers speak for themselves"
  // here used locator of button "Try now" from class "com.capital_tests.Locators"

  // Main page --------------------------------------------------- END

// --------------------------------------------------------------------------------------------------------------------

  // Trading instrument cards ------------------------------------ START
  // Files with trading instrument cards name
  public static final String ADDRESS_TIC_NAME_FOREX = "src/test/resources/data/tradingInstrumentCards/url/forexPageUrl.txt";
  public static final String ADDRESS_TIC_NAME_INDICES = "src/test/resources/data/tradingInstrumentCards/url/indicesPageUrl.txt";
  public static final String ADDRESS_TIC_NAME_COMMODITIES = "src/test/resources/data/tradingInstrumentCards/url/commoditiesPageUrl.txt";
  public static final String ADDRESS_TIC_NAME_CRYPTOCURRENCIES = "src/test/resources/data/tradingInstrumentCards/url/cryptocurrenciesPageUrl.txt";
  public static final String ADDRESS_TIC_NAME_SHARES = "src/test/resources/data/tradingInstrumentCards/url/sharesPageUrl.txt";

  // CSV files
  public static final String ADDRESS_CSV_FILE_FOREX = "src/test/resources/data/tradingInstrumentCards/csvFiles/allDataFiles/forexTicName.csv";
  public static final String ADDRESS_CSV_FILE_INDICES = "src/test/resources/data/tradingInstrumentCards/csvFiles/allDataFiles/indicesTicName.csv";
  public static final String ADDRESS_CSV_FILE_COMMODITIES = "src/test/resources/data/tradingInstrumentCards/csvFiles/allDataFiles/commoditiesTicName.csv";
  public static final String ADDRESS_CSV_FILE_CRYPTOCURRENCIES = "src/test/resources/data/tradingInstrumentCards/csvFiles/allDataFiles/cryptocurrenciesTicName.csv";
  public static final String ADDRESS_CSV_FILE_SHARES = "src/test/resources/data/tradingInstrumentCards/csvFiles/allDataFiles/sharesTicName.csv";


  // Special data for search the trading instrument card pages ---- START

  public static final String URL_FOREX = "https://capital.com/live-currency-prices";
  public static final String URL_INDICES = "https://capital.com/major-world-indices";
  public static final String URL_CRYPTOCURRENCIES = "https://capital.com/live-cryptocurrency-prices";
  public static final String URL_COMMODITIES = "https://capital.com/live-commodity-prices";
  public static final String URL_SHARES = "https://capital.com/live-share-prices";

  public static final By LAST_NUMBER_IN_LIST_PAGES = By.cssSelector("ul.pagination li:nth-last-child(2) a");
  public static final By TRADING_INSTRUMENT_CARD_LINK = By.cssSelector("tr.trlink a[data-type = 'wdg_markets_deep']");





  // --Arrange
  // Header
  // locators "Log in" and "Trade now" buttons placed above

  // Section "Trading instrument name pane"
  public static final By tradingInstrumentNamePanelBtnAddToFavourite = By.cssSelector("a[data-type = 'add_fav']");

  // Section "Widget"
  public static final By widgetBtnBell = By.cssSelector("a[data-type = 'market_alerts']");
  public static final By widgetBtnViewDetailedChart = By.cssSelector("a[data-type = 'detailed_chart']");
  public static final By widgetBtnSell = By.cssSelector("a[data-type = 'market_sell']");
  public static final By widgetBtnBuy = By.cssSelector("a[data-type = 'market_buy']");
  public static final By widgetBtnCreateAccount = By.cssSelector("div.sharesName__notTrading a");
  // Section "Trading Conditions"
  // "Long position overnight fee" - "Go to platform" button
  public static final By LONG_POSITION = By.cssSelector("table.table--num tr:nth-child(2) div.toolInfo");
  public static final By LONG_POSITION_BTN = By.cssSelector("tr:nth-child(2) div.cc-tooltip a");

  // "Short position overnight fee" - "Go to platform" button
  public static final By SHORT_POSITION = By.cssSelector("table.table--num tr:nth-child(3) div.toolInfo");
  public static final By SHORT_POSITION_BTN = By.cssSelector("tr:nth-child(3) div.cc-tooltip a");

  // Section "Why choose Capital.com? Our numbers speak for themselves"
  // locator "Try now" button placed above

  // Section "Trading calculator"
  // locator "Start trading" button placed above

  // Section Widget “Promo Market”
  // locator "Trade Now" button placed above. Total buttons - 4 item.

  // Section "Still looking for a broker you can trust?"
  // locator "user plus" button placed above

  // Trading instrument cards -------------------------------------- END
}

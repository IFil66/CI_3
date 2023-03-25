package com.capital.ticTests;

import com.capital.Locators;
import com.capital.Methods;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ParsingTicNames extends Methods {

  @Test
  public void parsingForexTicNames() {
    parsingUrlAndWriteToFile(Locators.URL_FOREX, Locators.ADDRESS_TIC_NAME_FOREX);
  }

  @Test
  public void parsingIndicesTicNames() {
    parsingUrlAndWriteToFile(Locators.URL_INDICES, Locators.ADDRESS_TIC_NAME_INDICES);
  }

  @Test
  public void parsingCryptocurrencyTicNames() {
    parsingUrlAndWriteToFile(Locators.URL_CRYPTOCURRENCIES, Locators.ADDRESS_TIC_NAME_CRYPTOCURRENCIES);
  }

  @Test
  public void parsingCommoditiesTicNames() {
    parsingUrlAndWriteToFile(Locators.URL_COMMODITIES, Locators.ADDRESS_TIC_NAME_COMMODITIES);
  }

  @Test
  public void parsingShareTicNames() {
    parsingUrlAndWriteToFile(Locators.URL_SHARES, Locators.ADDRESS_TIC_NAME_SHARES);
  }

  @Test
  public void createCSVFile() {
    ArrayList<String> languages = new ArrayList<>();
    languages.add("\"\""); // English
//    languages.add("ar");   // Arab
//    languages.add("id");   // Indonesian
//    languages.add("bg");   // Bulgarian
//    languages.add("cs");   // Czech
//    languages.add("da");   // Denmark
//
//    languages.add("de");   // Germany
//    languages.add("et");   // Estonian
//    languages.add("el");   // Greek
//    languages.add("es");   // Spanish
//    languages.add("fr");   // French
//    languages.add("hr");   // Croatia
//
//    languages.add("it");   // Italian
//    languages.add("lv");   // Latvian
//    languages.add("lt");   // Estonian
//    languages.add("hu");   // Hungarian
//    languages.add("nl");   // Netherlands
//    languages.add("pl");   // Polish
//
//    languages.add("pt");   // Portuguese
//    languages.add("ro");   // Romania
//    languages.add("ru");   // Russian
//    languages.add("sk");   // Slovak
//    languages.add("sl");   // Slovenian
//    languages.add("fi");   // Finnish
//
//    languages.add("sv");   // Swedish
//    languages.add("vi");   // Vietnamese
//    languages.add("th");   // Thai
//    languages.add("zh");   // Simplified Chinese
//    languages.add("cn");   // Traditional Chinese


    ArrayList<String> licenses = new ArrayList<>();
//    licenses.add("ASIC");    // Capital Com Australia Pty Ltd
    licenses.add("FCA");     // Capital Com UK Limited
//    licenses.add("CYSEC");   // Capital Com SV Investments Limited
//    licenses.add("NBRB");    // Сlosed Joint Stock Company «FinTech Solutions»
//    licenses.add("CCSTV");   // Smart Forex Broker LLC
//    licenses.add("FSA");     // Capital Com Stock and CFD Investing Ltd
//    licenses.add("SCB");     // Capital Com Online Investments Ltd

    CreateUrlForTests.createUrl(Locators.ADDRESS_CSV_FILE_FOREX, languages, Locators.ADDRESS_TIC_NAME_FOREX, licenses);
    CreateUrlForTests.createUrl(Locators.ADDRESS_CSV_FILE_INDICES, languages, Locators.ADDRESS_TIC_NAME_INDICES, licenses);
    CreateUrlForTests.createUrl(Locators.ADDRESS_CSV_FILE_CRYPTOCURRENCIES, languages, Locators.ADDRESS_TIC_NAME_CRYPTOCURRENCIES, licenses);
    CreateUrlForTests.createUrl(Locators.ADDRESS_CSV_FILE_COMMODITIES, languages, Locators.ADDRESS_TIC_NAME_COMMODITIES, licenses);
    CreateUrlForTests.createUrl(Locators.ADDRESS_CSV_FILE_SHARES, languages, Locators.ADDRESS_TIC_NAME_SHARES, licenses);
  }

}

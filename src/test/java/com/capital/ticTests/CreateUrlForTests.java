package com.capital.ticTests;

import java.io.*;
import java.util.ArrayList;

public class CreateUrlForTests {

  public static void createUrl(String addressOfFileWhereToWrite, ArrayList language, String addressOfFileWithNames, ArrayList<String> licenses) {
    ArrayList<String> listNames = new ArrayList<>();

    PrintWriter writer = null;
    try {
      writer = new PrintWriter(addressOfFileWhereToWrite);
    } catch (
            FileNotFoundException e) {
      throw new RuntimeException(e);
    }

    transferDataFromFileToList(listNames, addressOfFileWithNames);
    writer.write("LANGUAGE, LICENCE, TRADING_INSTRUMENT_NAME\n");
    System.out.println(language.size() + " - " + licenses.size() + " - " + listNames.size());

    for(int l = 0; l < language.size(); l++) {
      for(int i = 0; i < licenses.size(); i++) {
        for(int n = 0; n < listNames.size(); n++) {
          writer.write(language.get(l) + ", " + licenses.get(i) + ", " + listNames.get(n) + "\n");
        }
      }
    }
    writer.flush();
    writer.close();
  }


  private static ArrayList transferDataFromFileToList(ArrayList listUrl, String fileAddress) {
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


}

package com.capital.ticTests.EN.shares;

import com.capital.Methods;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DatasetBuilderTest {

  int numberElements = 90;
  Methods methods = new Methods();

  ArrayList<String> done = new ArrayList<>();
  ArrayList<String> toDo = new ArrayList<>();

  @Test
  @DisplayName("Create tests dataset")
  public void createTestDataset() throws FileNotFoundException {
    methods.transferDataFromFileToList(done,"src/test/resources/data/csvFiles/doneCSV/sharesDone.csv");
    methods.transferDataFromFileToList(toDo, "src/test/resources/data/csvFiles/sourceCSV/sharesSource.csv");
    toDo.removeAll(done);
    toDo.removeIf(x -> toDo.indexOf(x) >= numberElements);
    methods.writeListToFile("src/test/resources/data/csvFiles/toDoCSV/sharesToDo.csv", toDo);
  }

}

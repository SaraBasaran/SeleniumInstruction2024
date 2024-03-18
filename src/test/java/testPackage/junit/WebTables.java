/*
package testPackage;


import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Tests;

import java.util.ArrayList;
import java.util.List;

public class WebTables extends Tests {

    @Test
    public void test01() {

        //Go to URL: http://demo.guru99.com/test/web-table-element.php
        driver.get("http://demo.guru99.com/test/web-table-element.php");
        //To find third row of table
        WebElement thirdRow = driver.findElement(By.xpath("//table[@class = 'dataTable']//tbody//tr[3]"));


        //To get 3rd row's 2nd column data
        WebElement thirdRowSecondData = thirdRow.findElement(By.xpath(".//td[2]"));
        System.out.println(thirdRowSecondData.getText());

        //Get all the values of a Dynamic Table
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class = 'dataTable']//tbody//tr"));
        //List<WebElement> cells;

        List<String> allData = new ArrayList<>();

        for (WebElement w : rows) {
            //cells = w.findElements(By.xpath(".//td"));
            //for (WebElement y : cells)
            //  allData.add(y.getText());
        }

        //System.out.println(allData);

        //------------------------------------------

        //2nd Approach

        List<WebElement> rows1 = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr"));
        for (WebElement row : rows1) {
            // Find all columns in each row
            List<WebElement> columns = row.findElements(By.tagName("td"));

            // Iterate through each column
            for (WebElement column : columns) {
                // Print the text of each column
                //System.out.print(column.getText() + "\t");
            }
            //System.out.println();

        }

        //----------------------------------------
        //3rd approach

        List<WebElement> rows2 = driver.findElements(By.xpath("//table[@class='dataTable']//tbody//tr"));

        List<String> allRowsValues = new ArrayList<>();
        for (WebElement tr : rows2) {
            allRowsValues.add(tr.getText());
        }

        for (String r : allRowsValues) {
            //System.out.println(r);
        }


        //----------------------------------------
        //4th approach


        WebElement webTable = driver.findElement(By.xpath("//table[@class='dataTable']"));
        int rowNum = webTable.findElements(By.xpath(".//tr")).size();
        int columnNum = webTable.findElements(By.xpath(".//tr[1]//td")).size();

        for (int i = 1; i < rowNum; i++) {
            for (int j = 1; j <= columnNum; j++) {
                String cellValue = webTable.findElement(By.xpath(".//tr[" + i + "]//td[" + j + "]")).getText();
                //System.out.print(cellValue + " ");
            }
            //System.out.println();
            //System.out.println("---------------------------------------------------------------------------------");
        }


        //---------------------------------------------------
        //for loop 1st approach

        for (int i = 0; i < rows.size(); i++) {
            List<WebElement> rowsData = rows.get(i).findElements(By.tagName("td"));
            int columnSize = rowsData.size();
            for (int j = 0; j < columnSize; j++) {
                //System.out.print(rowsData.get(j).getText() + " ");
            }
            //System.out.println();
        }


        //-----------------------------------------------
        //for loop 2nd approach

        for (int i = 0; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            List<WebElement> columns = row.findElements(By.tagName("td"));

            for (int j = 0; j < columns.size(); j++) {
                WebElement column = columns.get(j);
                System.out.print(column.getText() + "\t");
            }
            System.out.println();
        }


        //-------------------------
        //3rd approach

        WebElement dynamicTable = driver.findElement(By.xpath("//table[@class='dataTable']"));

        StringBuilder tableValues = new StringBuilder();
        for (WebElement row : dynamicTable.findElements(By.xpath("./tbody/tr"))) {
            for (WebElement cell : row.findElements(By.xpath("./td"))) {
                String value = cell.getText();
                tableValues.append(value).append(" ");
            }
            tableValues.append("\n");
        }

        System.out.println("Table Values:");
        System.out.println(tableValues);


        //-----------------------------
        //4th approach



        WebElement row = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr"));
        PropertyConfigurator.configure("log4j.properties");
        Logger logger = Logger.getLogger(WebTables.class);

        logger.trace("Creating new list to store cells");
        List<WebElement> cells = new ArrayList<>();

        for (int i = 1; i <= rows.size(); i++) {
            logger.trace("adding the cells inside the row to iterate over it");
            cells = row.findElements(By.xpath(".//td"));
            for (int j = 1; j <= cells.size(); j++) {
                System.out.println("Cell : Row: " + i + " Column: " + j + ": " + driver.findElement(
                        By.xpath("//table[@class='dataTable']" +
                                "/tbody/tr[" + i + "]/td[" + j + "]")).getText());
            }
        }
    }
}
*/
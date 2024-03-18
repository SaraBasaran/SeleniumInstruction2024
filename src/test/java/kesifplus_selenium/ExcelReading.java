package kesifplus_selenium;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReading {
    public static void main(String[] args) throws IOException {
        //Exception in "IOException" olmasina dikkat edelim sonrasinda baska yerlerde hata veriyor
        // tekrar exception istiyor "file.close();" gibi
        String filePath = "src/test/resources/diamond77 Test Cases.xlsx";
        //open the file path
        FileInputStream file = new FileInputStream(filePath);

        //Read the excel file each sheet
        // Workbook excel = WorkbookFactory.create(file);
        Workbook excel = WorkbookFactory.create(file);

        //Read specific  sheet by giving sheet index number (0 dan baslar)
        Sheet sheet = excel.getSheetAt(0);

        //Read specific  Row by giving Row index number (Starts from "0" )
        Row row = sheet.getRow(1);

        //Read specific  Cell by giving Cell index number (Starts from "0" )
        Cell zero = row.getCell(0);
        Cell firstCell = row.getCell(1);
        Cell secondCell = row.getCell(2);
        Cell thirdCell = row.getCell(3);

        System.out.println(zero.toString());
        System.out.println(firstCell.toString());
        System.out.println(secondCell.toString());
        System.out.println(thirdCell.toString());
        System.out.println("*****"+row.toString());

    }

}

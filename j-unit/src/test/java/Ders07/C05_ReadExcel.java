package Ders07;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C05_ReadExcel {

    @Test
    public void test() throws IOException {


        String excelFileName="src/resources/udemy-selenium-deneme.xlsx";
        FileInputStream fileInputStream=new FileInputStream(excelFileName);
        Workbook workbook= WorkbookFactory.create(fileInputStream);

        //Excel'deki tüm tabloyu console'a yazdıralım.

        String table ="";
        int getLastRowNum = workbook.getSheet("Sheet1").getLastRowNum();
        for(int i =0; i< getLastRowNum+1; i++ ){
            table = workbook.getSheet("Sheet1").getRow(i).getCell(0).toString() +" " +
                    workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();

            System.out.println(table);
        }



    }
}

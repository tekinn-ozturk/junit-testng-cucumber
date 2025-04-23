package Ders07;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C07_DeleteExcel {

    @Test
    public void test() throws IOException {
        String excelFileName="src/resources/udemy-selenium-deneme.xlsx";
        FileInputStream fileInputStream=new FileInputStream(excelFileName);
        Workbook workbook= WorkbookFactory.create(fileInputStream);

        //- Sheet objesini getir.
        Sheet sheet = workbook.getSheet("Sheet1");
        //- Row objesi olusturun
        Row row = sheet.getRow(1); //ikinci satır; 1.index
        //- Cell objesi olusturun
        Cell cell = row.getCell(0); // ilk hücre -> Emre
        //-1. Satır 2. sütun'daki veriyi silelim
        row.removeCell(cell);

        FileOutputStream fileOutputStream= new FileOutputStream(excelFileName);
        workbook.write(fileOutputStream);





    }
}

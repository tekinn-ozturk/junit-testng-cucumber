package Ders07;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void readExcelTest() throws IOException, InterruptedException {
        //- Dosya yolunu bir String degiskene atayalim

        //src seviyesinde resources klasörü içersine de atılabilir yada masaüstü dosyası olarakta kalabilir. (sağ tık copy path/References, path from content root yolunu al )
        String excelFileName = "src/resources/udemy-selenium-deneme.xlsx";

        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim

        FileInputStream fis = new FileInputStream(excelFileName);
        // - Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook = WorkbookFactory.create(fis);
        Thread.sleep(1000);
        //- Sheet objesi olusturun
        Sheet sheet = workbook.getSheet("Sheet1");
        //- Row objesi olusturun
        Row row = sheet.getRow(3);
        //- Cell objesi olusturun
        Cell cell = row.getCell(0);
        //- 3. indexteki  satirin 0. indexindeki  datanin Yakup oldugunu test edin
        Thread.sleep(1000);
        String expData = "Yakup";
        String actualData = cell.toString();
        System.out.println(actualData);
        Assert.assertEquals("Veri Yakup Değil",expData,actualData);



    }
}

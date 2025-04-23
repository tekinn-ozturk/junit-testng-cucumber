package Ders07;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcelPractice {
    @Test
    public void test() throws IOException, InterruptedException {
        //Belirtilen satırNo ve sutunNo değerlerini parametre olarak alıp o cell'deki datayı konsola yazdıralım
        //Sonucun konsolda yazanla aynı olduğunu doğrulayın

        int satir = 2;
        int sutun = 1;

        String excelFileName="src/resources/udemy-selenium-deneme.xlsx";
        FileInputStream fis = new FileInputStream(excelFileName);
        Workbook workbook= WorkbookFactory.create(fis);
        String actualData = workbook.getSheet("Sheet1").getRow(satir-1).getCell(sutun-1).toString();
        String expecData = "Emre";
        Thread.sleep(2000);
        Assert.assertEquals("Veri {Emre} Değil",actualData,expecData);

    }
}

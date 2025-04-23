package Ders07;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C04_ReadExcel {

    @Test

    public void test() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        String excelFileName="src/resources/udemy-selenium-deneme.xlsx";
        FileInputStream fileInputStream=new FileInputStream(excelFileName);
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        //-sayfa 2'ye gidip satir sayisinin 17, kullanilan satir sayisinin ise 5 oldugunu test edin

        int sonSatirNumarasi = workbook.getSheet("Sheet1").getLastRowNum();
        System.out.println(sonSatirNumarasi);
        int expLastRowNum = 4;
        Assert.assertEquals("Numaralar Eşit Değil", sonSatirNumarasi+1 ,expLastRowNum);



    }
}

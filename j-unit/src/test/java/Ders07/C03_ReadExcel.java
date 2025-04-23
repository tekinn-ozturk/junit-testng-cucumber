package Ders07;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {

    @Test
    public void test() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        String excelFileName="src/resources/udemy-selenium-deneme.xlsx";
        FileInputStream fis = new FileInputStream(excelFileName);
        Workbook workbook= WorkbookFactory.create(fis);
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim

        //-Adların olduğu sutununu yazdiralim
        String adlar ="";
        for (int i=0; i<4; i++){
            adlar =workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
            System.out.println(adlar);
        }


    }
}

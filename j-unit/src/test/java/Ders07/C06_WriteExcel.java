package Ders07;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C06_WriteExcel {

    @Test
    public void test() throws IOException {

        String excelFileName="src/resources/udemy-selenium-deneme.xlsx";
        FileInputStream fileInputStream=new FileInputStream(excelFileName);
        Workbook workbook= WorkbookFactory.create(fileInputStream);

        //3.hucreye yeni bir cell olusturalim
        workbook.getSheet("Sheet1").getRow(0).createCell(2).setCellValue(141);
        //Olusturdugumuz hucreye 141 yazdiralim

        //2.satir 141 yazdığımız kolonun altına 100 yazdiralim
        workbook.getSheet("Sheet1").getRow(1).createCell(2).setCellValue(100);
        //3.satira 141 yazdiralim
        workbook.getSheet("Sheet1").getRow(2).createCell(2).setCellValue(141);
        //4.satira 142 yazdiralim
        workbook.getSheet("Sheet1").getRow(3).createCell(2).setCellValue(142);
        //Dosyayi kaydedelim,
        FileOutputStream fileOutputStream = new FileOutputStream(excelFileName);
        workbook.write(fileOutputStream);
        //Dosyayi kapatalim
        //aksilik olmasın diye iki kere close ettik.
        fileOutputStream.close();
        fileOutputStream.close();
        workbook.close();

    }
}

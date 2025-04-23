package Ders06;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;

public class C01_FileExist {

    @Test
    public void Test() {

        System.out.println(System.getProperty("user.dir")); //C:\Users\tekin.ozturk\Desktop\selenium-ile-test-otomasyonu\j-unit

        String anaDizin = System.getProperty("user.home"); //C:\Users\tekin.ozturk

        System.out.println(anaDizin);

        //dosyayı bilgisayarda bul shift+ sağtık ile yol olarak kopyala seçeneğini seç
        String checkFilePath = "C:\\Users\\tekin.ozturk\\Desktop\\instance-id-iceren-tables.txt";
        //String checkFilePath2 = "C:/Users/tekin.ozturk/Desktop/instance-id-iceren-tables.txt";
        Assert.assertTrue(Files.exists(Paths.get(checkFilePath)));
        //masaüstünde var mı yok mu doğrulaması
    }
}

package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    //Java'nın hazır bir sınıfıdır ve anahtar-değer (key-value) çiftleri şeklinde ayarları saklamak için kullanılır
    //şu an null properties nesnesi. sadece referans verdik.
    public static Properties properties;

    //static içersindeki şeyler uygulama çalıştırıldığında direkt oluşur ve sadece 1 kez oluşur.
    static {

        //FileStream'e okutacağımız dosyanın yolu.
        String dosyaYolu="configuration.properties";

        try{

            //Verdiğimiz dosya yoluna ait dosyayı okuması için yazılan kod.
            FileInputStream fileInputStream = new FileInputStream(dosyaYolu);

            //properties nesnesinin uygulama çalıştırıldığında örneği alınır.
            properties = new Properties();

            //properties nesnesine okunan dosya içersindeki bilgiler atanır.(load)
            properties.load(fileInputStream);


        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //Bir static metot ve String dönen bir metot ayrıca parametre olarak String key alan bi metot.
    //Bu metod, ConfigReader sınıfının bir nesnesi (new ConfigReader()) oluşturulmadan doğrudan çağrılabilir(STATIC).

    public static String getProperty(String key){

        //Properties class'ında olan ve keyi'ini verdiğim property'nin valuesini dönen java hazır metotu(getProperty())
        return properties.getProperty(key);
    }
    //bu metodun fonksiyonelliğini Properties classından nesne alarak getProperties hazır metodunu kullanarak sağlayabilirdim ancak her özellik için instance almak performans kaybına sebep olurdu.

}

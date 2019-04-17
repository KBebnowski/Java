package zaj5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class StreamExample {

    public static String readFromSource(InputStream is) throws IOException {

        int charCounter = 0;
        int wordCounter = 0;
        int b;
        StringBuilder sb = new StringBuilder();
        while((b=is.read())>-1){
            sb.append((char) b);

            if((char) b == 'o'){
                charCounter++;
            }
        }
        System.out.println(charCounter);
        return sb.toString();
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        InputStream is = new FileInputStream("pan-tadeusz.txt");
        System.out.println(readFromSource(is));
        is.close();

        URL url = new URL("https://www.uni.lodz.pl");
        System.out.println(readFromSource(url.openStream()));



    }



}

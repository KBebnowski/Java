package zaj5;

import java.io.*;
import java.net.URL;

public class ReaderExample {

    public static String readFromSource(Reader r) throws IOException {
        BufferedReader br = new BufferedReader(r);  // wczytuje linia po linii, zwykly reader po jednym znaku
        StringBuilder sb= new StringBuilder();
        String line;

        int lineCounter = 0;
        while((line = br.readLine())!=null){
            sb.append(line+"\n");
            lineCounter++;
        }

        System.out.println(lineCounter);
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        Reader r= new FileReader("pan-tadeusz.txt");
        System.out.println(readFromSource(r));
        r.close();


        URL url = new URL ("https://www.uni.lodz.pl");
        r = new InputStreamReader(url.openStream());
        r.close();



    }


}

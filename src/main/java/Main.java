import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {


    public static void main(String[] args) throws IOException {
        //Download webs
        List<String> links = new ArrayList<>();
        links.add("https://www.bbc.com/");
        links.add("https://www.bbc.com/mundo/noticias-internacional-61673922");
        links.add("https://www.bbc.com/mundo/noticias-internacional-61703738");
        links.add("https://www.bbc.com/mundo/noticias-61600791");
        links.add("https://www.bbc.com/mundo/deportes-61705882");
        links.add("https://www.bbc.com/mundo/noticias-internacional-61699753");
        links.add("https://www.bbc.com/mundo/vert-fut-61687793");
        links.add("https://www.bbc.com/");
        links.add("https://www.bbc.com/mundo/noticias-internacional-61673922");
        links.add("https://www.bbc.com/mundo/noticias-internacional-61703738");
        links.add("https://www.bbc.com/mundo/noticias-61600791");
        links.add("https://www.bbc.com/mundo/deportes-61705882");
        links.add("https://www.bbc.com/mundo/noticias-internacional-61699753");
        links.add("https://www.bbc.com/mundo/vert-fut-61687793");


        links.stream().parallel().forEach(link -> getWebContent(link));

        String link = "https://www.bbc.com";
        String result = getWebContent(link);

    }

    private synchronized static String getWebContent(String link) {
        System.out.println("INIT");
        System.out.println(link);
        try {
            URL url = new URL(link);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            String enconding = conn.getContentEncoding();

            InputStream input = conn.getInputStream();

            Stream<String> lines = new BufferedReader(new InputStreamReader(input))
                    .lines();
            System.out.println("END");
            return  lines.collect(Collectors.joining());
             } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

}

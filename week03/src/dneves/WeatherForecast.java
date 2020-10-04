package dneves;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WeatherForecast {
    int id;
    String name;
    Map<String,Float> main;

    public WeatherForecast(int id, String name, Map<String,Float> main) {
        this.id = id;
        this.name = name;
        this.main = new HashMap<>();
    }

    public static void sendRequest () throws IOException {
        String data = "";
        String name = "myFile.txt";
        String url = "https://api.openweathermap.org/data/2.5/forecast";
        String charset = "UTF-8";
        String city = "Portland";
        String api = "0ee69aa74ea23399f0cb0b304b922fe4";

        String query = String.format("q=%s&apiKey=%s",

                URLEncoder.encode(city, charset),
                URLEncoder.encode(api, charset));


        URLConnection connection = new URL(url + "?" + query).openConnection();


        connection.setRequestProperty("Accept-Charset", charset);
        InputStream response = connection.getInputStream();

        try (Scanner scanner = new Scanner(response)) {
            data = scanner.useDelimiter("\\A").next();
            System.out.println(data);

        }


    }

}

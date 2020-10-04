package dneves;

import com.google.gson.Gson;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class WeatherConditions {
    int id;
    String name;
    Map<String,Float> main;

    public WeatherConditions(int id, String name, Map<String,Float> main){
        this.id = id;
        this.name = name;
        this.main = new HashMap<>();

    }
    public static void sendRequest () throws IOException {
        String data = "";
        String name = "myFile.txt";
        String url = "https://api.openweathermap.org/data/2.5/weather";
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

    public static WeatherConditions loadConditions(String fileName) throws IOException {

        String data = "";
        try {
            File myObj = new File(String.valueOf(fileName));
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        Gson g = new Gson();
        WeatherConditions newForecast = g.fromJson(data,WeatherConditions.class);

        return newForecast;
    }

    @Override
    public String toString () {
        String s = "{" +
                "id=" + id +
                ", name=" + name +
                ", main= {";
        Iterator<Map.Entry<String,Float>> it = main.entrySet().iterator();

        while (it.hasNext()){
            Map.Entry<String,Float> weather = it.next();
            s = s.concat(weather.getKey() + ": " + weather.getValue() + ", ");
        }

        return s;
    }
}

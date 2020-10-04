package dneves;

import com.google.gson.Gson;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        Gson g = new Gson();
        String responseBody = null;
        WeatherForecast.sendRequest();


    }

}



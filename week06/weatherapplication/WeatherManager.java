package com.example.weatherapplication;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class WeatherManager {
    private final String key = "";
    private final String baseUrl = "https://api.openweathermap.org/data/2.5/";

    private Gson gson;

    public WeatherManager() {
        gson = new Gson();
    }
    public WeatherConditions loadCurrentWeather(String city) {
        String url = baseUrl + "weather" +
                "?q=" + city +
                "&units=imperial" +
                "&apiKey=" + key;
        String data = loadJsonData(url);

        // Convert JSON data to WeatherConditions object
        return gson.fromJson(data, WeatherConditions.class);
    }

    public WeatherForecast loadWeatherForecast(String city) {
        String url = baseUrl + "forecast" +
            "?q=" + city +
            "&units=imperial" +
            "&apiKey=" + key;
        String data = loadJsonData(url);

        // Convert JSON data to WeatherForecast object
        return gson.fromJson(data, WeatherForecast.class);
    }

    private String loadJsonData(String url) {
        StringBuilder data = new StringBuilder();
            try {
                URL urlObj = new URL(url);
                HttpsURLConnection connection = (HttpsURLConnection) urlObj.openConnection();
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

               // Read all data from the website into a single string
                String line;
                do {
                    line = reader.readLine();
                    if (line != null) {
                        data.append(line);
                    }
                }
                while (line != null);

            } catch (IOException ioe) {
                System.out.println(ioe.toString());
            }

            return data.toString();
    }
}

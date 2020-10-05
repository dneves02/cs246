package dneves;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        SendRequest newRequest = new SendRequest();

        System.out.println("Enter city name: ");
        String city = scanner.nextLine();
        WeatherConditions conditions = newRequest.loadCurrentWeather(city);
        System.out.println(conditions);
        WeatherForecast forecast = newRequest.loadWeatherForecast(city);
        System.out.println(forecast);


    }

}



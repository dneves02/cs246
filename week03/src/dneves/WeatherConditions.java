package dneves;

import com.google.gson.annotations.SerializedName;

import java.util.Iterator;
import java.util.Map;

public class WeatherConditions {

    private int id;
    private String name;
    @SerializedName("main")
    private Map<String,Float> measurements;

    public int getId() { return id; }
    public String getName() { return name; }
    public Map<String, Float> getMeasurements() { return measurements; }

    @Override
    public String toString () {
        String s = "{" +
                "id=" + id +
                ", name=" + name +
                ", measurements= ";
        Iterator<Map.Entry<String,Float>> it = measurements.entrySet().iterator();

        while (it.hasNext()){
            Map.Entry<String,Float> weather = it.next();
            s = s.concat(weather.getKey() + ": " + weather.getValue() + ", ");
        }

        return s;
    }
}

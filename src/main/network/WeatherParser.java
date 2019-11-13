package network;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//with code taken from https://www.codexpedia.com/java/sample-code-for-parsing-json-string-in-java/

public class WeatherParser {
    static final String KEY_WEATHER = "weather";
    static final String KEY_DES = "description";
    static final int DES_INDEX = 0;
    static final String KEY_MAIN = "main";
    static final String KEY_TEMP = "temp";
    static final int TEMP_INDEX = 0;

    public String weatherParser(String jsonData) throws JSONException {
        JSONObject forecastJson = new JSONObject(jsonData);
        JSONObject mainObject = (JSONObject) forecastJson.get(KEY_MAIN);
        Double temperatureObject = (Double) mainObject.get(KEY_TEMP);
        JSONArray weatherArray = (JSONArray) forecastJson.get(KEY_WEATHER);
        JSONObject descriptionObject = (JSONObject) weatherArray.get(DES_INDEX);
        String description = descriptionObject.getString(KEY_DES);
        return "Today the temperature is " + temperatureObject + " degrees F. The forecast is " + description + ".";
    }

}

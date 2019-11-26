package network;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

//quoting from CPSC210 deliverable 10 example, which is quoted from: http://zetcode.com/articles/javareadwebpage/

public class WeatherReader {

    // EFFECTS: prints the string of the temperature and forecast currently in Vancouver
    public static void main(String[] args) throws MalformedURLException, IOException {

        BufferedReader br = null;
        WeatherParser parser = new WeatherParser();

        try {
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=Vancouver,ca&APPID=edef38aea956909dafb3d3ab9ec1c694");

            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {
                buildString(line, sb);
            }

            System.out.println(parser.weatherParser(sb.toString()));

        } catch (JSONException e) {
            e.printStackTrace();
        } finally {

            if (br != null) {
                br.close();
            }
        }
    }

    private static void buildString(String line, StringBuilder sb) {
        sb.append(line);
        sb.append(System.lineSeparator());
    }
}

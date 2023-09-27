package lesson23;

import com.google.gson.Gson;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

public class G_Http {
    public static void main(String[] args) {

    // {"amount":10.0,"base":"GBP","date":"2023-09-11","rates":{"USD":12.5207}}
        String service = "https://api.frankfurter.app/latest?amount=10&from=GBP&to=USD";
        StringBuilder builder = new StringBuilder();
        try {
            URL url = new URL(service);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            try (
                    InputStream is = connection.getInputStream();
                    Reader reader = new InputStreamReader(is);
                    BufferedReader bufferedReader = new BufferedReader(reader);
            ) {
                bufferedReader.lines().forEach(line -> builder.append(line));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        Gson gson = new Gson();
        Rate rate = gson.fromJson(builder.toString(), Rate.class);
        System.out.println(rate.rates); // {USD=12.5207}
    }
}

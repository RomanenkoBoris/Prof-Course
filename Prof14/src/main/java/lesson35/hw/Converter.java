package lesson35.hw;

import lesson14.retro.FrankfurterService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Converter {
    public static double convert(double amount, String from, String to) {
        FrankfurterService service = new Retrofit.Builder()
                .baseUrl("https://api.frankfurter.app")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(FrankfurterService.class);
        try {
            return service.convert(amount, from, to).execute().body().rates.get(to);
        } catch (Exception e) {
            // если функция выбрасывает CheckedException, то имеет смысл перхватить его
            // и выбросить занового как не CheckedException
            throw new RuntimeException(e);
        }
    }
}
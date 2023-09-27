package lesson23;

import java.util.HashMap;
import java.util.Map;

// {"amount":10.0,"base":"GBP","date":"2023-09-11","rates":{"USD":12.5207}}
public class Rate {
    public double amount;
    public String base;
    public String date;
    public Map<String, Double> rates = new HashMap<>();
}

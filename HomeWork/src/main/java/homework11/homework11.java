package homework11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class homework11 {
    public static void main(String[] args) {
        String testString = "asds sadsdf foih lkjase";
        repleceAllVowels(testString);

        System.out.println(isPinCode("5465"));
        System.out.println(isPinCode("546565"));
        System.out.println(isPinCode("546"));

        String testString2 = "profit 12 expense 20 income 50.3";
        mapAllIntsToDouble(testString2);


    }
    public static void repleceAllVowels (String str){
        String current = str.replaceAll("[aeiou]", "");
        System.out.println(current);
    }

    public static boolean isPinCode (String str){
        return str.matches("\\d{4,6}");
    }

    public static void mapAllIntsToDouble (String str){
        Pattern number = Pattern.compile("[0-9]+ ");
        Matcher numbermatcher = number.matcher(str);
        StringBuilder current = new StringBuilder(str);
        int counter = 0;
        while (numbermatcher.find()){
            String tmp = numbermatcher.group();
            if (counter ==0) {
                current.replace(numbermatcher.start(), numbermatcher.end(), tmp.trim() + ".0 ");
            } else {
                int length = current.length() - str.length();
                current.replace(numbermatcher.start()+length, numbermatcher.end()+length, tmp.trim() + ".0 ");
            }
            counter++;
        }
        System.out.println(current.toString());
    }
}

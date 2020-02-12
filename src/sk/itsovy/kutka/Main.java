package sk.itsovy.kutka;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import sk.itsovy.data.DataIP;

public class Main {

    public static void main(String[] args) {
        DataIP dataIP = new DataIP();
        List<String> list = dataIP.get();
        for (String s: list) {
            System.out.println(s);
        }
        System.out.println("*********************");
        ipAddressRegex(list);

    }

    public static void ipAddressRegex(List<String> list) {
        String line = list.get(0);
        Pattern pattern = Pattern.compile("^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                Matcher matcher = pattern.matcher(list.get(i));
                if (matcher.find()) {
                    System.out.println("Valid IP: " + matcher.group());

                }
            }
        }


    }

    public static void birthNumberRegex(ArrayList<String> list) {
        String line = list.get(0);
        Pattern pattern = Pattern.compile("^[0-9]{2}[0156][0-9]{3}\\/?[0-9]{3,4}$");
        Matcher matcher = pattern.matcher(line);
    }
}

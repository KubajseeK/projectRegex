package sk.itsovy.kutka;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sk.itsovy.data.DataIP;
import sk.itsovy.data.Date;
import sk.itsovy.data.MacAddress;
import sk.itsovy.data.PersonalID;

public class Main {

    public static void main(String[] args) {
        DataIP dataIP = new DataIP();
        PersonalID personalID = new PersonalID();
        MacAddress macAddress = new MacAddress();
        Date date = new Date();

        List<String> list = dataIP.get();
        List<String> list1 = personalID.get();
        List<String> list2 = macAddress.get();
        List<String> list3 = date.get();

        System.out.println("*********************");

        ipAddressRegex(list);
        birthNumberRegex(list1);
        macAddressRegex(list2);
        dateRegex(list3);

    }

    public static void ipAddressRegex(List<String> list) {

        Pattern pattern = Pattern.compile("^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                Matcher matcher = pattern.matcher(list.get(i));
                if (matcher.find()) {
                    System.out.println("Valid IP: " + matcher.group());

                }
            }
        }
        System.out.println("******************************");


    }

    public static void birthNumberRegex(List<String> list) {

        Pattern pattern = Pattern.compile("^[0-9]{2}[0156][0-9]{3}\\/?[0-9]{3,4}$");

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                Matcher matcher = pattern.matcher(list.get(i));
                if (matcher.find()) {
                    System.out.println("Valid ID: " + matcher.group());
                }
            }
        }
        System.out.println("*************************");
    }

    public static void macAddressRegex(List<String> list) {

        Pattern pattern = Pattern.compile("^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$");

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                Matcher matcher = pattern.matcher(list.get(i));
                if (matcher.find()) {
                    System.out.println("Valid Mac Address: " + matcher.group());

                }
            }
        }
        System.out.println("******************************");
    }

    public static void dateRegex(List<String> list) {

        Pattern pattern = Pattern.compile("^((([1-9]|[12][0-9]|3[0-1])\\.(1|3|5|7|8|10|12))|(([1-9]|[12][0-9]|30)\\.(4|6|9|11))|(([1-9]|[12][0-9])\\.2))\\.(19|20)[0-9]{2}$");

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                Matcher matcher = pattern.matcher(list.get(i));
                if (matcher.find()) {
                    System.out.println("Valid Date: " + matcher.group());

                }
            }
        }
        System.out.println("******************************");

    }
}

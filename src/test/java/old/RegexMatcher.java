package old;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static driver.SingletonDriver.getDriver;


public class RegexMatcher {

    private final By addressEpam = By.xpath("//b//span[@class='font-size-22']");


    //Task1
    public List<String> regexFiltering(List<String> values, String pattern) {
        List<String> result = new ArrayList<>();
        Pattern p = Pattern.compile(pattern);
        for (String value : values) {
            Matcher m = p.matcher(value);
            if (m.matches()) {
                result.add(value);
                System.out.println(value + " - Value is valid!");
            } else continue;
        }
        return result;
    }


    //Task5

    public void getAndPrintEpamAddressElements() {
        getDriver().get("https://www.epam.com/about/who-we-are/contact");
        String epamAddress = getDriver().findElement(addressEpam).getText();
        getDriver().quit();
        String universalPattern = "^(\\d+)\\s(.+)•\\s(.+),\n(\\w+),\\s(.+)•\\s(\\w+)$";

        String country = getValueByRegEx(epamAddress, universalPattern, 6);
        String streetNumber = getValueByRegEx(epamAddress, "^[0-9]{2}");
        String streetName = getValueByRegEx(epamAddress, universalPattern, 2);
        String postCode = getValueByRegEx(epamAddress, universalPattern, 3);
        String city = getValueByRegEx(epamAddress, universalPattern, 4);

        System.out.println(country + "\n" + streetNumber + "\n" + streetName + "\n" + postCode + "\n" + city);
    }


    public static String getValueByRegEx(String text, String pattern) {
        int firstGroup = 0;
        return getValueByRegEx(text, pattern, firstGroup);
    }

    public static String getValueByRegEx(String text, String pattern, int group) {
        Pattern replacementPattern = Pattern.compile(pattern);
        Matcher matcher = replacementPattern.matcher(text);
        matcher.find();
        return matcher.group(group);
    }


    //Task2,3
    public static void main(String[] args) {
        List<String> listOfValidAndInvalidEmails = new ArrayList<>();
        listOfValidAndInvalidEmails.add("daryna_horobei@ukr.net");
        listOfValidAndInvalidEmails.add("daryna.horobei@ukr.net");
        listOfValidAndInvalidEmails.add("daryna_horobei@ukr");
        listOfValidAndInvalidEmails.add("darynahorobei8ukr");


        List<String> listOfValidAndInvalidIP = new ArrayList<>();
        listOfValidAndInvalidIP.add("255.255.255.255");
        listOfValidAndInvalidIP.add("22.222.22");
        listOfValidAndInvalidIP.add("33.3.3");

        List<String> listOfValidAndInvalidBankCard = new ArrayList<>();
        listOfValidAndInvalidBankCard.add("4111 2222 3333 4443");
        listOfValidAndInvalidBankCard.add("5111222233334443");
        listOfValidAndInvalidBankCard.add("jhhkjk566");
        listOfValidAndInvalidBankCard.add("54545645445554545444454j");


        RegexMatcher regexMatcher = new RegexMatcher();
        regexMatcher.regexFiltering(listOfValidAndInvalidEmails, "(^\\w+.?_?\\w+)@(\\w+[.]\\w+{2,})");
        regexMatcher.regexFiltering(listOfValidAndInvalidIP, "([0-9]{1,3}[.]){3}([0-9]{1,3}){1}");
        regexMatcher.regexFiltering(listOfValidAndInvalidBankCard, "((^[4|5]){1}([0-9]{3}) ?)([0-9]{4} ?){3}");


        regexMatcher.getAndPrintEpamAddressElements();

    }

}
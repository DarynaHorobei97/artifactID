package old;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static driver.SingletonDriver.getDriver;


public class RegexMatcher {

    private final By addressEpam = By.xpath("//span[contains(text(),'41')");


    //Task1
    public List<String> regexFiltering(List<String> values, String pattern) {
        List<String> result = new ArrayList<>();
        Pattern p = Pattern.compile(pattern);
        for (String value : values) {
            Matcher m = p.matcher(value);
            if (m.matches()) {
                result.add(value);
                System.out.println(value + " - Value is valid!");
            } else System.out.println("Invalid");
        }
        return result;
    }


    //Task5

    String addressInfo = "41 University Drive • Suite 202,\n" +
            "Newtown, PA 18940 • USA";

    public void getAndPrintEpamAddressElements() {
        getDriver().get("https://www.epam.com/about/who-we-are/contact");
        String epamAddress = getDriver().findElement(addressEpam).getText();

        String country = getValueByRegEx(epamAddress, "^(.+)•(.+)\\n(.+)• ([A-Z])$", 4);
        String streetNumber = getValueByRegEx(epamAddress, "^[0-9]{2}");
        String streetName = getValueByRegEx(epamAddress, "^([0-9]{2})\\s(\\w| ) •(.+)$", 2);
        String postCode = getValueByRegEx(epamAddress, "^(.+)\\n(\\w), ([A-Z]{2})\\s([0-9]{5}) •(.+)$",
                4);
        String suiteNumber = getValueByRegEx(epamAddress, "(.+)• (.+)\\s([0-9]{3}), \\n(.+)$", 3);
        String city = getValueByRegEx(epamAddress, "(.+)\\n(\\w),(.+)$", 2);

        System.out.println(country + "\n" + streetNumber + "\n" + streetName + "\n" + postCode + "\n" + suiteNumber +
                "\n" + city);
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
        listOfValidAndInvalidEmails.add("darynahorobei@ukr.net");
        listOfValidAndInvalidEmails.add("daryna_horobei8ukr.net");
        listOfValidAndInvalidEmails.add("daryna_horobei@ukr");

        List<String> listOfValidAndInvalidIP = new ArrayList<>();
        listOfValidAndInvalidIP.add("255.255.255.255");
        listOfValidAndInvalidIP.add("22.222.22");
        listOfValidAndInvalidIP.add("33.3.3");

        List<String> listOfValidAndInvalidBankCard = new ArrayList<>();
        listOfValidAndInvalidBankCard.add("4111222233334443");
        listOfValidAndInvalidBankCard.add("jhhkjk566");
        listOfValidAndInvalidBankCard.add("54545645445554545444454j");


        RegexMatcher regexMatcher = new RegexMatcher();
        regexMatcher.regexFiltering(listOfValidAndInvalidEmails, "[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+");
        regexMatcher.regexFiltering(listOfValidAndInvalidIP, "^(([1-9]?\\d|1\\d\\d|2[0-4]\\d|25[0-5])" +
                "(\\.(?!$)|(?=$))){4}$");
        regexMatcher.regexFiltering(listOfValidAndInvalidBankCard, "4[0-9]{12}(?:[0-9]{3})");


        regexMatcher.getAndPrintEpamAddressElements();

    }

}
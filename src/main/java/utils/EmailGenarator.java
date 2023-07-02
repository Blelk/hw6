package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class EmailGenarator {
    public static String generator() {
        String prefix = RandomStringUtils.randomAlphanumeric(7);
        String sufix = RandomStringUtils.randomAlphabetic(5);
        String domain = RandomStringUtils.randomAlphabetic(3);
        String emailAddress = prefix + "@" + sufix + "." + domain;
        return emailAddress;
    }
}
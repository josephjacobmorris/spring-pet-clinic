package com.example.config;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdRegexMatcher {
    public static void main(String[] args) {
        String input ="{\"type\":\"PrimaryParty\",\"name\":\"Karen\",\"id\":\"456789-9996\"},\n" +
                "{\"type\":\"SecondaryParty\",\"name\":\"Juliane\",\"id\":\"345678-9996\"},\n" +
                "{\"type\":\"SecondaryParty\",\"name\":\"Ellen\",\"id\":\"001234-9996\"}";

        Pattern pattern = Pattern.compile("(?<=SecondaryParty)(.*?)(\\d{6}-\\d{4})(?=\\\"})");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String idStr = matcher.group(2);
            System.out.println(idStr);
        }
    }
}

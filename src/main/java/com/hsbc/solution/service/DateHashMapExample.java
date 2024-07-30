package com.hsbc.solution.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateHashMapExample {

    /*public static void main(String[] args) {
        // Create a HashMap with date keys (as strings) and associated values
        Map<String, String> dateHashMap = new HashMap<>();

        // Populate the HashMap (you can add your own data here)
        dateHashMap.put("01-01-2024  08:00:00", "Value for July 28, 2024");
        dateHashMap.put("01-01-2024  08:03:00", "Value for July 29, 2024");
        dateHashMap.put("01-01-2024  08:06:00", "Value for July 30, 2024");

        // Example: Get a value for an approximate date (e.g., "2024-07-27")
        String approximateDate = "01-01-2024  08:01:00"; // Replace with your desired date
        String value = getValueForApproximateDate(dateHashMap, approximateDate);

        if (value != null) {
            System.out.println("Value for approximate date " + approximateDate + ": " + value);
        } else {
            System.out.println("No value found for approximate date " + approximateDate);
        }
    }*/

    // Custom method to get a value for an approximate date
    private static String getValueForApproximateDate(Map<String, String> map, String approximateDate) {
        // Iterate through the keys and find the closest date
        String closestDate = null;
        long minDifference = Long.MAX_VALUE;

        for (String date : map.keySet()) {
            long difference = Math.abs(getDateDifference(date, approximateDate));
            if (difference < minDifference) {
                minDifference = difference;
                closestDate = date;
            }
        }

        return map.get(closestDate);
    }

    // Custom method to calculate the difference between two dates (in milliseconds)
    private static long getDateDifference(String date1, String date2) {
        // You can use more sophisticated date parsing and comparison here
        // For simplicity, let's assume the dates are in the format "yyyy-MM-dd"
        // and convert them to milliseconds since epoch



        long millis1 = parseToLocalDateTime(date1).getTime();
        long millis2 = parseToLocalDateTime(date2).getTime();
        return Math.abs(millis1 - millis2);
    }


    private static Date parseToLocalDateTime(String dateString) {
        try {

            SimpleDateFormat simpleDateFormat =  new SimpleDateFormat("dd-mm-YYYY HH:mm:ss");

             return simpleDateFormat.parse(dateString);

            // Define the expected date format
            //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-mm-YYYY HH:mm:ss");
            // Parse the input string
            //return LocalDateTime.parse(dateString, formatter);
        } catch (DateTimeParseException | ParseException e ) {
            // Handle invalid date format
            return null;
        }
    }

}


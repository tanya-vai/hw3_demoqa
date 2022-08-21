package com.demoqa.utils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static String getRandomString(int length) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }

        return result.toString();

    }

    public static String getRandomEmail() {
        return getRandomString(10) + "@qa.guru";
    }

    public static String getRandomGender() {
        String[] arr = {"Female", "Male", "Other"};
        int randIdx = ThreadLocalRandom.current().nextInt(arr.length);
        String randomElem = arr[randIdx];
        return randomElem;
    }
    public static String getRandomMonth() {
        String[] arr = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int randIdx = ThreadLocalRandom.current().nextInt(arr.length);
        String randomElem = arr[randIdx];
        return randomElem;
    }

    public static String getRandomYear() {
        return getRandomLong(1900L, 2022L).toString();
    }

    public static Long getRandomLong(Long min, Long max) {
        return ThreadLocalRandom.current().nextLong(min, max);
    }

    public static String getRandomPhone() {
        return getRandomLong(1111111111L, 9999999999L).toString();
    }

    public static String getRandomHobby() {
        String[] arr = {"Sports", "Reading", "Music"};
        int randIdx = ThreadLocalRandom.current().nextInt(arr.length);
        String randomElem = arr[randIdx];
        return randomElem;
    }


}

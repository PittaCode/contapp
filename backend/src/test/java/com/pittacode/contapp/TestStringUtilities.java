package com.pittacode.contapp;

import java.security.SecureRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class TestStringUtilities {

    private TestStringUtilities() {
    }

    private static final SecureRandom secureRandom = new SecureRandom();
    private static final String CHARS_FOR_RANDOM_STRINGS = "qwertyuioplkjhgfdsazxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM ";
    private static final int NUM_OF_RANDOM_CHARS = CHARS_FOR_RANDOM_STRINGS.length();

    public static String generateRandomString() {
        return generateRandomString(NUM_OF_RANDOM_CHARS);
    }

    public static String generateRandomString(int numberOfChars) {
        return IntStream.range(0, numberOfChars)
                .mapToObj(index -> CHARS_FOR_RANDOM_STRINGS.charAt(secureRandom.nextInt(NUM_OF_RANDOM_CHARS)))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}

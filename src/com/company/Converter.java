package com.company;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Converter {

    public static Map<Character, Integer> romanArabic = new HashMap<>(5);

    static {
        romanArabic.put('I', 1);
        romanArabic.put('V', 5);
        romanArabic.put('X', 10);
        romanArabic.put('L', 50);
        romanArabic.put('C', 100);
    }

    public static int romanToArabic(String input) {

        int result = 0;
        int len = input.length() - 1;
        for (int i = 0; i < len; i++) {
            if (romanArabic.get(input.charAt(i)) < romanArabic.get(input.charAt(i + 1))) {
                result -= romanArabic.get(input.charAt(i));
            } else {
                result += romanArabic.get(input.charAt(i));
            }
        }
        return result += romanArabic.get(input.charAt(len));
    }

    static Map<String, Integer> arabicRoman = new LinkedHashMap<>();

    static {
        arabicRoman.put("M", 1000);
        arabicRoman.put("CM", 900);
        arabicRoman.put("D", 500);
        arabicRoman.put("CD", 400);
        arabicRoman.put("C", 100);
        arabicRoman.put("XC", 90);
        arabicRoman.put("L", 50);
        arabicRoman.put("XL", 40);
        arabicRoman.put("X", 10);
        arabicRoman.put("IX", 9);
        arabicRoman.put("V", 5);
        arabicRoman.put("IV", 4);
        arabicRoman.put("I", 1);
    }

    public static String arabicToRoman(int Int) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : arabicRoman.entrySet()) {
            int matches = Int / entry.getValue();
            result.append(repeat(entry.getKey(), matches));
            Int = Int % entry.getValue();
        }
        return result.toString();
    }

    public static String repeat(String s, int n) {
        if ( s == null ) {
            return null;
        }
        return s.repeat(Math.max(0, n));
    }
}

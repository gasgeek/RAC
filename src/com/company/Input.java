package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    private static String input1, operation, input3;

    public static boolean isRoman1() {
        return _isRoman1();
    }

    public static boolean isArabic2() {
        return _isArabic2();
    }

    public static boolean isRoman2() {
        return _isRoman2();
    }

    public static boolean isArabic1() {
        return _isArabic1();
    }

    public static void invalidInput1() throws Exception {

        if ( Input.isArabic2() && Integer.parseInt(Input.getInput3()) > 10 ) {
            throw new Exception("Input number is out of range");
        } else {
            if ( Input.isRoman2() && Converter.romanToArabic(Input.getInput3()) > 10 ) {
                throw new Exception("Input number is out of range");
            } else {
                if ( Input.isArabic1() && Integer.parseInt(Input.getInput1()) > 10 ) {
                    throw new Exception("Input number is out of range");
                } else {
                    if ( Input.isRoman1() && Converter.romanToArabic(Input.getInput1()) > 10 ) {
                        throw new Exception("Input number is out of range");
                    } else {
                        if ( ((Input.getInput1().contains("0")) && Input.getInput1().length() > 2) ) {
                            throw new Exception("Only positive integers are allowed");
                        } else {
                            if ( ((Input.getInput3().contains("0")) && Input.getInput3().length() > 2) ) {
                                throw new Exception("Only positive integers are allowed");
                            } else {
                                if ( (Input.getInput1().contains("-")) || (Input.getInput3().contains("-")) ) {
                                    throw new Exception("Only positive integers are allowed");
                                } else {
                                    if ( (Input.isArabic1() && Input.getInput1().length() > 2) || (Input.isRoman2() && Input.getInput3().length() > 4) ) {
                                        throw new StringIndexOutOfBoundsException("Too long number");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void getInput() throws Exception {

        BufferedReader BufferedInputData = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите число1, требуемую арифметическую операцию и число2, разделяя их пробелами.");

        String[] data;
        try {
            String inputString = BufferedInputData.readLine().toUpperCase();
            /* *The minimum number of character is  : 1_+_1 = 5
             *The maximum number of character is: VIII_+_VIII = 11   */
            if ( (inputString.length() < 5) || (inputString.length() > 11) ) {
                throw new Exception("Invalid input. Input is not an arithmetical expression.");
            }
            // Let's check input for possible illegal symbols
            if ( inputString.contains(",") || inputString.contains((".")) ) {
                throw new IllegalArgumentException("We can operate with integers only..");
            }
            // Let's check there is only one arithmetic operation

            int cont = 0;
            for (int i = 0; i < inputString.length() - 1; i++) {
                if ( inputString.charAt(i) == ' ' ) {
                    cont++;
                }
            }
            if ( cont > 2 ) {
                throw new IllegalArgumentException("Only one arithmetic operation is allowed");
            }

            data = inputString.split("\\s+");
            input1 = data[0];
            operation = data[1];
            input3 = data[2];
        } catch (
                IOException a) {
            a.printStackTrace();
        }
    }

    public static String getInput1() {
        return input1;
    }

    public static String getOperation() {
        return operation;
    }

    public static String getInput3() {
        return input3;
    }

    public static boolean _isArabic1() {
        return Character.isDigit(Input.getInput1().charAt(0));
    }

    public static boolean _isArabic2() {
        return Character.isDigit(Input.getInput3().charAt(0));
    }

    private static boolean _isRoman1() {
        return Input.getInput1().contains("I") || Input.getInput1().contains("V") || Input.getInput1().contains("X");
    }

    private static boolean _isRoman2() {
        return Input.getInput3().contains("I") || Input.getInput3().contains("V") || Input.getInput3().contains("X");
    }
}

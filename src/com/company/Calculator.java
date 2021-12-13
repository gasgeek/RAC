package com.company;

import static java.lang.String.*;

public class Calculator {

    public static int number1;
    public static int number2;
    public static int result;

    public static void getNumber1() {

        if ( Input.isArabic1() ) {
            number1 = Integer.parseInt(Input.getInput1());
        } else {
            if ( Input.isRoman1() ) {
                number1 = Integer.parseInt(valueOf(Converter.romanToArabic(Input.getInput1())));
            }
        }
    }

    public static void getNumber2() {

        if ( Input.isArabic2() ) {
            number2 = Integer.parseInt(Input.getInput3());
        } else {
            if ( Input.isRoman2() ) {
                number2 = Integer.parseInt(valueOf(Converter.romanToArabic(Input.getInput3())));
            }
        }
    }

    public void isInRange() {
        if ( number1 > 11 || number2 > 11 ) {
            throw new IllegalArgumentException("Integer's allowed range is from 1 to 10 inclusive");
        }
    }

    public static void calculate() throws Exception {

        switch (Input.getOperation()) {

            case "+": {
                if ( Input.isRoman1() && Input.isRoman2() ) {
                    result = number1 + number2;
                    System.out.println(Converter.arabicToRoman(result));
                } else {
                    if ( Input.isArabic1() && Input.isArabic2() ) {
                        result = number1 + number2;
                        System.out.println(result);
                    } else {
                        if ( !(Input.isArabic1() && Input.isRoman1()) || !(Input.isRoman1() && Input.isArabic2()) ) {
                            throw new Exception("Invalid input. Both numbers must belong the same count system");
                        }
                    }
                }
            }

            break;

            case "-": {
                if ( Input.isRoman1() && Input.isRoman2() ) {
                    if ( number1 < number2 ) {
                        throw new Exception("There are no negative numbers in roman numerals");
                    } else {
                        if ( number1 == number2 ) {
                            throw new Exception("There is no null in roman numerals");
                        }
                    }
                    result = number1 - number2;
                    System.out.println(Converter.arabicToRoman(result));
                } else {
                    if ( Input.isArabic1() && Input.isArabic2() ) {
                        result = number1 - number2;
                        System.out.println(result);
                    } else {
                        if ( (Input.isArabic1() && Input.isRoman1()) || (Input.isRoman1() && Input.isArabic2()) ) {
                            throw new Exception("Invalid input. Both numbers must belong the same count system");
                        }
                    }
                }
            }
            break;

            case "*": {
                if ( Input.isRoman1() && Input.isRoman2() ) {
                    result = number1 * number2;
                    System.out.println(Converter.arabicToRoman(result));
                } else {
                    if ( Input.isArabic1() && Input.isArabic2() ) {
                        result = number1 * number2;
                        System.out.println(result);
                    } else {
                        if ( (Input.isArabic1() && Input.isRoman1()) || (Input.isRoman1() && Input.isArabic2()) ) {
                            throw new Exception("Invalid input. Both numbers must belong the same count system");
                        }
                    }
                }
            }
            break;

            case "/": {
                if ( Input.isRoman1() && Input.isRoman2() ) {
                    if ( number1 < number2 ) {
                        throw new Exception("There is no null in roman numerals");
                    } else {
                        result = number1 / number2;
                        System.out.println(Converter.arabicToRoman(result));
                    }
                } else {
                    if ( Input.isArabic1() && Input.isArabic2() ) {
                        result = number1 * number2;
                        System.out.println(result);
                    } else {
                        if ( (Input.isArabic1() && Input.isRoman1()) || (Input.isRoman1() && Input.isArabic2()) ) {
                            throw new Exception("Invalid input. Both numbers must belong the same count system");
                        }
                    }
                }
            }
            break;

            default: {
                throw new Exception("Invalid input.");
            }
        }
    }
}
package com.company;

public class Main {

    public static void main(String[] args) throws Exception {

        Input input = new Input();
        input.getInput();
        input.getInput1();
        input.getInput3();
        input.getOperation();
        Input.invalidInput1();
        Calculator calculator = new Calculator();
        calculator.getNumber1();
        calculator.getNumber2();
        calculator.isInRange();
        calculator.calculate();
        Converter converter = new Converter();
        if ( Input.isRoman1 && Input.isRoman2 ) {
            System.out.println(converter.arabicToRoman(calculator.result));
        } else {
            if ( Input.isArabic1 && Input.isArabic2 ) {
                System.out.println(calculator.result);
            }
        }
    }
}
